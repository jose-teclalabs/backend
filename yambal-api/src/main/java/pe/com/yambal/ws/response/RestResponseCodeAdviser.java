package pe.com.yambal.ws.response;

import pe.com.yambal.model.AdviserDTO;
import pe.com.yambal.util.Constant;

public class RestResponseCodeAdviser {
	private String code;
	public RestResponseCodeAdviser(AdviserDTO adviserReturn) {		
		this.code = (adviserReturn.getCode() == null) ? Constant.IS_EMPTY
				: String.valueOf(adviserReturn.getCode());
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
