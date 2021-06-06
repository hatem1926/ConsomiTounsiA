package tn.ConsomiTounsi.Repositories;

import org.springframework.data.repository.CrudRepository;

import tn.ConsomiTounsi.Entities.Userr;

public interface UserrRepository extends CrudRepository<Userr, Integer> {
	
	public Userr getUserByEmailAndPassword(String login, String password);

}
