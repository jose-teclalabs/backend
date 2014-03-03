package pe.com.yambal.ws.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ClientRequest {

	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "address")
	private String address;
	@XmlElement(name = "age")
	private String age;
	@XmlElement(name = "dni")
	private String dni;
	@XmlElement(name = "email")
	private String email;
	@XmlElement(name = "code")
	private String code;

	public ClientRequest() {

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "ClientRequest [name=" + name + ", address=" + address
				+ ", age=" + age + ", dni=" + dni + ", email=" + email
				+ ", code=" + code + "]";
	}
	
	

}
