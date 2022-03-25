package view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import controle.*;
import modelo.Casa;
import modelo.Imovel;

public class ViewMenuImoveis implements ActionListener{
	
	private static DadosCasa dadosCasa;
	
	private static JFrame janela = new JFrame("Imóveis");
	private static JLabel titulo = new JLabel("Imóveis", SwingConstants.CENTER);
	private static JButton voltar = new JButton("Voltar");
	private static JList<Imovel> listaImoveis = new JList<Imovel>();
	private static JTextField buscaImovel = new JTextField();
	private static JLabel labelBusca = new JLabel("Digite aqui o nome o imóvel");
	private static JButton btnBusca = new JButton("Buscar");
	private static JButton cadastrarNovo = new JButton("Cadastrar novo imóvel");
	
	
	
	public ViewMenuImoveis() {
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		voltar.setBounds(10, 10, 100, 30);
		titulo.setBounds(210, 10, 180, 30);
		listaImoveis.setBounds(10, 50, 450, 300);
		cadastrarNovo.setBounds(400, 525, 180, 30);
		labelBusca.setBounds(10, 360, 180, 20);
		buscaImovel.setBounds(10, 380, 350, 20);
		btnBusca.setBounds(370, 380, 90, 20);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(voltar);
		janela.add(listaImoveis);
		janela.add(cadastrarNovo);
		janela.add(labelBusca);
		janela.add(buscaImovel);
		janela.add(btnBusca);
		
		// Criacao de variaveis para determinar o tamanho da janela
		int jframeW = 600;
		int jframeH= 600;
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
			new ViewCadastroImovel();
		}
		
	}
	
}