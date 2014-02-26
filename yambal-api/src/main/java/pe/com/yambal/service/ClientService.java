package pe.com.yambal.service;

import pe.com.yambal.model.ClientDTO;
import pe.com.yambal.ws.request.ClientRequest;

public interface ClientService {
	
	public ClientDTO saveClient(ClientRequest request);
	public ClientDTO sendProducts(String email);

}
