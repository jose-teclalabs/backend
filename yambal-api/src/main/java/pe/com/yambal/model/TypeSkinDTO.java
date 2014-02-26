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
@Table(name = "type_skin", catalog = Constant.NAME_CATALOG, schema = Constant.NAME_SCHEMA)
@XmlRootElement
public class TypeSkinDTO {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name = "tysk_id")
	private Integer tyskId;
	@Column(name = "tysk_description")
	private String descripcion;
	@Column(name = "tysk_status")
	private Integer  status;
	@Column(name = "tysk_date")
	private Date tyskDate;
	@OneToMany(targetEntity = CombinationDTO.class, mappedBy = "typeSkin", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<CombinationDTO> combinationList = new ArrayList<CombinationDTO>(0);

}
