package dev.agboneni.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import dev.agboneni.entities.Associate;
import dev.agboneni.repositories.AssociateRepository;


@SpringBootTest
@ContextConfiguration(classes = dev.agboneni.app.RpasApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AssociateRepoTests {
	
	@Autowired
	AssociateRepository ar;

	@Test
	@Order(1)
	void createAssociateTest() {
		Associate tiff = new Associate(0,"Avi", 1500);
		ar.save(tiff);
		System.out.println("===========");
		System.out.println(tiff);
		System.out.println("===========");
	}
	
	@Test
	@Order(2)
	void updatePointsTest() {
		Associate tiff = ar.findByName("Tiffany").get(0);
		tiff.setPoints(1700);
		ar.save(tiff);
		System.out.println("===========");
		System.out.println(tiff);
		System.out.println("===========");
	}
	
	
	

}
