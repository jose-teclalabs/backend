package pe.com.yambal.ws;

import java.util.Collections;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.core.InjectParam;
import pe.com.yambal.model.RegisterDTO;
import pe.com.yambal.service.RegisterService;
import pe.com.yambal.util.Constant;
import pe.com.yambal.ws.request.RegisterRequest;
import pe.com.yambal.ws.response.RestResponse;
import pe.com.yambal.ws.response.RestResponseIDRegister;

@Path("/register")
public class RegisterWS {
	
	@InjectParam
	RegisterService registerService;
	
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public RestResponse register(RegisterRequest request){
		
		try{
			RegisterDTO newRegisterReturn = registerService.addCombination(request);
			if( newRegisterReturn != null){
				RestResponseIDRegister returnNewID = new RestResponseIDRegister(newRegisterReturn);
				return new RestResponse(newRegisterReturn.getMessage().isSuccess(),Collections.singletonList(returnNewID), newRegisterReturn.getMessage().getDescription() );
			}else{
				return new RestResponse(false,Constant.SERVICE_ERROR );
			}	
	}catch(Exception e){
		return new RestResponse(false,Constant.SERVICE_ERROR );
		}
	}

}
