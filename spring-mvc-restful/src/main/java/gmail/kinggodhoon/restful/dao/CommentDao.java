package gmail.kinggodhoon.restful.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gmail.kinggodhoon.restful.domain.Comment;

@Repository
public class CommentDao {

	@Autowired
	private SqlSession sqlSession;
	
	//댓글 작성
	public int insert(Comment comment) {
		return sqlSession.insert("comment.insert",comment);
	}
	
	//댓글 리스트
	public List<Comment> list(int postid){
		return sqlSession.selectList("comment.list", postid);
	}
	  
}
