package interfaceGrafica;

import javax.swing.*;

import erros.ArrayVaziaException;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import itens.Item;
import managers.BDManager;
import managers.ItemManager;
import recursosGrafico.ModeloJanelaListar;

import java.util.ArrayList;
import java.util.UUID;

public class JanelaItensListar extends ModeloJanelaListar<Item>{
	private static final long serialVersionUID = 1L;
	private ItemManager itemManager;
	private BDManager bdManager;
	
	public JanelaItensListar(GerenciadorPaginas gerenciador, ItemManager itemManager, BDManager bdManager) {	
		super(gerenciador, "Listagens Itens", "TELA_ITENS_ADICIONAR");
		this.gerenciador = gerenciador;
		this.itemManager = itemManager;
		this.bdManager = bdManager;
		
		atualizarListagem();
	}

	
	protected ArrayList<Item> obterListagem() throws ArrayVaziaException {
		return itemManager.listarTodos();
	}

	
	protected JPanel obterPainelItem(Item item) {
		JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        itemPanel.add(new JLabel(item.getTipo()));
        itemPanel.add(new JLabel(item.getModelo()));
        itemPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        itemPanel.setMaximumSize(new Dimension(800, 40));
        
        JButton butaoDelete = new JButton("Deletar");
        butaoDelete.putClientProperty("id", item.getId());
        
        butaoDelete.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		UUID id = (UUID) butaoDelete.getClientProperty("id");
        		try {
        			Item removido = itemManager.retornarItemPorId(id);
        			itemManager.remover(removido);
        			bdManager.removerItem(removido);
        		} catch (Exception erro) {
        			System.out.print(erro);
        		}
        		atualizarListagem();
            }
        });
        itemPanel.add(butaoDelete);
        
        JButton butaoEditar = new JButton("Editar");
        butaoEditar.putClientProperty("id", item.getId());
        
        butaoEditar.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		UUID id = (UUID) butaoEditar.getClientProperty("id");
        		try {
        			gerenciador.mostrarTela("TELA_ITENS_ADICIONAR");
        			gerenciador.JIAdd.setItemEditar(id);
        		} catch (Exception erro) {
        			System.out.print(erro);
        		}
        		atualizarListagem();
            }
        });
        itemPanel.add(butaoEditar);
        
        return itemPanel;
	}
}
