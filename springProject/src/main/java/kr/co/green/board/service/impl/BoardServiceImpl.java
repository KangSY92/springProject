package kr.co.green.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.green.board.dto.BoardDTO;
import kr.co.green.board.mapper.BoardMapper;
import kr.co.green.board.service.BoardService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardMapper boardMapper;
	
	
	@Override
	public List<BoardDTO> getAllposts() {
		return boardMapper.getAllPosts();
	}
	

}
