package tn.ConsomiTounsi.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.ConsomiTounsi.Entities.Evenement;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {
	

}
