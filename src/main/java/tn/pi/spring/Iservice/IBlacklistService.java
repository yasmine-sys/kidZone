package tn.pi.spring.Iservice;

import java.util.List;

import tn.pi.spring.entity.Blacklist;

	public interface IBlacklistService {
		public void addUserToBlacklist(String email);
		public void deleteUserFromBlacklist(Long id);
		public List<Blacklist> getAllBlacklist();

	}

