package gmail.kinggodhoon.restful;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gmail.kinggodhoon.restful.domain.Comment;
import gmail.kinggodhoon.restful.domain.Post;
import gmail.kinggodhoon.restful.service.CommentService;
import gmail.kinggodhoon.restful.service.PostService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;

@RestController
public class PostJsonController {

	@Autowired
	private PostService postService;
	@Autowired
	private CommentService commentService;
	
	//글 작성
	@PostMapping("/post")
	@ApiOperation(value="글작성", notes="성공시 1을 반환합니다.")
	public Map<String,Object> insert(@RequestBody Post post){
		Map<String,Object> map = new HashMap<>();
		
		int result = postService.insert(post);
		
		map.put("result", result);
		
		return map;
	}
	
	//글 리스트 보여주기
	@GetMapping("/posts/{boardid}")
	@ApiOperation(value="글리스트조회", notes="성공시 글 리스트를 응답합니다.")
	public List<Post> list(@PathVariable int boardid){
		List<Post> list = postService.list(boardid);
		return list;
	}
	
	//글 한개 조회
	@GetMapping("/post/{postid}")
	@ApiOperation(value="글조회", notes="성공시 글을 응답합니다.")
	public Map<String,Object> getPost(@PathVariable int postid){
		Map<String,Object> map = new HashMap<>();
		
		Post post = postService.getPost(postid);
		List<Comment> comments = commentService.list(postid);
		
		//글과 댓글을 같이 응답
		map.put("comments", comments);
		map.put("post",post);
		
		return map;
	}
	
	//글 수정
	@PutMapping("/post/{postid}")
	@ApiOperation(value="글수정", notes="성공시 1을 반환합니다.")
	@ApiImplicitParam(name="post",dataType="Post",examples= @Example(value= {@ExampleProperty(value="{'property':'test'}",mediaType="application/json")}))
	public Map<String,Object> update(@PathVariable int postid, @RequestBody Post post){
		Map<String,Object> map = new HashMap<>();
		
		Calendar cal = new GregorianCalendar();
		Date updatetime = new Date(cal.getTimeInMillis());
		post.setUpdatetime(updatetime);
		
		int result = postService.update(post);
		
		map.put("result", result);
		
		return map;
	}
	
	//글 조회수 늘리기
	@PutMapping("/post/{postid}/views")
	@ApiOperation(value="글조회수증가", notes="성공시 1을 반환합니다.")
	public Map<String,Object> increaseViews(@PathVariable int postid){
		int result = postService.increaseViews(postid);
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("result", result);
		
		return map;
	}
	
	//글 추천수 늘리기
	@PutMapping("/post/{postid}/recommands")
	@ApiOperation(value="글추천수증가", notes="성공시 1을 반환합니다.")
	public Map<String,Object> increaseRecommands(@PathVariable int postid){
		int result = postService.increaseRecommands(postid);
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("result", result);
		
		return map;
	}
	
	//글 삭제
	@DeleteMapping("/post/{postid}")
	@ApiOperation(value="글삭제", notes="성공시 1을 반환합니다.")
	public Map<String,Object> delete(@PathVariable int postid){
		int result = postService.delete(postid);
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("result", result);
		
		return map;
	}
}