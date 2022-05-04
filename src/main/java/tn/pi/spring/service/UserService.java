package tn.pi.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tn.pi.spring.Iservice.IuserManagement;
import tn.pi.spring.entity.RoleName;
import tn.pi.spring.entity.User;
import tn.pi.spring.repository.AppUserRepository;
@Service
public class UserService implements IuserManagement {
	
	@Autowired 
	AppUserRepository myRepository;

	@Override
	public List<User> getUsers() {
		return myRepository.findAll(Sort.by(Sort.Direction.DESC, "firstName"));

	}

	@Override
	public User findByEmail(String email) {
		return myRepository.findByEmail(email).orElse(null);
	}

	@Override
	public void deleteUser(String email) {
		User u = myRepository.findByEmail(email).orElse(null);
		myRepository.delete(u);
		
	}

	@Override
	public void updateUser(User user) {
		 myRepository.save(user);
		
	}

	@Override
	public List<User> findByFirstNameContains(String firstName) {
		return myRepository.findByFirstNameContains(firstName);
	}

	@Override
	public List<User> getRole(RoleName role) {
		
		return myRepository.getRole(role);
	}

	@Override
	public List<Object[]> countTotalUsersByRole() {
		// TODO Auto-generated method stub
		return myRepository.countTotalUsersByRole();
	}

	
	
	
	
}