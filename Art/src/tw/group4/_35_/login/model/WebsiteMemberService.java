package tw.group4._35_.login.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebsiteMemberService {

	private WebsiteMemberDao dao;

	@Autowired
	public WebsiteMemberService(WebsiteMemberDao dao) {
		this.dao = dao;
	}
	
	public WebsiteMember insert(WebsiteMember wmBean) {
		return dao.insert(wmBean);
	}
	
	//按id讀取資料庫內會員的方法
	public WebsiteMember selectById(int id) {
		return dao.selectById(id);
	}
	
	//傳入登入表單輸入會員資料進行驗證的方法
	public Boolean checkLogin(WebsiteMember member) {
		return dao.checkLogin(member);
	}
	
	//傳入登入表單輸入會員名確認無重複的方法
	public Boolean checkNameExsist(String name) {
		return dao.checkNameExsist(name);
	}
	
	//傳入登入表單輸入會員資料，回傳會員完整資料放到session
	public WebsiteMember getMemberFullInfo(WebsiteMember member) {
		return dao.getMemberFullInfo(member);
	}
	
	public byte[] getMemberPicByteArray(WebsiteMember member) {
		return dao.getMemberPicByteArray(member);
	}
}
