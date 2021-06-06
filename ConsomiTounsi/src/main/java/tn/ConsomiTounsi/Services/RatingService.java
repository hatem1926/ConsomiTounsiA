package tn.ConsomiTounsi.Services;

import java.util.List;


import tn.ConsomiTounsi.Entities.Rating;

public interface RatingService {
	public List<Rating> getAllPublicity();
	public  Rating getByid(int id);
	public void saveOrUpdate(Rating Publicity);
	public void deletePublicity(int id);
	public Rating updatePublicity(int id, Rating Publicity);


}
