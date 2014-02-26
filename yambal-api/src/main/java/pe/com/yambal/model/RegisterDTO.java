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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import pe.com.yambal.util.Constant;
import pe.com.yambal.util.Message;

@Entity
@Table(name = "register", catalog = Constant.NAME_CATALOG, schema = Constant.NAME_SCHEMA)
@XmlRootElement
public class RegisterDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "regi_id")
	private Integer registerId;
	@Column(name = "regi_status")
	private Integer status;
	@Column(name = "regi_date")
	private Date regiDate;
	@ManyToOne(targetEntity = ClientDTO.class)
	@JoinColumn(name = "clie_id")
	private ClientDTO client;
	@OneToMany(targetEntity = SeleccionDTO.class, mappedBy = "register", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<SeleccionDTO> seleccionList = new ArrayList<SeleccionDTO>(0);

	@ManyToOne(targetEntity = CombinationDTO.class)
	@JoinColumn(name = "comb_id")
	private CombinationDTO combination;

	@Transient
	Message message;

	public RegisterDTO() {

	}

	public CombinationDTO getCombination() {
		return combination;
	}

	public void setCombination(CombinationDTO combination) {
		this.combination = combination;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public RegisterDTO(Integer id) {
		this.registerId = id;
	}

	public RegisterDTO(Message message) {
		this.message = message;
	}

	public RegisterDTO(Integer id, Message message) {
		this.registerId = id;
		this.message = message;
	}

	public Integer getRegisterId() {
		return registerId;
	}

	public void setRegisterId(Integer registerId) {
		this.registerId = registerId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getRegiDate() {
		return regiDate;
	}

	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}

	public List<SeleccionDTO> getSeleccionList() {
		return seleccionList;
	}

	public void setSeleccionList(List<SeleccionDTO> seleccionList) {
		this.seleccionList = seleccionList;
	}

}
