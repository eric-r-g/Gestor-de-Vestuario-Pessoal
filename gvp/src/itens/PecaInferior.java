package itens;

public abstract class PecaInferior extends Item implements IEmprestavel {
	public PecaInferior(String modelo, String lojaOrigem, estadosConservacao conservacao, double preco) {
		super(modelo, lojaOrigem, conservacao, preco);
	}
}
