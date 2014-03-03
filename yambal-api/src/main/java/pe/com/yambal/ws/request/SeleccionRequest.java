package pe.com.yambal.ws.request;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class SeleccionRequest {

	@XmlElement(name = "regId")
	private String regId;
	
	@XmlElement(name = "productos")
	private List<RespRequest> respList;

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public List<RespRequest> getRespList() {
		return respList;
	}

	public void setRespList(List<RespRequest> respList) {
		this.respList = respList;
	}	
}
