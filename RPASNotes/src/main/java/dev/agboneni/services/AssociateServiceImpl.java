package dev.agboneni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.agboneni.entities.Associate;
import dev.agboneni.repositories.AssociateRepository;

@Component
@Service // lets spring know that this class is a service, automatically making it a service
public class AssociateServiceImpl  implements AssociateService{
	@Autowired
	AssociateRepository ar;
	
	@Override
	public Associate createAssociate(Associate a) {
		a = ar.save(a);
		return a;
	}

	@Override
	public Associate getAssociateById(int id) {
		
		return ar.findById(id).get(); 
	}

	@Override
	public Associate updateAssociate(Associate a) {
		ar.save(a);
		return a;
	}

	@Override
	public boolean deleteAssociate(Associate a) {
		try {
			ar.delete(a);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Associate> getAllAssociates() {
		List<Associate> associates = (List<Associate>) ar.findAll();
		return associates;
	}

	@Override
	public List<Associate> findAssociatesInPointRange(int min, int max) {
		
		return null;
	}

}
