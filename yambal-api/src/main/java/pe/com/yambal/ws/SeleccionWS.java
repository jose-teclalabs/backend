package pe.com.yambal.ws;

import java.util.Collections;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import pe.com.yambal.model.SeleccionDTO;
import pe.com.yambal.service.SeleccionService;
import pe.com.yambal.util.Constant;
import pe.com.yambal.ws.request.SeleccionRequest;
import pe.com.yambal.ws.response.RestResponse;
import pe.com.yambal.ws.response.RestResponseSeleId;
import com.sun.jersey.api.core.InjectParam;

@Path("/seleccion")
public class SeleccionWS {
	
	@InjectParam
	SeleccionService seleccionService;
	
	@POST 
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) 
	public RestResponse registrarCuestionario(SeleccionRequest request){
		try{
			SeleccionDTO seleccion = seleccionService.registrarSeleccion(request);
			if( seleccion != null){
				RestResponseSeleId cuestID = new RestResponseSeleId(seleccion);
				if( seleccion.getMessage().isSuccess() ){
					return new RestResponse(seleccion.getMessage().isSuccess(), Collections.singletonList(cuestID),seleccion.getMessage().getDescription());
				}else{
					return new RestResponse(seleccion.getMessage().isSuccess(), seleccion.getMessage().getDescription() );
				}
			}else{
				return new RestResponse(false,Constant.SERVICE_ERROR );
			}	
		}catch(Exception e){
			return new RestResponse(false,Constant.SERVICE_ERROR );
		}
	}

}
