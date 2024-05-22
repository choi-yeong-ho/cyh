package edu.mit.quiz;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
//@RequestMapping("/quiz1")
@AllArgsConstructor
public class QuizController {
	
	@GetMapping("/quiz1")
	public void list(Model model) {
		model.addAttribute("aaa", "이해했다.");
	}
	
}
