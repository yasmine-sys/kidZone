package tn.esprit.spring.interfaces;
import java.util.List;

import tn.esprit.spring.entity.EnfantEntity;
import tn.esprit.spring.entity.UserEntity;
import tn.esprit.spring.entity.Role;
public interface IUserService {
	
	public List<UserEntity> getAllUserEntitys();
	UserEntity addUserEntity(UserEntity u);
	void deleteUserEntity(Long id);
	UserEntity updateUserEntity(UserEntity u);
	
	public UserEntity getUserEntityById(Long id);

	List<UserEntity> getParents(Role role);

	void affecterchildAparent(Long childId, Long parentId) ;
	List<EnfantEntity> getEnfant(Long id);
	
}
