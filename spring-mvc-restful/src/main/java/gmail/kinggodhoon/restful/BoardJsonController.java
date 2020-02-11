package gmail.kinggodhoon.restful;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gmail.kinggodhoon.restful.domain.Board;
import gmail.kinggodhoon.restful.service.BoardService;

@RestController
public class BoardJsonController {

	@Autowired
	private BoardService boardService;
	
	@PostMapping("/boards")
	public Map<String,Object> insert(@RequestBody HashMap<String,Object> body){
		int boardid = Integer.parseInt(body.get("boardid").toString());
		String boardname = body.get("boardname").toString();
		
		Board board = new Board(boardid,boardname);
		
		int result = boardService.insert(board);
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("result", result);
		
		return map;
	}
	
	@GetMapping("/boards")
	public List<Board> list(){
		List<Board> list = boardService.list();
		
		return list;
	}
	
}
