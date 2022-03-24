package cat.dbuenov.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.dbuenov.app.dades.RepositoriBotigues;
import cat.dbuenov.app.dades.RepositoriQuadres;
import cat.dbuenov.app.exceptions.BotigaNotFoundException;
import cat.dbuenov.app.exceptions.BotigaPlenaException;
import cat.dbuenov.app.model.Botiga;
import cat.dbuenov.app.model.Quadre;

@Service
public class ServiceWhiteCollar {
	
	@Autowired
	RepositoriBotigues botigues;
	
	@Autowired
	RepositoriQuadres quadres;
	
	public Botiga addBotiga(Botiga botiga) {
		return botigues.save(botiga);
	}
	
	public List<Botiga> getBotigues(){
		return (List<Botiga>) botigues.findAll();
	}
	
	public Botiga getBotiga(Long id) {
		Optional<Botiga> botiga = botigues.findById(id);
		if (botiga.isEmpty()) {
			throw new BotigaNotFoundException(id);
		}
		return botiga.get();
	}
	
	public Quadre addQuadre(Long id, Quadre quadre) {
		Botiga botiga = getBotiga(id);
		
		//controlo la capacitat de la botiga
		if (botiga.getCapacitat()>quadres.countByBotiga(botiga)) {
			quadre.setBotiga(botiga);		
			quadres.save(quadre);
		}else {
			throw new BotigaPlenaException(id);
		}
		return quadre;
	}	
	
	public List<Quadre> getQuadresBotiga(Long id){
		Botiga botiga = getBotiga(id);
		return (List<Quadre>) quadres.findByBotiga(botiga);
	}
	
	public List<Quadre> deleteQuadresBotiga(Long id) {
		List<Quadre> quadresBotiga = getQuadresBotiga(id);
		quadres.deleteAll(quadresBotiga);	
		return quadresBotiga;
	}
		
}
