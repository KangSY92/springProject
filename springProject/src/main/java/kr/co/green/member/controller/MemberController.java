package kr.co.green.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.green.member.dto.MemberDTO;
import kr.co.green.member.service.impl.MemberServiceImpl;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberServiceImpl memberService;


	@GetMapping("/register/form")
	public String registerForm(Model model) {
		model.addAttribute("memberDTO", new MemberDTO());
		return "member/register";
				
	}
	
	@PostMapping("/register")
	public String register(MemberDTO memberDTO) {
		
		return null;
	}
	
	
	
}
