package pe.com.yambal.service.impl;

import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.yambal.dao.AdviserDao;
import pe.com.yambal.dao.ClientDao;
import pe.com.yambal.model.AdviserDTO;
import pe.com.yambal.model.ClientDTO;
import pe.com.yambal.pojo.Adviser;
import pe.com.yambal.pojo.Client;
import pe.com.yambal.service.ClientService;
import pe.com.yambal.util.Constant;
import pe.com.yambal.util.HtmlEmailSender;
import pe.com.yambal.util.Message;
import pe.com.yambal.ws.request.ClientRequest;

@Service
public class ClientServiceImpl implements ClientService{

	private static final Log log = LogFactory.getLog(ClientServiceImpl.class);
	
	@Autowired
	ClientDao clientDao;
	@Autowired
	AdviserDao adviserDao;
	
	@Override
	public ClientDTO saveClient(ClientRequest request) {
		try{			
			String phone = null;
			String email =  null;
			String name = null;
			String codeprincipal = request.getCode();
			try {
				phone = request.getPhone();
				email = request.getEmail();
				name = request.getName();
			} catch (Exception e) {
				return new ClientDTO(new Message(false,
						Constant.PARAMETER_IS_NOT_PROPERLY_FORMATTED));
			}
		if (!request.getCode().equals(Constant.IS_EMPTY) && (!email.equals(Constant.IS_EMPTY))){
			Adviser adviserReturn = adviserDao.verifyCodeOfAdviser(new AdviserDTO(codeprincipal));
			if (adviserReturn == null) {
				return new ClientDTO(new Message(false,Constant.ADVISER_NOT_FOUND));
			}
			ClientDTO objAlmacenador = new ClientDTO();
			objAlmacenador.setEmail(email);
			objAlmacenador.setPhone(phone);
			Client clientDniVerify = clientDao.searchByEmailOrPhone(objAlmacenador);
			
			if(clientDniVerify != null){
				Integer oldID = clientDniVerify.getClientId();
				return new ClientDTO(oldID,new Message(true,Constant.CLIENT_ALREADY_EXIST));				
			}
			
			ClientDTO clientObj =  new ClientDTO();
			clientObj.setEmail(email);
			clientObj.setName(name);
			clientObj.setPhone(phone);
			clientObj.setClientDate(new Date());
			clientObj.setStatus(1);
			clientObj.setAdviser(new AdviserDTO(adviserReturn.getAdviserId()));
			Integer newID = clientDao.saveClient(clientObj);		
			return new ClientDTO(newID, new Message(true ,Constant.SUCCESS));
			} else {
			return new ClientDTO(new Message(false, Constant.MISSING_VALUES_PARAMETERS));
		}			
		}
		catch (Exception e) {
			log.error("Error at client" );
			return new ClientDTO(new Message(false,Constant.DATABASE_ERROR));
		}
	}
	
	@Override
	public ClientDTO sendProducts(String email) {
		try{
			System.out.println("el correo que viene es : "+email);
			if( !email.equals(Constant.IS_EMPTY) ){
				
				//verified
				Client clientVerified = clientDao.findPaUserByEmailV2( new ClientDTO(email) );
				System.out.println("email = "+clientVerified.getEmail());
				
				if( (clientVerified != null) == true ){
					
					ClientDTO client = new ClientDTO();
					//password generated
					client.setClientId(clientVerified.getClientId());
					client.setEmail( clientVerified.getEmail() );
					
					System.out.println("si modifico");
					//send email
					// SMTP server information
			        String host = "smtp.gmail.com";
			        String port = "587";
			        String mailFrom = "yanbal.email@gmail.com";
			        String password = "yanbal123456789";
			 
			        // outgoing message information
			        String mailTo = client.getEmail().trim(); 
			        String subject = "Yanbal Email";
			 
			        // message contains HTML markups
			        String message = "<i>Greetings!</i><br>";
			        message += "<b>Hello , this is an example to send email</b><br>";
			        message += "<font color=orange>Yanbal Mail Service</font>";
			 
			        HtmlEmailSender mailer = new HtmlEmailSender();
			 
			        try {
			            mailer.sendHtmlEmail(host, port, mailFrom, password, mailTo, subject, message);
			            return new ClientDTO( new Message(true, Constant.SATISFACTORY_PROCESS) );
			        } catch (Exception ex) {
			            ex.printStackTrace();
			            return new ClientDTO( new Message(false, Constant.ERROR_SENDING_EMAIL) );
			        }
				}
				else{
					return new ClientDTO( new Message(false, Constant.EMAIL_NOT_FOUND) );
				}
			
			}else{
				return new ClientDTO( new Message(false, Constant.PARAMETER_IS_NOT_SPECIFIED) );
			}
		}catch(Exception e){
			return new ClientDTO( new Message(false, Constant.DATABASE_ERROR) );
		}	
	}

}
