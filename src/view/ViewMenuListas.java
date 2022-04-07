package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.*;

/**
 * Classe para Tela principal de cada objeto, Usuários e Imóveis
 * @author Rafael Nobre e Caio Berg
 *
 */

public class ViewMenuListas implements ActionListener, ListSelectionListener{
	
	String[] listaTotalCasas;
	String[] listaTotalAps;
	String[]listaTotalUsuarios;
	ArrayList<String> listaAtual = new ArrayList<String>();
	
	private static JFrame janela;
	private static JLabel titulo;
	private static JLabel filtros = new JLabel("Filtros", SwingConstants.CENTER); //Imovel 
	private static JButton voltar = new JButton("Voltar");
	private  JList<String> listaImoveis = new JList<String>();
	private  JList<String> listaUsuarios= new JList<String>();
	private  JTextField buscaNome = new JTextField();
	private static JLabel labelBusca;
	private  JButton btnBusca = new JButton("Buscar");
	private static JButton cadastrarNovo;
	private static JButton reservar = new JButton("Reservar");
	private static ButtonGroup buttonGroup = new ButtonGroup();
	private static JRadioButton casa = new JRadioButton("Casas");
	private static JRadioButton ap = new JRadioButton("Apartamentos");
	private static ControleDados dados;
	private String s;
	private int opcao;
	
	/**
	 * Construtor da Tela
	 * @param d
	 * Controle de dados
	 * @param op
	 * opção do tipo de objeto
	 * 1 - Casa
	 * 2 - Apartamento
	 * 3 - Pessoa
	 */
	
	public ViewMenuListas(ControleDados d, int op) {
		
		opcao = op;
		dados = d;
		
		if(op == 1) { 
			s = "Imovel";
			listaTotalCasas = dados.listaCasas();
			listaTotalAps = dados.listaAps();
			for(String nome : listaTotalCasas) {
				listaAtual.add(nome);
			}
			listaImoveis.setListData(listaTotalCasas);
			listaImoveis.addListSelectionListener(this);
		}
		if(op == 2) {
			s = "Usuario";
			listaTotalUsuarios = dados.listaUsuarios();
			listaUsuarios.setListData(listaTotalUsuarios);
			listaUsuarios.addListSelectionListener(this);
			
		}
		
		janela = new JFrame(s);
		titulo = new JLabel(s, SwingConstants.CENTER);
		labelBusca = new JLabel("Digite aqui o nome do " + s);
		cadastrarNovo = new JButton("Cadastrar novo " + s);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 300, 300);
		
		if(op == 1) {
			scrollPane.setViewportView(listaImoveis);
			casa.addActionListener(this);
			ap.addActionListener(this);
			janela.add(casa);
			janela.add(ap);
			janela.add(filtros);
			janela.add(reservar);
			
		}	
		if(op == 2) {
			scrollPane.setViewportView(listaUsuarios);
		}
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		filtros.setFont(new Font("Arial", Font.BOLD, 15));
		filtros.setBounds(300, 20, 180, 30);
		voltar.setBounds(10, 10, 100, 30);
		titulo.setBounds(160, 10, 180, 30);
		casa.setBounds(330, 50, 100, 20);
		casa.setSelected(true);
		ap.setBounds(330, 70, 120, 20);
		cadastrarNovo.setBounds(300, 475, 180, 30);
		reservar.setBounds(120, 475, 100, 30);
		labelBusca.setBounds(10, 360, 180, 20);
		buscaNome.setBounds(10, 380, 210, 20);
		btnBusca.setBounds(230, 380, 80, 20);
		janela.setLayout(null);
	
		janela.add(scrollPane);
		buttonGroup.add(casa);
		buttonGroup.add(ap);
		janela.add(titulo);
		janela.add(voltar);
		janela.add(cadastrarNovo);
		janela.add(labelBusca);
		janela.add(buscaNome);
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
		reservar.addActionListener(this);
	}
	
	/**
	 * Método para controle de eventos dentro da janela
	 */
	
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
			buscaNome.setText("");
			
		}
		if(src == ap) {
			listaImoveis.setListData(listaTotalAps);
			listaImoveis.updateUI();
			listaAtual.clear();
			for(String nome : listaTotalAps) {
				listaAtual.add(nome);
			}
			buscaNome.setText("");
		}
		if(src == voltar) {
			janela.dispose();
			new ViewMenu();		
		}
		if(src == cadastrarNovo) {
			janela.dispose();
			if(opcao == 1) new ViewCadastroImovel(dados);
			if(opcao == 2) new ViewCadastroUsuario(dados);
		}
		if(src == btnBusca) {
			if(buscaNome.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Campo de busca em branco!!", null, 
						JOptionPane.ERROR_MESSAGE);
			}else {
				switch(opcao) {
				case 1:
					if(listaAtual.contains(buscaNome.getText())) {
						String[] listaBusca = new String[1];
						listaBusca[0] = buscaNome.getText();
						listaImoveis.setListData(listaBusca);
					}else {
						JOptionPane.showMessageDialog(null,"Título não encontrado", null, 
								JOptionPane.WARNING_MESSAGE);
						buscaNome.setText("");
					}
					break;
				
				case 2:
					boolean achei = false;
					for(String nome : listaTotalUsuarios){
						if(nome.equals(buscaNome.getText())) {
							String[] listaBusca = new String[1];
							listaBusca[0] = buscaNome.getText();
							listaUsuarios.setListData(listaBusca);
							achei = true;
							break;
						}
					}
					if(!achei) {
						JOptionPane.showMessageDialog(null,"Título não encontrado", null, 
								JOptionPane.WARNING_MESSAGE);
						buscaNome.setText("");
					}
				}
			}
			
		}
		
		if(src == reservar) {
			janela.dispose();
			new ViewReservar(dados);
		}
		
	}
	
	/**
	 * Método para controle de selação do JList dentro da Janela
	 */
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		String nomeBusca = null;
		int posicaoBusca;
		// Casa
		if(e.getValueIsAdjusting() && casa.isSelected() && src == listaImoveis
				&& listaImoveis.getSelectedIndex() != -1) {
			
			
			if(listaImoveis.getModel().getSize() < dados.listaCasas().length) {
				nomeBusca = listaImoveis.getSelectedValue();
				posicaoBusca = dados.getCasaPos(nomeBusca);
				if(posicaoBusca >= 0) {
					janela.dispose();
					new ViewDetalhe(1, dados, posicaoBusca);
				}else {
					JOptionPane.showMessageDialog(null, "Casa não encontrada"
							, null, 
							JOptionPane.INFORMATION_MESSAGE);
				}
			}else {
				janela.dispose();
				new ViewDetalhe(1, dados, listaImoveis.getSelectedIndex());
					
			}
				
			
		}
		// Apartamento
		if(e.getValueIsAdjusting() && ap.isSelected() && src == listaImoveis
				&& listaImoveis.getSelectedIndex() != -1) {
			
			if(listaImoveis.getModel().getSize() < dados.listaAps().length) {
				nomeBusca = listaImoveis.getSelectedValue();
				posicaoBusca = dados.getApPos(nomeBusca);
				if(posicaoBusca >= 0) {
					janela.dispose();
					new ViewDetalhe(2, dados, posicaoBusca);
				}else {
					JOptionPane.showMessageDialog(null, "Apartamento não encontrado"
							, null, 
							JOptionPane.INFORMATION_MESSAGE);
				}
			}else {
				janela.dispose();
				new ViewDetalhe(2, dados, listaImoveis.getSelectedIndex());
					
			}
			
		}
		// Pessoa
		if(e.getValueIsAdjusting() && src == listaUsuarios) {
			
			if(listaUsuarios.getModel().getSize() < dados.listaUsuarios().length) {
				nomeBusca = listaUsuarios.getSelectedValue();
				posicaoBusca = dados.getPessoaPos(nomeBusca);
				janela.dispose();
				new ViewDetalhe(3, dados, posicaoBusca);
			}else {
				janela.dispose();
				new ViewDetalhe(3, dados, listaUsuarios.getSelectedIndex());
					
			}
			
		}
	}	
}