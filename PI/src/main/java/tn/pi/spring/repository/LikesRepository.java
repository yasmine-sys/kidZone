package tn.pi.spring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.pi.spring.entity.LikePublication;



public interface LikesRepository extends JpaRepository<LikePublication, Integer> {
	
	@Query(value="select count(*) from like_posts l where l.pub_id= :publication_id and l.user_id= :user_id ",nativeQuery=true)
	int FindUserByIdFromLikes(@Param("publication_id") int publication_id,@Param("user_id") int user_id);
	@Query(value="select count(*) from like_posts k where k.pub_id= :publication_id and k.user_id= :user_id and k.is_liked = false",nativeQuery=true)
	int FindUserByIdFromDislikes(@Param("publication_id") int publication_id,@Param("user_id") int user_id);
	@Transactional
	@Modifying
	@Query(value="delete from like_posts where pub_id= :publication_id and user_id= :user_id and is_liked = true",nativeQuery=true)
	void DeleteLike(@Param("publication_id") int publication_id,@Param("user_id") int user_id);
	@Transactional
	@Modifying
	@Query(value="delete from like_posts where pub_id= :publication_id and user_id= :user_id and is_liked = false",nativeQuery=true)
	void DeleteDisLike(@Param("publication_id") int publication_id,@Param("user_id") int user_id);
}




