package gmail.kinggodhoon.restful.service;

import java.util.List;

import gmail.kinggodhoon.restful.domain.Post;

public interface PostService {
	//삽입
	public int insert(Post post);
	
	//리스트
	public List<Post> list(int boardid);
	
	//조회
	public Post getPost(int postid);
	
	//수정
	public int update(Post post);
	
	//조회수증가
	public int increaseViews(int postid);
	
	//추천수증가
	public int increaseRecommands(int postid);
	
	//삭제
	public int delete(int postid);
	
}
