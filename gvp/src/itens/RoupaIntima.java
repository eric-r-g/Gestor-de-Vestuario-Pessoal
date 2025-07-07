package itens;

public abstract class RoupaIntima  extends Item implements IEmprestavel {
	public RoupaIntima(String modelo, String lojaOrigem, estadosConservacao conservacao, double preco) {
		super(modelo, lojaOrigem, conservacao, preco);
	}
}
