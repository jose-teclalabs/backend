package pe.com.yambal.ws.response;

import pe.com.yambal.model.ClientDTO;
import pe.com.yambal.util.Constant;


public class RestResponseIDClient {
	private String newID;
	public RestResponseIDClient(ClientDTO clientReturn) {

		this.newID = (clientReturn.getClientId() == null) ? Constant.IS_EMPTY
				: String.valueOf(clientReturn.getClientId());
	}

	public String getNewID() {
		return newID;
	}

	public void setNewID(String newID) {
		this.newID = newID;
	}
}
