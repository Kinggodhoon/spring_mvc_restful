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
		try {
			return sqlSession.insert("member.insert",member);
		}catch(Exception e) {
			return 0;
		}
		
	}
	
	//유저 한명 검색
	public Member getMember(int userid) {
		return sqlSession.selectOne("member.getMember", userid);
	}
	
	//닉네임 변경
	public int updateNickname(int userid, String nickname) {
		Map<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("userid", userid);
		parameter.put("nickname", nickname);	
		System.out.println(parameter);
		return sqlSession.update("member.updateNickname",parameter);
	}
	
	//회원탈퇴를 통한 유저 삭제
	public int delete(int userid) {
		return sqlSession.delete("member.delete",userid);
	}
	
}
