package pe.com.yambal.service.impl;

import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.yambal.dao.ClientDao;
import pe.com.yambal.dao.CombinationDao;
import pe.com.yambal.dao.RegisterDao;
import pe.com.yambal.model.ClientDTO;
import pe.com.yambal.model.CombinationDTO;
import pe.com.yambal.model.RegisterDTO;
import pe.com.yambal.service.RegisterService;
import pe.com.yambal.util.Constant;
import pe.com.yambal.util.Message;
import pe.com.yambal.ws.request.RegisterRequest;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	ClientDao clientDao;
	@Autowired
	CombinationDao combinacionDao;
	@Autowired
	RegisterDao registerDao;
	
	private static final Log log = LogFactory.getLog(RegisterServiceImpl.class);
	
	
	
	@Override
	public RegisterDTO addCombination(RegisterRequest request) {

		try {
			Integer idclientVerify = null;
			Integer idcombinationVerify = null;
				try {
	
					idclientVerify = Integer.parseInt(request.getClientId());
					idcombinationVerify = Integer.parseInt(request
							.getCombinationId());
	
				} catch (Exception e) {
					return new RegisterDTO(new Message(false,
							Constant.PARAMETER_IS_NOT_PROPERLY_FORMATTED));
				}
			if (!request.getClientId().equals(Constant.IS_EMPTY) &&
				(!request.getCombinationId().equals(Constant.IS_EMPTY))){

			// Verificando si los ID existen
			ClientDTO clientReturn = clientDao.findById(idclientVerify);
			if (clientReturn == null) {
				return new RegisterDTO(new Message(false,Constant.CLIENT_NOT_FOUND));

			}
			CombinationDTO combinationReturn = combinacionDao.findById(idcombinationVerify);
			if (combinationReturn == null) {
				
				return new RegisterDTO(new Message(false,Constant.COMBINATION_NOT_FOUND));
			}

			RegisterDTO register = new RegisterDTO();
			register.setClient(clientReturn);
			register.setCombination(combinationReturn);
			register.setStatus(1);
			register.setRegiDate(new Date());
			registerDao.persist(register);
			return new RegisterDTO(new Message(true ,Constant.SUCCESS));
			
			}else{
				return new RegisterDTO(new Message(false, Constant.MISSING_VALUES_PARAMETERS));
			}
			
			} catch (Exception e) {
			log.error("Error at register" );
			return new RegisterDTO(new Message(false,Constant.DATABASE_ERROR));
		}
	}
}
