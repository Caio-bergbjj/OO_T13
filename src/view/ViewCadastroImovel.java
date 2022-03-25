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
	private static JComboBox<String> uf = new JComboBox<String>(listaUF);
	private static JLabel lBairro = new JLabel("Bairro");
	private static JTextField bairro = new JTextField();
	private static JLabel lLote = new JLabel("Rua");
	private static JTextField lote = new JTextField();
	private static JLabel lRua = new JLabel("Lote");
	private static JTextField rua = new JTextField();
	private static JLabel lComp = new JLabel("Complemento");
	private static JTextField comp = new JTextField();
	private static JLabel lValor = new JLabel("Valor");
	private static JTextField valor = new JTextField();
	private static JLabel lQtdQuartos = new JLabel("Quantidade de quartos");
	private static JTextField qtdQuartos = new JTextField();
	private static JLabel lQtdCamas = new JLabel("Quantidade de camas");
	private static JTextField qtdCamas = new JTextField();
	private static JLabel lQtdBanheiros = new JLabel("Quantidade de banheiros");
	private static JTextField qtdBanheiros = new JTextField();
	private static JLabel lQtdHospedes = new JLabel("Quantidade de hóspedes");
	private static JTextField qtdHospedes = new JTextField();
	private static JLabel lQtdAndares = new JLabel("Quantidade de andares");
	private static JTextField qtdAndares = new JTextField();
	
	// Form Casa
	private static JLabel lCategoria = new JLabel("Categoria da Casa");
	private static JTextField categoria = new JTextField();
	private static JLabel lWifi = new JLabel("A casa possui Wifi?");
	private static ButtonGroup buttonGroup2 = new ButtonGroup();
	private static JRadioButton simWifi = new JRadioButton("S");
	private static JRadioButton naoWifi = new JRadioButton("N");
	private static JLabel lPisc = new JLabel("A casa possui Piscina?");
	private static ButtonGroup buttonGroup3 = new ButtonGroup();
	private static JRadioButton simPisc = new JRadioButton("S");
	private static JRadioButton naoPisc = new JRadioButton("N");
	
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
		uf.setSelectedIndex(-1);
		
		lBairro.setBounds(310	, 150, 80, 20);
		bairro.setBounds(310, 170, 100, 20);
		
		lLote.setBounds(10, 190, 100, 20);
		lote.setBounds(10, 210, 80, 20);
		
		lRua.setBounds(100, 190, 50, 20);
		rua.setBounds(100, 210, 50, 20);
		
		lComp.setBounds(160, 190, 100, 20);
		comp.setBounds(160, 210, 230, 20);
		
		lValor.setBounds(10, 230, 50, 20);
		valor.setBounds(10, 250, 100, 20);
		
		lQtdQuartos.setBounds(10, 280, 150, 20);
		qtdQuartos.setBounds(160, 280, 30, 20);
		
		lQtdCamas.setBounds(10, 310, 150, 20);
		qtdCamas.setBounds(160, 310, 30, 20);
		
		lQtdBanheiros.setBounds(10, 340, 150, 20);
		qtdBanheiros.setBounds(160, 340, 30, 20);
		
		lQtdHospedes.setBounds(200, 280, 150, 20);
		qtdHospedes.setBounds(350, 280, 30, 20);
		
		lQtdAndares.setBounds(200, 310, 150, 20);
		qtdAndares.setBounds(350, 310, 30, 20);
		
		janela.add(lTituloImovel);
		janela.add(tituloImovel);
		janela.add(lCep);
		janela.add(cep);
		janela.add(lCidade);
		janela.add(cidade);
		janela.add(lUf);
		janela.add(uf);
		janela.add(lBairro);
		janela.add(bairro);
		janela.add(lLote);
		janela.add(lote);
		janela.add(lRua);
		janela.add(rua);
		janela.add(lComp);
		janela.add(comp);
		janela.add(lValor);
		janela.add(valor);
		janela.add(lQtdQuartos);
		janela.add(qtdQuartos);
		janela.add(lQtdCamas);
		janela.add(qtdCamas);
		janela.add(lQtdBanheiros);
		janela.add(qtdBanheiros);
		janela.add(lQtdHospedes);
		janela.add(qtdHospedes);
		janela.add(lQtdAndares);
		janela.add(qtdAndares);
		
		// Form Casa
		lCategoria.setBounds(10, 370, 120, 20);
		lCategoria.setVisible(false);
		categoria.setBounds(10, 390, 120, 20);
		categoria.setVisible(false);
		buttonGroup2.add(simWifi);
		buttonGroup2.add(naoWifi);
		lWifi.setBounds(10, 420, 130, 20);
		lWifi.setVisible(false);
		simWifi.setBounds(120, 420, 40, 20);
		simWifi.setVisible(false);
		naoWifi.setBounds(160, 420, 40, 20);
		naoWifi.setVisible(false);
		lPisc.setBounds(10, 450, 130, 20);
		lPisc.setVisible(false);
		simPisc.setBounds(140, 450, 40, 20);
		simPisc.setVisible(false);
		naoPisc.setBounds(180, 450, 40, 20);
		naoPisc.setVisible(false);
		
		janela.add(lCategoria);
		janela.add(categoria);
		janela.add(lWifi);
		janela.add(simWifi);
		janela.add(naoWifi);
		janela.add(lPisc);
		janela.add(simPisc);
		janela.add(naoPisc);
		
		janela.setLayout(null);
	
		// Criacao de variaveis para determinar o tamanho da janela
		int jframeW = 500;
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
		casa.addActionListener(this);
		ap.addActionListener(this);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == voltar) {
			casa.setSelected(false);
			ap.setSelected(false);
			janela.dispose();
			new ViewMenuImoveis();
			
		}
		if(src == casa) {
			lCategoria.setVisible(true);
			categoria.setVisible(true);
			lWifi.setVisible(true);
			simWifi.setVisible(true);
			naoWifi.setVisible(true);
			lPisc.setVisible(true);
			simPisc.setVisible(true);
			naoPisc.setVisible(true);
		}
		if(src == ap) {
			lCategoria.setVisible(false);
			categoria.setVisible(false);
			lWifi.setVisible(false);
			simWifi.setVisible(false);
			naoWifi.setVisible(false);
			lPisc.setVisible(false);
			simPisc.setVisible(false);
			naoPisc.setVisible(false);
		}
		
		
	}
	
}