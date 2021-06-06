package tn.ConsomiTounsi.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.ConsomiTounsi.Entities.Publication;
import tn.ConsomiTounsi.Entities.Rating;
import tn.ConsomiTounsi.Repositories.PublicationRepository;
import tn.ConsomiTounsi.Repositories.RatingRepository;



@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	RatingRepository RatingRepository ;
	@Autowired
	PublicationRepository Pr;

	@Override
	public List<Rating> getAllPublicity() {
		// TODO Auto-generated method stub
		return RatingRepository.findAll();
	}

	@Override
	public Rating getByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Rating Publicity) {
		// TODO Auto-generated method stub
		RatingRepository.save(Publicity);
	}

	@Override
	public void deletePublicity(int id) {
		// TODO Auto-generated method stub
		RatingRepository.deleteById(id);
	}

	@Override
	public Rating updatePublicity(int id, Rating Publicity) {
		// TODO Auto-generated method stub
		Rating r = RatingRepository.findById(id).get();
		r.setNbrRating(Publicity.getNbrRating());
		
		return RatingRepository.save(r);
	}

	
	
	

}
