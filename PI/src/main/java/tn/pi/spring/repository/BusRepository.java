package tn.pi.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.pi.spring.entity.Bus;

@Repository
public interface BusRepository extends CrudRepository<Bus,Long>{

}
