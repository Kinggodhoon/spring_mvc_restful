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
}