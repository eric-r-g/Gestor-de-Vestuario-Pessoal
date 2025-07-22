package erros;

public class ArrayVaziaException  extends Exception {
	private static final long serialVersionUID = 1L;

	public ArrayVaziaException(String texto) {
		super(texto);
	}
}
