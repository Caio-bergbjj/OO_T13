package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.*;

public class ViewMenuUsuarios implements ActionListener{
	
	String[]listaTotalUsuarios;

	private static JFrame janela = new JFrame("Usuários");
	private static JLabel titulo = new JLabel("Usuários", SwingConstants.CENTER);
	private static JButton voltar = new JButton("Voltar");
	private  JList<String> listaUsuarios= new JList<String>();
	private  JTextField buscaUsuario = new JTextField();
	private static JLabel labelBusca = new JLabel("Digite aqui o nome do usuario");
	private  JButton btnBusca = new JButton("Buscar");
	private static JButton cadastrarNovo = new JButton("Cadastrar novo Usuário");
	private static ControleDados dados;
	
	public ViewMenuUsuarios(ControleDados d) {
		dados = d;
		
		listaTotalUsuarios = d.listaUsuarios();
		
		
		listaUsuarios.setListData(listaTotalUsuarios);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 300, 300);
		scrollPane.setViewportView(listaUsuarios);
		janela.add(scrollPane);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		voltar.setBounds(10, 10, 100, 30);
		titulo.setBounds(160, 10, 180, 30);
		
		cadastrarNovo.setBounds(300, 475, 180, 30);
		labelBusca.setBounds(10, 360, 180, 20);
		buscaUsuario.setBounds(10, 380, 210, 20);
		btnBusca.setBounds(230, 380, 80, 20);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(voltar);
		janela.add(cadastrarNovo);
		janela.add(labelBusca);
		janela.add(buscaUsuario);
		janela.add(btnBusca);
		
		// Criacao de variaveis para determinar o tamanho da janela
		int jframeW = 500;
		int jframeH= 550;
		janela.setSize(jframeW, jframeH);
		
		// Codigo para colocar a janela no meio da tela, essa variavel dim pega o tamanho do display
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int locationX = (dim.width - jframeW)/2;
		int locationY = (dim.height - jframeH)/2;
		janela.setLocation(locationX, locationY);

		
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		voltar.addActionListener(this);
		cadastrarNovo.addActionListener(this);
		btnBusca.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == voltar) {	
			janela.dispose();
			new ViewMenu();	
		}
		if(src == cadastrarNovo) {
			janela.dispose();
			new ViewCadastroUsuario(dados);
		}
		if(src == btnBusca) {
			if(buscaUsuario.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Campo de busca em branco!!", null, 
						JOptionPane.ERROR_MESSAGE);
			}else {
				boolean achei = false;
				for(String nome : listaTotalUsuarios){
					if(nome.equals(buscaUsuario.getText())) {
						String[] listaBusca = new String[1];
						listaBusca[0] = buscaUsuario.getText();
						listaUsuarios.setListData(listaBusca);
						achei = true;
						break;
					}
				}
				if(!achei) {
					JOptionPane.showMessageDialog(null,"Título não encontrado", null, 
							JOptionPane.WARNING_MESSAGE);
					buscaUsuario.setText("");
				}
			
			}
		}
		
	}
	
}