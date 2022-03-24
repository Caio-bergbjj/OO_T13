package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import controle.*;

public class ViewMenu implements ActionListener{

	private static JFrame janela = new JFrame("Menu");
	private static JLabel titulo = new JLabel("Menu Principal", SwingConstants.CENTER);
	private static JButton btnImoveis = new JButton("Gerenciar Imoveis");
	private static JButton btnUsuarios = new JButton("Gerenciar Usuários");
	
	
	
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
		
		btnImoveis.addActionListener(this);
		btnUsuarios.addActionListener(this);
	}
	
//	public static void main(String[] args) {
//		new ViewMenu();
//			
//	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == btnImoveis) {
			janela.dispose();
			new ViewMenuImoveis();
			
		}
		if(src == btnUsuarios) {
			janela.dispose();
			new ViewMenuUsuarios();
			
		}
		
		
	}
	
}