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

@RestController
public class CommentJsonController {

	@Autowired
	private CommentService commentService;
	
	//댓글 작성
	@PostMapping("/comment/{postid}")
	public Map<String,Object> insert(@PathVariable int postid, @RequestBody Map<String,Object> body){
		String content = body.get("content").toString();
		boolean ismember = Boolean.parseBoolean(body.get("ismember").toString());
		String username = body.get("username").toString();
		String userpw = null;
		if(body.get("userpw") != null) {
			userpw = body.get("userpw").toString();
		}
		String userip = body.get("userip").toString();
		
		Comment comment = new Comment(postid, content, ismember, username, userpw, userip);
		
		int result = commentService.insert(comment);
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("result", result);
		
		return map;
	}
}