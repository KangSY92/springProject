package kr.co.green.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.co.green.board.dto.BoardDTO;
import kr.co.green.board.dto.PageInfoDTO;
import kr.co.green.board.dto.SearchDTO;

public interface BoardService {
	
	List<BoardDTO> getAllposts(PageInfoDTO pi, SearchDTO searchDTO);

	int getTotalCount(SearchDTO searchDTO);
	
	int create(BoardDTO boardDTO, MultipartFile file, String sessionID);
	
	BoardDTO detail(int fbId);

	int delete(int fbId, String author, String sessionId);

	int edit(BoardDTO boardDTO, String sessionId);
}
