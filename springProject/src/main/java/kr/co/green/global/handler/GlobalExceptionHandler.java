package kr.co.green.global.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import kr.co.green.member.dto.MemberDTO;
import kr.co.green.member.exception.MemberException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MemberException.class)
	public ModelAndView handleMemberException(MemberException me) {
		ModelAndView mav = new ModelAndView(me.getPath());
		mav.addObject("message", me.getMessage());
		mav.addObject("status", me.getStackTrace());
		mav.addObject("memberDTO", new MemberDTO());
		
		return mav;
		
	}

}
