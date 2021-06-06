package tn.ConsomiTounsi.Services;



import tn.ConsomiTounsi.Entities.Role;

public interface IRoleService {
	
	public Role addUser (Role role);
	public void DeleteRole(Long idUser);
	public void UpdateRole(Long id , Long user);

}