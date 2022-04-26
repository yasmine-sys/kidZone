package tn.pi.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.pi.entity.ListMenu;
@Repository
public interface ListMenuRepository extends CrudRepository<ListMenu,Long>{

}
