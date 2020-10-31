package tw.group4.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(names = {"name"})
public class HelloController {
	
	@RequestMapping(path = "/formEntry.controller", method = RequestMethod.GET)
	public String processEntryPage() {
		return "form";
	}

	@RequestMapping(path = "/hello.controller", method = RequestMethod.GET)
    public String processHelloAction(@RequestParam(name = "user") String user, Model m) {
		
		Map<String, String> errors = new HashMap<String,String>();
		m.addAttribute("errors", errors);
		
		if(user==null || user.length()==0) {
			errors.put("msg", "name is required");
		}
		
		if(errors!=null && !errors.isEmpty()) {			
			return "form";
		}

		m.addAttribute("name", user);
		return "success";
    }
	
//	@Override
//	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		
//		request.setCharacterEncoding("UTF-8");
//		String user = request.getParameter("user");
//		
//		Map<String, String> errors = new HashMap<String,String>();
//		request.setAttribute("errors", errors);
//		
//		if(user==null || user.length()==0) {
//			errors.put("msg", "name is required");
//		}
//		
//		if(errors!=null && !errors.isEmpty()) {			
//			return new ModelAndView("form");
//		}
//		
//		HttpSession session = request.getSession();
//		session.setAttribute("name", user);
//		return new ModelAndView("success");
//	}

}
