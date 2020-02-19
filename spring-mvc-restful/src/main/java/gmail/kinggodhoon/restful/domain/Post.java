package gmail.kinggodhoon.restful.domain;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Post {
	@ApiModelProperty(name="boardid", notes="number of the post", hidden=true)
	private int postid;
	
	@ApiModelProperty(name="boardid", required=true, notes="number of the board")
	private int boardid;
	
	@ApiModelProperty(name="title", required=true, notes="title of the post")
	private String title;
	
	@ApiModelProperty(name="content", required=true, notes="content of the post")
	private String content;
	
	@ApiModelProperty(name="views", notes="view count of the post", hidden=true)
	private int views;
	
	@ApiModelProperty(name="recommand", notes="recommand count of the post", hidden=true)
	private int recommand;
	
	@ApiModelProperty(name="posttime", notes="posting time of the post", hidden=true)
	private Date posttime;
	
	@ApiModelProperty(name="updatetime", notes="update time of the post", hidden=true)
	private Date updatetime;
	
	@ApiModelProperty(name="ismember", required=true, notes="is this member")
	private boolean ismember;
	
	@ApiModelProperty(name="username", required=true, notes="name of the user")
	private String username;
	
	@ApiModelProperty(name="userpw", notes="password of the user")
	private String userpw;
	
	@ApiModelProperty(name="userip", required=true ,notes="ip of the user")
	private String userip;
}