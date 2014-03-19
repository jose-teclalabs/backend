package pe.com.yambal.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Adviser {
	
	@XmlElement(name = "adviserId")
	private Integer adviserId;
	@XmlElement(name = "code")
	private String code;
	@XmlElement(name = "name")
	private String name;


	public Adviser() {
		super();
	}

	public Adviser(Integer adviserId) {
		super();
		this.adviserId = adviserId;
	}

	public Adviser(String code) {
		this.code = code;
	}

	public Integer getAdviserId() {
		return adviserId;
	}

	public void setAdviserId(Integer adviserId) {
		this.adviserId = adviserId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Adviser [adviserId=" + adviserId + ", code=" + code + ", name="
				+ name + "]";
	}
	
	
}
