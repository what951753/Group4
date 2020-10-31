package tw.group4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.group4.model.Members;

@Controller
public class MembersController {
	
	@RequestMapping(path = "/myformPage.controller", method = RequestMethod.GET)
	public String processFormPage(Model m) {
		Members members = new Members();
		m.addAttribute("members", members);
		return "members";
	}
	
	@RequestMapping(path ="/addMembers", method = RequestMethod.POST)
	public String processFormResult(@ModelAttribute("members") Members members, BindingResult result, Model m) {
		if(result.hasErrors()) {
			return "membersError";
		}
		
		m.addAttribute("memberName", members.getMemberName());
		m.addAttribute("memberGender", members.getGender());
		m.addAttribute("memberAge", members.getAge());
		
		return "membersResult";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
