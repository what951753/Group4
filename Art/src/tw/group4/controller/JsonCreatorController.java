package tw.group4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.group4.model.HouseBean;

@Controller
public class JsonCreatorController {
	
	@RequestMapping(path = "/houseBeanJson", method = RequestMethod.GET)
	public String processJson(Model m) {
		
		HouseBean hBean = new HouseBean();
		hBean.setHouseid(1001);
		hBean.setHousename("Funny House");
		m.addAttribute("houseBean", hBean);
		
		return "myHouseBean";
	}

}
