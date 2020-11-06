package tw.group4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="House")
@Component
public class HouseBean {
	
	@Id
	@Column(name = "HOUSEID")
	private int houseid;
	
	@Column(name = "HOUSENAME")
	private String housename;
	
	public HouseBean() {
	}
	
	public HouseBean(int houseid, String housename) {
		this.houseid = houseid;
		this.housename = housename;
	}
	
	public int getHouseid() {
		return houseid;
	}
	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}
	public String getHousename() {
		return housename;
	}
	public void setHousename(String housename) {
		this.housename = housename;
	}
	
	
}
