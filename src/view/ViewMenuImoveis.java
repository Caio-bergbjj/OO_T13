package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import controle.*;

public class ViewMenuImoveis implements ActionListener{
	
	String[] listaTotalCasas;
	String[] listaTotalAps;
	ArrayList<String> listaAtual = new ArrayList<String>();
	
	private static JFrame janela = new JFrame("Im�veis");
	private static JLabel titulo = new JLabel("Im�veis", SwingConstants.CENTER);
	private static JLabel filtros = new JLabel("Filtros", SwingConstants.CENTER);
	private static JButton voltar = new JButton("Voltar");
	private  JList<String> listaImoveis = new JList<String>();
	private  JTextField buscaImovel = new JTextField();
	private static JLabel labelBusca = new JLabel("Digite aqui o t�tulo do im�vel");
	private  JButton btnBusca = new JButton("Buscar");
	private static JButton cadastrarNovo = new JButton("Cadastrar novo im�vel");
	
	private static ButtonGroup buttonGroup = new ButtonGroup();
	private static JRadioButton casa = new JRadioButton("Casas");
	private static JRadioButton ap = new JRadioButton("Apartamentos");
	private static ControleDados dados;
	
	public ViewMenuImoveis(ControleDados d) {
		dados = d;
		
		listaTotalCasas = dados.listaCasas();
		listaTotalAps = dados.listaAps();
		
		for(String nome : listaTotalCasas) {
			listaAtual.add(nome);
		}
		
		listaImoveis.setListData(listaTotalCasas);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 300, 300);
		scrollPane.setViewportView(listaImoveis);
		janela.add(scrollPane);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		filtros.setFont(new Font("Arial", Font.BOLD, 15));
		filtros.setBounds(300, 20, 180, 30);
		voltar.setBounds(10, 10, 100, 30);
		titulo.setBounds(160, 10, 180, 30);
		
		buttonGroup.add(casa);
		buttonGroup.add(ap);
		casa.setBounds(330, 50, 100, 20);
		casa.setSelected(true);
		ap.setBounds(330, 70, 120, 20);
		janela.add(casa);
		janela.add(ap);
		
		
		cadastrarNovo.setBounds(300, 475, 180, 30);
		labelBusca.setBounds(10, 360, 180, 20);
		buscaImovel.setBounds(10, 380, 210, 20);
		btnBusca.setBounds(230, 380, 80, 20);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(voltar);
		janela.add(cadastrarNovo);
		janela.add(labelBusca);
		janela.add(buscaImovel);
		janela.add(btnBusca);
		janela.add(filtros);
		
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
		
		casa.addActionListener(this);
		ap.addActionListener(this);
		
		btnBusca.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == casa) {
			listaImoveis.setListData(listaTotalCasas);
			listaImoveis.updateUI();
			listaAtual.clear();
			for(String nome : listaTotalCasas) {
				listaAtual.add(nome);
			}
			buscaImovel.setText("");
			
		}
		if(src == ap) {
			listaImoveis.setListData(listaTotalAps);
			listaImoveis.updateUI();
			listaAtual.clear();
			for(String nome : listaTotalAps) {
				listaAtual.add(nome);
			}
			buscaImovel.setText("");
		}
		if(src == voltar) {
			janela.dispose();
			new ViewMenu();		
		}
		if(src == cadastrarNovo) {
			janela.dispose();
			new ViewCadastroImovel(dados);
		}
		if(src == btnBusca) {
			if(buscaImovel.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Campo de busca em branco!!", null, 
						JOptionPane.ERROR_MESSAGE);
			}else {
				if(listaAtual.contains(buscaImovel.getText())) {
					String[] listaBusca = new String[1];
					listaBusca[0] = buscaImovel.getText();
					listaImoveis.setListData(listaBusca);
				}else {
					JOptionPane.showMessageDialog(null,"T�tulo n�o encontrado", null, 
							JOptionPane.WARNING_MESSAGE);
					buscaImovel.setText("");
				}	
			}
			
		}
		
	}
	
}