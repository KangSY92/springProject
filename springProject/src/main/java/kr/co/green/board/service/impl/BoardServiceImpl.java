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
	public List<BoardDTO> getAllposts(PageInfoDTO pi, SearchDTO searchDTO) {
		//전체 게시글 수

		
		return boardMapper.getAllPosts(pi, searchDTO);
	}
	@Override
	public int getTotalCount(SearchDTO searchDTO) {
		return boardMapper.getTotalCount(searchDTO);
	}
	
	@Override
	public int create(BoardDTO boardDTO, String sessionID) {
		if(boardDTO.getAuthor().equals(sessionID)) {
			return boardMapper.create(boardDTO);
		} else {
			return 0;
		}
	}

	@Override
	public BoardDTO detail(int fbId) {
		int viewCountResult = boardMapper.incrementViewCount(fbId);
		
		if(viewCountResult == 1) {
			return boardMapper.detail(fbId);
		} else {
			return null;
		}
		
	}
	
	@Override
	public int delete(int fbId, String author, String sessionId) {
		if(author.equals(sessionId)) {
			return boardMapper.delete(fbId);
		} else {
			return 0;
		}
	}
	
	@Override
	public int edit(BoardDTO boardDTO, String sessionId) {
		if(boardDTO.getAuthor().equals(sessionId)) {
			return boardMapper.edit(boardDTO);
		}
		return 0;
	}
}
