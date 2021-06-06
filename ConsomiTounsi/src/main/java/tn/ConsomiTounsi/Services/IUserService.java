package tn.ConsomiTounsi.Services;

import java.util.List;
import java.util.Optional;

import tn.ConsomiTounsi.Entities.User;

public interface IUserService {
	
	public User addUser (User user);
	public Optional<User> ShowUserByid (Long idUser);
	public List<User> affiche();
	public void DeleteUser(Long idUser);
	public void UpdateUser(Long id , User user);
	



}