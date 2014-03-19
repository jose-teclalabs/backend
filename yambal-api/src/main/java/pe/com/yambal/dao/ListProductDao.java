package pe.com.yambal.dao;

import java.util.List;
import pe.com.yambal.base.GenericDao;
import pe.com.yambal.model.ListProductDTO;
import pe.com.yambal.pojo.ListProduct;

public interface ListProductDao extends GenericDao<ListProductDTO> {
	
	public List<ListProduct> getAllProducts() throws Exception;

}
