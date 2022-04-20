package tn.pi.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.pi.spring.entity.InscriBus;

@Repository
public interface InscriBusRepository extends CrudRepository<InscriBus,Long> {

		//afficher la liste des enfants inscrits ByBus  
		@Query("SELECT e FROM InscriBus e   WHERE   e.buss.idBus=:idBus")
		List<InscriBus> getEnfantsByBus(@Param("idBus")Long idBus);
		
		//nombre des enfants inscrits
		@Query("SELECT count (*) from InscriBus")
		public int getNombreEnfantsInscriJPQL();
		
		//nombre des enfants inscrits ByBus
		@Query("SELECT count (*) from InscriBus WHERE   buss.idBus=:idBus")
		public int getNombreEnfantsInscriByBusJPQL(@Param("idBus")Long idBus);
}
