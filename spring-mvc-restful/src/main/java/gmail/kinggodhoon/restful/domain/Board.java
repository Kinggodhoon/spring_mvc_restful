package gmail.kinggodhoon.restful.domain;

import lombok.Data;

@Data
public class Board {
	private int boardid;
	private String boardname;
	
	public Board() {}
	public Board(int boardid, String boardname) {
		this.boardid = boardid;
		this.boardname = boardname;
	}
}
