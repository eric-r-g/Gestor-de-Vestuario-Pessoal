package recursosGrafico;

import javax.swing.*;

import interfaceGrafica.GerenciadorPaginas;

import java.awt.*;

public abstract class ModeloPagina extends JPanel {
	private static final long serialVersionUID = 1L;
	private Font fonteLogo = new Font("Arial", Font.BOLD, 64); 
	private JPanel sidePane;
	protected JPanel contentPane;
	
	public ModeloPagina(GerenciadorPaginas gerenciador) {
		// painel principal
		setLayout(new BorderLayout());
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		
		sidePane = new JPanel();
		sidePane.setBackground(Color.BLACK);
		sidePane.setPreferredSize(new Dimension(300, 0));
		sidePane.setLayout(new BoxLayout(sidePane, BoxLayout.Y_AXIS));
		
		sidePane.add(Box.createVerticalStrut(100)); // espacamento 

        JLabel logo = new JLabel("GVP");
        logo.setForeground(Color.WHITE);
        logo.setFont(fonteLogo);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidePane.add(logo);
        
        sidePane.add(Box.createVerticalStrut(200)); // espacamento 
        
        JPanel bullets = new JPanel();
        bullets.setBackground(Color.BLACK);
        
       
        BulletPanel itens = new BulletPanel(
        		"Itens", 
        		"TELA_ITENS_LISTAR",
        		gerenciador
        		);
        BulletPanel looks = new BulletPanel(
        		"Looks", 
        		"TELA_LOOKS_LISTAR",
        		gerenciador
        		);
        BulletPanel emprestimos = new BulletPanel(
        		"Emprestimos", 
        		"TELA_EMPRESTIMOS_LISTAR",
        		gerenciador
        		);
        BulletPanel lavagens = new BulletPanel(
        		"Lavagens", 
        		"TELA_LAVAGENS_LISTAR",
        		gerenciador
        		);
        BulletPanel estatisticas = new BulletPanel(
        		"Estatisticas", 
        		"TELA_ESTATISTICAS",
        		gerenciador
        		);
        
        
        bullets.add(itens);
        bullets.add(looks);
        bullets.add(emprestimos);
        bullets.add(lavagens);
        bullets.add(estatisticas);
        
        

        sidePane.add(bullets);
        
        
        add(sidePane, BorderLayout.WEST); // Lateral esquerda
        add(contentPane, BorderLayout.CENTER); // Centro (resto do espaço)		
        
	}
	
	protected abstract void configurarContentPane();
}
