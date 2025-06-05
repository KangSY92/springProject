package kr.co.green.board.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginAuthInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		Object id = session.getAttribute("id");
		
		if(id == null) {
			response.sendRedirect("/member/login/form");
			return false;	//컨트롤러 호출 안함
		}

		return true;		//컨트롤러 호출
	}

}
