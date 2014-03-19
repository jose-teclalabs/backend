package pe.com.yambal.service.impl;

import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.yambal.dao.AdviserDao;
import pe.com.yambal.model.AdviserDTO;
import pe.com.yambal.pojo.Adviser;
import pe.com.yambal.service.AdviserService;
import pe.com.yambal.util.Constant;
import pe.com.yambal.util.Message;
import pe.com.yambal.ws.request.AdviserRequest;

@Service
public class AdviserServiceImpl implements AdviserService{

	@Autowired
	AdviserDao adviserDao;
	
	private static final Log log = LogFactory.getLog(AdviserServiceImpl.class);
	
	@Override
	public AdviserDTO yambalLogin(AdviserRequest request) {
		try{
			String codeReturn =  request.getCode();
			if(!request.equals(Constant.IS_EMPTY) ){
				System.out.println("el codigo del adviser es " + codeReturn);
			 return  adviserDao.getUserYambal(new AdviserDTO(codeReturn));	
			}else {
				return new AdviserDTO(new Message(false,
						Constant.MISSING_VALUES_PARAMETERS));
			}
		}catch (Exception e){
			log.error("Error at Select Adviser");
			return new AdviserDTO(new Message(false,Constant.DATABASE_ERROR));						
		}
		
	}

	@Override
	public AdviserDTO yambalLoginV2(AdviserRequest request) {
		try{
			if(!request.getCode().equals(Constant.IS_EMPTY) ){
				String codeReturn =  request.getCode();
				Adviser adviser =  adviserDao.getUserYambalv2(new AdviserDTO(codeReturn));
				//Si el adviser no existe, se crea uno
					if(adviser == null){
						AdviserDTO adviserCreate = new AdviserDTO();
						adviserCreate.setCode(codeReturn);
						adviserCreate.setCountry(request.getCountry());
						adviserCreate.setEmail(request.getEmail());
						adviserCreate.setAdviDate(new Date());
						adviserCreate.setStatus(1);
						String adviserCode =  adviserCreate.getCode();
						adviserDao.persist(adviserCreate);
						return new AdviserDTO(adviserCode);				
					}else{
						//Si el adviser existe, se devuelve  codigo
						String advserExist = adviser.getCode();
						return new AdviserDTO(advserExist);
					}				
			}else {
				return new AdviserDTO(new Message(false,Constant.MISSING_VALUES_PARAMETERS));
			}
		}catch (Exception e){
			log.error("Error at Select Adviser");
			return new AdviserDTO(new Message(false,Constant.DATABASE_ERROR));						
		}
	}

}
