package dev.agboneni.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import dev.agboneni.aspects.Authorized;
import dev.agboneni.entities.Associate;
import dev.agboneni.services.AssociateService;

@Component
@Controller //makes class a singleton, and designs it to handle http requests
@CrossOrigin("*") //should allow anyone to use end points. Helps with cors regulations
public class AssociateController {
	
	@Autowired //finds implementation for dependency injection 
	AssociateService aserv;
	
	//getting all associates 
	@RequestMapping(value = "/associates", method = RequestMethod.GET)
	@ResponseBody // this method does not return an html view 
	// indicates we will be sending back info  in JSON or xml or plain text
	public List<Associate> getAllAssociates(){
		
		return aserv.getAllAssociates();
	}
	
	
	//creating a new associate
	@ResponseBody
	@RequestMapping(value = "/associates", method = RequestMethod.POST)
	public Associate createAssociate(@RequestBody Associate a) {
		//@ request body will parse the body of incoming request into that parameter
		System.out.println(a);
		return aserv.createAssociate(a);
	}
	
	@ResponseBody
	@RequestMapping(value = "/associates/{id}", method = RequestMethod.GET)
	 public Associate getAssociateById(@PathVariable int id) {
		 
		try {
			return aserv.getAssociateById(id);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Associate not found");
		}
	 }
	
	@ResponseBody
	@RequestMapping(value = "/associates", method = RequestMethod.PUT)
	public Associate updateAssociate(@RequestBody Associate a) {
		
		return aserv.updateAssociate(a);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/associates", method = RequestMethod.DELETE)
	@Authorized
	public Boolean deleteAssociate(@RequestBody Associate a) {
		boolean result = aserv.deleteAssociate(a);
		if(result == false) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Did not delete");
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "/query/associates", method = RequestMethod.GET)
	public List<Associate> query(@RequestParam int min, @RequestParam int max, @RequestParam(required = false)  Integer maxresults ){
		System.out.println(maxresults);
		return aserv.findAssociatesInPointRange(min, max);	
	}

}
