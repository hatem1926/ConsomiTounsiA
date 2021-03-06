package tn.ConsomiTounsi.Repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.ConsomiTounsi.Entities.Commentaire;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {
	@Query(value="SELECT  c.Commentaire FROM Commentaire c   " , nativeQuery=true )
	public List<Commentaire> getCommentaire();
	
	@Query(value="select * from commentaire where idpub=?1 ",nativeQuery=true)
	public List<Commentaire> getComment(int idpub);
	
	
	@Query(value="declare"
			+ "cursor cur is select commentaire  from commentaire;"
			+ "rec cur%rowtype;"
			+ "begin"
			+ "for rec in cur loop"
			+ "if (rec.idpub =?1)"
			+ " dbms_output.putline(rec.commentaire);"
			+ "end loop;"
			+ "end;",
			
			
			nativeQuery=true)
	public String getCommentairee(int idpub);
	
	
	
}
