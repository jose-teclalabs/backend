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
import javax.xml.bind.annotation.XmlRootElement;

import pe.com.yambal.util.Constant;

@Entity
@Table(name = "sub_tone_skin", catalog = Constant.NAME_CATALOG, schema = Constant.NAME_SCHEMA)
@XmlRootElement
public class SubToneSkinDTO {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "stok_id")
	private Integer stokId;
	@Column(name = "stok_description")
	private String descripcion;
	@Column(name = "stok_status")
	private Integer  status;
	@Column(name = "stok_date")
	private Date toskDate;
	
	@OneToMany(targetEntity = CombinationDTO.class, mappedBy = "subToneSkin", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<CombinationDTO> combinationList = new ArrayList<CombinationDTO>(0);
}
