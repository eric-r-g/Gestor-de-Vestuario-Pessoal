package erros;

public class ElementoInexistenteException extends Exception {
	private static final long serialVersionUID = 1L;

	public ElementoInexistenteException(String texto) {
		super(texto);
	}
}
