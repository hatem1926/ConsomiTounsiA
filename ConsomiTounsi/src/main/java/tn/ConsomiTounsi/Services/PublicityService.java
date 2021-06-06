package tn.ConsomiTounsi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.ConsomiTounsi.Entities.Publicity;
import tn.ConsomiTounsi.Repositories.PublicityRepository;







@Service
@Transactional
public class PublicityService implements PublicityServiceInterface{
@Autowired
PublicityRepository pur;

@Override
public List<Publicity> getAllPublicity() {
	// TODO Auto-generated method stub
	return pur.findAll();
}

@Override
public Publicity getByid(int id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void saveOrUpdate(Publicity Publicity) {
	// TODO Auto-generated method stub
	pur.save(Publicity);
}

@Override
public void deletePublicity(int id) {
	// TODO Auto-generated method stub
	pur.deleteById(id);
}

@Override
public Publicity updatePublicity(int id, Publicity Publicity) {
	// TODO Auto-generated method stub
	Publicity pur1 = pur.findById(id).get();
	pur1.setPublicityName(Publicity.getPublicityName());
	pur1.setStart_Date(Publicity.getStart_Date());
	pur1.setEnd_Date(Publicity.getEnd_Date());
	pur1.setPrice(Publicity.getPrice());
	pur1.setCanal(Publicity.getCanal());
	
	
	
	return pur.save(pur1);
}
}