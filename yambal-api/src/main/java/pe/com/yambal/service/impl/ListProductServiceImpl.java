package pe.com.yambal.service.impl;

import java.util.List;
import javax.persistence.NoResultException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.yambal.dao.ListProductDao;
import pe.com.yambal.dao.ProductDao;
import pe.com.yambal.pojo.ListProduct;
import pe.com.yambal.service.ListProductService;

@Service
public class ListProductServiceImpl implements ListProductService{

	@Autowired
	ListProductDao listProductDao;
	@Autowired
	ProductDao productoDao;

	private static final Log log = LogFactory.getLog(ListProductServiceImpl.class);
	
	@Override
	public List<ListProduct> listProducts() {
		try{
			System.out.println("Emtrando al servicio ");

			return listProductDao.getAllProducts();			 
		}catch( NoResultException  e ){
			System.out.println("errrrrrorrr " + e);
			return null;
		}catch(Exception e){
			log.error("Error at get  list.");
			return null;
		}
	}	
}
