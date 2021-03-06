package tn.pi.spring.Iservice;

import java.util.List;
import java.util.stream.Stream;

import tn.pi.spring.entity.RoleName;
import tn.pi.spring.entity.User;


public interface Iuser {

	List<User> retrieveAllUsers();

	User addUser (User u);

	void deleteUser (Long id);

	User updateUser (User u);

	User retrieveUser (Long id);
	
	List<User> getRole(RoleName role);
	List<Object[]> countTotalUsersByNom();

}
