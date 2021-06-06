package tn.ConsomiTounsi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.ConsomiTounsi.Entities.Userr;
import tn.ConsomiTounsi.Repositories.UserrRepository;
@Service
public class UserrServiceImpl implements UserrService{

	
	@Autowired
	UserrRepository uu ;
	@Override
	public Userr authenticate(String login, String password) {
		// TODO Auto-generated method stub
		return uu.getUserByEmailAndPassword(login, password);
	}
	
	

}
