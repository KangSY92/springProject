package kr.co.green.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
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
	public String register(@Valid MemberDTO memberDTO, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("bindingResult", bindingResult);  //생략 가능
			return "member/register";
		}
		
		int resert = memberService.register(memberDTO);
		return "redirect:/member/login/form";
	}
	
	@GetMapping("/login/form")
	public String loginForm() {
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(MemberDTO memberDTO, HttpSession session) {
		MemberDTO result = memberService.login(memberDTO);
		
		if(result != null) {
			session.setAttribute("memberId", result.getMemberId());
			session.setAttribute("id", result.getId());
			session.setAttribute("name", result.getName());
			session.setAttribute("status", result.getStatus());
			return "redirect:/";
		}
		
		return "redirect:/member/login/form";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
			session.invalidate(); // 세션 무효화
		return "redirect:/";
	}
	
}
