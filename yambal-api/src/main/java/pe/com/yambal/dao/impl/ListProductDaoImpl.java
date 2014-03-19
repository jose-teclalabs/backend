package pe.com.yambal.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
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
import pe.com.yambal.dao.ListProductDao;
import pe.com.yambal.model.ListProductDTO;
import pe.com.yambal.pojo.ListProduct;

@Repository
public class ListProductDaoImpl extends GenericDaoImpl<ListProductDTO> implements ListProductDao {

	private static final Log log = LogFactory.getLog(ListProductDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<ProductDTO> getAllProducts() throws Exception {
////		String sql = "SELECT distinct p.prod_id as productId ,p.prod_description as productName,l.comb_id as combinationId FROM listproduct l, product p where  p.prod_status = 1 and l.lipo_status = 1 order by p.prod_id asc; ";
//		String sql = "SELECT * FROM product p, benefit b, application a, tip t WHERE p.prod_status = 1";
//
//		try {
//			Query squery = entityManager.createNativeQuery(sql.toString());
//			HibernateQuery hibernateQuery = (HibernateQuery) squery;
//			SQLQuery query = (SQLQuery) hibernateQuery.getHibernateQuery();
//			query.addEntity(ProductDTO.class);
////			query.addScalar("productId", StandardBasicTypes.STRING);
////			query.addScalar("productName", StandardBasicTypes.STRING);
////			query.addScalar("combinationId", StandardBasicTypes.STRING);
////			query.setResultTransformer(Transformers.aliasToBean(ListProduct.class));
//			return  squery.getResultList();
//		}catch (RuntimeException re) {
//			log.error("get all products failed", re);
//			throw re;
//		}
//	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ListProduct> getAllProducts() throws Exception {
		String sql = "SELECT distinct p.prod_id as productId ,p.prod_description as productName,l.comb_id as combinationId FROM listproduct l, product p where  p.prod_status = 1 and l.lipo_status = 1 order by p.prod_id asc; ";
//		String sql = "SELECT * FROM product p, benefit b, application a, tip t WHERE p.prod_status = 1";

		try {
			Query squery = entityManager.createNativeQuery(sql.toString());
			HibernateQuery hibernateQuery = (HibernateQuery) squery;
			SQLQuery query = (SQLQuery) hibernateQuery.getHibernateQuery();
//			query.addEntity(ProductDTO.class);
			query.addScalar("productId", StandardBasicTypes.STRING);
			query.addScalar("productName", StandardBasicTypes.STRING);
			query.addScalar("combinationId", StandardBasicTypes.STRING);
			query.setResultTransformer(Transformers.aliasToBean(ListProduct.class));
			return  squery.getResultList();
		}catch (RuntimeException re) {
			log.error("get all products failed", re);
			throw re;
		}
	}

}
