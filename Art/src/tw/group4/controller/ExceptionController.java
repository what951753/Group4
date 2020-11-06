package tw.group4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExceptionController {
	
	@RequestMapping(path="/exception.controller", method = RequestMethod.GET)
	public void processAction() throws Exception {
		throw new Exception();
	}

}
