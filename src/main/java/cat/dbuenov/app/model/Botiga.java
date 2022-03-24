package cat.dbuenov.app.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Component
public class Botiga {
	
	@Id 
	@GeneratedValue 
	private Long id;
	private String nom;
	private int capacitat;
	
	@OneToMany(mappedBy = "botiga")
	private List<Quadre> quadres;
	
	private Botiga() {}
	
	public Botiga(String nom, int capacitat) {
		this.nom = nom;
		this.capacitat = capacitat;		
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getCapacitat() {
		return capacitat;
	}
	
	public void setCapacitat(int capacitat) {
		this.capacitat = capacitat;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacitat, id, nom, quadres);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Botiga other = (Botiga) obj;
		return capacitat == other.capacitat && Objects.equals(id, other.id) && Objects.equals(nom, other.nom)
				&& Objects.equals(quadres, other.quadres);
	}

	@Override
	public String toString() {
		return "Botiga [id=" + id + ", nom=" + nom + ", capacitat=" + capacitat + ", quadres=" + quadres + "]";
	}	
}




