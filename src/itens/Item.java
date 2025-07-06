package itens;

// item genérico do vestuario
public abstract class Item {
	private String modelo;
	private String lojaOrigem;
	private double preco;
	
	public enum estadosConservacao{
		NOVO, USADO, DANIFICADO;
	}
	
	private estadosConservacao conservacao;
	
	public Item(String modelo, String lojaOrigem, estadosConservacao conservacao, double preco) {
		setModelo(modelo);
		setLojaOrigem(lojaOrigem);
		setConservacao(conservacao);
		setPreco(preco);
	}
	
	// getters
	public double getPreco() {
		return preco;
	}
	
	public String getLojaOrigem() {
		return lojaOrigem;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public estadosConservacao getConservacao() {
		return conservacao;
	}
	
	// setters
	public void setPreco(double preco) {
		this.preco = preco;
	}

	public void setLojaOrigem(String lojaOrigem) {
		this.lojaOrigem = lojaOrigem;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setConservacao(estadosConservacao conservacao) {
		this.conservacao = conservacao;
	}
}
