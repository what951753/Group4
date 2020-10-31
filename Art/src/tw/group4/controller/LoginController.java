package tw.group4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping(path="/login.controller", method=RequestMethod.POST)
	public void checkLogin(@RequestParam(name = "userName") String user, @RequestParam(name = "userPwd") String pwd) {
		
		System.out.println(user);
		System.out.println(pwd);
		
		if("jim".equalsIgnoreCase(user) && "test321".equalsIgnoreCase(pwd)) {
			System.out.println("Success !!");
			return;
		}
		System.out.println("Your username or password is not correct!");
	}
}
