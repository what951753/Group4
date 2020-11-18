package tw.group4._35_.login.model;

import java.sql.Blob;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "WebsiteMember")
@Component
public class WebsiteMember {
	
	@Id @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "tel")
	private String tel;
	
	@Column(name = "memberType")
	private String memberType;
	
	@Column(name = "memberPic")
	private Blob memberPic;
	
	@Column(name = "preference")
	private String preference;
	
	@Column(name = "registerTime")
	private LocalDate registerTime;
	
	@Column(name = "purchaseLimit")
	private Double purchaseLimit;
	
	public WebsiteMember() {
		
	}

	public WebsiteMember(String name, String password, String address, String email, String tel, String memberType,
			Blob memberPic, String preference, LocalDate registerTime, Double purchaseLimit) {
		super();
		this.name = name;
		this.password = password;
		this.address = address;
		this.email = email;
		this.tel = tel;
		this.memberType = memberType;
		this.memberPic = memberPic;
		this.preference = preference;
		this.registerTime = registerTime;
		this.purchaseLimit = purchaseLimit;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public Blob getMemberPic() {
		return memberPic;
	}

	public void setMemberPic(Blob memberPic) {
		this.memberPic = memberPic;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	public LocalDate getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(LocalDate registerTime) {
		this.registerTime = registerTime;
	}

	public Double getPurchaseLimit() {
		return purchaseLimit;
	}

	public void setPurchaseLimit(Double purchaseLimit) {
		this.purchaseLimit = purchaseLimit;
	}
	
	
}
