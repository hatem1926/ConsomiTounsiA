package tn.ConsomiTounsi.Services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.ConsomiTounsi.Entities.Commentaire;
import tn.ConsomiTounsi.Entities.Publication;
import tn.ConsomiTounsi.Repositories.PublicationRepository;



@Service
@Transactional
public class PublicationServiceImpl implements PublicationService {
	
	@Autowired
	PublicationRepository Pr ;

	

	@Override
	public List<Publication> getAllPublicity() {
		// TODO Auto-generated method stub
		return Pr.findAll();
	}

	@Override
	public Publication getByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Publication Publicity) {
		// TODO Auto-generated method stub
		LocalDateTime localDateTime = LocalDateTime.now();
	    Date date =  (Date) Date.from( localDateTime.atZone( ZoneId.systemDefault()).toInstant());
		Publicity.setDate(date);
	    Pr.save(Publicity);
	}

	@Override
	public void deletePublicity(int id) {
		// TODO Auto-generated method stub
		Pr.deleteById( id);
	}

	@Override
	public Publication updatePublicity(int id, Publication Publicity) {
		// TODO Auto-generated method stub
		Publication p =Pr.findById(id).get();
		p.setRate(0);
		p.setDescription(Publicity.getDescription());


		
		return Pr.save(p);
	}

	@Override
	public String getCommentaireOfPub() {
		// TODO Auto-generated method stub
		
		return Pr.getCommentaire();
	}

	@Override
	public List<Publication> listTopPub() {
		// TODO Auto-generated method stub
		return Pr.getCommentaires();
	}

	@Override
	public List<Publication> findSujetByName(String name) {
		// TODO Auto-generated method stub
		return Pr.findSujetbyName(name);
	}

	
	
	

	
	
	

	

}
