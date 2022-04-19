package tn.pi.spring.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.pi.spring.Iservice.Iuser;
import tn.pi.spring.entity.RoleName;
import tn.pi.spring.entity.User;
import tn.pi.spring.repository.UserRepository;


@Service
@Slf4j
public class UserService implements Iuser {
	
	@Autowired 
	UserRepository userRepository;

	@Override
	public List<User> retrieveAllUsers() {
		List<User> listUser = (List<User>) userRepository.findAll();
		return listUser;	
		}

	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		return userRepository.save(u);
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return userRepository.save(u);
	}

	@Override
	public User retrieveUser(Long id) {
		// TODO Auto-generated method stub
		 User user = userRepository.findById(id).orElse(null);
			
			return user;
	}

/*	@Override
	public List<User> getParents(RoleName role) {
		return (List<User>) userRepository.getParents(null);
	}
	@Override
	public List<User> getJardinEnfant(RoleName role) {
		return (List<User>) userRepository.getJardinEnfant(null);
	}


	@Override
	public List<User> findByRoles() {
		// TODO Auto-generated method stub
		List<User> role = (List<User>) userRepository.findByRoles(null);
		return role;
	}
	
	@Override
	public Stream<RoleName> getAllRolesStream() {
		return userRepository.getAllRolesStream();

	}*/	
	
	
}