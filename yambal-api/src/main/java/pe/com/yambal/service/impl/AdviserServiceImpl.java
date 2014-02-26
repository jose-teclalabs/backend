package pe.com.yambal.service.impl;
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
	
//			return new AdviserDTO(new Message(true,Constant.SUCCESS));
			}else {
				return new AdviserDTO(new Message(false,
						Constant.MISSING_VALUES_PARAMETERS));
			}
		}catch (Exception e){
			log.error("Error at Select Adviser");
			return new AdviserDTO(new Message(false,Constant.DATABASE_ERROR));						
		}
		
	}

}
