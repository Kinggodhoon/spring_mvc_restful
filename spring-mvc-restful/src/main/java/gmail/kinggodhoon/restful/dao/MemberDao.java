package gmail.kinggodhoon.restful.dao;

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
	
}
