package repositorios;

import java.time.LocalDate;
import java.util.UUID;

import erros.ArrayVaziaException;
import erros.ElementoInexistenteException;
import itens.ILavavel;


public class RepositorioLavagem extends RepositorioBase <ILavavel>{
	
	public RepositorioLavagem()  {
		super();
	}
	
	public RepositorioLavagem(int tamMax) {
		super(tamMax);
	}
	
	public void realizarLavagem(LocalDate data) {
		for(ILavavel item : elementos) {
			item.AdicionarLavagem(data);
		}
		elementos.clear();
	}
	
	public void resetarLavagem(ILavavel item) throws ElementoInexistenteException {
		int index = elementos.indexOf(item);
		
		if(index == -1) {
			throw new ElementoInexistenteException("Elemento inexistente");
		}
		
		elementos.get(index).ResetarLavagem();
	}
	
	public int quantidadeLavagens(ILavavel item) throws ElementoInexistenteException {
		int index = elementos.indexOf(item);
		
		if(index == -1) {
			throw new ElementoInexistenteException("Elemento inexistente");
		}
		
		return elementos.get(index).getQuantidadeLavagens();
	}
	
	public LocalDate dataUltimaLavagem(ILavavel item) throws ElementoInexistenteException {
		int index = elementos.indexOf(item);
		
		if(index == -1) {
			throw new ElementoInexistenteException("Elemento inexistente");
		}
		
		return elementos.get(index).getUltimaLavagem();
	}
	
	public ILavavel RetornarLavagemPorId(UUID id) throws ArrayVaziaException, ElementoInexistenteException {
		if (elementos.size() == 0) { 
			throw new ArrayVaziaException("Array está vazia");	
		}
		
		for(ILavavel item : elementos){
			if(item.getId().equals(id)) {
				return item;
			}
		}
		throw new ElementoInexistenteException("Elemento inexistente");
	}
}
