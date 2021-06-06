package tn.ConsomiTounsi.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.ConsomiTounsi.Entities.Likes;
import tn.ConsomiTounsi.Entities.Publication;
import tn.ConsomiTounsi.Entities.Rating;
import tn.ConsomiTounsi.Repositories.LikesRepository;



@Service
public class LikesServiceImpl implements LikesService {

	@Autowired
	LikesRepository LikesRepository ;

	@Override
	public List<Likes> getAllPublicity() {
		// TODO Auto-generated method stub
		return LikesRepository.findAll();
	}

	@Override
	public Likes getByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Likes Publicity) {
		// TODO Auto-generated method stub
		LikesRepository.save(Publicity);
	}

	@Override
	public void deletePublicity(int id) {
		// TODO Auto-generated method stub
		LikesRepository.deleteById(id);
	}

	@Override
	public Likes updatePublicity(int id, Likes Publicity) {
		// TODO Auto-generated method stub
		Likes l = LikesRepository.findById(id).get();
		l.setNbrLikes(Publicity.getNbrLikes());
		
		
		return LikesRepository.save(l);
	}

	
	
	
}
