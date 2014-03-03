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
import javax.xml.bind.annotation.XmlRootElement;
import pe.com.yambal.util.Constant;

@Entity
@Table(name = "listproduct", catalog = Constant.NAME_CATALOG, schema = Constant.NAME_SCHEMA)
@XmlRootElement
public class ListProductDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "lipo_id")
	private Integer lipoId;

	@Column(name = "lipo_status")
	private Integer status;
	@Column(name = "lipo_date")
	private Date descripcion;

	@ManyToOne(targetEntity = ProductDTO.class)
	@JoinColumn(name = "prod_id")
	private ProductDTO product;

	@ManyToOne(targetEntity = CombinationDTO.class)
	@JoinColumn(name = "comb_id")
	private CombinationDTO combination;

	public Integer getLipoId() {
		return lipoId;
	}

	public void setLipoId(Integer lipoId) {
		this.lipoId = lipoId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(Date descripcion) {
		this.descripcion = descripcion;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public CombinationDTO getCombination() {
		return combination;
	}

	public void setCombination(CombinationDTO combination) {
		this.combination = combination;
	}
}
