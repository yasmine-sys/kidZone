package tn.pi.spring.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.spring.entity.RoleName;
import tn.pi.spring.entity.User;


@Repository
public interface UserRepository  extends CrudRepository<User, Long> {


	//lister les parents ayant le role x
	//@Query(value="SELECT nom FROM user u WHERE u.role=:Parent",nativeQuery = true)
	//public List<User> getParents(List<String> role);
	
	//lister les enfants ayant le role x
		//@Query(value="select * from user u WHERE u.role=\"KIDZONEPROFILE\"",nativeQuery = true)
		//public List<User> getJardinEnfant(List<String> role);
	/*
	@Query("SELECT count(e.id), e.profession FROM user e group by e.profession")
	public List<String> getprofession();*/
	
	//lister tous les user by role
		//@Query( "select u from User u  where u.role in :role" )
		//public List<User> findByRoles( List<String> role);
		
		//@Query("select * from user u WHERE u.role=\"KIDZONEPROFILE\"")
	    //Stream<RoleName> getAllRolesStream();// Java8 Stream : on place la liste des rôles dans un Stream
}
