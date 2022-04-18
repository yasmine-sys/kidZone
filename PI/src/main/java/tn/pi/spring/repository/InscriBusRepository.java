package tn.pi.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.pi.spring.entity.InscriBus;

@Repository
public interface InscriBusRepository extends CrudRepository<InscriBus,Long> {

}
