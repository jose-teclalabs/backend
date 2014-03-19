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
@Table(name = "client", catalog = Constant.NAME_CATALOG, schema = Constant.NAME_SCHEMA)
@XmlRootElement
public class ClientDTO {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "clie_id")
	private Integer clientId;
	@Column(name = "clie_name")
	private String name;
	@Column(name = " clie_email")
	private String email;
	@Column(name = " clie_phone")
	private String phone;
	@Column(name = "clie_status")
	private Integer status;
	@Column(name = "clie_date")
	private Date clientDate;
	@ManyToOne(targetEntity = AdviserDTO.class)
	@JoinColumn(name = "advi_id")
	private AdviserDTO adviser;
	@Transient
	Message message;

	public ClientDTO() {

	}

	public ClientDTO(String email) {
		this.email = email;
	}
	
	public ClientDTO(Integer id) {
		this.clientId = id;
	}

	public ClientDTO(Message message) {
		this.message = message;
	}

	public ClientDTO(Integer id, Message message) {
		this.clientId = id;
		this.message = message;
	}

	public Integer getClientId() {
		return clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getClientDate() {
		return clientDate;
	}

	public void setClientDate(Date clientDate) {
		this.clientDate = clientDate;
	}

	public AdviserDTO getAdviser() {
		return adviser;
	}

	public void setAdviser(AdviserDTO adviser) {
		this.adviser = adviser;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ClientDTO [clientId=" + clientId + ", name=" + name
				+ ", email=" + email + ", phone=" + phone + ", clientDate="
				+ clientDate + ", adviser=" + adviser + ", message=" + message
				+ "]";
	}	
}
