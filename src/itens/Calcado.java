package itens;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import erros.EmprestimoException;

public class Calcado extends Item implements IEmprestavel{
	private int numeracao;
	private LocalDate dataDeEmprestimo;
	private String nomeEmprestimo;
	
	public Calcado(String modelo, String lojaOrigem, estadosConservacao conservacao, double preco, int numeracao) {
		super(modelo, lojaOrigem, conservacao, preco);
		this.setNumeracao(numeracao);
		dataDeEmprestimo = null;
		nomeEmprestimo = null;
	}
	
	// getters
	public int getNumeracao() { return numeracao; }
	public String getNomeEmprestimo() { return nomeEmprestimo; }
	public LocalDate dataDeEmprestimo() { return dataDeEmprestimo; }
	public String getTipo() { return "calcado"; }
	
	// setters
	public void setNumeracao(int numeracao) { this.numeracao = numeracao; }
	
	// metodos para emprestimo
	public void registrarEmprestimo(LocalDate data, String nome) throws EmprestimoException {
		if (dataDeEmprestimo != null) {
			throw new EmprestimoException("Já está em emprestimo");
		}
		dataDeEmprestimo = data;
		nomeEmprestimo = nome;
	}
	
	public long quantidadeDeDiasDesdeOEmprestimo() throws EmprestimoException{
		if (dataDeEmprestimo == null) {
			throw new EmprestimoException("não está em emprestimo");
		}
		return ChronoUnit.DAYS.between(LocalDate.now(), dataDeEmprestimo);
		
	}
	
	public void registrarDevolucao() throws EmprestimoException {
		if (dataDeEmprestimo == null) {
			throw new EmprestimoException("não está em emprestimo");
		}
		dataDeEmprestimo = null;
	}
}
