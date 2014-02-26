package pe.com.yambal.service;

import pe.com.yambal.model.ClientDTO;
import pe.com.yambal.model.RegisterDTO;
import pe.com.yambal.ws.request.RegisterRequest;

public interface RegisterService {
	
	public RegisterDTO addCombination(RegisterRequest request);

}
