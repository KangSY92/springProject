package kr.co.green.board.service;

import java.util.List;

import kr.co.green.board.dto.BoardDTO;
import kr.co.green.board.dto.PageInfoDTO;
import kr.co.green.board.dto.SearchDTO;

public interface BoardService {
	
	List<BoardDTO> getAllposts(PageInfoDTO pi);

	int getTotalCount(SearchDTO searchDTO);
}
