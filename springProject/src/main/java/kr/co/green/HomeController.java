package kr.co.green;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class HomeController {
	
	
	@GetMapping("/")
	public String doHome(Model model,
						 @SessionAttribute(name="name", required=false) String name) {
		
		model.addAttribute("name", name);
		
		return "home";
	}
	
	
	
	
//	@GetMapping("/")
//	public String doHome(Model model, HttpSession session) {
//		Object name = session.getAttribute("name");
//		model.addAttribute("name", name);
//		
//		return "home";
//	}

}
