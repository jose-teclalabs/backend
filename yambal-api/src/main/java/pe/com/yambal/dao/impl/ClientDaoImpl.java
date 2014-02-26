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
import pe.com.yambal.dao.ClientDao;
import pe.com.yambal.model.ClientDTO;
import pe.com.yambal.pojo.Client;

@Repository
public class ClientDaoImpl extends GenericDaoImpl<ClientDTO> implements ClientDao {

	private static final Log log = LogFactory.getLog(ClientDaoImpl.class);

	@PersistenceContext
    private EntityManager entityManager;
	
	
	@Transactional
	@Override
	public Integer saveClient(ClientDTO c) {
		Integer idAssinged = null;
		try {
			entityManager.persist(c);
			entityManager.flush();
			idAssinged = c.getClientId();
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
		return idAssinged;
	}

	@Transactional
	@Override
	public Client searchByDni(ClientDTO client) throws Exception {
		String sql = "SELECT clie_id as clientId FROM client WHERE clie_dni = :dni and clie_status = 1 ";
//		Client clieReturn = null;
		try {			
			System.out.println("Vengo con la siguiente informaciuon  +  " + client.toString());
			Query squery = entityManager.createNativeQuery(sql.toString());
			HibernateQuery hibernateQuery = (HibernateQuery) squery;
			SQLQuery query = (SQLQuery) hibernateQuery.getHibernateQuery();
			query.setInteger("dni",client.getDni());
			query.addScalar("clientId", StandardBasicTypes.INTEGER);
			query.setResultTransformer(Transformers.aliasToBean(Client.class));	
			return 	 ((Client) squery.getSingleResult());
//			System.out.println("ERRRORRRR en el DAAAAOO  :" + clieReturn.toString());
			
		}
//		catch (NullPointerException npe){
//			System.out.println("Error " + npe);
//			return null;			
//		}
//		catch (NonUniqueResultException non){
//			return null;			
//		}
		catch (NoResultException e) {
			return null;
		} catch (RuntimeException re) {
			log.error("verify dni client failed", re);
			throw re;
		}
	}
}
