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
import io.swagger.annotations.ApiOperation;

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
	@ApiOperation(value="회원가입", notes="성공시 1을 반환 후 DB에 유저를 삽입합니다.")
	public Map<String,Object> register(@RequestBody Member member){
		
		int result = memberService.insert(member);
		
		Map<String,Object> map = new HashMap<>();
		
		map.put("result", result);
		
		return map;
	}
	
	//유저 하나 정보 가져오기
	@GetMapping("/member/{userid}")
	@ApiOperation(value="게시판생성", notes="성공시 유저 한명을 응답합니다.")
	public Member getMember(@PathVariable int userid) {
		Member member = memberService.getMember(userid);
		
		return member;
	}
	
	//유저 닉네임 변경
	@PutMapping("/member/{userid}")
	@ApiOperation(value="게시판생성", notes="성공시 1을 반환 후 DB에서 유저 닉네임을 변경합니다.")
	public Map<String,Object> updateNickname(@PathVariable int userid, @RequestBody String nickname) {
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
