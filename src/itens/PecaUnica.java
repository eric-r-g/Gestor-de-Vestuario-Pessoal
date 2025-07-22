package itens;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import erros.EmprestimoException;

public class PecaUnica extends Item implements IEmprestavel, ILavavel {
	private int tamanho;
	private LocalDate dataDeEmprestimo;
	private String nomeEmprestimo;
	private int quantidadeLavagens;
	private LocalDate dataLavagem;
	
	public PecaUnica(String modelo, String lojaOrigem, estadosConservacao conservacao, double preco, int tamanho) {
		super(modelo, lojaOrigem, conservacao, preco);
		quantidadeLavagens = 0;
		dataLavagem = null;
	}
	
	// getters
	public String getTipo() { return "unica"; }
	public int getTamanho() { return tamanho; }
	public String getNomeEmprestimo() { return nomeEmprestimo; }
	public LocalDate dataDeEmprestimo() { return dataDeEmprestimo; } 
	public int getQuantidadeLavagens() { return quantidadeLavagens; }
	public LocalDate getUltimaLavagem() { return dataLavagem; }

	// setters
	public void setTamanho(int tamanho) { this.tamanho = tamanho; }
	
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
	
	public void AdicionarLavagem(LocalDate data) {
		quantidadeLavagens += 1;
		dataLavagem = data;
	}
	public void ResetarLavagem() {
		quantidadeLavagens = 0;
		dataLavagem = null;
	}
}
