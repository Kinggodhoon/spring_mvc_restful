package gmail.kinggodhoon.restful.service;

import gmail.kinggodhoon.restful.domain.Member;

public interface MemberService {
	public int insert(Member member);
	
	public Member getMember(int userid);
	
	public int updateNickname(int userid, String nickname);
	
	public int delete(int userid);
}
