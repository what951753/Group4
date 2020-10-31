package tw.group4.model;

import java.util.List;

public class HouseBeanService{
	
	private HouseBeanDAO hDao;
	
	public HouseBeanService(HouseBeanDAO hDao) {
		this.hDao = hDao;
	}

	public HouseBean insert(HouseBean bean) {
		return hDao.insert(bean);
	}

	public HouseBean select(int houseid) {
		return hDao.select(houseid);
	}

	public List<HouseBean> selectAll() {
		return hDao.selectAll();
	}

	public HouseBean update(int houseid, String housename) {
		return hDao.update(houseid, housename);
	}

	public boolean delete(int houseid) {
		return hDao.delete(houseid);
	}

}
