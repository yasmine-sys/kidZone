package tn.pi.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.pi.entity.Jardinenfant;

@Repository
public interface JardinenfantRepository extends CrudRepository<Jardinenfant,Long> {

}
