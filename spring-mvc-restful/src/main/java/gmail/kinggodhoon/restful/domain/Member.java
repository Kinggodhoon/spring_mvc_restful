package gmail.kinggodhoon.restful.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class Member {
	private int userid;
	private String username;
	private String password;
	private String nickname;
	private Date regdate;
	private boolean isadmin;
	
	public Member() {}
	
	public Member(String username,String password, String nickname) {
		this.username = username;
		this.password = password;
		this.nickname = nickname;
	}
	
	
}
