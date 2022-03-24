package cat.dbuenov.app.dades;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cat.dbuenov.app.model.Botiga;
import cat.dbuenov.app.model.Quadre;

@Repository
public interface RepositoriQuadres extends CrudRepository<Quadre, Long>{
	public List<Quadre> findByBotiga(Botiga botiga);
	public int countByBotiga(Botiga botiga);		
}
