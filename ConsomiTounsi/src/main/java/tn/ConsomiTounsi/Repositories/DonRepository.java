package tn.ConsomiTounsi.Repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.ConsomiTounsi.Entities.Don;

@Repository
public interface DonRepository extends CrudRepository<Don, Integer> {

}
