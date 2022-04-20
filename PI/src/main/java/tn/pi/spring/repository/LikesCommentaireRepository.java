package tn.pi.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.pi.spring.entity.LikeCommentaire;

public interface LikesCommentaireRepository extends JpaRepository<LikeCommentaire, Integer>  {
	
	@Query(value="select count(*) from like_comments l where l.com_id= :publication_id and l.user_id= :user_id and interaction_type = 'like' and is_liked=1",nativeQuery=true)
	int LikesComments(@Param("publication_id") int publication_id,@Param("user_id") int user_id);
	
	
	@Query(value="select count(*) from like_comments l where l.com_id= :publication_id and l.user_id= :user_id and interaction_type = 'love' and is_liked=1",nativeQuery=true)
	int LoveComments(@Param("publication_id") int publication_id,@Param("user_id") int user_id);
	
	
	@Query(value="select count(*) from like_comments l where l.com_id= :publication_id and l.user_id= :user_id and interaction_type = 'haha' and is_liked=1",nativeQuery=true)
	int HahaComments(@Param("publication_id") int publication_id,@Param("user_id") int user_id);
	
	
	@Query(value="select count(*) from like_comments l where l.com_id= :publication_id and l.user_id= :user_id and interaction_type = 'sad' and is_liked=1",nativeQuery=true)
	int SadComments(@Param("publication_id") int publication_id,@Param("user_id") int user_id);
	
	
	@Query(value="select count(*) from like_comments l where l.com_id= :publication_id and l.user_id= :user_id and interaction_type = 'angry' and is_liked=1",nativeQuery=true)
	int AngryComments(@Param("publication_id") int publication_id,@Param("user_id") int user_id);

}
