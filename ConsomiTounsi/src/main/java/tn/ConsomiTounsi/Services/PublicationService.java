package tn.ConsomiTounsi.Services;


import java.util.List;


import tn.ConsomiTounsi.Entities.Publication;


public interface PublicationService {

	
	public List<Publication> getAllPublicity();
	public  Publication getByid(int id);
	public void saveOrUpdate(Publication Publicity);
	public void deletePublicity(int id);
	public Publication updatePublicity(int id, Publication Publicity);
	public List<Publication> listTopPub();
	public List<Publication>findSujetByName(String name);

	public String getCommentaireOfPub();
}
