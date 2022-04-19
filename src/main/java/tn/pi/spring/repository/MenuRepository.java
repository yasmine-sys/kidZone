package tn.pi.spring.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.pi.entity.Menu;

@Repository
public interface MenuRepository extends CrudRepository<Menu,Long> {

}
