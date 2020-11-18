package tw.group4._04_.back.controller;

import java.text.ParseException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.group4._04_.back.model.ShowBean;
import tw.group4.util.IdentityFilter;

@Controller
public class JSPDirectCMS {
	@RequestMapping(path = "/04/index_back", method = RequestMethod.GET)
	public String processShowDetail( ) {
		
		return IdentityFilter.loginID+"04/cms_Act/index_back";
	}
}
