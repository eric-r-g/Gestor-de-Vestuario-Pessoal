package itens;


public abstract class PecaUnica extends Item implements IEmprestavel {
	public PecaUnica(String modelo, String lojaOrigem, estadosConservacao conservacao, double preco) {
		super(modelo, lojaOrigem, conservacao, preco);
	}
}
