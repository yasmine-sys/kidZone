package tn.pi.spring.Iservice;

import java.util.List;

import tn.pi.spring.entity.RoleName;
import tn.pi.spring.entity.User;


public interface IuserManagement {

	public List<User> getUsers();
	
	public User findByEmail(String email);
	
	public void deleteUser(String email);
	
	public void updateUser(User user);
	
	List<User> findByFirstNameContains(String firstName);
	List<User> getRole(RoleName role);
	List<Object[]> countTotalUsersByRole();
	
	//List<User> findByFirstNameOrLastNameContains(String firstName,String lastName);

	
	
	
	
	
	
	
	
	
	/*List<User> retrieveAllUsers();

	User addUser (User u);

	void deleteUser (Long id);

	User updateUser (User u);

	User retrieveUser (Long id);
	
	List<User> getJardinEnfant(RoleName role);
	List<Object[]> countTotalUsersByNom();*/

}
