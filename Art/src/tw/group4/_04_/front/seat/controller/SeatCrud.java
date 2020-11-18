package tw.group4._04_.front.seat.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import oracle.net.aso.m;
import tw.group4._04_.back.model.ShowBean;
import tw.group4._04_.front.seat.model.SeatBean;
import tw.group4._04_.front.seat.model.SeatBeanDAO;
import tw.group4._04_.front.seat.model.SeatBeanService;
import tw.group4.util.IdentityFilter;

@Controller
public class SeatCrud {
	
	@Autowired
	private SeatBean seatBean;
	@Autowired
	private SeatBeanService seatBeanService;
	
	//search seat
//	@RequestMapping(path = "/04/seatSearch.ctrl", method = RequestMethod.GET)
//	@ResponseBody 
//	public Object seatSearch(Model model) {
//		int actno = 1;
//		Map<String, Integer>seatMap=seatBeanService.select(actno);
//		System.out.println(seatMap);
//			return seatMap;
//	}
	@RequestMapping(path = "/04/seatSearch.ctrl", method = RequestMethod.GET)
//	public String seatSearch(@ModelAttribute("actid")int actid,Model model) {
	public String seatSearch(Model model,HttpSession session) {
		int actid =Integer.parseInt((String) session.getAttribute("actid"));
		System.out.println("actid = "+actid);
		Map<String, Integer>seatMap=seatBeanService.select(actid);
		System.out.println(seatMap);
		model.addAttribute("seat", seatMap);
		return IdentityFilter.loginID+"04/fromt_Seat/Seat";
	}
}
