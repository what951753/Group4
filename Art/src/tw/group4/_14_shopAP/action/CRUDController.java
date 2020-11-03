package tw.group4._14_shopAP.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.group4._14_shopAP.model.ARTProduct;
import tw.group4._14_shopAP.model.dao.ProductBeanDAOService;
import tw.group4.util.HibernateUtil;


@Controller
@SessionAttributes(names = {"pageNo"})
public class CRUDController {

	@RequestMapping(path = "/14/CRUD.ctrl", method = RequestMethod.GET)
	public String processAction(Model m, @RequestParam(name = "pageNo" ,required = false) Integer pageNo) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session csession = factory.getCurrentSession();
		ProductBeanDAOService pDAO = new ProductBeanDAOService(csession);
		
			if (pageNo == null||pageNo ==0) {
				pageNo = 1;
			}
			
			List<ARTProduct> pList = pDAO.selectAll(pageNo);
			int totalPage = pDAO.getTotalPages();
			
			List<Integer> totalPages = new ArrayList<Integer>();
			for (int i = 1; i <= totalPage; i++) {
				totalPages.add(i);
			}
			
			m.addAttribute("pList", pList);
			m.addAttribute("pageNo", pageNo);
			m.addAttribute("totalPages", totalPage);
			m.addAttribute("pages", totalPages);
			
			return "/35/14_CRUDPage";
	}
	
	@RequestMapping(path = "/14/deleteProduct.ctrl", method = RequestMethod.GET)
	private String processDelete(Model m, @RequestParam(name = "pageNo" ,required = false) Integer pageNo, String productid)
			 {
		SessionFactory factory = HibernateUtil.getFactory();
		Session csession = factory.getCurrentSession();
		ProductBeanDAOService pDAO = new ProductBeanDAOService(csession);

		boolean result = pDAO.delete(productid);
		if (result != false) {
			m.addAttribute("SuccessMessage", "編號 " + productid + " 的商品已刪除！");

		} else {
			m.addAttribute("OrderErrorMessage", "刪除失敗，請再次確認此商品狀態！");
		}
		
		if (pageNo == null||pageNo ==0) {
			pageNo = 1;
		}

		List<ARTProduct> pList = pDAO.selectAll(pageNo);
		
			int totalPage = pDAO.getTotalPages();
			List<Integer> totalPages = new ArrayList<Integer>();
			for (int i = 1; i <= totalPage; i++) {
				totalPages.add(i);
			}
			
			m.addAttribute("pList", pList);
			m.addAttribute("pageNo",pageNo);
			m.addAttribute("totalPages", totalPage);
			m.addAttribute("pages", totalPages);
			return "/_14_shopAP/14_CRUDPage";

	}
	
	@RequestMapping(path = "/14/updateProduct.ctrl", method = RequestMethod.GET)
	private String processUpdate(Model m, @RequestParam(name = "pageNo" ,required = false) Integer pageNo,@RequestParam(name = "productid") String productid )
			 {
		SessionFactory factory = HibernateUtil.getFactory();
		Session csession = factory.getCurrentSession();
		ProductBeanDAOService pDAO = new ProductBeanDAOService(csession);
		ARTProduct ap = pDAO.select(productid);
		m.addAttribute("ap", ap);

		return "/_14_shopAP/14_Update";

	}
	
	@RequestMapping(path = "/14/updateDoneProduct.ctrl", method = RequestMethod.GET)
	private String processUpdateDone(Model m, @RequestParam(name = "pageNo",required = false) Integer pageNo, @RequestParam(name = "APNUM") String apNum,@RequestParam(name = "APPRICE") String apPrice,@RequestParam(name = "APTITLE") String apTitle,@RequestParam(name = "productid") String productid){
		System.out.println("processUpdateDone");
		SessionFactory factory = HibernateUtil.getFactory();
		Session csession = factory.getCurrentSession();
		ProductBeanDAOService pDAO = new ProductBeanDAOService(csession);

		int num = Integer.parseInt(apNum);
		pDAO.update(productid, apTitle, apPrice, num);

		return  "redirect:/14/CRUD.ctrl";

	}
	
	
	
	@RequestMapping(path = "/14/createProduct.ctrl", method = RequestMethod.GET)
	private String processCreate(Model m, @RequestParam(name = "pageNo" ,required = false) Integer pageNo,
			@RequestParam(name = "APNUM") String apNum,@RequestParam(name = "APPRICE") String apPrice, @RequestParam(name = "APTITLE") String apTitle) {

		SessionFactory factory = HibernateUtil.getFactory();
		Session csession = factory.getCurrentSession();

		int num = Integer.parseInt(apNum);
		ARTProduct pd = new ARTProduct();
		pd.setProductTitle(apTitle);
		pd.setProductPrice(apPrice);
		pd.setProductNum(num);

		csession.save(pd);
		
		m.addAttribute("SuccessMessage", "商品新增成功！");

		return "redirect:/14/CRUD.ctrl";

	}
	
	@RequestMapping(path="/14/Create.ctrl")
	public String processAction2(Model m) {
		m.addAttribute("result","wonderful hour");
		return "/_14_shopAP/14_Create";
	}
	
}
