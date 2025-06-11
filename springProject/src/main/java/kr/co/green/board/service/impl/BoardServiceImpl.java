package kr.co.green.board.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.multipart.MultipartFile;

import kr.co.green.boar.mapper.BoardMapper;
import kr.co.green.board.dto.BoardDTO;
import kr.co.green.board.dto.FileDTO;
import kr.co.green.board.dto.PageInfoDTO;
import kr.co.green.board.dto.SearchDTO;
import kr.co.green.board.service.BoardService;
import kr.co.green.board.transaction.TransactionHandler;
import kr.co.green.board.util.FileUpload;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardMapper boardMapper;
	private final FileUpload fileUpload;
	private final TransactionHandler transactionHandler;
	
	
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
	public int create(BoardDTO boardDTO, MultipartFile file, String sessionID) {
		// 1. 트랜잭션 설정 및 시작(현재 트랜잭션의 상태를 가져옴)
		TransactionStatus status = transactionHandler.getStatus();

		// 2. commit, rollback을 사용하기 위한 객체
		PlatformTransactionManager transactionManager = transactionHandler.getTransactionManager();
		
		if(boardDTO.getAuthor().equals(sessionID)) {
			int result = boardMapper.create(boardDTO);
			
			if(file != null && !file.isEmpty()) {
				
				try {
					FileDTO fileDTO = new FileDTO();
					fileDTO.setFbId(boardDTO.getFbId());
					fileUpload.upload(file, fileDTO);
					boardMapper.createFile(fileDTO);
					
					transactionManager.commit(status);
				} catch (IOException e) {
					transactionManager.rollback(status);
					e.printStackTrace();
				}
			}
			return result;
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
			// 1.게시글 삭제 (ststus 컬럼 N)
			int result = boardMapper.delete(fbId);
			
			// 2. 서버(로컬)에 저장 된 파일 삭제
			String changeName = boardMapper.getFileChangeName(fbId);
			fileUpload.deleteFile(changeName);
			
			// 3. DB에 저장 된 파일 정보 삭제
			boardMapper.deleteFile(fbId, changeName);
			
			return result;
		} else {
			return 0;
		}
	}
	
	@Override
	public int edit(BoardDTO boardDTO, String sessionId) {
		if(boardDTO.getAuthor().equals(sessionId)) {
//			if(file != null && !file.isEmpty()) {
//				// 1. 기존 파일에 대한 정보 삭제(로컬, DB)
//				
//				// 2. 새로운 파일을 업로드(로컬, DB)
//				
//			}
			return boardMapper.edit(boardDTO);
		}
		return 0;
	}
}
