package tn.pi.spring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.pi.entity.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu,Long> {
	@Query(value = "SELECT * FROM menu LIMIT 1", nativeQuery=true)
	List<Menu> findRandom();
}