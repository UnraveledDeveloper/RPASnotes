package dev.agboneni.services;

import java.util.List;

import dev.agboneni.entities.Associate;

public interface AssociateService {
	
	Associate createAssociate(Associate a);
	
	Associate getAssociateById(int id);
	List<Associate> getAllAssociates();
	
	Associate updateAssociate(Associate a);
	
	boolean deleteAssociate(Associate a);

	List<Associate> findAssociatesInPointRange(int min, int max);
}
