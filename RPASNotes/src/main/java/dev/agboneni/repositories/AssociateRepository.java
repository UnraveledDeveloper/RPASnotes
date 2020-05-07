package dev.agboneni.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.agboneni.entities.Associate;

@Component
@Repository
public interface AssociateRepository extends CrudRepository<Associate, Integer> {
	
	List<Associate> findByName(String name);
	List<Associate> findByPointsLessThan(int max);
	List<Associate> findByPointsBetween(int min, int max);
	
}