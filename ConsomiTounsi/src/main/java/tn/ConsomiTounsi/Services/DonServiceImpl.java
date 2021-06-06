package tn.ConsomiTounsi.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.ConsomiTounsi.Entities.Don;
import tn.ConsomiTounsi.Repositories.DonRepository;



@Service
public class DonServiceImpl implements DonService {
	
	@Autowired
	DonRepository DonRepository ;

	@Override
	public Don addDon(Don dd) {
		// TODO Auto-generated method stub
		return DonRepository.save(dd);
	}

	@Override
	public void deletDon(int id) {
		// TODO Auto-generated method stub
		DonRepository.deleteById(id);
	}

	@Override
	public Don updateDon(Don dd) {
		// TODO Auto-generated method stub
		return DonRepository.save(dd);
	}

	@Override
	public List<Don> getAllPub() {
		// TODO Auto-generated method stub
		return (List<Don>) DonRepository.findAll();
	}
	
	

}
