package tw.group4.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountService {
	
	private AccountDAO accountDao;
	
	@Autowired
	public AccountService(AccountDAO accountDao) {
		this.accountDao = accountDao;
	}
	
	public boolean checkLogin(Account account) {
		return accountDao.checkLogin(account);
	}
	
}
