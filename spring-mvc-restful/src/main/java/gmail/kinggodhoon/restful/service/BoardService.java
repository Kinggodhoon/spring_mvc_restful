package gmail.kinggodhoon.restful.service;

import java.util.List;

import gmail.kinggodhoon.restful.domain.Board;

public interface BoardService {
	//생성
	public int insert(Board board);
	
	//리스트
	public List<Board> list();
}
