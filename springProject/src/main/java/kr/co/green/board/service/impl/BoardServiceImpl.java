package kr.co.green.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.green.board.dto.BoardDTO;
import kr.co.green.board.dto.PageInfoDTO;
import kr.co.green.board.dto.SearchDTO;
import kr.co.green.board.mapper.BoardMapper;
import kr.co.green.board.service.BoardService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardMapper boardMapper;
	
	
	@Override
	public List<BoardDTO> getAllposts(PageInfoDTO pi) {
		//전체 게시글 수

		
		return boardMapper.getAllPosts(pi);
	}
	@Override
	public int getTotalCount(SearchDTO searchDTO) {
		return boardMapper.getTotalCount(searchDTO);
	}

}
