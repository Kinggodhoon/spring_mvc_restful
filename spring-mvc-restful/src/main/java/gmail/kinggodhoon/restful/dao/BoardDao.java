package gmail.kinggodhoon.restful.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gmail.kinggodhoon.restful.domain.Board;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	//삽입
	public int insert(Board board) {
		return sqlSession.insert("board.insert",board);
	}
	
	public int delete(int boardid) {
		return sqlSession.delete("board.delete",boardid);
	}
	
}
