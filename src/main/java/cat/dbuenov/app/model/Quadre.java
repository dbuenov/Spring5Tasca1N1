package cat.dbuenov.app.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Component
public class Quadre {
	private @Id @GeneratedValue Long id;
	private String nom;
	
	//@ManyToOne
	private String autor="";
	private float preu;
	
	private LocalDate dataEntrada;
	
	@ManyToOne
	private Botiga botiga;
	
	private Quadre() {
		super();
		this.dataEntrada = LocalDate.now(); 
	}
	
	public Quadre(String nom, float preu) {
		super();
		this.nom = nom;
		this.preu = preu;
		this.dataEntrada = LocalDate.now(); 		
	}
	
	public Quadre(String nom, String autor, float preu) {
		super();
		this.nom = nom;
		this.autor = autor;
		this.preu = preu;
		this.dataEntrada = LocalDate.now();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public float getPreu() {
		return preu;
	}

	public void setPreu(float preu) {
		this.preu = preu;
	}
	
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}
	
	public Long getId() {
		return id;
	}
	
	public Botiga getBotiga() {
		return botiga;
	}

	public void setBotiga(Botiga botiga) {
		this.botiga = botiga;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, botiga, dataEntrada, id, nom, preu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quadre other = (Quadre) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(botiga, other.botiga)
				&& Objects.equals(dataEntrada, other.dataEntrada) && Objects.equals(id, other.id)
				&& Objects.equals(nom, other.nom) && Float.floatToIntBits(preu) == Float.floatToIntBits(other.preu);
	}

	@Override
	public String toString() {
		return "Quadre [id=" + id + ", nom=" + nom + ", autor=" + autor + ", preu=" + preu 
				+ ", dataEntrada="+ dataEntrada + ", botiga=" + botiga + "]";
	}	
}