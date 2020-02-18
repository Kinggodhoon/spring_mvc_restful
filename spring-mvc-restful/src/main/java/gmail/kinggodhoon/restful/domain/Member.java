package gmail.kinggodhoon.restful.domain;

import java.sql.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Member {
	@ApiModelProperty(name="userid", notes="number of the member",hidden=true)
	private int userid;
	
	@ApiModelProperty(name="username", notes="name of the member", required=true)
	private String username;
	
	@ApiModelProperty(name="password", notes="password of the member", required=true)
	private String password;
	
	@ApiModelProperty(name="nickname", notes="nickname of the member", required=true)
	private String nickname;
	
	@ApiModelProperty(name="regdate", notes="register date of member",hidden=true)
	private Date regdate;
	
	@ApiModelProperty(name="isadmin", notes="is this admin", required=true)
	private boolean isadmin;
}
