package gmail.kinggodhoon.restful.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gmail.kinggodhoon.restful.domain.Member;

@Repository
public class MemberDao {

	@Autowired
	private SqlSession sqlSession;
	
	//삽입
	public int insert(Member member) {
		return sqlSession.insert("member.insert");
	}
	
	//유저 한명 검색
	public Member getMember(int memberid) {
		return sqlSession.selectOne("member.getMember", memberid);
	}
	
	//닉네임 변경
	public int updateNickname(int memberid, String nickname) {
		Map<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("memberid", memberid);
		parameter.put("nickname", nickname);
		
		return sqlSession.update("member.updateNickname",parameter);
	}
	
	//회원탈퇴를 통한 유저 삭제
	public int delete(int memberid) {
		return sqlSession.delete("member.delete",memberid);
	}
	
}
