package pe.com.yambal.ws.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import pe.com.yambal.model.SeleccionDTO;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class RestResponseSeleId {

	@XmlElement(name="idSele")
	private Integer idSele;
	
	public RestResponseSeleId(SeleccionDTO selec) {
		this.idSele = ( selec.getSeleId()!= null )? selec.getSeleId() : null;
	}

	public Integer getIdSele() {
		return idSele;
	}

	public void setIdSele(Integer idSele) {
		this.idSele = idSele;
	}
}
