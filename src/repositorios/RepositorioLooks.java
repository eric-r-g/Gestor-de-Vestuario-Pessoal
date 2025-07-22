package repositorios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import erros.*;
import itens.Item;
import itens.Look;

public class RepositorioLooks extends RepositorioBase <Look> {
	public RepositorioLooks() {
		super();
	}
	
	public RepositorioLooks(int tamMax) {
		super(tamMax);
	}
	
	public void utilizarLook(Look look, String local, LocalDate data) throws ElementoInexistenteException, ArrayVaziaException {
		if (elementos.isEmpty()) {
			throw new ArrayVaziaException("Array está vazia");
		}
		int index = elementos.indexOf(look);
		
        if (index == -1) {
            throw new ElementoInexistenteException("Elemento inexistente");
        }
        
        look.adicionarUtilizacao(data, local);
	}
	
	public void atualizarElemento(Look look, ArrayList <Item> itens ) throws ArrayVaziaException, ElementoInexistenteException {
		if (elementos.isEmpty()) {
			throw new ArrayVaziaException("Array está vazia");
		}
		int index = elementos.indexOf(look);
		
        if (index == -1) {
            throw new ElementoInexistenteException("Elemento inexistente");
        }
        
        look.atualizarLook(itens);
	}
	
	public Look RetornarLookPorId(UUID id) throws ArrayVaziaException, ElementoInexistenteException {
		if (elementos.size() == 0) { 
			throw new ArrayVaziaException("Array está vazia");	
		}
		
		for(Look look : elementos){
			if(look.getId().equals(id)) {
				return look;
			}
		}
		throw new ElementoInexistenteException("Elemento inexistente");
	}
}