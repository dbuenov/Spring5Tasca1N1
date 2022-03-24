package cat.dbuenov.app.configuracio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cat.dbuenov.app.dades.RepositoriBotigues;
import cat.dbuenov.app.dades.RepositoriQuadres;
import cat.dbuenov.app.model.Botiga;
import cat.dbuenov.app.model.Quadre;

@Configuration
public class CarregaDades {
	
	@Bean
	CommandLineRunner iniciaBaseDatos (RepositoriBotigues botigues, RepositoriQuadres quadres) {

		return args ->{
			
			Botiga botiga1 = new Botiga("Barcelona", 2);
			Botiga botiga2 = new Botiga("Madrid", 4);
			Botiga botiga3= new Botiga("Sevilla", 5);
			Botiga botiga4 = new Botiga("Valencia", 7);
			
			botigues.save(botiga1);
			botigues.save(botiga2);
			botigues.save(botiga3);
			botigues.save(botiga4);
			
			Quadre quadre1 = new Quadre("Salvator Mundi", "Leonardo Da Vinci", 450000000F);
			quadre1.setBotiga(botiga1);
			quadres.save(quadre1);
			
			Quadre quadre2 = new Quadre("No. 20 (Yellow Expanse)", "Mark Rothko", 200000000F);
			quadre2.setBotiga(botiga1);
			quadres.save(quadre2);
			
			Quadre quadre3 = new Quadre("Wasserschlangen II", "Gustav Klimt", 222000000F);
			quadre3.setBotiga(botiga2);
			quadres.save(quadre3);
			
			Quadre quadre4 = new Quadre("Interchange", 300000000F);
			quadre4.setBotiga(botiga2);
			quadres.save(quadre4);
			
			Quadre quadre5 = new Quadre("Los Jugadores de cartas", "Paul Cézanne", 250000000F);
			quadre5.setBotiga(botiga2);
			quadres.save(quadre5);
			
			Quadre quadre6 = new Quadre("Orange Marilyn", 248000000F);
			quadre6.setBotiga(botiga3);
			quadres.save(quadre6);
			
			Quadre quadre7 = new Quadre("Nafea faa Ipoipo?", "Paul Gauguin", 210000000F);
			quadre7.setBotiga(botiga3);
			quadres.save(quadre7);
			
			Quadre quadre8 = new Quadre("Number 17A", "Jackson Pollock", 233000000F);
			quadre8.setBotiga(botiga3);
			quadres.save(quadre8);
			
			Quadre quadre9 = new Quadre("No. 6 (Violeta, Verde y Rojo)", "Mark Rothko", 217000000F);
			quadre9.setBotiga(botiga3);
			quadres.save(quadre9);
			
			Quadre quadre10 = new Quadre("Les Femmes d'Alger", "Pablo Picasso", 209000000F);
			quadre10.setBotiga(botiga4);
			quadres.save(quadre10);
			
			Quadre quadre11 = new Quadre("Nu couché",  209000000F);
			quadre11.setBotiga(botiga4);
			quadres.save(quadre11);
			
			Quadre quadre12 = new Quadre("El Portaestandarte", "Rembrandt", 197000000F);
			quadre12.setBotiga(botiga4);
			quadres.save(quadre12);
			
			Quadre quadre13 = new Quadre("Number 5",  197000000F);
			quadre13.setBotiga(botiga4);
			quadres.save(quadre13);		
					
		};
	}	
}
