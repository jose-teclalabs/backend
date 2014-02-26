package pe.com.yambal.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Client {
	@XmlElement(name = "clientId")
	private Integer clientId;
	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "dni")
	private Integer dni;
	@XmlElement(name = "email")
	private String email;

	public Client() {

	}

	public Client(Integer dni) {
		this.dni = dni;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", name=" + name + ", dni="
				+ dni + ", email=" + email + "]";
	}

}
