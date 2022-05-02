package tn.pi.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.pi.entity.Enfant;

@Repository
public interface EnfantRepository extends CrudRepository<Enfant,Long>{

}
