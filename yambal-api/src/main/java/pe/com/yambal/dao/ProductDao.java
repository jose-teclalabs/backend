package pe.com.yambal.dao;

import java.util.List;
import pe.com.yambal.base.GenericDao;
import pe.com.yambal.model.ProductDTO;

public interface ProductDao extends GenericDao<ProductDTO> {
	public List<ProductDTO> gettAllProducts(Integer status);
	public List<ProductDTO> getAllProducts() throws Exception;

}
