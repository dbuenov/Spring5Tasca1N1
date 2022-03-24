package cat.dbuenov.app.exceptions;

public class BotigaPlenaException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public BotigaPlenaException(Long id) {
		super("La botiga amb id "+id+", esta plena");
	}
}
