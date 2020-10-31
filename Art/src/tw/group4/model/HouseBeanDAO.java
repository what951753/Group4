package tw.group4.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class HouseBeanDAO {
	
	private SessionFactory sessionFactory;
//	private Session session;
	
	//DAO一叫出來就幫忙取完session了
	//現在都在DAO層用SessionFactory幫忙做事
	//不再傳遞session一層一層下去
	public HouseBeanDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
//		session = sessionFactory.getCurrentSession();
	}
	
	//新增。存在就不新增，不存在才新增
	public HouseBean insert(HouseBean bean) {
		Session session = sessionFactory.getCurrentSession();
		HouseBean result = session.get(HouseBean.class, bean.getHouseid());
		
		if(result==null) {
			session.save(bean);
			return bean;
		}
		return null;
	}
	
	//查詢單筆
	public HouseBean select(int houseid) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(HouseBean.class, houseid);
	}
	
	//查詢全部
	public List<HouseBean> selectAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<HouseBean> query = session.createQuery("From HouseBean",HouseBean.class);
		List<HouseBean> list = query.list();
		return list;
	}
	
	//更新
	public HouseBean update(int houseid, String housename) {
		Session session = sessionFactory.getCurrentSession();
		HouseBean result = session.get(HouseBean.class, houseid);
		if(result!=null) {
			result.setHousename(housename);
		}
		return result;
	}
	
	//刪除
	public boolean delete(int houseid) {
		Session session = sessionFactory.getCurrentSession();
		HouseBean result = session.get(HouseBean.class, houseid);
		if(result!=null) {
			session.delete(result);
			return true;
		}
		return false;
	}

}
