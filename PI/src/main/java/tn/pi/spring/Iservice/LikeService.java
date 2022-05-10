package tn.pi.spring.Iservice;

import java.util.List;

import tn.pi.spring.entity.LikePublication;


public interface LikeService {
	
	public void AddLike(LikePublication likes, int user_id,int pub_id);
	public List<LikePublication> GetLikes();
	public void AddDislike(LikePublication likes, int user_id,int pub_id);
	public void Deletelike(int user_id,int pub_id);
	public void DeleteDislike(int user_id,int com_id);

}
