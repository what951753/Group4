package tw.group4._04_.back.model;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("showbeanService")

public class ShowBeanService {
	
	
	private ShowBeanDAO SDao;
	
	public ShowBeanService() {		
	}
//	public ShowBeanService(Session session) {
//		SDao = new ShowBeanDAO();
//	}
	@Autowired 
	public ShowBeanService(ShowBeanDAO SDao) {
		this.SDao = SDao;
	}
	

	public ShowBean insert(ShowBean showbean) {		
		return SDao.insert(showbean);
	}


	public ShowBean select(int actId) {		
		return SDao.select(actId);
	}


	public List<ShowBean> selectAll() {	
		return SDao.selectAll();
	}
	
	public List<ShowBean>selectAll_startdate() {	
		return SDao.selectAll_startdate();
	}
	
	public List<ShowBean> selectAll_enddate() {
		return SDao.selectAll_enddate();
	}
	
	

	public List<ShowBean> selectAll2() {	
		return SDao.selectAll2();
	}
	
	public List<ShowBean> selectAll3(int pageNo,int category) {	
		return SDao.selectAll3(pageNo,category);
	}
	
	public int getTotalPages() {
		return SDao.getTotalPages();
	}


	public ShowBean update(int actno, String title, int category, String location, String locationName,
			String mainunit, String showunit, String description, String startdate, String enddate) {	
		
		return SDao.update(actno,title,category,location,locationName,
				mainunit,showunit,description,startdate,enddate);
	}

	public boolean delete(int actid) {	
		return SDao.delete(actid);
	}

	public List<ShowBean> find(String searchString){
		return SDao.find(searchString);
	}

}
