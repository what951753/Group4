package tw.group4._14_shopAP.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.group4._14_shopAP.model.ARTProduct;

@Service("ProductBeanDAOService")
public class ProductBeanDAOService {
	private ProductBeanDAOImp pDAO;
	
	public ProductBeanDAOService() {
		
	}

	@Autowired
	public ProductBeanDAOService(ProductBeanDAOImp pDAO) {
		this.pDAO = pDAO;
	}
//	public ProductBeanDAOService(Session session) {
//		pDAO = new ProductBeanDAOImp(session);
//	}
	

	public ARTProduct insert(ARTProduct pd) {
		return pDAO.insert(pd);
		
	}

	public ARTProduct select(String productId) {
		 return pDAO.select(productId);
	 }
	 

	public  List<ARTProduct> selectAll(int pageNo){
		return pDAO.selectAll(pageNo);
		
	}
	
	public List<ARTProduct> selectNoPage() {
		return pDAO.selectNoPage();
	}
	

	public  ARTProduct update (String productId, String productTitle, String productPrice, int productNum) {
		return pDAO.update(productId, productTitle, productPrice, productNum);
		
	}
	

	public boolean delete(String productId) {
		return pDAO.delete(productId);
	}
	
	public int selectCount() {
		return pDAO.selectCount();
	}
	
	public int getTotalPages() {
		return pDAO.getTotalPages();
	}
	
	
	
}
