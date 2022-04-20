package tn.pi.spring.services;

import java.util.List;

import tn.pi.spring.entity.User;


public interface Iuser {

	List<User> retrieveAllUsers();

	User addUser (User u);

	void deleteUser (Long id);

	User updateUser (User u);

	User retrieveUser (Long id);
}
