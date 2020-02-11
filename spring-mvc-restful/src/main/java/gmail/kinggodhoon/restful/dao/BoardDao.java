package gmail.kinggodhoon.restful.dao;

import java.util.List;

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
		try {
			return sqlSession.insert("board.insert",board);
		}catch(Exception e) {
			return 0;
		}
	}
	
	//게시판 리스트 받아오기
	public List<Board> list(){
		return sqlSession.selectList("board.list");
	}
}
