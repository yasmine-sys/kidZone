package tn.pi.spring.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.pi.entity.Evenement;
import tn.pi.entity.Reclamation;

@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation,Long> {

}
