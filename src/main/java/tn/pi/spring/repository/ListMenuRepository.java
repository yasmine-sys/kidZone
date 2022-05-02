package tn.pi.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.pi.entity.ListMenu;
@Repository
public interface ListMenuRepository extends CrudRepository<ListMenu,Long>{
	@Query(value = "SELECT * FROM `list_menu`ORDER BY RAND() LIMIT 1", nativeQuery=true)
	List<ListMenu> findRandom();
}
