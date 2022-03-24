package cat.dbuenov.app.exceptions;

public class BotigaNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public BotigaNotFoundException(Long id) {
		super("No he trobat la botiga amb id: "+id);
	}
}
