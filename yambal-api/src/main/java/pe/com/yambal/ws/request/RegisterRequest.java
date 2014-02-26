package pe.com.yambal.ws.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class RegisterRequest {

	@XmlElement(name = "clientId")
	private String clientId;
	@XmlElement(name = "combinationId")
	private String combinationId;
		
	public RegisterRequest() {
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getCombinationId() {
		return combinationId;
	}
	public void setCombinationId(String combinationId) {
		this.combinationId = combinationId;
	}
}
