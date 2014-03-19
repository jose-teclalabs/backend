package pe.com.yambal.ws.response;

import pe.com.yambal.model.RegisterDTO;
import pe.com.yambal.util.Constant;

public class RestResponseIDRegister {
	private String newID;
	public RestResponseIDRegister(RegisterDTO registerReturn) {

		this.newID = (registerReturn.getRegisterId() == null) ? Constant.IS_EMPTY
				: String.valueOf(registerReturn.getRegisterId());
	}

	public String getNewID() {
		return newID;
	}

	public void setNewID(String newID) {
		this.newID = newID;
	}
}
