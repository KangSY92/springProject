package kr.co.green.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.green.board.dto.BoardDTO;
import kr.co.green.board.dto.PageInfoDTO;
import kr.co.green.board.dto.SearchDTO;
import kr.co.green.board.service.impl.BoardServiceImpl;
import kr.co.green.board.util.Pagination;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardServiceImpl boardService;
	private final Pagination pagenation;
	
	/**
	 * 자유게시판 리스트 조회 메서드 입니다.
	 * 
	 * @param searchDTO 검색(제목, 내용)을 받는 DTO
	 * @param currentPage 현재 페이지 호출
	 * @return list.html 호출
	 */
	@GetMapping("/list")
	public String list(SearchDTO searchDTO
			,@RequestParam(value="currentPage", defaultValue="1") int currentPage
						,Model model) {
		
		int totalCount = boardService.getTotalCount(searchDTO); // 전체 게시글 수
		int pageLimit = 5; // (버튼에) 보여질 페이지 수
		int boardLimit = 5; // 한 페이지에 들어갈 게시글 수
		
		PageInfoDTO pi = pagenation.getpageInfoDTO(totalCount, currentPage, pageLimit, boardLimit);
		
		List<BoardDTO> posts = boardService.getAllposts(pi, searchDTO);
		model.addAttribute("posts", posts);
		model.addAttribute("pi", pi);
		model.addAttribute("search", searchDTO);
		return "board/list";
	}
	
	@GetMapping("/create/form")
	public String createForm(Model model) {
		model.addAttribute("board", new BoardDTO());
		return "board/create";
	}
	
	@PostMapping("/create")
	public String create(BoardDTO boardDTO, 
						 @SessionAttribute("id") String sessionID) {
		int result = boardService.create(boardDTO, sessionID);
		return "redirect:/board/list";
	}

	@GetMapping("/detail")
	public String detail(@RequestParam(name="fbId") int fbId, Model model) {
		BoardDTO result = boardService.detail(fbId);
		model.addAttribute("board", result);
		return "board/detail";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam(name="fbId") int fbId,
						 @RequestParam(name="author") String author,
						 @SessionAttribute("id") String sessionId) {
		int result = boardService.delete(fbId, author, sessionId);
		return "redirect:/board/list";
	}
	
	@PostMapping("/edit/form")
	public String editForm(@RequestParam(name="fbId") int fbId, Model model) {
		BoardDTO result = boardService.detail(fbId);
		model.addAttribute("board", result);
		return "board/edit";
	}
	
	@PostMapping("/edit")
	public String edit(BoardDTO boardDTO, @SessionAttribute("id") String sessionId,
					   RedirectAttributes redirectAttributes) {
		int result = boardService.edit(boardDTO, sessionId);
		
		// redirect (Controller -> Controller) 사용할 때 데이터 넘기는 방법
		// 1. redirectAttributes
		// - 리다이렉트할 때 주로 사용
		// - 일회성 데이터 전달
		// 2. model-forward
		// 3. GET요청일 경우 쿼리스트링 사용
		// 4. 세션 사용
		redirectAttributes.addAttribute("fbId", boardDTO.getFbId());
//		redirectAttributes.addFlashAttribute("fbId", boardDTO.getFbId());
		return "redirect:/board/detail";
	}
	
}
