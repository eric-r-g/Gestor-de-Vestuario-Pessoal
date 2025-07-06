package itens;


public abstract class Acessorio extends Item implements IEmprestavel {
	public Acessorio(String modelo, String lojaOrigem, estadosConservacao conservacao, double preco) {
		super(modelo, lojaOrigem, conservacao, preco);
	}
}
