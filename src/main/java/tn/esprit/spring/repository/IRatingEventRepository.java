package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Rating;
@Repository
public interface IRatingEventRepository extends JpaRepository<Rating, Integer> {
	@Query(value="SELECT AVG(rat.rating_value) FROM rating rat", nativeQuery =true)
	public int getAvgOfValueRating();
	
	@Query(value="SELECT * FROM rating rat WHERE rat.event_rat_id_event=:idEvent", nativeQuery =true)
	public List<Rating> findRatingEventByEvent(@Param("idEvent")int eventRat);
}
