package gmail.kinggodhoon.restful.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Board {
	@ApiModelProperty(name="boardid", required=true, notes="number of the board")
	private int boardid;
	@ApiModelProperty(name="boardname", required=true, notes="name of the board")
	private String boardname;
}
