package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import controle.*;

public class ViewMenu implements ActionListener{

	private static JFrame janela = new JFrame("Menu");
	private static JLabel titulo = new JLabel("Menu Principal", SwingConstants.CENTER);
	private static JButton btnImoveis = new JButton("Gerenciar Imoveis");
	private static JButton btnDisponibilidade = new JButton("Verificar Disponibilidade");
	private static JButton btnUsuarios = new JButton("Gerenciar Usuários");
	
	public ViewMenu() {

		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(160, 10, 180, 30);
		btnImoveis.setBounds(160, 80, 180, 30);
		btnDisponibilidade.setBounds(160, 120, 180, 30);
		btnUsuarios.setBounds(160, 160, 180, 30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(btnImoveis);
		janela.add(btnDisponibilidade);
		janela.add(btnUsuarios);
		
		janela.setSize(500, 400);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		btnImoveis.addActionListener(this);
		btnUsuarios.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new ViewMenu();
			
	}
	
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