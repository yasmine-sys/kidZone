package tn.pi.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.pi.entity.InscriCantine;
@Repository
public interface InscriCantineRepository extends CrudRepository<InscriCantine,Long> {

}
