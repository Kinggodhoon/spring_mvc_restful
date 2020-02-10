package gmail.kinggodhoon.restful.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gmail.kinggodhoon.restful.domain.Post;

@Repository
public class PostDao {

	@Autowired
	private SqlSession sqlSession;
	
	//글 작성
	public int insert(Post post) {
		return sqlSession.insert("post.insert",post);
	}
	
	//글 리스트
	public List<Post> list(int boardid){
		return sqlSession.selectList("post.listWithBoardid",boardid);
	}
	
	//글 조회
	public Post getPost(int postid) {
		return sqlSession.selectOne("post.getPost",postid);
	}
	
	//글 수정
	public int update(Post post) {
		return sqlSession.update("post.update",post);
	}
	
	//글 추천 증가
	public int increaseRecommand(int postid) {	
		return sqlSession.update("post.increaseRecommand", postid);
	}
	
	//글 조회수 증가
	public int increaseViews(int postid) {
		return sqlSession.update("post.increaseViews", postid);
	}
	
	//글 삭제
	public int delete(int postid) {
		return sqlSession.delete("post.delete",postid);
	}
	
}
