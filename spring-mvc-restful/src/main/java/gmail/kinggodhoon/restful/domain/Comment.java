package gmail.kinggodhoon.restful.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Comment {
	private int postid;
	private String content;
	private Date posttime;
	private boolean ismember;
	private String username;
	private String userpw;
	private String userip;
	
	public Comment() {}
	public Comment(int postid, String content, boolean ismember, String username, String userpw, String userip) {
		this.postid = postid;
		this.content = content;
		this.ismember = ismember;
		this.username = username;
		this.userpw = userpw;
		this.userip = userip;
	}
}