package kr.co.green.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BoardDTO {
	
	private int fbId;
	private String title;
	private String content;
	private String author;
	private String createdDate;
	private String modifiedDate;
	private int viewCount;
	private String status;

	private FileDTO fileDTO = new FileDTO();
	
}
