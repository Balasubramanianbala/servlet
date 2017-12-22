package in.vamsoft.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HelloController {
	
	@RequestMapping("/hello")
	public ModelAndView helloWorld() {
		System.out.println("Hello spring");
		
		String msg="Welcome to spring Controller";
		msg+="<br> continued...";
		return new ModelAndView("welcomePage", "welcomeMessage", msg);
	}
	/*@RequestMapping(method = RequestMethod.GET)public String printHello(ModelMap model) {
	      model.addAttribute("message", "Hello Spring MVC Framework!");
	      return "hello";
	   }

*/}
