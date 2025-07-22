package repositorios;

import java.util.UUID;

import erros.ArrayVaziaException;
import erros.ElementoInexistenteException;
import itens.IEmprestavel;

public class RepositorioEmprestimo extends RepositorioBase <IEmprestavel> {
	
	public RepositorioEmprestimo() {
		super();
	}
	
	public RepositorioEmprestimo(int tamMax) {
		super(tamMax);
	}
	
	public IEmprestavel RetornarEmprestavelPorId(UUID id) throws ArrayVaziaException, ElementoInexistenteException {
		if (elementos.size() == 0) { 
			throw new ArrayVaziaException("Array está vazia");	
		}
		
		for(IEmprestavel item : elementos){
			if(item.getId().equals(id)) {
				return item;
			}
		}
		throw new ElementoInexistenteException("Elemento inexistente");
	}
}
