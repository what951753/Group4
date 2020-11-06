package tw.group4.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.group4.model.Account;
import tw.group4.model.AccountService;

@Controller
public class CheckLoginController {
	
	@Autowired
	private Account act;

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(path = "/checkLoginEntry.controller", method = RequestMethod.GET)
	public String processCheckLoginEntryPage() {
		return "LoginSystem";
	}
	
	@RequestMapping(path = "/checkLogin.controller", method = RequestMethod.POST)
	public String processCheckLoginAction(@RequestParam(name="userName")String userName, @RequestParam(name="userPwd")String userPwd, Model m) {
		HashMap<String, String> errors = new HashMap<String,String>();
		m.addAttribute("errors", errors);
		
		if(userName==null || userName.length()==0) {
			errors.put("user", "Username is required.");
		}
		
		if(userPwd==null || userPwd.length()==0) {
			errors.put("pwd", "User password is required.");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			return "LoginSystem";
		}
		new Account("j","j");
		
		act.setUsername(userName);
		act.setUserpwd(userPwd);
		
		boolean status = accountService.checkLogin(act);
		m.addAttribute("user", userName);
		m.addAttribute("pwd", userPwd);
		
		if(status) {
			return "loginSuccess";
		}
		
		m.addAttribute("msg", "Please enter correct username or password.");
		
		return "LoginSystem"; 
	}
}
