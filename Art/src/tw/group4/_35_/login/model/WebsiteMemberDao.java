package tw.group4._35_.login.model;

import java.sql.Blob;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class WebsiteMemberDao {
	
	SessionFactory sessionFactory;
	
	@Autowired
	public WebsiteMemberDao(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public WebsiteMember insert(WebsiteMember wmBean) {
		Session session = sessionFactory.getCurrentSession();
		
		if (wmBean!=null) {
			session.save(wmBean);
		}
		
		return wmBean;
	}
	
	public WebsiteMember selectById(int id) {
		Session session = sessionFactory.getCurrentSession();
		WebsiteMember wmBean = session.get(WebsiteMember.class, id);
		return wmBean;
	}
	
	public Boolean checkLogin(WebsiteMember member) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<WebsiteMember> query = session.createQuery("From WebsiteMember where name = :name and password = :password", WebsiteMember.class);
		query.setParameter("name", member.getName());
		query.setParameter("password", member.getPassword());
		WebsiteMember memberResult = query.uniqueResult();
		if(memberResult!=null) {
			return true;
		}
		
		return false;
	}
	
	public WebsiteMember getMemberFullInfo(WebsiteMember member) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<WebsiteMember> query = session.createQuery("From WebsiteMember where name = :name and password = :password", WebsiteMember.class);
		query.setParameter("name", member.getName());
		query.setParameter("password", member.getPassword());
		WebsiteMember memberResult = query.uniqueResult();
		
		return memberResult;
	}
	
	public byte[] getMemberPicByteArray(WebsiteMember member) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<WebsiteMember> query = session.createQuery("From WebsiteMember where name = :name and password = :password", WebsiteMember.class);
		query.setParameter("name", member.getName());
		query.setParameter("password", member.getPassword());
		WebsiteMember memberResult = query.uniqueResult();
		Blob blob = memberResult.getMemberPic();
		
//		Blob轉byteArray須設定Blob.getBytes(long pos, int length)
		byte[] byteArray = null;
		try {
			byteArray = blob.getBytes(1, (int) blob.length());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return byteArray;
	}
	
	public boolean checkNameExsist(String name) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<WebsiteMember> query = session.createQuery("From WebsiteMember where name = :name", WebsiteMember.class);
		query.setParameter("name", name);
		WebsiteMember memberResult = query.uniqueResult();
		
		if (memberResult==null) {
			return false;
		}
		
		return true;
	}
	
}
