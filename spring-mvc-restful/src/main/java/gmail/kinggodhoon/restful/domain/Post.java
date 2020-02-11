package gmail.kinggodhoon.restful.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Post {
	private int postid;
	private int boardid;
	private String title;
	private String content;
	private int views;
	private int recommand;
	private Date posttime;
	private Date updatetime;
	private boolean ismember;
	private String username;
	private String userpw;
	private String userip;
	
	public Post() {}
	public Post(int boardid, String title, String content, boolean ismember, String username, String userpw,String userip) {
		this.boardid = boardid;
		this.title = title;
		this.content = content;
		this.ismember = ismember;
		this.username = username;
		this.userpw = userpw;
		this.userip = userip;
	}
	
}