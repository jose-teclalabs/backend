package pe.com.yambal.ws;

import java.util.Collections;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pe.com.yambal.model.AdviserDTO;
import pe.com.yambal.service.impl.AdviserServiceImpl;
import pe.com.yambal.util.Constant;
import pe.com.yambal.ws.request.AdviserRequest;
import pe.com.yambal.ws.response.RestResponse;
import com.sun.jersey.api.core.InjectParam;


@Path("/adviser")
public class AdviserWS {
	
	@InjectParam
	AdviserServiceImpl adviserServiceImpl;
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public RestResponse Login(AdviserRequest request){
			
		try{
			AdviserDTO adviserReturn = adviserServiceImpl.yambalLogin(request);
			if(adviserReturn != null){
				return new RestResponse(true,Collections.singletonList(adviserReturn),Constant.SATISFACTORY_PROCESS);
				
			}else{
				return new RestResponse(false,Constant.ADVISER_NOT_FOUND );
			}			
		}catch(Exception e){
			System.out.println(e);
			return new RestResponse(false,Constant.SERVICE_ERROR );
		}
	}

}
