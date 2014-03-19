package pe.com.yambal.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.com.yambal.base.GenericDaoImpl;
import pe.com.yambal.dao.RegisterDao;
import pe.com.yambal.model.RegisterDTO;

@Repository
public class RegisterDaoImpl extends GenericDaoImpl<RegisterDTO> implements RegisterDao {

	private static final Log log = LogFactory.getLog(ClientDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@Override
	public Integer saveRegister(RegisterDTO c) {
		Integer idAssinged = null;
		try {
			entityManager.persist(c);
			entityManager.flush();
			idAssinged = c.getRegisterId();
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
		return idAssinged;
	}
	
	
	
}
