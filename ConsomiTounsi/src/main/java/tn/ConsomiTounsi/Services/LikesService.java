package tn.ConsomiTounsi.Services;

import java.util.List;


import tn.ConsomiTounsi.Entities.Likes;


public interface LikesService {
	
	public List<Likes> getAllPublicity();
	public  Likes getByid(int id);
	public void saveOrUpdate(Likes Publicity);
	public void deletePublicity(int id);
	public Likes updatePublicity(int id, Likes Publicity);
	
	

}
