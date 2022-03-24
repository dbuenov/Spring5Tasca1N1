package cat.dbuenov.app.exceptions;

import java.util.Date;

public class RespostaExcepcio {
	private Date data;
	private String missatge;
	private String detalls;
	private String httpCode;
	
	public RespostaExcepcio(Date data, String missatge, String detalls, String httpCode) {
		super();
		this.data = data;
		this.missatge = missatge;
		this.detalls = detalls;
		this.httpCode = httpCode;
	}

	public Date getData() {
		return data;
	}

	public String getMissatge() {
		return missatge;
	}

	public String getDetalls() {
		return detalls;
	}

	public String getHttpCode() {
		return httpCode;
	}
	
	
	
	
	
}
