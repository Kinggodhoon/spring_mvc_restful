package gmail.kinggodhoon.restful.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gmail.kinggodhoon.restful.domain.Post;

@Repository
public class PostDao {

	@Autowired
	private SqlSession sqlSession;
	
	
	public int insert(Post post) {
		return sqlSession.insert("",post);
	}
}
