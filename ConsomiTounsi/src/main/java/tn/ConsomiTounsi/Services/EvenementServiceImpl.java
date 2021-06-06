package tn.ConsomiTounsi.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.ConsomiTounsi.Entities.Evenement;
import tn.ConsomiTounsi.Repositories.EvenementRepository;



@Service class EvenementServiceImpl implements EvenementService {

	@Autowired
	EvenementRepository EvenementRepository;

	@Override
	public Evenement addEvenement(Evenement ee) {
		// TODO Auto-generated method stub
		return EvenementRepository.save(ee);
	}

	@Override
	public void deleteEvenement(int id) {
		// TODO Auto-generated method stub
		EvenementRepository.deleteById((long) id);
	}

	@Override
	public Evenement updateEvenement(Evenement ee) {
		// TODO Auto-generated method stub
		return EvenementRepository.save(ee);
	} 
	
	

}
