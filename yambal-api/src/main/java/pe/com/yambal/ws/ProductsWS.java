package pe.com.yambal.ws;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.google.gson.Gson;
import pe.com.yambal.model.ProductDTO;
import pe.com.yambal.service.ProductService;
import pe.com.yambal.util.Constant;
import pe.com.yambal.ws.response.RestResponse;

@Path("/products")
public class ProductsWS {

	@Autowired
	ProductService productService;

//	@GET
//	@Path("/getall/{code}")
//	@Produces({ MediaType.APPLICATION_JSON })
//	public RestResponse getallProducts(@PathParam("code") String code_p) {
//		try {
//			Integer status = null;
//			try{ 
//				status = Integer.parseInt(code_p);
//			}catch(Exception e){
//				return new RestResponse(false, Constant.PARAMETER_IS_NOT_SPECIFIED);
//			}	
//			List<ProductDTO> tools = productService.listProducts(status);
//			System.out.println("ENTRANDO AL SERVICIO -  " + tools.toString());
//			if (tools.size() > 0) {
//				return new RestResponse(true, Collections.singletonList(tools),
//						Constant.SATISFACTORY_PROCESS);
//
//			} else {
//				return new RestResponse(false, Constant.PRODUCT_NOT_FOUND);
//			}
//		} catch (Exception e) {
//			System.out.println("Errrorr"+e);
//			return new RestResponse(false, Constant.SERVICE_ERROR);
//		}
//	}
	
	@GET
	@Path("/getall")
	@Produces({ MediaType.APPLICATION_JSON })
	public RestResponse getallProducts() {
		try {
			List<ProductDTO> listProductsReturn = productService.listProducts();
			if (listProductsReturn.size() > 0) {
				
				
				Gson gson = new Gson();
			    Collection collection = new ArrayList();
			    collection.add(listProductsReturn);
			    String json = gson.toJson(collection);

				FileWriter file = new FileWriter("/Users/Cesar/Documents/Proyectos/Yambal/prueba.json");
				file.write(json);
				file.flush();
				file.close();
				
				return new RestResponse(true, listProductsReturn, Constant.SATISFACTORY_PROCESS);
			} else {
				return new RestResponse(false, Constant.PRODUCT_NOT_FOUND);
			}
		}
		catch (Exception e) {
			System.out.println("Errrorr  "+e.getCause() + "  "  + e.getLocalizedMessage()+ "  " + e.getStackTrace()+ "  " + e.getClass()+ "  " + e.getMessage());
			return new RestResponse(false, Constant.SERVICE_ERROR);
		}
	}

}
