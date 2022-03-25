package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import controle.*;

public class ViewCadastroImovel implements ActionListener{
	
	private static String[] listaUF = {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG",
					 				   "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", 
					 				   "RS", "SC", "SE", "SP", "TO"};
		
	private static JFrame janela = new JFrame("CadastroImovel");
	private static JLabel titulo = new JLabel("Cadastrar Imóveis", SwingConstants.CENTER);
	
	private static JLabel lbutton = new JLabel("Tipo de imóvel");
	private static ButtonGroup buttonGroup = new ButtonGroup();
	private static JRadioButton casa = new JRadioButton("Casa");
	private static JRadioButton ap = new JRadioButton("Apartamento");
	private static JButton voltar = new JButton("Voltar");
	
	// Form Geral
	private static JLabel lTituloImovel = new JLabel("Título do Imóvel");
	private static JTextField tituloImovel = new JTextField();
	private static JLabel lCep = new JLabel("CEP");
	private static JTextField cep = new JTextField();
	private static JLabel lCidade = new JLabel("Cidade");
	private static JTextField cidade = new JTextField();
	private static JLabel lUf = new JLabel("UF");
	private static JComboBox uf = new JComboBox(listaUF);
	public ViewCadastroImovel() {
		
		// Titulo da janela e voltar
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(160, 10, 180, 30);
		voltar.setBounds(10, 10, 100, 30);
		janela.add(titulo);
		janela.add(voltar);
		
		// Botoes de selecao de imovel
		lbutton.setBounds(10, 60, 100, 20);
		buttonGroup.add(casa);
		buttonGroup.add(ap);	
		casa.setBounds(10, 80, 60, 20);
		ap.setBounds(80, 80, 100, 20);
		janela.add(lbutton);
		janela.add(casa);
		janela.add(ap);
		
		
		// Form Geral
		lTituloImovel.setBounds(10, 110, 100, 20);
		tituloImovel.setBounds(10, 130, 300, 20);
		
		lCep.setBounds(10, 150, 100, 20);
		cep.setBounds(10, 170, 100, 20);
		
		lCidade.setBounds(120, 150, 100, 20);
		cidade.setBounds(120, 170, 120, 20);
		
		lUf.setBounds(250, 150, 50, 20);
		uf.setBounds(250, 170, 50, 20);
		
		janela.add(lTituloImovel);
		janela.add(tituloImovel);
		janela.add(lCep);
		janela.add(cep);
		janela.add(lCidade);
		janela.add(cidade);
		janela.add(lUf);
		janela.add(uf);
		
		janela.setLayout(null);
	
		// Criacao de variaveis para determinar o tamanho da janela
		int jframeW = 500;
		int jframeH= 500;
		janela.setSize(jframeW, jframeH);
		
		// Codigo para colocar a janela no meio da tela, essa variavel dim pega o tamanho do display
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int locationX = (dim.width - jframeW)/2;
		int locationY = (dim.height - jframeH)/2;
		janela.setLocation(locationX, locationY);
		
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		voltar.addActionListener(this);
		casa.addActionListener(this);
		ap.addActionListener(this);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == voltar) {
			janela.dispose();
			new ViewMenuImoveis();
			
		}
		if(src == casa) {
			
		}
		
		
	}
	
}