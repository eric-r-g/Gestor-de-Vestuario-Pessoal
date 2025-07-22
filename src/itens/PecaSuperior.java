package itens;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import erros.EmprestimoException;

public class PecaSuperior extends Item implements IEmprestavel, ILavavel {
	private LocalDate dataDeEmprestimo;
	private String nomeEmprestimo;
	private int tamanho;
	private boolean externo;
	private int quantidadeLavagens;
	private LocalDate dataLavagem;
	
	// getters
	public String getTipo() { return "superior"; }
	public int getTamanho() { return tamanho; }
	public boolean isExterno() { return externo; }
	public String getNomeEmprestimo() { return nomeEmprestimo; }
	public LocalDate dataDeEmprestimo() { return dataDeEmprestimo; }
	public int getQuantidadeLavagens() { return quantidadeLavagens; }
	public LocalDate getUltimaLavagem() { return dataLavagem; }
	
	
	// setters
	public void setTamanho(int tamanho) { this.tamanho = tamanho; }
	public void setExterno(boolean externo) { this.externo = externo; }


	
	public PecaSuperior(String modelo, String lojaOrigem, estadosConservacao conservacao, double preco, int tamanho, boolean externo) {
		super(modelo, lojaOrigem, conservacao, preco);
		this.tamanho = tamanho;
		this.externo = externo;
		dataDeEmprestimo = null;
		quantidadeLavagens = 0;
		dataLavagem = null;
	}
	
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
