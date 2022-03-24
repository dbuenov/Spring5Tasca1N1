package cat.dbuenov.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.dbuenov.app.exceptions.BotigaNotFoundException;
import cat.dbuenov.app.model.Botiga;
import cat.dbuenov.app.model.Quadre;
import cat.dbuenov.app.service.ServiceWhiteCollar;

@RestController
@RequestMapping("/")
public class WhiteCollarController {

	@Autowired
	ServiceWhiteCollar serviceWhiteCollar;
	
	@PostMapping("/shops")
	public ResponseEntity<Botiga> creaBotiga(@RequestBody Botiga botiga) {
		return new ResponseEntity<Botiga> (serviceWhiteCollar.addBotiga(botiga),HttpStatus.CREATED);		
	}
	
	@GetMapping("/shops")
	public ResponseEntity<List<Botiga>> mostraTotesLesBotigues(){
		return new ResponseEntity<List<Botiga>> (serviceWhiteCollar.getBotigues(),HttpStatus.OK);		
	}
	
	@PostMapping("/shops/{id}/pictures")
	public ResponseEntity<Quadre> creaQuadre(@PathVariable Long id, @RequestBody Quadre quadre) {
		return new ResponseEntity<Quadre> (serviceWhiteCollar.addQuadre(id, quadre),HttpStatus.CREATED);		
	}
	
	@GetMapping("/shops/{id}/pictures")
	public ResponseEntity<List<Quadre>> mostraQuadresBotiga(@PathVariable Long id){
		return new ResponseEntity<List<Quadre>> (serviceWhiteCollar.getQuadresBotiga(id),HttpStatus.OK);		
	}
	
	@DeleteMapping("/shops/{id}/pictures")
	public ResponseEntity<List<Quadre>> esborraQuadresBotiga(@PathVariable Long id){
		return new ResponseEntity<List<Quadre>> (serviceWhiteCollar.deleteQuadresBotiga(id),HttpStatus.ACCEPTED);		
	}
		
}
