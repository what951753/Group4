package tw.group4.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TilesController {
	
	@RequestMapping(path = "/tilesNavbar/35/cms", method = RequestMethod.GET)
	public String tilesNavbar35cms() {
		
		return "redirect:/35/selectAll.ctrl";
	}
	
	@RequestMapping(path = "/tilesNavbar/35/geo", method = RequestMethod.GET)
	public String tilesNavbar35geo() {

		return "redirect:/35/randomRecom.ctrl";
	}
	
	@RequestMapping(path = "/tilesNavbar/35/csr", method = RequestMethod.GET)
	public String tilesNavbar35csr() {

		return "35/csr/csr";
	}
	
    @RequestMapping(path = { "/*/index.html", "/*/*/index.html", "/*/*/*/index.html" }, method = RequestMethod.GET)
    public String returnHome() {
        return "homePage";
    }
}
