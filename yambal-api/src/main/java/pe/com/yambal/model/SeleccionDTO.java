package pe.com.yambal.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import pe.com.yambal.util.Constant;
import pe.com.yambal.util.Message;

@Entity
@Table(name = "seleccion", catalog = Constant.NAME_CATALOG, schema = Constant.NAME_SCHEMA)
@XmlRootElement
public class SeleccionDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "sele_id")
	private Integer seleId;

	@ManyToOne(targetEntity = RegisterDTO.class)
	@JoinColumn(name = "regi_id")
	private RegisterDTO register;

	@ManyToOne(targetEntity = ListProductDTO.class)
	@JoinColumn(name = "prod_id")
	private ProductDTO producto;
	
	@Column(name = "sele_status")
	private Integer status;
	@Column(name = "sele_date")
	private Date seleDate;
	
	
	@Transient
	Message message;

	public SeleccionDTO() {

	}

	
	public SeleccionDTO(Integer id) {
		this.seleId = id;
	}

	public SeleccionDTO(Message message) {
		this.message = message;
	}

	public SeleccionDTO(Integer id, Message message) {
		this.seleId = id;
		this.message = message;
	}
	

	public Integer getSeleId() {
		return seleId;
	}

	public void setSeleId(Integer seleId) {
		this.seleId = seleId;
	}

	public RegisterDTO getRegister() {
		return register;
	}

	public void setRegister(RegisterDTO register) {
		this.register = register;
	}
	
	public ProductDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductDTO producto) {
		this.producto = producto;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getSeleDate() {
		return seleDate;
	}

	public void setSeleDate(Date seleDate) {
		this.seleDate = seleDate;
	}


	public Message getMessage() {
		return message;
	}


	public void setMessage(Message message) {
		this.message = message;
	}
	
	 
}
