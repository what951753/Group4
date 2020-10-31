package tw.group4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class MyController {
 
    @RequestMapping(path = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage(Model model) {
        return "homePage";
    }
    
    @RequestMapping(path = { "/memberPage" }, method = RequestMethod.GET)
    public String memberPage(Model model) {
    	return "memberPage";
    }
 
     
    @RequestMapping(path = { "/contactus" }, method = RequestMethod.GET)
    public String contactusPage(Model model) {
        model.addAttribute("address", "Vietnam");
        model.addAttribute("phone", "...");
        model.addAttribute("email", "...");
        return "contactusPage";
    }
     
}