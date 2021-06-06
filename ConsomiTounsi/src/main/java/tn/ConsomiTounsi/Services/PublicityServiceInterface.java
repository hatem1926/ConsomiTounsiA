package tn.ConsomiTounsi.Services;

import java.util.List;

import tn.ConsomiTounsi.Entities.Publicity;





public interface PublicityServiceInterface {
	
	public List<Publicity> getAllPublicity();
	public  Publicity getByid(int id);
	public void saveOrUpdate(Publicity Publicity);
	public void deletePublicity(int id);
	public Publicity updatePublicity(int id, Publicity Publicity);

}
