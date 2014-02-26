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
import javax.xml.bind.annotation.XmlRootElement;

import pe.com.yambal.util.Constant;

@Entity
@Table(name = "combination", catalog = Constant.NAME_CATALOG, schema = Constant.NAME_SCHEMA)
@XmlRootElement
public class CombinationDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "comb_id")
	private Integer combId;
	@Column(name = "comb_status")
	private Integer combStatus;
	@Column(name = "comb_date")
	private Date combDate;

	@ManyToOne(targetEntity = SubToneSkinDTO.class)
	@JoinColumn(name = "stok_id")
	private SubToneSkinDTO subToneSkin;

	@ManyToOne(targetEntity = Tone_SkinDTO.class)
	@JoinColumn(name = "tosk_id")
	private Tone_SkinDTO toneSkin;

	@ManyToOne(targetEntity = TypeSkinDTO.class)
	@JoinColumn(name = "tysk_id")
	private TypeSkinDTO typeSkin;

	@ManyToOne(targetEntity = TypeLookDTO.class)
	@JoinColumn(name = "tylo_id")
	private TypeLookDTO typeLook;

	@OneToMany(targetEntity = RegisterDTO.class, mappedBy = "combination", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<RegisterDTO> registerList = new ArrayList<RegisterDTO>(0);

	public Integer getCombId() {
		return combId;
	}

	public void setCombId(Integer combId) {
		this.combId = combId;
	}

	public Integer getCombStatus() {
		return combStatus;
	}

	public void setCombStatus(Integer combStatus) {
		this.combStatus = combStatus;
	}

	public Date getCombDate() {
		return combDate;
	}

	public void setCombDate(Date combDate) {
		this.combDate = combDate;
	}

	public SubToneSkinDTO getSubToneSkin() {
		return subToneSkin;
	}

	public void setSubToneSkin(SubToneSkinDTO subToneSkin) {
		this.subToneSkin = subToneSkin;
	}

	public Tone_SkinDTO getToneSkin() {
		return toneSkin;
	}

	public void setToneSkin(Tone_SkinDTO toneSkin) {
		this.toneSkin = toneSkin;
	}

	public TypeSkinDTO getTypeSkin() {
		return typeSkin;
	}

	public void setTypeSkin(TypeSkinDTO typeSkin) {
		this.typeSkin = typeSkin;
	}

	public TypeLookDTO getTypeLook() {
		return typeLook;
	}

	public void setTypeLook(TypeLookDTO typeLook) {
		this.typeLook = typeLook;
	}

	public List<RegisterDTO> getRegisterList() {
		return registerList;
	}

	public void setRegisterList(List<RegisterDTO> registerList) {
		this.registerList = registerList;
	}
	

}
