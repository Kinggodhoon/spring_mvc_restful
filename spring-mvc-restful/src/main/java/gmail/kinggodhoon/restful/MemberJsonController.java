package gmail.kinggodhoon.restful;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gmail.kinggodhoon.restful.domain.Member;
import gmail.kinggodhoon.restful.service.MemberService;

//userid int(11) not NULL AUTO_INCREMENT PRIMARY KEY,
//username char(20) not NULL UNIQUE,
//password char(100) not null,
//nickname char(20) not null UNIQUE,
//regdate datetime DEFAULT NOW(),
//isadmin bool DEFAULT false

@RestController
public class MemberJsonController {
	
	@Autowired
	private MemberService memberService;
	
	//유저 회원가입
	@PostMapping("/member")
	public Map<String,Object> register(@RequestBody HashMap<String,Object> body){
		String username = body.get("username").toString();
		String password = body.get("password").toString();
		String nickname = body.get("nickname").toString();
		
		Member member = new Member(username,password,nickname);
		
		int result = memberService.insert(member);
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("result", result);
		
		return map;
	}
	
	//유저 하나 정보 가져오기
	@GetMapping("/member/{userid}")
	public Member getMember(@PathVariable int userid) {
		Member member = memberService.getMember(userid);
		
		return member;
	}
	
	//유저 닉네임 변경
	@PutMapping("/member/{userid}")
	public Map<String,Object> updateNickname(@PathVariable int userid, @RequestBody HashMap<String,Object> body) {
		String nickname = body.get("nickname").toString();
		
		int result = memberService.updateNickname(userid, nickname);
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("result", result);
		
		return map;
	}
	
	//회원 탈퇴
	@DeleteMapping("/member/{userid}")
	public Map<String,Object> leaveMember(@PathVariable int userid){
		int result = memberService.delete(userid);
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("result", result);
		
		return map;
	}
}
