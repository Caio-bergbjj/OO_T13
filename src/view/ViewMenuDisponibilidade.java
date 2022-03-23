package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import controle.*;

public class ViewMenuUsuarios implements ActionListener{

	private static JFrame janela = new JFrame("Menu");
	private static JLabel titulo = new JLabel("Menu imóveis", SwingConstants.CENTER);
	private static JButton cadastrarUsuario = new JButton("Cadastrar Usuário");
	private static JButton excluirUsuario = new JButton("Excluir Usuário");
	private static JButton listarUsuarios = new JButton("Listar Usuários");
	private static JButton voltar = new JButton("Voltar");
	
	public ViewMenuUsuarios() {

		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(160, 10, 180, 30);
		cadastrarUsuario.setBounds(160, 80, 180, 30);
		excluirUsuario.setBounds(160, 120, 180, 30);
		listarUsuarios.setBounds(160, 160, 180, 30);
		voltar.setBounds(160, 280, 180, 30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(cadastrarUsuario);
		janela.add(excluirUsuario);
		janela.add(listarUsuarios);
		janela.add(voltar);
		
		janela.setSize(500, 400);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		voltar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == voltar) {	
			janela.dispose();
			new ViewMenu();	
		}
		
	}
	
}
