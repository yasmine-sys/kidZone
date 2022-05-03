package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.EnfantEntity;


@Repository
public interface EnfantRepository  extends JpaRepository<EnfantEntity, Long>{
	//findAll Enfant ByEventJPQL
		@Query(value="SELECT DISTINCT e.* from event ev , enfant e , reservation r where r.id_enfant=e.id_enfant AND r.id_event=ev.id_event AND r.id_event=:idEvent", nativeQuery =true)
		public List<EnfantEntity> findAllEnfantByEventJPQL(@Param("idEvent")Long idEvent);
}
