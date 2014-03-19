package pe.com.yambal.ws.response;

import java.util.Collections;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class RestResponseCodeAdviserObject {

	@XmlElement(name="success")
	private Boolean success;
	
	@XmlElement(name="data")
    private List<?> data;
	
	@XmlElement(name="code")
    private String code;

	@XmlElement(name="message")
    private String message;
	
	
    
    public RestResponseCodeAdviserObject() {
        this(true, Collections.EMPTY_LIST);
    } 
     
    public RestResponseCodeAdviserObject(boolean success) {
        this(success, Collections.EMPTY_LIST);
    }
     
    public RestResponseCodeAdviserObject(boolean success, List<?> data) {
        this.success = success;
        this.data = data;
    }
    
    public RestResponseCodeAdviserObject(boolean success,String message) {
        this.success = success;
        this.message = message;
    }
    
    public RestResponseCodeAdviserObject(boolean success, List<?> data,String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }
    
    public RestResponseCodeAdviserObject(boolean success, String code ,String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Boolean getSuccess()
    {
        return success;
    }

    public void setSuccess(Boolean success)
    {
        this.success = success;
    }

    public List<?> getData()
    {
        return data;
    }

    public void setData(List<?> data)
    {
        this.data = data;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
