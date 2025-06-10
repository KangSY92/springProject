package kr.co.green.board.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import kr.co.green.board.dto.FileDTO;

@Component
public class FileUpload {
	
	public void upload(MultipartFile file, FileDTO fileDTO) throws IOException {
		// 1. 원본 파일 이름
		String originalName = file.getOriginalFilename();
		
		// 2. 새로운 파일 이름
		String changeName = UUID.randomUUID().toString() + getFileExtension(originalName); 
		
		// 3. 서버에 저장될 경로 설정
		Path path = Paths.get(FileDTO.LOCAL_PATH + changeName);
		
		// 4.파일 저장
		Files.write(path, file.getBytes());
		
		// 5. fileDTO에 정보 저장
		fileDTO.setOriginalName(originalName);
		fileDTO.setChangeName(changeName);
		
		
	}
	
	public void deleteFile(String changeName) {
		Path path = Paths.get(FileDTO.LOCAL_PATH + changeName);
		try {
			Files.delete(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String getFileExtension(String originalName) {
		// originalName : 제목없음.png
		// dotIndex : 4
		
		int dotIndex = originalName.lastIndexOf('.');
		return dotIndex == -1 ? "" : originalName.substring(dotIndex);
	}
	

	

}
