package kr.co.green;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	
	@GetMapping("/")
	public String welcome(Model model) {
		//
		model.addAttribute("name", "홍길동");
		List<String> items =Arrays.asList("강아지", "고양이", "돼지"); 
		model.addAttribute("items", items);
		
		
		
		return "index";
	}

}
