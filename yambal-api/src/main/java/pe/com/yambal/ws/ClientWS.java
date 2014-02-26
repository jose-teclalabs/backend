package pe.com.yambal.ws;

import java.util.Collections;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.core.InjectParam;
import pe.com.yambal.model.ClientDTO;
import pe.com.yambal.service.ClientService;
import pe.com.yambal.util.Constant;
import pe.com.yambal.ws.request.ClientRequest;
import pe.com.yambal.ws.response.RestResponse;
import pe.com.yambal.ws.response.RestResponseIDClient;

@Path("/client")
public class ClientWS {
	
	@InjectParam
	ClientService clientService;
	
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public RestResponse registrarCheck(ClientRequest request) {
		
		try {
			ClientDTO newclientReturn = clientService.saveClient(request);
			if (newclientReturn != null) {

				RestResponseIDClient returnNewID = new RestResponseIDClient(newclientReturn);
				if (newclientReturn.getMessage().isSuccess()) {
					return new RestResponse(newclientReturn.getMessage().isSuccess(),Collections.singletonList(returnNewID),newclientReturn.getMessage().getDescription());
				} else {
					return new RestResponse(newclientReturn.getMessage().isSuccess(), newclientReturn.getMessage().getDescription());
				}
			} else {
				return new RestResponse(false, Constant.SERVICE_ERROR);
			}
		} catch (Exception e) {
			return new RestResponse(false, Constant.SERVICE_ERROR);
		}
	}

}
