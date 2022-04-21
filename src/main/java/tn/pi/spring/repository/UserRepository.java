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
	
	
		@Query(value="select u from User u WHERE u.role like :x")
		public List<User> getJardinEnfant(@Param("x")RoleName role);
		
		 @Query("SELECT c.role, COUNT(c.role) FROM User AS c GROUP BY c.role ORDER BY c.role DESC")
			List<Object[]> countTotalUsersByNom();
		
	
}
