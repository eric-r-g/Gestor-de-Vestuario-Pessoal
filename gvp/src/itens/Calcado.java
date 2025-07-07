package itens;

public abstract class Calcado extends Item implements IEmprestavel{
	private int numeracao;
	public Calcado(String modelo, String lojaOrigem, estadosConservacao conservacao, double preco, int numeracao) {
		super(modelo, lojaOrigem, conservacao, preco);
		this.setNumeracao(numeracao);
	}
	
	public int getNumeracao() {
		return numeracao;
	}
	
	public void setNumeracao(int numeracao) {
		this.numeracao = numeracao;
	}
}
