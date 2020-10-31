package tw.group4.model;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Repository("accountDao")
public class AccountDAO {

	private SessionFactory sessionFactory;
	
	@Autowired
	public AccountDAO(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean checkLogin(Account account) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Account where username=:user and userpwd=:pwd";
		Query<Account> query = session.createQuery(hql, Account.class);
		query.setParameter("user", account.getUsername());
		query.setParameter("pwd", account.getUserpwd());
	
		Account resultAccount = query.uniqueResult();
		if(resultAccount!=null) {
			return true;
		}
		return false;
	}
	
}
