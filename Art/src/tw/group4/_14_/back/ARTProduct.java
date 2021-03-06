package tw.group4._14_.back;


import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "ARTPRODUCT")
@DynamicInsert@DynamicUpdate
public class ARTProduct implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "APID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String productId;
	
	@Column(name = "APTITLE")
	private String productTitle;
	
	@Column(name = "APTYPE")
	private String productType;
	
	@Column(name = "APPRICE")
	private String productPrice;
	
	@Column(name = "APIMG")
	private String productImg;
	
	@Column(name = "APDES")
	private String productDes;
	
	@Column(name = "APNUM")
	private int productNum;
	
	@Column(name = "APIMGBLOB")
	private byte[] productImgBlob;
//	private byte[] productImgBlob;

	public ARTProduct() {

	}
	


	public ARTProduct(String productId, String productTitle, String productType, String productPrice, String productImg,
			String productDes, int productNum, byte[] productImgBlob) {
		super();
		this.productId = productId;
		this.productTitle = productTitle;
		this.productType = productType;
		this.productPrice = productPrice;
		this.productImg = productImg;
		this.productDes = productDes;
		this.productNum = productNum;
		this.productImgBlob = productImgBlob;
	}



	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public String getProductDes() {
		return productDes;
	}

	public void setProductDes(String productDes) {
		this.productDes = productDes;
	}


	public byte[] getProductImgBlob() {
		return productImgBlob;
	}



	public void setProductImgBlob(byte[] productImgBlob) {
		this.productImgBlob = productImgBlob;
	}


}
