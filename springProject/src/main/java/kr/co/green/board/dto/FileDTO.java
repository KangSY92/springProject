package kr.co.green.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileDTO {
	public static final String LOCAL_PATH = "C:\\dev\\git-workspace\\springProject\\src\\main\\resources\\static\\uploads\\";
	public static final String RESOURCES_PATH = "/uploads/";
	
	private int fbfId;
	
	/** 게시글 PK */
	private int fbId;
	private String changeName;
	private String originalName;
	private String uploadedDate;
	private String extension;
	private long size;
	
}
