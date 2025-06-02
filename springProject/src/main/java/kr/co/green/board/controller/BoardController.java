package kr.co.green.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	@GetMapping("/list")
	public String list(SearchDTO searchDTO
			,@RequestParam(value="currentPage", defaultValue="1") int currentPage
						,Model model) {
		
		int totalCount = boardService.getTotalCount(searchDTO); // 전체 게시글 수
		int pageLimit = 5; // (버튼에) 보여질 페이지 수
		int boardLimit = 5; // 한 페이지에 들어갈 게시글 수
		
		PageInfoDTO pi = pagenation.getpageInfoDTO(totalCount, currentPage, pageLimit, boardLimit);
		
		List<BoardDTO> posts = boardService.getAllposts(pi);
		model.addAttribute("posts", posts);
		model.addAttribute("pi", pi);
		model.addAttribute("search", new SearchDTO());
		return "board/list";
	}

}
