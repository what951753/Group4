package tw.group4._35_.geo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.group4._35_.geo.model.Position;
import tw.group4._35_.geo.model.PositionService;

@Controller
public class RandomRecom{
	
	@Autowired
	PositionService ptService;
	
	@RequestMapping(path = "/35/randomRecom.ctrl", method = RequestMethod.GET)
    public String randomRecom(Model m) {

		List<Position> list = ptService.recommendList();
		m.addAttribute("recommend", list);
		
		return "35/geo/recomAct";
	}

}
