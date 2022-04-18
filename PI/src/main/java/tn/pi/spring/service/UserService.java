package tn.pi.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.pi.spring.entity.User;
import tn.pi.spring.iservice.Iuser;
import tn.pi.spring.repository.UserRepository;

@Service 
@Slf4j
public class UserService implements Iuser{
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> retrieveAllUser() {
		List<User> users = (List<User>) userRepository.findAll();
		for (User user : users) {
			log.info(" User : " + user);
		}
		return users;
	}

	@Override
	public User addUser(User u) {
		log.info("In method addUser");
		return userRepository.save(u);
	}

	@Override
	public void deleteUser(Long id) {
		log.info("In method deleteUser");
		userRepository.deleteById(id);
		
	}

	@Override
	public User updateUser(User u) {
		log.info("In method updateUser");
		return userRepository.save(u);
	}

	@Override
	public User retrieveUser(Long id) {
		User user = userRepository.findById(id).orElse(null);
		return user;
	}
}
