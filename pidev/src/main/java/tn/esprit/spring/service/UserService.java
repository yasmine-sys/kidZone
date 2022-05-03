package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import tn.esprit.spring.entity.EnfantEntity;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.UserEntity;
import tn.esprit.spring.interfaces.IUserService;
import tn.esprit.spring.repository.EnfantRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserService implements IUserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	EnfantRepository enfantRepository;

	@Override
	public List<EnfantEntity> getChildren(Long idUser) {
		return userRepository.getChildren(idUser);
	}

	@Override
	public List<UserEntity> getAllUserEntitys() {
		return (List<UserEntity>) userRepository.findAll();
	}

	@Override
	public UserEntity addUserEntity(UserEntity u) {
		return userRepository.save(u);

	}

	@Override
	public void deleteUserEntity(Long id) {
		userRepository.deleteById(id);

	}

	@Override
	public UserEntity updateUserEntity(UserEntity u) {
		userRepository.save(u);
		return u;

	}

	@Override
	public UserEntity getUserEntityById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public List<UserEntity> getParents(Role role) {
		return (List<UserEntity>) userRepository.getParents(role);
	}
	
    //@Transactional
	/*@Override
	public void affecterchildAparent(Long childId, Long parentId) {
		UserEntity p = userRepository.findById(parentId).orElse(null);
		EnfantEntity c = enfantRepository.findById(childId).orElse(null);
		p.setEnfant(c);
		enfantrepository.save(c);
	
	}*/
	
	/*	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Stock st = stockRepository.findById(idStock).orElse(null);
		Produit product = produitRepository.findById(idProduit).orElse(null);
		product.setStock(st);
		produitRepository.save(product);
	}*/

	/*@Override
	public List<EnfantEntity> getEnfant(Long id) {
		return (List<EnfantEntity>) userRepository.getChildren(id);
	}*/

}
