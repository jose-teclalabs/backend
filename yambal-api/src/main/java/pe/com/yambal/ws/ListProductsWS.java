package pe.com.yambal.ws;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.sun.jersey.api.core.InjectParam;
import pe.com.yambal.pojo.ListProduct;
import pe.com.yambal.service.ListProductService;
import pe.com.yambal.util.Constant;
import pe.com.yambal.ws.response.RestResponse;

@Path("/listproducts")
public class ListProductsWS {

	@InjectParam
	ListProductService listProductService;

	@GET
	@Path("/getall")
	@Produces({ MediaType.APPLICATION_JSON })
	public RestResponse getallProducts() {
		try {
			List<ListProduct> listProductsReturn = listProductService.listProducts();
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
		}	}

}
