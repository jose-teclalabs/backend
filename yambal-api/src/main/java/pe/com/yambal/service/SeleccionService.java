package pe.com.yambal.service;


import pe.com.yambal.model.SeleccionDTO;
import pe.com.yambal.ws.request.SeleccionRequest;

public interface SeleccionService {
	public abstract SeleccionDTO registrarSeleccion( SeleccionRequest cuest );

}
