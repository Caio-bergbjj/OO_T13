package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import controle.*;
import modelo.Imovel;

public class ViewMenuUsuarios implements ActionListener{

	private DadosCasa dadosCasa;
	private DadosApartamento dadosApartamento;
	private DadosPessoa dadosPessoa;
	private DadosReserva dadosReserva;
	
	private static JFrame janela = new JFrame("Usu�rios");
	private static JLabel titulo = new JLabel("Usu�rios", SwingConstants.CENTER);

	private static JButton voltar = new JButton("Voltar");
	private  JList<String> listaUsuarios= new JList<String>();
	private  JTextField buscaUsuario = new JTextField();
	private static JLabel labelBusca = new JLabel("Digite aqui o nome do usuario");
	private  JButton btnBusca = new JButton("Buscar");
	private static JButton cadastrarNovo = new JButton("Cadastrar novo Usu�rio");
	
	public ViewMenuUsuarios(ControleDados dados) {
		
		
		this.dadosCasa = dadosCasa;
		this.dadosApartamento = dadosApartamento;
		this.dadosPessoa = dadosPessoa;
		this.dadosReserva = dadosReserva;

		
//		listaUsuarios.setListData();
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
			new ViewMenu(dadosCasa, dadosApartamento, dadosPessoa, dadosReserva);	
		}
		if(src == cadastrarNovo) {
			janela.dispose();
			new ViewCadastroUsuario(dadosCasa, dadosApartamento, dadosPessoa, dadosReserva);
		}
		
	}
	
}