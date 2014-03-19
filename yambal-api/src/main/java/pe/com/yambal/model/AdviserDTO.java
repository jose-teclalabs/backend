package pe.com.yambal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import pe.com.yambal.util.Constant;
import pe.com.yambal.util.Message;

@Entity
@Table(name = "adviser", catalog = Constant.NAME_CATALOG, schema = Constant.NAME_SCHEMA) 
@XmlRootElement
public class AdviserDTO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "advi_id")
	private Integer adviserId;
	@Column(name = "advi_code")
	private String code;
	@Column(name = "advi_email")
	private String email;
	@Column(name = "advi_country")
	private String country;
	@Column(name = "advi_status")
	private Integer status;	
	@Column(name = "advi_date")
	private Date adviDate;
	@OneToMany(targetEntity = ClientDTO.class, mappedBy = "adviser", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<ClientDTO> clientList = new ArrayList<ClientDTO>(0);
	
	@Transient
	Message message;

	public AdviserDTO() {
		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<ClientDTO> getClientList() {
		return clientList;
	}

	public void setClientList(List<ClientDTO> clientList) {
		this.clientList = clientList;
	}

	public AdviserDTO(Integer id) {
		this.adviserId = id;
	}
	
	public AdviserDTO(Message message) {
	  this.message = message;
	}
	
	public AdviserDTO(Integer id, Message message) {
		this.adviserId = id;
		this.message = message;
	}	
	
	public AdviserDTO(String code) {
		this.code = code;
	}

	public AdviserDTO(String code, Message message2) {
		this.code = code;
		this.message = message2;
	}

	public AdviserDTO(Integer id, String code, Message message2) {
		this.adviserId = id;
		this.code = code;
		this.message  = message2;
	}

	public Integer getAdviserId() {
		return adviserId;
	}

	public void setAdviserId(Integer adviserId) {
		this.adviserId = adviserId;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getAdviDate() {
		return adviDate;
	}
	public void setAdviDate(Date adviDate) {
		this.adviDate = adviDate;
	}

	@Override
	public String toString() {
		return "AdviserDTO [adviserId=" + adviserId + ", code=" + code
				+ ", status=" + status + ", adviDate="
				+ adviDate + ", message=" + message + "]";
	}	
}
