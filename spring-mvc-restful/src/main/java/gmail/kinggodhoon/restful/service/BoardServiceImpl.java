package gmail.kinggodhoon.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmail.kinggodhoon.restful.dao.BoardDao;
import gmail.kinggodhoon.restful.domain.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public int insert(Board board) {
		int result = 0;
		
		result = boardDao.insert(board);
		
		return result;
	}

	@Override
	public List<Board> list() {
		List<Board> list = null;
		
		list = boardDao.list();
		
		return list;
	}

}
