package cat.dbuenov.app.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ManipuladorErrors {
	
	@ExceptionHandler(BotigaNotFoundException.class)
	public ResponseEntity<RespostaExcepcio> manipuladorBotigaNoTrobada(BotigaNotFoundException ex, WebRequest peticio) {
		RespostaExcepcio resposta = new RespostaExcepcio(new Date(), ex.getMessage(), peticio.getDescription(false), HttpStatus.NOT_FOUND.getReasonPhrase());
		return new ResponseEntity<RespostaExcepcio> (resposta, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BotigaPlenaException.class)
	public ResponseEntity<RespostaExcepcio> manipuladorBotigaNoTrobada(BotigaPlenaException ex, WebRequest peticio) {
		RespostaExcepcio resposta = new RespostaExcepcio(new Date(), ex.getMessage(), peticio.getDescription(false), HttpStatus.CONFLICT.getReasonPhrase());
		return new ResponseEntity<RespostaExcepcio> (resposta, HttpStatus.CONFLICT);
	}
}


