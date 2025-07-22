package erros;

public class EntradaInvalidaException extends Exception {
	private static final long serialVersionUID = 1L;

	public EntradaInvalidaException(String texto) {
		super(texto);
	}
}
