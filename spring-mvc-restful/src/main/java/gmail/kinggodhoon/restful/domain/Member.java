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
}
