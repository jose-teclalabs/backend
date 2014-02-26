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
	@Column(name = "clie_address")
	private String address;
	@Column(name = "clie_age")
	private Integer age;
	@Column(name = "clie_dni",unique=true)
	private Integer dni;
	@Column(name = " clie_email")
	private String email;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "ClientDTO [clientId=" + clientId + ", name=" + name
				+ ", address=" + address + ", age=" + age + ", dni=" + dni
				+ ", email=" + email + ", status=" + status + ", clientDate="
				+ clientDate + ", adviser=" + adviser + ", message=" + message
				+ "]";
	}

	
	
}
