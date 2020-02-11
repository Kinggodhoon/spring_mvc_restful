package gmail.kinggodhoon.restful.service;

import java.util.List;

import gmail.kinggodhoon.restful.domain.Comment;

public interface CommentService {

	//댓글 작성
	public int insert(Comment comment);
	
	//댓글 리스트
	public List<Comment> list(int postid);
	
}
