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
import io.swagger.annotations.ApiOperation;

@RestController
public class BoardJsonController {

	@Autowired
	private BoardService boardService;
	
	//게시판 생성
	@PostMapping("/board")
	@ApiOperation(value="게시판생성", notes="성공시 1을 반환 후 DB에 게시판 삽입합니다.")
	public Map<String,Object> insert(@RequestBody Board board){
		int result = boardService.insert(board);
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("result", result);
		
		return map;
	}
	
	//게시판 리스트 보여주기
	@GetMapping("/board")
	@ApiOperation(value="게시판리스트", notes="성공시 게시판의 리스트를 응답합니다.")
	public List<Board> list(){
		List<Board> list = boardService.list();
		
		return list;
	}
	
}
