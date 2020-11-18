package tw.group4._04_.back.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tw.group4._04_.back.model.ShowBean;
import tw.group4._04_.back.model.ShowBeanService;
import tw.group4.util.IdentityFilter;

@Controller
public class CrudCtrlCMS {

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

	@RequestMapping(path = "/04/CMS/SearchAll.ctrl", method = RequestMethod.GET)
	public String processSearchAll(String searchString, String page, Model model) {

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

			Map map = new HashMap();
			map.put("no", noint);
			map.put("title", titleString);
			map.put("site", siteString);
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

		return IdentityFilter.loginID+"04/cms_Act/SearchAll";
	}

	@RequestMapping(path = "/04/CMS/Category.ctrl", method = RequestMethod.GET)
	public String processCategorySearch(String category, String page, Model model) {

		System.out.println("category=" + category);
//		System.out.println("page="+p);

		List<Map> list = new ArrayList<Map>();

		List<ShowBean> showList = showBeanService.selectAll();

		for (ShowBean showBean : showList) {
			String categoryString = Integer.toString(showBean.getACT_CATEGORY());
//			System.out.println(categoryString);
			int noint = showBean.getACT_NO();
			String titleString = showBean.getACT_TITLE();
			String siteString = showBean.getACT_LOCATION_NAME();

			if (category.equals(categoryString)) {

				Map map = new HashMap();
				map.put("no", noint);
				map.put("title", titleString);
				map.put("site", siteString);
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

		return IdentityFilter.loginID+"04/cms_Act/categorySearch";
	}

	@RequestMapping(path = "/04/CMS/Delete.ctrl", method = RequestMethod.GET)
	public String processDelete(int actno, String page, String category, String searchString)
			throws UnsupportedEncodingException {

//		response.setContentType("text/html;charset=UTF-8");
		System.out.println(actno);
		System.out.println(searchString);
		System.out.println(category);
		showBeanService.delete(actno);

		// 導回前頁
		if (category.equals("")) {
			// URLEncoder.encode中文亂碼解決
			return "redirect:/04/CMS/SearchAll.ctrl?page=" + page + "&searchString="
					+ URLEncoder.encode(searchString, "utf-8");
		} else {
			return "redirect:/04/CMS/Category.ctrl?page=" + page + "&category=" + category;
		}
//		return "04/categorySearch";

	}

	@RequestMapping(path = "/04/CMS/Update1.ctrl", method = RequestMethod.GET)
	public String processUpdate(int actno, String page, String category, String searchString, Model model) {

		System.out.println(actno);
		System.out.println(searchString);
		System.out.println(page);

		ShowBean showBean = showBeanService.select(actno);

		String title = showBean.getACT_TITLE();
		System.out.println(title);
		int category2 = showBean.getACT_CATEGORY();
		System.out.println(category);
		String location = showBean.getACT_LOCATION();
		String locationName = showBean.getACT_LOCATION_NAME();
		String mainunit = showBean.getACT_MAINUNIT();
		String showunit = showBean.getACT_SHOWUNIT();
		String description = showBean.getACT_DESCRIPTION();
		String startdate = showBean.getACT_STARTDATE();
		String enddate = showBean.getACT_ENDDATE();
		// 將DB 日期字串由yyyy/mm/dd改為yyyy-mm-dd
		String startdate2 = startdate.replace("/", "-");
		String enddate2 = enddate.replace("/", "-");

		model.addAttribute("actno", actno);
		model.addAttribute("title", title);
		model.addAttribute("category", category2);
		model.addAttribute("location", location);
		model.addAttribute("locationName", locationName);
		model.addAttribute("mainunit", mainunit);
		model.addAttribute("showunit", showunit);
		model.addAttribute("description", description);
		model.addAttribute("startdate", startdate2);
		model.addAttribute("enddate", enddate2);
		model.addAttribute("page", page);
		model.addAttribute("searchString", searchString);

		return IdentityFilter.loginID+"04/cms_Act/UpdateAction";
	}

	@RequestMapping(path = "/04/CMS/Update2.ctrl", method = RequestMethod.GET)
	public String processUpdate2(int actno, String title, int category, String location, String locationName,
			String mainunit, String showunit, String description, String startdate, String enddate, String page) {

		String startdate2 = startdate.replace("-", "/");
		String enddate2 = enddate.replace("-", "/");

		showBeanService.update(actno, title, category, location, locationName, mainunit, showunit, description,
				startdate2, enddate2);

		return "redirect:/04/CMS/Category.ctrl?page=" + page + "&category=" + category;
	}

	@RequestMapping(path = "/04/CMS/insert", method = RequestMethod.GET)
	public String processUpdate2() {

		return IdentityFilter.loginID+"04/cms_Act/InsertAction";
	}

	@RequestMapping(path = "/04/CMS/Insert.ctrl", method = RequestMethod.GET)
	public String processInsert(String title, int category, String location, String locationName, String mainunit,
			String showunit, String description, String startdate, String enddate)  {
//		System.out.println("startdate"+startdate);
		String startdate2 = startdate.replace("-", "/");
		String enddate2 = enddate.replace("-", "/");
//		System.out.println(startdate2);

		showBean.setACT_TITLE(title);
		showBean.setACT_CATEGORY(category);
		showBean.setACT_LOCATION(location);
		showBean.setACT_LOCATION_NAME(locationName);
		showBean.setACT_MAINUNIT(mainunit);
		showBean.setACT_SHOWUNIT(showunit);
		showBean.setACT_DESCRIPTION(description);
		showBean.setACT_STARTDATE(startdate2);
		showBean.setACT_ENDDATE(enddate2);

		showBeanService.insert(showBean);
		System.out.println("已成功新增一筆");
//		return "04/categorySearch";
		return "redirect:/04/CMS/Category.ctrl?page=&category=" + category;
	}

	// 分類查詢+分頁
	@RequestMapping(path = "/04/CMS/Category2.ctrl", method = RequestMethod.GET)
	public String processCategorySearch2(int category, String p, Model model) {

		// 設定頁數

		int pageNo;
		try {
			// 當前頁數
			pageNo = Integer.valueOf(p);
		} catch (NumberFormatException e) {
			pageNo = 1;
		}
		System.out.println("pageNo" + pageNo);
		System.out.println("category" + category);

		List<Map> list = new ArrayList<Map>();

		List<ShowBean> showList = showBeanService.selectAll3(pageNo, category);
		for (ShowBean showBean : showList) {
			String categoryString = Integer.toString(showBean.getACT_CATEGORY());
			System.out.println(categoryString);
			int noint = showBean.getACT_NO();
			String titleString = showBean.getACT_TITLE();
			String siteString = showBean.getACT_LOCATION_NAME();

			Map map = new HashMap();
			map.put("no", noint);
			map.put("title", titleString);
			map.put("site", siteString);
			// 存入map集合中
			System.out.println(map);
			list.add(map);// 將map集合放入list集合
//						System.out.println("放入集合");

			int totalPage = showBeanService.getTotalPages();

			List<Integer> totalPages = new ArrayList<Integer>();
			for (int i = 1; i <= totalPage; i++) {
				totalPages.add(i);
			}

			int PerPage = 100;

			model.addAttribute("PerPage", PerPage);
			model.addAttribute("category", category);
			model.addAttribute("key_list", list);// 将list放入request中
			model.addAttribute("pageNo", String.valueOf(pageNo));
			model.addAttribute("totalPages", totalPage);
			model.addAttribute("pages", totalPages);

		}
		int listsize = list.size();
		System.out.println("共" + listsize + "筆資料");

		return IdentityFilter.loginID+"04/cms_Act/index2";
	}

}
