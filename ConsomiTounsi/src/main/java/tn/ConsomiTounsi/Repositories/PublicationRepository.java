package tn.ConsomiTounsi.Repositories;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.ConsomiTounsi.Entities.Publication;

@Repository
@Transactional
public interface PublicationRepository extends JpaRepository<Publication,Integer> {
	@Query(value="select p.description  from publication p  where (p.id=1)"
			,nativeQuery=true)
	public String getCommentaire();
	
	
	@Query(value="select p.description from publication p order by nbrrating desc"
			,nativeQuery=true)
	public List getCommentaires();
	
	@Query(value = "SELECT DISTINCT * FROM publication WHERE description  LIKE %?1%", nativeQuery = true)
	public List<Publication> findSujetbyName(String name);
	
	

}
