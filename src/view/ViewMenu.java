package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.*;

/**
 * Classe do menu introdut�rio, permite o redirecionamento para os principais meios, o de Im�veis e os de Usu�rios
 * @author Rafael Nobre e Caio Berg
 *
 */

public class ViewMenu implements ActionListener{

	private static JFrame janela = new JFrame("Menu");
	private static JLabel titulo = new JLabel("Menu Principal", SwingConstants.CENTER);
	private static JButton btnImoveis = new JButton("Gerenciar Imoveis");
	private static JButton btnUsuarios = new JButton("Gerenciar Usu�rios");
	public static ControleDados dados = new ControleDados();
	
	/**
	 * Construtor do Menu
	 */
	
	public ViewMenu() {
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(110, 10, 180, 30);
		btnImoveis.setBounds(110, 80, 180, 30);
		btnUsuarios.setBounds(110, 130, 180, 30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(btnImoveis);
		janela.add(btnUsuarios);
		
		// Criacao de variaveis para determinar o tamanho da janela
		int jframeW = 400;
		int jframeH= 250;
		janela.setSize(jframeW, jframeH);
		
		// Codigo para colocar a janela no meio da tela, essa variavel dim pega o tamanho do display
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int locationX = (dim.width - jframeW)/2;
		int locationY = (dim.height - jframeH)/2;
		janela.setLocation(locationX, locationY);
		
		
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
	}
	
	/**
	 * M�todo main, onde d� in�cio ao sistema
	 * @param args
	 */
	
	public static void main(String[] args) {
		ViewMenu menu = new ViewMenu();
		
		btnImoveis.addActionListener(menu);
		btnUsuarios.addActionListener(menu);
			
	}
	
	/**
	 * M�todo para controle dos eventos na janela
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == btnImoveis) {
			janela.dispose();
			new ViewMenuListas(dados, 1);
			
		}
		if(src == btnUsuarios) {
			janela.dispose();
			new ViewMenuListas(dados, 2);
			
		}
		
		
	}
	
}