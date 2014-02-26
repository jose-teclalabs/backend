package pe.com.yambal.dao.impl;

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
import org.springframework.transaction.annotation.Transactional;

import pe.com.yambal.base.GenericDaoImpl;
import pe.com.yambal.dao.AdviserDao;
import pe.com.yambal.model.AdviserDTO;
import pe.com.yambal.pojo.Adviser;

@Repository
public class AdviserDaoImpl extends GenericDaoImpl<AdviserDTO> implements AdviserDao {

	private static final Log log = LogFactory.getLog(AdviserDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@Override
	public AdviserDTO getUserYambal(AdviserDTO adviser) {
		
		String sql = "select advi_code as code ,advi_name as name from adviser where advi_code = :codeId and advi_status = 1 LIMIT 1";
		AdviserDTO adviserReturn = null;
		try {
			Query squery = entityManager.createNativeQuery(sql.toString());
			HibernateQuery hibernateQuery = (HibernateQuery) squery;
			SQLQuery query = (SQLQuery) hibernateQuery.getHibernateQuery();
			query.setString("codeId", adviser.getCode());
			query.addScalar("code", StandardBasicTypes.STRING);
			query.addScalar("name", StandardBasicTypes.STRING);
			query.setResultTransformer(Transformers.aliasToBean(AdviserDTO.class));
			adviserReturn = ((AdviserDTO) squery.getSingleResult());
		} catch (NoResultException e) {
			return null;
		} catch (RuntimeException re) {
			log.error("verify code adviser failed", re);
			throw re;
		}
		return adviserReturn;
	}

	@Override
	public Adviser verifyCodeOfAdviser(AdviserDTO adviser) {
		String sql = "SELECT advi_id as adviserId FROM adviser WHERE advi_status = 1 AND advi_code = :code ";
		Adviser adviserReturn = null;
		try {
			System.out.println("el codigo de adviser es " + adviser.getCode());
			Query squery = entityManager.createNativeQuery(sql.toString());
			HibernateQuery hibernateQuery = (HibernateQuery) squery;
			SQLQuery query = (SQLQuery) hibernateQuery.getHibernateQuery();
			query.setString("code", adviser.getCode());
			query.addScalar("adviserId", StandardBasicTypes.INTEGER);
			query.setResultTransformer(Transformers.aliasToBean(Adviser.class));
			adviserReturn = ((Adviser) squery.getSingleResult());
		} catch (NoResultException e) {
			log.error("el usuario no existe", e);
			return null;
		} catch (RuntimeException re) {
			log.error("verify code adviser failed", re);
			throw re;
		}
		return adviserReturn;
	}

}
