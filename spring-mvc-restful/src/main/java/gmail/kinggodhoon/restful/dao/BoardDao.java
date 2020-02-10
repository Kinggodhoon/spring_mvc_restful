package gmail.kinggodhoon.restful.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gmail.kinggodhoon.restful.domain.Board;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	//가장 큰 게시판 번호를 가져오는 메소드
	public Integer findLastId() {
		return sqlSession.selectOne("board.findLastId");
	}
	
	//삽입
	public int insert(Board board) {
		return sqlSession.insert("board.insert",board);
	}
	
}
