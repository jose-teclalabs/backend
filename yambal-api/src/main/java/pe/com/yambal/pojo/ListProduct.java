package pe.com.yambal.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ListProduct implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "productId")
	private String productId;
	@XmlElement(name = "productName")
	private String productName;
	@XmlElement(name = "combinationId")
	private String combinationId;

	public ListProduct() {
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCombinationId() {
		return combinationId;
	}

	public void setCombinationId(String combinationId) {
		this.combinationId = combinationId;
	}

	@Override
	public String toString() {
		return "ListProduct [productId=" + productId + ", productName="
				+ productName + ", combinationId=" + combinationId + "]";
	}
	
	

}
