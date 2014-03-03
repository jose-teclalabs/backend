package pe.com.yambal.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.service.jdbc.connections.spi.ConnectionProvider;
import org.springframework.stereotype.Repository;

import pe.com.yambal.base.GenericDaoImpl;
import pe.com.yambal.dao.SeleccionDao;
import pe.com.yambal.model.SeleccionDTO;

@Repository
public class SeleccionDaoImpl extends GenericDaoImpl<SeleccionDTO> implements SeleccionDao  {
	
	private static final Log log = LogFactory.getLog(SeleccionDaoImpl.class);

	@PersistenceContext 
    private EntityManager entityManager;
	
	@Override
	public Boolean agregarRespuesta(List<SeleccionDTO> respList) {
		
		String sql = "INSERT INTO selection(regi_id,prod_id) VALUES(?,?)";
		Boolean success = false;
		try {
			Session session = (Session) entityManager.getDelegate();
		    SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();
		    ConnectionProvider cp = sfi.getConnectionProvider();
			java.sql.Connection connection = cp.getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			
			final int batchSize = 100;
			int count = 0;
			
			for( SeleccionDTO resp : respList ){
				ps.setInt(1, resp.getRegister().getRegisterId());
			    ps.setInt(2, resp.getProducto().getProdId());
			    ps.addBatch(); 
			     
			    if(++count % batchSize == 0) {
			        ps.executeBatch();
			    }
			}
			ps.executeBatch();
			ps.close();
			connection.close();
			
			success = true;
		}
		catch (SQLException e) {
			log.error("save seleccion failed", e);
			return false;
		}
		catch( NoResultException  e ){
			log.error("save seleccion failed", e);
			return false;
		} catch (RuntimeException re) {
			log.error("save seleccion failed", re);
			throw re;
		}
		return success;
	}

}
