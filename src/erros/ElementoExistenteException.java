package erros;

public class ElementoExistenteException extends Exception {
	private static final long serialVersionUID = 1L;

	public ElementoExistenteException(String texto) {
		super(texto);
	}
}
