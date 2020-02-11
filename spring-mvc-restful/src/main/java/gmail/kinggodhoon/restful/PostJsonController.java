package gmail.kinggodhoon.restful;

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

import gmail.kinggodhoon.restful.domain.Post;
import gmail.kinggodhoon.restful.service.PostService;

@RestController
public class PostJsonController {

	@Autowired
	private PostService postService;
	
	@PostMapping("/post")
	public Map<String,Object> insert(@RequestBody HashMap<String,Object> body){
		System.out.println(body);
		int boardid = Integer.parseInt(body.get("boardid").toString());
		String title = body.get("title").toString();
		String content = body.get("content").toString();
		boolean ismember = Boolean.valueOf(body.get("ismember").toString());
		String username = body.get("username").toString();
		String userpw = null;
		if(body.get("userpw") != null) {
			userpw = body.get("userpw").toString();
		}
		String userip = body.get("userip").toString();
		
		Post post = new Post();
		
		post.setBoardid(boardid);
		post.setTitle(title);
		post.setContent(content);
		post.setIsmember(ismember);
		post.setUsername(username);
		post.setUserpw(userpw);
		post.setUserip(userip);
		
		System.out.println(post);
		int result = postService.insert(post);
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("result", result);
		
		return map;
	}
	
	@GetMapping("/posts/{boardid}")
	public List<Post> list(@PathVariable int boardid){
		List<Post> list = postService.list(boardid);
		return list;
	}
	
	@GetMapping("/post/{postid}")
	public Map<String,Object> getPost(@PathVariable int postid){
		Map<String,Object> map = new HashMap<>();
		
		Post post = postService.getPost(postid);
//		List<Comment> commentList = 
		
		//글과 댓글을 같이 응답
		
		return null;
	}
	
	@PutMapping("/post/{postid}")
	public Map<String,Object> update(@PathVariable int postid, @RequestBody Map<String,Object> body){
		System.out.println(body);
		
		String title = body.get("title").toString();
		String content = body.get("content").toString();
		
		Post post = new Post();
		
		post.setPostid(postid);
		post.setTitle(title);
		post.setContent(content);
		
		int result = postService.update(post);
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("result", result);
		
		return map;
	}
	
	@PutMapping("/post/{postid}/views")
	public Map<String,Object> increaseViews(@PathVariable int postid){
		int result = postService.increaseViews(postid);
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("result", result);
		
		return map;
	}
	
	@PutMapping("/post/{postid}/recommands")
	public Map<String,Object> increaseRecommands(@PathVariable int postid){
		int result = postService.increaseRecommands(postid);
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("result", result);
		
		return map;
	}
	
	@DeleteMapping("/post/{postid}")
	public Map<String,Object> delete(@PathVariable int postid){
		int result = postService.delete(postid);
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("result", result);
		
		return map;
	}
}
////삽입
//	public int insert(Post post);
//	
//	//리스트
//	public List<Post> list(int boardid);
//	
//	//조회
//	public Post getPost(int postid);
//	
//	//수정
//	public int update(Post post);
//	
//	//조회수증가
//	public int increaseViews(int postid);
//	
//	//추천수증가
//	public int increaseRecommands(int postid);
//	
//	//삭제
//	public int delete(int postid);