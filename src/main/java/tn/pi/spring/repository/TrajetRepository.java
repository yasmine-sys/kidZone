package tn.pi.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.spring.entity.Trajet;

@Repository
public interface TrajetRepository extends CrudRepository<Trajet,Long>{

<<<<<<< Updated upstream
	@Query("SELECT t FROM Trajet t WHERE t.longeur_trajet=:longueur")
	List<Trajet> retrieveTrajetByLongeurTrajet(@Param("longueur") Long longueur);
=======
	@Query("SELECT t FROM Trajet t WHERE t.longueur_trajet=:longueur")
	List<Trajet> retrieveTrajetByLongueurTrajet(@Param("longueur") Long longueur);
>>>>>>> Stashed changes

}

