package pe.com.yambal.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;
import org.hibernate.ejb.HibernateQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import pe.com.yambal.base.GenericDaoImpl;
import pe.com.yambal.dao.ProductDao;
import pe.com.yambal.model.ProductDTO;

@Repository
public class ProductDaoImpl extends GenericDaoImpl<ProductDTO> implements ProductDao {

	
	private static final Log log = LogFactory.getLog(ProductDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDTO> gettAllProducts(Integer status) {
		String sql = "SELECT prod_id as prodId, prod_description as descripcion FROM product WHERE prod_status= : ";

		List<ProductDTO>  productReturn = null;
		try {
			Query squery = entityManager.createNativeQuery(sql.toString());
			HibernateQuery hibernateQuery = (HibernateQuery) squery;
			SQLQuery query = (SQLQuery) hibernateQuery.getHibernateQuery();
			query.setInteger("status", status);
			query.addScalar("prodId", StandardBasicTypes.STRING);
			query.addScalar("descripcion", StandardBasicTypes.STRING);
			query.setResultTransformer(Transformers.aliasToBean(ProductDTO.class));
			productReturn = ((List<ProductDTO>) squery.getSingleResult());
		} catch (NoResultException e) {
			return null;
		} catch (RuntimeException re) {
			log.error("get all products failed", re);
			throw re;
		}
		return productReturn;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDTO> getAllProducts() throws Exception {
		String sql = "SELECT DISTINCT * FROM product p where  p.prod_status = 1 order by p.prod_id asc ";
//		String sql = "SELECT * FROM product ";

		try {
			Query squery = entityManager.createNativeQuery(sql.toString());
			HibernateQuery hibernateQuery = (HibernateQuery) squery;
			SQLQuery query = (SQLQuery) hibernateQuery.getHibernateQuery();
			query.addEntity(ProductDTO.class);
//			query.addScalar("productId", StandardBasicTypes.STRING);
//			query.addScalar("productName", StandardBasicTypes.STRING);
//			query.addScalar("combinationId", StandardBasicTypes.STRING);
//			query.setResultTransformer(Transformers.aliasToBean(ListProduct.class));
			return  squery.getResultList();
		}catch (RuntimeException re) {
			log.error("get all products failed", re);
			throw re;
		}
	}

}
