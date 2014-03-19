package pe.com.yambal.service.impl;

import java.util.List;
import javax.persistence.NoResultException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pe.com.yambal.dao.ProductDao;
import pe.com.yambal.model.ProductDTO;
import pe.com.yambal.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;

	private static final Log log = LogFactory.getLog(ProductServiceImpl.class);
	
//	@Override
//	public List<ProductDTO> listProducts(Integer status) {
//		try{
//			Integer statusReturn =  status;
//			List<ProductDTO> listprofileGoal = (List<ProductDTO>) productDao.gettAllProducts(statusReturn);
//			return listprofileGoal;
//		}catch(Exception e){
//			log.error("Error at get  list.");
//			return null;
//		}
//	}
	
	@Override
	public List<ProductDTO> listProducts() {
		try{
			System.out.println("Emtrando al servicio ");
			return productDao.getAllProducts();			 
		}catch( NoResultException  e ){
			System.out.println("errrrrrorrr " + e);
			return null;
		}catch(Exception e){
			log.error("Error at get  list.");
			return null;
		}
	}	
}
