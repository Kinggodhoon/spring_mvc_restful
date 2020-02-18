package gmail.kinggodhoon.restful;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gmail.kinggodhoon.restful.domain.Comment;
import gmail.kinggodhoon.restful.service.CommentService;
import io.swagger.annotations.ApiOperation;

@RestController
public class CommentJsonController {

	@Autowired
	private CommentService commentService;
	
	//댓글 작성
	@PostMapping("/comment/{postid}")
	@ApiOperation(value="댓글작성", notes="성공시 1을 반환 후 DB에 댓글을 삽입합니다.")
	public Map<String,Object> insert(@PathVariable int postid, @RequestBody Comment comment){
		Map<String,Object> map = new HashMap<>();
		
		comment.setPostid(postid);
		int result = commentService.insert(comment);
		
		map.put("result", result);
		
		return map;
	}
}