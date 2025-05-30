package kr.co.green.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.green.board.dto.BoardDTO;
import kr.co.green.board.service.impl.BoardServiceImpl;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardServiceImpl boardService;
	
	@GetMapping("/list")
	public String list() {
		List<BoardDTO> posts = boardService.getAllposts();
		return "board/list";
	}

}
