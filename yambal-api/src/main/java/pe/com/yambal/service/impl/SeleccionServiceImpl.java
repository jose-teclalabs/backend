package pe.com.yambal.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.yambal.dao.ProductDao;
import pe.com.yambal.dao.RegisterDao;
import pe.com.yambal.dao.SeleccionDao;
import pe.com.yambal.model.ProductDTO;
import pe.com.yambal.model.RegisterDTO;
import pe.com.yambal.model.SeleccionDTO;
import pe.com.yambal.service.SeleccionService;
import pe.com.yambal.util.Constant;
import pe.com.yambal.util.Message;
import pe.com.yambal.ws.request.RespRequest;
import pe.com.yambal.ws.request.SeleccionRequest;

@Service
public class SeleccionServiceImpl implements SeleccionService {
	
	private static final Log log = LogFactory.getLog(SeleccionServiceImpl.class);
		
	@Autowired
	SeleccionDao seleccionDao;
	
	@Autowired
	RegisterDao registerDao;
	
	@Autowired
	ProductDao productDao;
	

	@Override
	public SeleccionDTO registrarSeleccion(SeleccionRequest request) {
		try{		
			
			Integer idRegistroReturn = null;
			try{  
				idRegistroReturn = Integer.parseInt(request.getRegId());
			}catch(Exception e){
				return new SeleccionDTO(new Message(false, Constant.PARAMETER_IS_NOT_PROPERLY_FORMATTED));
			}
			if( !request.getRegId().equals(Constant.IS_EMPTY) && request.getRespList().size() > 0){	
			
				
			RegisterDTO register = registerDao.findById(idRegistroReturn);	
			if(register == null){
				return new SeleccionDTO(new Message(false, Constant.REGISTER_NOT_FOUND) );
			}
			  
			List<SeleccionDTO> respList = new ArrayList<SeleccionDTO>();
				for( RespRequest respRequest : request.getRespList()){
					ProductDTO producto = productDao.findById(respRequest.getProducto());
					if(producto == null){
						return new SeleccionDTO(new Message(false, Constant.PRODUCT_NOT_FOUND) );
					}
					SeleccionDTO seleccion = new SeleccionDTO();
					seleccion.setRegister(new RegisterDTO(idRegistroReturn));
					seleccion.setProducto(new ProductDTO(respRequest.getProducto()));
					seleccion.setSeleDate(new Date());
					seleccion.setStatus(1);
					respList.add(seleccion);
				}				
				//enviando a registrar				
				Boolean success = seleccionDao.agregarRespuesta(respList);
				if(success){
					return new SeleccionDTO(idRegistroReturn, new Message(true, Constant.SATISFACTORY_PROCESS) );
				}else{
					return new SeleccionDTO( new Message(false, Constant.DATABASE_ERROR) );
				}			
			}else{
				return new SeleccionDTO( new Message(false, Constant.PARAMETER_IS_NOT_SPECIFIED) );
			}
	
	}catch( Exception e ){
		log.error("Error at save the client selection: "+e);
		return new SeleccionDTO( new Message(false, Constant.DATABASE_ERROR) );
	}	
  }
}
