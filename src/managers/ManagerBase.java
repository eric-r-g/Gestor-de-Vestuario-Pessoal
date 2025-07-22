package managers;

import java.util.ArrayList;
import repositorios.RepositorioBase;
import erros.*;

public abstract class ManagerBase <T> {
    protected RepositorioBase<T> repositorio;
    
    protected ManagerBase(RepositorioBase<T> repositorio) {
        this.repositorio = repositorio;
    }
    
    public int tamanhoRepositorio() { 
        return repositorio.getTamanho(); 
    }
    
    public ArrayList<T> listarTodos() throws ArrayVaziaException {
        return repositorio.getTodos();
    }
    
    public void adicionar(T item) throws ArrayCheiaException, ElementoExistenteException {
        repositorio.inserirElemento(item);
    }
    
    public void remover(T item) throws ElementoInexistenteException, ArrayVaziaException {
        repositorio.removerElemento(item);
    }
    
    public T atualizar(T antigo, T novo) throws ElementoInexistenteException, ArrayVaziaException, ElementoExistenteException {
    	return repositorio.atualizarElemento(antigo, novo);
    }
    
    public abstract void atualizarBD();
    public abstract void inicializarDados();
}