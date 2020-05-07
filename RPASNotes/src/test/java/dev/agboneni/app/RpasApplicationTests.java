package dev.agboneni.app;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import dev.agboneni.entities.Associate;
import dev.agboneni.repositories.AssociateRepository;

@SpringBootTest //notifies junit that this is a spring boot app being tested
@Transactional  //all CRUD operations are automatically rolledbacked so it won't save to DB
class RpasApplicationTests {
	
	@Autowired //tells spring this field needs dependency injection
	//spring will search spring container to satisfy the dependency 
	//spring data will create its own
	AssociateRepository ar;
	
	@Test
	void getAllAssociates() {
		//Iterable<Associate> associates = ar.findAll();
		//Set<Associate> associateset = new HashSet<Associate>((Collection<? extends Associate>) associates);
		List<Associate> associates = (List<Associate>) ar.findAll();
		System.out.println("===================");
		for(Associate a : associates) {
			System.out.println(a);
		}
		System.out.println("===================");
	}
	
	@Test
	void getAssociate() {
		//optional are helpful for when you do not get the data
		Associate jesse = ar.findById(1).get();
		System.out.println("===================");
		System.out.println(jesse);
		System.out.println("===================");
	
	}
	@Test
	void getAssociateByName() {
		//optional are helpful for when you do not get the data
		List<Associate> associates = ar.findByName("Nirav");
		System.out.println("===================");
		System.out.println(associates);
		System.out.println("===================");
	
	}
	
	@Test
	void getAssociateByPoints() {
		//optional are helpful for when you do not get the data
		List<Associate> associates = ar.findByPointsBetween(0, 1000);
		System.out.println("===================");
		for(Associate a : associates) {
			System.out.println(a);
		}
		System.out.println("===================");
	
	}
	
	@Test
	//@Commit allow test to save/change the data in DB
	//@Rollback to not save any changes to the database
	void createAssociate() {
		Associate employee = new Associate(0,"Ehimare",500);
		ar.save(employee);
	}

}
