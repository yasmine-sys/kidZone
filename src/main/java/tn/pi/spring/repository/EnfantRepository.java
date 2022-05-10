package tn.pi.spring.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.spring.entity.Enfant;

@Repository
public interface EnfantRepository extends CrudRepository<Enfant,Long>{
	//afficher villeEnfant By idEnfant  
	@Query(value="SELECT ville from enfant e where e.id_enfant=:idEnfant", nativeQuery =true)
	public String afficherVilleEnfantByIdEnfant(@Param("idEnfant")Long idEnfant);
}
