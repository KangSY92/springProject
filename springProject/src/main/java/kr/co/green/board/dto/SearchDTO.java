package kr.co.green.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SearchDTO {
	private String category = "title";
	private String text = "";

}
