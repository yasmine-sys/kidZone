package tn.esprit.spring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.EnfantEntity;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long> {
	
	//lister les parents ayant le role x
	@Query(value="SELECT nomu FROM user e WHERE e.role=:parent",nativeQuery = true)
	public List<UserEntity> getParents(@Param("parent")Role role);
	
	//getChildren by userId
	@Query(value= "SELECT e.nom FROM user u, enfant e where u.id_user=e.user_id_user AND u.id_user:=id",nativeQuery = true)
	 List<EnfantEntity> getChildren(@Param("id") Long id);
	/*
	@Query("SELECT count(e.id), e.profession FROM user e group by e.profession")
	public List<String> getprofession();*/
	
	//lister tous les user by role
	@Query(value="Select * FROM user u where u.role=:role",nativeQuery = true)
	List<UserEntity> findAllByRole(@Param("role") Role role);	
}
