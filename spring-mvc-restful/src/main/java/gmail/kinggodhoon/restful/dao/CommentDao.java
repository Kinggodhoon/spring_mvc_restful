package gmail.kinggodhoon.restful.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gmail.kinggodhoon.restful.domain.Comment;

@Repository
public class CommentDao {

	@Autowired
	private SqlSession sqlSession;
	
	public Integer insert(Comment comment) {
		return sqlSession.insert("",comment);
	}
	
}
