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
@Table(name = "product", catalog = Constant.NAME_CATALOG, schema = Constant.NAME_SCHEMA)
@XmlRootElement
public class ProductDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "prod_id")
	private Integer prodId;
	@Column(name = "prod_description")
	private String descripcion;
	@Column(name = "prod_details")
	private String details;
	@Column(name = "prod_type")
	private String type;
	@Column(name = "prod_status")
	private Integer  status;
	@Column(name = "prod_date")
	private Date prodDate;
	@OneToMany(targetEntity = ListProductDTO.class, mappedBy = "product", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<ListProductDTO> listProductList = new ArrayList<ListProductDTO>(0);
	
	@OneToMany(targetEntity = SeleccionDTO.class, mappedBy = "producto", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<SeleccionDTO> seleccionList = new ArrayList<SeleccionDTO>(0);
	
	public ProductDTO() {
		
	}
	public ProductDTO(Integer prodId) {
		this.prodId = prodId;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getProdDate() {
		return prodDate;
	}
	public void setProdDate(Date prodDate) {
		this.prodDate = prodDate;
	}
	public List<ListProductDTO> getListProductList() {
		return listProductList;
	}
	public void setListProductList(List<ListProductDTO> listProductList) {
		this.listProductList = listProductList;
	}
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public List<SeleccionDTO> getSeleccionList() {
		return seleccionList;
	}
	public void setSeleccionList(List<SeleccionDTO> seleccionList) {
		this.seleccionList = seleccionList;
	}
	
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ProductDTO [prodId=" + prodId + ", descripcion=" + descripcion
				+ ", details=" + details + ", type=" + type + ", status="
				+ status + ", prodDate=" + prodDate + ", listProductList="
				+ listProductList + ", seleccionList=" + seleccionList + "]";
	}	    
}
