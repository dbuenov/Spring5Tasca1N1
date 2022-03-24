package cat.dbuenov.app.dades;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cat.dbuenov.app.model.Botiga;


@Repository
public interface RepositoriBotigues extends CrudRepository<Botiga, Long>{
	
}
