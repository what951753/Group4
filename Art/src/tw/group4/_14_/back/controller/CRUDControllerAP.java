package tw.group4._14_.back.controller;


import static org.hamcrest.CoreMatchers.nullValue;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import tw.group4._14_.back.ARTProduct;
import tw.group4._14_.back.dao.ProductBeanDAOService;
import tw.group4._14_.init.ImageProcess;
import tw.group4.util.IdentityFilter;



@Controller
//@SessionAttributes(names = {"pageNo"})
public class CRUDControllerAP {

	@Autowired
	private ProductBeanDAOService pDaoservice;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	ServletContext ctx;
	
	@RequestMapping(path = "/14/CRUDNoDataTable.ctrl", method = RequestMethod.GET)
	public String processAction(Model m, @RequestParam(name = "pageNo" ,required = false) Integer pageNo) {
		
			if (pageNo == null||pageNo ==0) {
				pageNo = 1;
			}
			
			List<ARTProduct> pList = pDaoservice.selectAll(pageNo);
			int totalPage = pDaoservice.getTotalPages();
			
			List<Integer> totalPages = new ArrayList<Integer>();
			for (int i = 1; i <= totalPage; i++) {
				totalPages.add(i);
			}
			
			m.addAttribute("pList", pList);
			m.addAttribute("pageNo", pageNo);
			m.addAttribute("totalPages", totalPage);
			m.addAttribute("pages", totalPages);
			
			return IdentityFilter.loginID+"14/14_CRUDPage";
	}
	
	
	@RequestMapping(path = "/14/CRUD.ctrl", method = RequestMethod.GET)
	public String processAction23(Model m) {
		
			
			List<ARTProduct> pList = pDaoservice.selectNoPage();
			
			m.addAttribute("pList", pList);
			
			return IdentityFilter.loginID+"14/14_CRUDPage";
	}
	
	
	@RequestMapping(path = "/14/deleteProduct.ctrl", method = RequestMethod.GET)
	private String processDelete(Model m, @RequestParam(name = "pageNo" ,required = false) Integer pageNo, 
			@RequestParam(name = "productId" ,required = false)String productid)
			 {

		boolean result = pDaoservice.delete(productid);
		if (result != false) {
			m.addAttribute("SuccessMessage", "編號 " + productid + " 的商品已刪除！");

		} else {
			m.addAttribute("OrderErrorMessage", "刪除失敗，請再次確認此商品狀態！");
		}
		
		if (pageNo == null||pageNo ==0) {
			pageNo = 1;
		}

		List<ARTProduct> pList = pDaoservice.selectAll(pageNo);
		
			int totalPage = pDaoservice.getTotalPages();
			List<Integer> totalPages = new ArrayList<Integer>();
			for (int i = 1; i <= totalPage; i++) {
				totalPages.add(i);
			}
			
			return  "redirect:/14/CRUD.ctrl";

	}
	
	@RequestMapping(path = "/14/updateProduct.ctrl", method = RequestMethod.GET)
	private String processUpdate(Model m, @RequestParam(name = "pageNo" ,required = false) Integer pageNo,
			@RequestParam(name = "productid") String productid )
			 {
		System.out.println("productid"+productid);
		ARTProduct ap = pDaoservice.select(productid);
		m.addAttribute("ap", ap);

//		return "14/14_UpdatePage";
		return IdentityFilter.loginID+"14/UpdateForm";

	}
	
	@RequestMapping(path = "/14/updateDoneProduct.ctrl", method = RequestMethod.GET)
	private String processUpdateDone(Model m, @RequestParam(name = "pageNo",required = false) Integer pageNo, 
			@RequestParam(name = "APNUM") String apNum,@RequestParam(name = "APPRICE") String apPrice,
			@RequestParam(name = "APTITLE") String apTitle,@RequestParam(name = "productid") String productid,
			@RequestParam(name = "myFiles") MultipartFile mFile) throws IllegalStateException, IOException{
		System.out.println("processUpdateDone");
		
		int num = Integer.parseInt(apNum);
		pDaoservice.update(productid, apTitle, apPrice, num);

		return  "redirect:/14/CRUD.ctrl";

	}
	
	@RequestMapping(path = "/14/updateFormDone.ctrl", method = RequestMethod.POST)
	private String processUpdateFormDone(@ModelAttribute("ap") ARTProduct ap,BindingResult result, Model m) {
		if(ap.getProductImgBlob() == null) {
			ARTProduct originArtProduct = pDaoservice.select(ap.getProductId());
			ap.setProductImg(originArtProduct.getProductImg());
			ap.setProductImgBlob(originArtProduct.getProductImgBlob());
		}
		pDaoservice.updateProduct(ap);
		
		return  "redirect:/14/CRUD.ctrl";
	}
	
	
	
	@RequestMapping(path = "/14/createProduct.ctrl", method = RequestMethod.POST)
	private String processCreate(Model m, @RequestParam(name = "pageNo" ,required = false) Integer pageNo,
			@RequestParam(name = "APNUM") String apNum,@RequestParam(name = "APPRICE") String apPrice, 
			@RequestParam(name = "APTITLE") String apTitle, @RequestParam(name = "APTYPE",required = false) String apType,
			@RequestParam(name = "APDES",required = false) String apDes, @RequestParam(name = "myFiles") MultipartFile mFile) throws IllegalStateException, IOException {

		String fileName = mFile.getOriginalFilename();
		String fileTempDirPath = request.getSession().getServletContext().getRealPath("/") + "UploadTempDir\\";
		
		File dirPath = new File(fileTempDirPath);
		if(!dirPath.exists()) {
			boolean status = dirPath.mkdirs();
			System.out.println("status:" + status);
		}
		
		
		String fileSavePath = fileTempDirPath + fileName;
		File saveFile = new File(fileSavePath);
		mFile.transferTo(saveFile);
		
	
//		Blob blob = null;
		byte[] img = null;
		try {
//			blob = ImageProcess.fileToBlob(fileSavePath);
			img = ImageProcess.fileToByte(fileSavePath);
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		int num = Integer.parseInt(apNum);
		ARTProduct pd = new ARTProduct();
		pd.setProductTitle(apTitle);
		pd.setProductPrice(apPrice);
		pd.setProductNum(num);
		pd.setProductType(apType);
		pd.setProductDes(apDes);
//		pd.setProductImgBlob(blob);
		pd.setProductImgBlob(img);

		pDaoservice.insert(pd);
		
		m.addAttribute("SuccessMessage", "商品新增成功！");

		return "redirect:/14/CRUD.ctrl";

	}
	
	@RequestMapping(path="/14/showOneProductCMS.ctrl")
	private String processDetial(Model m, @RequestParam(name = "pageNo" ,required = false) Integer pageNo,
			@RequestParam(name = "productid") String apNum) {
		ARTProduct ap = pDaoservice.select(apNum);
		m.addAttribute("ap",ap);
		return IdentityFilter.loginID+"14/14_showOnePdCms";
		
		
	}
	
	
	@RequestMapping(path="/14/Create.ctrl")
	public String processAction2(Model m) {
		return IdentityFilter.loginID+"14/14_Create";
	}
	
}
