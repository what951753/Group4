package tw.group4._14_shopAP.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.group4._14_shopAP.model.ARTProduct;

@Repository("ProductBeanDAOImp")
public class ProductBeanDAOImp {
	private Session session;
	private SessionFactory sessionFactory;
	private int pageNo = 0; // 存放目前顯示之頁面的編號
	private int pageSize = 10;
	private int totalPages = 1;
	private String query ;

//	@Autowired
//	public ProductBeanDAOImp(Session session) {
//		this.session = session;
//	}

	@Autowired
	public ProductBeanDAOImp(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public ARTProduct insert(ARTProduct pd) {
		Session session = sessionFactory.getCurrentSession();
//		ARTProduct result = session.get(ARTProduct.class, pd.getProductId());
//		if (result == null) {
			session.save(pd);
			return pd;
//		}
//		return null;
	}

	public ARTProduct select(String productId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(ARTProduct.class, productId);
	}

	public List<ARTProduct> selectAll(int pageNo) {
		
		Session session = sessionFactory.getCurrentSession();
		String countQ = "Select count (ap.productId) From ARTProduct ap";
		Query countQuery = session.createQuery(countQ);
		Long countResult = (Long) countQuery.uniqueResult();
		int lastPageNum = (int) (Math.ceil(countResult / pageSize));
		
		
		Query<ARTProduct> query = session.createQuery("From ARTProduct ap ORDER BY ap.productId", ARTProduct.class);
		query.setFirstResult((pageNo-1)*pageSize);
		query.setMaxResults(pageSize);
		List<ARTProduct> list = query.list();
		return list;
	}

	public int selectCount() {
		Session session = sessionFactory.getCurrentSession();
		int count =0;
		String sql ="SELECT COUNT(*) FROM ARTProduct";
		Query<ARTProduct> q = session.createQuery(sql);
		
//		q.setFirstResult(1);
//		q.setMaxResults(10);
		List<ARTProduct> list = q.list();

		for (int i = 0; i < list.size(); i++) {
			count++;
		}
		
		return count;
	}
	
	public int getTotalPages() {
		Session session = sessionFactory.getCurrentSession();
		String countQ = "Select count (ap.productId) From ARTProduct ap";
		Query countQuery = session.createQuery(countQ);
		Long countResult = (Long) countQuery.uniqueResult();
		System.out.println("countResult"+countResult);
//		totalPages = (int) (Math.ceil(countResult/pageSize));
		if ((countResult % pageSize)!=0) {
			totalPages = (int) (Math.ceil(countResult/pageSize))+1;
		}else {
			totalPages = (int) (Math.ceil(countResult/pageSize));
			
		}
		return totalPages;
	}

	public ARTProduct update(String productId, String productTitle, String productPrice, int productNum) {
		Session session = sessionFactory.getCurrentSession();
		ARTProduct result = session.get(ARTProduct.class, productId);
		System.out.println("productTitle"+productTitle);
		if (result != null) {
			
			result.setProductTitle(productTitle);
			result.setProductPrice(productPrice);
			result.setProductNum(productNum);

		}

		return result;
	}

	public boolean delete(String productId) {
		Session session = sessionFactory.getCurrentSession();
		ARTProduct result = session.get(ARTProduct.class, productId);
		if (result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}
	
	public List<ARTProduct> selectNoPage() {
		Session session = sessionFactory.getCurrentSession();
		String countQ = "Select count (ap.productId) From ARTProduct ap";
		Query countQuery = session.createQuery(countQ);
		Query<ARTProduct> query = session.createQuery("From ARTProduct ap ORDER BY ap.productId", ARTProduct.class);
		List<ARTProduct> list = query.list();
		return list;
	}

}
