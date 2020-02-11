package gmail.kinggodhoon.restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmail.kinggodhoon.restful.dao.MemberDao;
import gmail.kinggodhoon.restful.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public int insert(Member member) {
		int result = 0;
		
		result = memberDao.insert(member);
		
		return result;
	}

	@Override
	public Member getMember(int userid) {
		Member member = memberDao.getMember(userid);
		
		return member;
	}

	@Override
	public int updateNickname(int userid, String nickname) {
		int result = 0;
		
		result = memberDao.updateNickname(userid, nickname);
		
		return result;
	}

	@Override
	public int delete(int userid) {
		int result = 0;
		
		result = memberDao.delete(userid);
		
		return result;
	}

}
