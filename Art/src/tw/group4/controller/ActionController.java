package tw.group4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//銝annotaion���"result"霅摮葡����ession蝑��
@SessionAttributes(names= {"result"})
public class ActionController {
	
	@RequestMapping(path = "/action.controller", method = RequestMethod.GET)
	public String processAction(Model m) {
		m.addAttribute("result","happy day");
		return "resultPage";
	}
	
	@RequestMapping(path="/myaction.controller")
	public String processAction2(Model m) {
		m.addAttribute("result","wonderful hour");
		return "/35/NewFile";
	}
	
	@RequestMapping(path="/myaction.controller1")
	public String processAction1(Model m) {
		m.addAttribute("result","wonderful hour");
		return "New";
	}
	
	@RequestMapping(path="/myaction.controller2")
	public String processAction3(Model m) {
		m.addAttribute("result","wonderful hour");
		return "memberPage";
	}
	
}
