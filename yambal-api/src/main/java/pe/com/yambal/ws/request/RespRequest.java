package pe.com.yambal.ws.request;

import javax.xml.bind.annotation.XmlElement;

public class RespRequest {

		
	@XmlElement(name = "producto")
	private Integer producto;
	
	public RespRequest() {
	}

	public Integer getProducto() {
		return producto;
	}

	public void setProducto(Integer producto) {
		this.producto = producto;
	}

	
}
