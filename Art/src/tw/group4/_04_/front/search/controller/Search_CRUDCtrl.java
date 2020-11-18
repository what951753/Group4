package tw.group4._04_.front.search.controller;

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import tw.group4._04_.back.model.ShowBean;
import tw.group4._04_.back.model.ShowBeanService;
import tw.group4.util.IdentityFilter;

@Controller
public class Search_CRUDCtrl {

	// 標註@Autowired，注入dependency
	@Autowired
	private ShowBean showBean;

	@Autowired
	private ShowBeanService showBeanService;

	int pageNo = 0;
	// @ModelAttribute設定傳入參數
	// Model 類似request的功能
	// @SessionAttributes(names = {"name"})可以將參數設為session
	// Action導到的名稱
	
	@RequestMapping(path = "/04/SearchTo.ctrl", method = RequestMethod.GET)
	public String processSearchAll(String searchString, String page,String site,String category,String startdate,String enddate ,Model model) throws ParseException {

		
		//使用.equals("")來判定字串是否相同 ==判定的是物件位址 

		if (!searchString.equals("")) {	
			System.out.println("模糊查詢");
			return  processSearchString(searchString, page, model);
		}
		else if (!site.equals("")) {
			
			return  processSearchString(site, page, model);
		}
		else if (!category.equals("")) {
			return  processCategorySearch(category, page, model);	
		}
		else if (!startdate.equals("")) {
			return  processStartDateSearch(page,startdate, model);
		}
		else if (!enddate.equals("")) {
			return  processEndDateSearch(page,enddate, model);
				
		}
		else {
			
		}

		return IdentityFilter.loginID+"04/front_saleTicket/04_select";
	}
	
	
	//模糊查詢
	@RequestMapping(path = "/04/AllSearch.ctrl", method = RequestMethod.GET)
	public String processSearchString(String searchString, String page, Model model) {

		System.out.println("searchString=" + searchString);
		List<Map> list = new ArrayList<Map>();
//		不用再new ShowBeanService因為已經用@Autowired  private ShowBeanService showBeanService依賴注入
//		ShowBeanService showService = new ShowBeanService();
		List<ShowBean> showList = showBeanService.find(searchString);
		for (ShowBean showBean : showList) {
//			String category = Integer.toString(showBean.getACT_CATEGORY());

			int noint = showBean.getACT_NO();
			String titleString = showBean.getACT_TITLE();
			String siteString = showBean.getACT_LOCATION_NAME();
			String startdate = showBean.getACT_STARTDATE();
			String enddate = showBean.getACT_ENDDATE();
			String description = showBean.getACT_DESCRIPTION();

			Map map = new HashMap();
			map.put("no", noint);
			map.put("title", titleString);
			map.put("site", siteString);
			map.put("startdate", startdate);
			map.put("enddate", enddate);
			map.put("description", description);
			
	
			// 存入map集合中
//			System.out.println(map);
			list.add(map);// 將map集合放入list集合
//			System.out.println("放入集合");

//				String p = request.getParameter("page");
			int page2;
			try {
				// 當前頁數
				page2 = Integer.valueOf(page);
			} catch (NumberFormatException e) {
				page2 = 1;
			}
			// 搜尋後總活動數
			int totalnum = list.size();
//					System.out.println("共"+totalnum+"筆資料");
			// 每頁顯示活動數
			int PerPage = 100;
			// 總頁數
			int totalPages = totalnum % PerPage == 0 ? totalnum / PerPage : totalnum / PerPage + 1;
			// 本頁起始使用者序號
			int beginIndex = (page2 - 1) * PerPage;
			// 本頁末尾使用者序號的下一個
			int endIndex = beginIndex + PerPage;
			if (endIndex > totalnum)
				endIndex = totalnum;

//				model.addAttribute(attributeName, attributeValue)
			model.addAttribute("totalnum", totalnum);
			model.addAttribute("PerPage", PerPage);
			model.addAttribute("totalPages", totalPages);
			model.addAttribute("beginIndex", beginIndex);
			model.addAttribute("endIndex", endIndex);
			model.addAttribute("page", page2);
//			model.addAttribute("category", category);
			model.addAttribute("searchString", searchString);

			model.addAttribute("key_list", list);// 将list放入request中
		}
		int listsize = list.size();
		System.out.println("共" + listsize + "筆資料");


		return IdentityFilter.loginID+"04/front_saleTicket/04_select";
	}
	//分類查詢
	@RequestMapping(path = "/04/CategorySearch.ctrl", method = RequestMethod.GET)
	public String processCategorySearch(String category, String page, Model model) {

		System.out.println("category=" + category);
//		System.out.println("page="+p);

		List<Map> list = new ArrayList<Map>();

		List<ShowBean> showList = showBeanService.selectAll_startdate();

		for (ShowBean showBean : showList) {
			String categoryString = Integer.toString(showBean.getACT_CATEGORY());
//			System.out.println(categoryString);
			int noint = showBean.getACT_NO();
			String titleString = showBean.getACT_TITLE();
			String siteString = showBean.getACT_LOCATION_NAME();
			String startdate = showBean.getACT_STARTDATE();
			String enddate = showBean.getACT_ENDDATE();
			String description = showBean.getACT_DESCRIPTION();
			if (category.equals(categoryString)) {

				Map map = new HashMap();
				map.put("no", noint);
				map.put("title", titleString);
				map.put("site", siteString);
				map.put("startdate", startdate);
				map.put("enddate", enddate);
				map.put("description", description);
				// 存入map集合中
//				System.out.println(map);
				list.add(map);// 將map集合放入list集合
//					System.out.println("放入集合");

//				String p = request.getParameter("page");
				int page2;
				try {
					// 當前頁數
					page2 = Integer.valueOf(page);
				} catch (NumberFormatException e) {
					page2 = 1;
				}
				// 搜尋後總活動數
				int totalnum = list.size();
//					System.out.println("共"+totalnum+"筆資料");
				// 每頁顯示活動數
				int PerPage = 100;
				// 總頁數
				int totalPages = totalnum % PerPage == 0 ? totalnum / PerPage : totalnum / PerPage + 1;
				// 本頁起始使用者序號
				int beginIndex = (page2 - 1) * PerPage;
				// 本頁末尾使用者序號的下一個
				int endIndex = beginIndex + PerPage;
				if (endIndex > totalnum)
					endIndex = totalnum;

//				model.addAttribute(attributeName, attributeValue)
				model.addAttribute("totalnum", totalnum);
				model.addAttribute("PerPage", PerPage);
				model.addAttribute("totalPages", totalPages);
				model.addAttribute("beginIndex", beginIndex);
				model.addAttribute("endIndex", endIndex);
				model.addAttribute("page", page2);
				model.addAttribute("category", category);

				model.addAttribute("key_list", list);// 将list放入request中
			}
		}
		int listsize = list.size();
		System.out.println("共" + listsize + "筆資料");

		return IdentityFilter.loginID+"04/front_saleTicket/04_select";
	}
	
	//開始日期查詢
	@RequestMapping(path = "/04/StartDateSearch.ctrl", method = RequestMethod.GET)
	public String processStartDateSearch(String page,String startdate ,Model model) throws ParseException {

		System.out.println("startdate=" + startdate);
//		System.out.println("page="+p);

		List<Map> list = new ArrayList<Map>();

		List<ShowBean> showList = showBeanService.selectAll_startdate();

		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

		Date requestDate = sdf2.parse(startdate);
		System.out.println(requestDate);
		// 帶入list內日期字串 轉為date格式

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		//將日期轉為年-月-日-星期格式
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-EE");
		for (ShowBean showbean : showList) {
			String dateString = showbean.getACT_STARTDATE();
			int noint = showbean.getACT_NO();
			String titleString = showbean.getACT_TITLE();
			String siteString = showbean.getACT_LOCATION_NAME();
			String enddate = showbean.getACT_ENDDATE();
			String description = showBean.getACT_DESCRIPTION();
			Date date;
			date = sdf.parse(dateString);
			// System.out.println(date);
//			request.getAttribute("");
			if (date.after(requestDate)) {
				Map map = new HashMap();
				map.put("no", noint);
				map.put("title", titleString);
				map.put("site", siteString);
				map.put("startdate", dateString);
				map.put("enddate", enddate);
				map.put("description", description);
//				map.put("startdate", dateFormat.format(date));

				// 存入map集合中
//				System.out.println(map);
				list.add(map);// 將map集合放入list集合
//				System.out.println("放入集合");
				for (Map map_1 : list) {
//					System.out.println(map_1);
				}
	
//				String p = request.getParameter("page");
				int page2;
				try {
					// 當前頁數
					page2 = Integer.valueOf(page);
				} catch (NumberFormatException e) {
					page2 = 1;
				}
				// 搜尋後總活動數
				int totalnum = list.size();
//					System.out.println("共"+totalnum+"筆資料");
				// 每頁顯示活動數
				int PerPage = 100;
				// 總頁數
				int totalPages = totalnum % PerPage == 0 ? totalnum / PerPage : totalnum / PerPage + 1;
				// 本頁起始使用者序號
				int beginIndex = (page2 - 1) * PerPage;
				// 本頁末尾使用者序號的下一個
				int endIndex = beginIndex + PerPage;
				if (endIndex > totalnum)
					endIndex = totalnum;

//				model.addAttribute(attributeName, attributeValue)
				model.addAttribute("totalnum", totalnum);
				model.addAttribute("PerPage", PerPage);
				model.addAttribute("totalPages", totalPages);
				model.addAttribute("beginIndex", beginIndex);
				model.addAttribute("endIndex", endIndex);
				model.addAttribute("page", page2);
				model.addAttribute("startdate", startdate);



				model.addAttribute("key_list", list);// 将list放入request中
			}
		}
		int listsize = list.size();
		System.out.println("共" + listsize + "筆資料");

		return IdentityFilter.loginID+"04/front_saleTicket/04_select";
	}
	
	
	//結束日期查詢
		@RequestMapping(path = "/04/EndDateSearch.ctrl", method = RequestMethod.GET)
		public String processEndDateSearch(String page,String enddate ,Model model) throws ParseException {

			List<Map> list = new ArrayList<Map>();

			List<ShowBean> showList = showBeanService.selectAll_enddate();

			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

			Date requestDate = sdf2.parse(enddate);
			System.out.println(requestDate);
			// 帶入list內日期字串 轉為date格式

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			//將日期轉為年-月-日-星期格式
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-EE");
			for (ShowBean showbean : showList) {
				String dateString = showbean.getACT_ENDDATE();
				String startdate = showbean.getACT_STARTDATE();
				
				int noint = showbean.getACT_NO();
				String titleString = showbean.getACT_TITLE();
				String siteString = showbean.getACT_LOCATION_NAME();
				String description = showbean.getACT_DESCRIPTION();
				Date date;
				date = sdf.parse(dateString);
				// System.out.println(date);
//				request.getAttribute("");
				if (date.before(requestDate)) {
					Map map = new HashMap();
					map.put("no", noint);
					map.put("title", titleString);
					map.put("site", siteString);
					map.put("startdate", dateString);
					map.put("enddate", dateString);
					map.put("description", description);

					// 存入map集合中
//					System.out.println(map);
					list.add(map);// 將map集合放入list集合
//					System.out.println("放入集合");
					for (Map map_1 : list) {
//						System.out.println(map_1);
					}
			
			
//					String p = request.getParameter("page");
					int page2;
					try {
						// 當前頁數
						page2 = Integer.valueOf(page);
					} catch (NumberFormatException e) {
						page2 = 1;
					}
					// 搜尋後總活動數
					int totalnum = list.size();
//						System.out.println("共"+totalnum+"筆資料");
					// 每頁顯示活動數
					int PerPage = 100;
					// 總頁數
					int totalPages = totalnum % PerPage == 0 ? totalnum / PerPage : totalnum / PerPage + 1;
					// 本頁起始使用者序號
					int beginIndex = (page2 - 1) * PerPage;
					// 本頁末尾使用者序號的下一個
					int endIndex = beginIndex + PerPage;
					if (endIndex > totalnum)
						endIndex = totalnum;

//					model.addAttribute(attributeName, attributeValue)
					model.addAttribute("totalnum", totalnum);
					model.addAttribute("PerPage", PerPage);
					model.addAttribute("totalPages", totalPages);
					model.addAttribute("beginIndex", beginIndex);
					model.addAttribute("endIndex", endIndex);
					model.addAttribute("page", page2);
					model.addAttribute("enddate", enddate);


					model.addAttribute("key_list", list);// 将list放入request中
				}
			}
			int listsize = list.size();
			System.out.println("共" + listsize + "筆資料");

			return IdentityFilter.loginID+"04/front_saleTicket/04_select";
		}
		
		
		

}
