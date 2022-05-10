package tn.pi.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.pi.spring.Iservice.IBlacklistService;
import tn.pi.spring.entity.Blacklist;
import tn.pi.spring.repository.AppUserRepository;
import tn.pi.spring.repository.BlacklistRepository;


@Service
public class BlacklistService implements IBlacklistService{

	@Autowired(required = false)
	private BlacklistRepository blacklistRepository;
	@Autowired(required = false)

	private AppUserRepository userRepository;
	
	@Override
	public void addUserToBlacklist(String email) {
		
		Blacklist b = new Blacklist();
		b.setEmail(email);
		blacklistRepository.save(b);
		
	}

	@Override
	public void deleteUserFromBlacklist(Long id) {
		blacklistRepository.deleteById(id);
		
	}

	@Override
	public List<Blacklist> getAllBlacklist() {
		return blacklistRepository.findAll();
	}
}
