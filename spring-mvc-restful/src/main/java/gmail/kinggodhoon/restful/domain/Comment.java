package gmail.kinggodhoon.restful.domain;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Comment {
	@ApiModelProperty(name="postid", notes="number of the post",hidden=true)
	private int postid;
	
	@ApiModelProperty(name="content", notes="content of the comment", required=true)
	private String content;
	
	@ApiModelProperty(name="posttime", notes="posting time of the comment", hidden=true)
	private Date posttime;
	
	@ApiModelProperty(name="ismember", notes="is this member",required=true)
	private boolean ismember
	;
	@ApiModelProperty(name="username", notes="name of the user",required=true)
	private String username;
	
	@ApiModelProperty(name="userpw", notes="password of the user")
	private String userpw;
	
	@ApiModelProperty(name="userip", notes="ip of the user", required=true)
	private String userip;
}