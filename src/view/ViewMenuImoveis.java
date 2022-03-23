package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import controle.*;

public class ViewMenuImoveis implements ActionListener{

	private static JFrame janela = new JFrame("Menu");
	private static JLabel titulo = new JLabel("Menu imóveis", SwingConstants.CENTER);
	private static JButton cadastrarCasa = new JButton("Cadastrar Casa");
	private static JButton cadastraApartamento = new JButton("Cadastrar Apartamento");
	private static JButton listarImoveis = new JButton("Listar Imóveis");
	private static JButton excluirCasa = new JButton("Excluir Casa");
	private static JButton excluirApartamento = new JButton("Excluir Apartamento");
	private static JButton voltar = new JButton("Voltar");
	
	public ViewMenuImoveis() {

		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(160, 10, 180, 30);
		cadastrarCasa.setBounds(160, 80, 180, 30);
		cadastraApartamento.setBounds(160, 120, 180, 30);
		listarImoveis.setBounds(160, 160, 180, 30);
		excluirCasa.setBounds(160, 200, 180, 30);
		excluirApartamento.setBounds(160, 240, 180, 30);
		voltar.setBounds(160, 280, 180, 30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(cadastrarCasa);
		janela.add(cadastraApartamento);
		janela.add(listarImoveis);
		janela.add(excluirCasa);
		janela.add(excluirApartamento);
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