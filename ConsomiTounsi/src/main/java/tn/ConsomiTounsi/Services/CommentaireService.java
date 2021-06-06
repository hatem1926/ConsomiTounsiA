package tn.ConsomiTounsi.Services;

import java.util.List;

import tn.ConsomiTounsi.Entities.Commentaire;
import tn.ConsomiTounsi.Entities.Don;
import tn.ConsomiTounsi.Entities.Publicity;

public interface CommentaireService {
	
	public List<Commentaire> getAllPublicity();
	public  Commentaire getByid(int id);
	public void saveOrUpdate(Commentaire Publicity);
	public void deletePublicity(int id);
	public Commentaire updatePublicity(int id, Commentaire Publicity);
	
	public void updatePublicity1(int id, int idPubr);
	
	public List<Commentaire> getCommentaireOfPub(int idpub);


}