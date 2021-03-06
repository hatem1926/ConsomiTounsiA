package tn.ConsomiTounsi.Services;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.ConsomiTounsi.Entities.Commentaire;
import tn.ConsomiTounsi.Entities.Publication;
import tn.ConsomiTounsi.Entities.Publicity;
import tn.ConsomiTounsi.Entities.User;
import tn.ConsomiTounsi.Repositories.CommentaireRepository;
import tn.ConsomiTounsi.Repositories.PublicationRepository;
import tn.ConsomiTounsi.Repositories.UserRep;




@Service
@Transactional
public class CommentaireServiceImpl implements CommentaireService {
	
	@Autowired
	CommentaireRepository CommentaireRepository ;
	
	@Autowired
	UserRep ur ;
	
	@Autowired
	PublicationRepository pr ;

	@Override
	
	public List<Commentaire> getAllPublicity() {
		// TODO Auto-generated method stub
	//	List<Commentaire> commentaires=new ArrayList<>();
	//	commentaires = CommentaireRepository.getCommentaire();
	//    return commentaires ;
		return CommentaireRepository.findAll();
	}

	@Override
	public Commentaire getByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Commentaire Publicity) {
		// TODO Auto-generated method stub
		List<String> badwords=new ArrayList<>();
		badwords.add("corona");
		badwords.add("badwords");
		badwords.add("badword");
		badwords.add("bad");
		
		badwords.add("bads");
		String motcommentaire[]=Publicity.getCommentaire().split(" ");
		String com ="";
	//	 User user =userRepository.getOne(userId);
	//	 Sujet sujet=sujetRepository.getOne(sujetId);
	for(String mots:motcommentaire){
//		if(motcommentaire.length==1 && motcommentaire.equals("b"))
		
			if (badwords.contains(mots)){
			    mots="*******";
				com=com+" "+mots;	
			}
		else
			com=com+" "+mots;}
	Publicity.setCommentaire(com);
		CommentaireRepository.save(Publicity);
	}

	@Override
	public void deletePublicity(int id) {
		// TODO Auto-generated method stub
		CommentaireRepository.deleteById(id);
	}

	@Override
	public Commentaire updatePublicity(int id, Commentaire Publicity) {
		// TODO Auto-generated method stub
	//	Publicity pur1 = pur.findById(id).get();
	//	pur1.setPublicityName(Publicity.getPublicityName());
	//	pur1.setStart_Date(Publicity.getStart_Date());
	//	pur1.setEnd_Date(Publicity.getEnd_Date());
	//	pur1.setPrice(Publicity.getPrice());
	//	pur1.setCanal(Publicity.getCanal());
	//	return pur.save(pur1);
		
		Commentaire c = CommentaireRepository.findById( id).get();
		List<String> badwords=new ArrayList<>();
		badwords.add("corona");
		badwords.add("badwords");
		badwords.add("badword");
		badwords.add("bad");
		
		badwords.add("bads");
		String motcommentaire[]=Publicity.getCommentaire().split(" ");
		String com ="";
	//	 User user =userRepository.getOne(userId);
	//	 Sujet sujet=sujetRepository.getOne(sujetId);
	for(String mots:motcommentaire){
//		if(motcommentaire.length==1 && motcommentaire.equals("b"))
		
			if (badwords.contains(mots)){
			    mots="*******";
				com=com+" "+mots;	
			}
		else
			com=com+" "+mots;}
	Publicity.setCommentaire(com);
				
		c.setCommentaire(Publicity.getCommentaire());
		return CommentaireRepository.save(c);
		
		
	}

	@Override
	public void updatePublicity1(int id, int idPub) {
		// TODO Auto-generated method stub
		Commentaire c = CommentaireRepository.findById( id).get();
		
		
			Publication p = pr.findById(idPub).get();
	//		User u = ur.findById(idUser).get();
			p.setId(idPub);
//			u.setIdUser(idUser);
			pr.save(p);
		
		
	}

	@Override
	public List<Commentaire> getCommentaireOfPub(int idpub) {
		// TODO Auto-generated method stub
	//	Publication p = pr.findById(idpub).get();
	//	return  CommentaireRepository.getComment(idpub);
		List<Commentaire> commentaires=new ArrayList<>();
		commentaires = CommentaireRepository.getComment(idpub);
		return commentaires ;
	}




	

	
	
	
	
	

}
