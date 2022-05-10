package tn.pi.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.pi.spring.entity.RoleName;
import tn.pi.spring.entity.User;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
	
	 
    @Transactional
    @Modifying
    @Query("UPDATE User a " + "SET a.password = ?1 WHERE a.email = ?2")
    void resetPassword(String password,String email);
    
	@Transactional
    @Modifying
    @Query("UPDATE User a " + "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);
	
	 
    List<User> findByFirstNameContains(String firstName);
    
    
	@Query(value="select u from User u WHERE u.role like :x")
	public List<User> getRole(@Param("x")RoleName role);
	
	 @Query("SELECT c.role, COUNT(c.role) FROM User AS c GROUP BY c.role ORDER BY c.role DESC")
		List<Object[]> countTotalUsersByRole();


    
}

