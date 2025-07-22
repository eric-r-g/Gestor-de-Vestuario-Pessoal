package repositorios;

import java.util.ArrayList;

import erros.*;



public abstract class RepositorioBase <T> {
	protected ArrayList <T> elementos;
	private final int tamanhoMax;
	
	public RepositorioBase() {
		this(50); // tamanho padrão
	}
	
	public RepositorioBase(int tamMax) {
		tamanhoMax = tamMax;
		elementos = new ArrayList <T>();
	}
	
	// getters
	public int getTamanho() { return elementos.size(); }
	public ArrayList<T> getTodos() throws ArrayVaziaException {
		if(elementos.isEmpty()) {
			throw new ArrayVaziaException("Array está vazia");
		}
		return new ArrayList<>(elementos); 
	}

	public void inserirElemento(T novo) throws ArrayCheiaException, ElementoExistenteException {
		if (elementos.size() >= tamanhoMax) {
			throw new ArrayCheiaException("Array está cheia");			
		}
		if(elementos.contains(novo)){
			throw new ElementoExistenteException("Elemento já existente");
		}
		elementos.add(novo);
	}
	
	public T retornarElemento(T item) throws ElementoInexistenteException, ArrayVaziaException {
		if (elementos.size() == 0) { 
			throw new ArrayVaziaException("Array está vazia");	
		}
		
		int index = elementos.indexOf(item);
		
        if (index == -1) {
            throw new ElementoInexistenteException("Elemento inexistente");
        }
        return elementos.get(index);	
	}
	
	// talvez trocar por UUID
	public void removerElemento(T item) throws ElementoInexistenteException, ArrayVaziaException {
		if (elementos.isEmpty()) { 
            throw new ArrayVaziaException("Array está vazia");    
        }
        if (!elementos.remove(item)) {
            throw new ElementoInexistenteException("Elemento inexistente");
        }
	}
	
	public T atualizarElemento(T antigo, T novo) 
            throws ElementoInexistenteException, ArrayVaziaException, ElementoExistenteException {
        if (elementos.isEmpty()) {
            throw new ArrayVaziaException("Array está vazia");
        }
        int index = elementos.indexOf(antigo);
        if (index == -1) {
            throw new ElementoInexistenteException("Elemento antigo não encontrado");
        }
        if (!antigo.equals(novo) && elementos.contains(novo)) {
            throw new ElementoExistenteException("Novo elemento já existe");
        }
        elementos.set(index, novo);
        return novo;
    }
	
	
}
