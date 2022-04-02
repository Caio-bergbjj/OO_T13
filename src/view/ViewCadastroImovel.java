package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.stream.IntStream;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import controle.*;

public class ViewCadastroImovel implements ActionListener, KeyListener{
	
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
	
	private static SpinnerModel model0 = new SpinnerNumberModel(1, 1, 20, 1); 
	private static SpinnerModel model1 = new SpinnerNumberModel(1, 1, 20, 1); 
	private static SpinnerModel model2 = new SpinnerNumberModel(1, 1, 20, 1); 
	private static SpinnerModel model3 = new SpinnerNumberModel(1, 1, 20, 1); 
	private static SpinnerModel model4 = new SpinnerNumberModel(1, 1, 20, 1); 
	private static SpinnerModel model5 = new SpinnerNumberModel(0, 0, 1000, 1); 
	// Form Geral
	private static JLabel lTituloImovel = new JLabel("Título do Imóvel");
	private static JTextField tituloImovel = new JTextField();
	private static JLabel lCep = new JLabel("CEP");
	private static JFormattedTextField  cep = new JFormattedTextField (Validador.Mascara("#####-###"));
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
	private static JLabel lNum = new JLabel("Número");
	private static JSpinner num = new JSpinner(model5);
	private static JLabel lValor = new JLabel("Valor");
	private static JFormattedTextField  valor = new JFormattedTextField (Validador.Mascara("####,##"));
	private static JLabel lQtdQuartos = new JLabel("Quantidade de quartos");
	private static JSpinner qtdQuartos = new JSpinner(model0);
	private static JLabel lQtdCamas = new JLabel("Quantidade de camas");
	private static JSpinner qtdCamas = new JSpinner(model1);
	private static JLabel lQtdBanheiros = new JLabel("Quantidade de banheiros");
	private static JSpinner qtdBanheiros = new JSpinner(model2);
	private static JLabel lQtdHospedes = new JLabel("Quantidade de hóspedes");
	private static JSpinner qtdHospedes = new JSpinner(model3);
	private static JLabel lQtdAndares = new JLabel("Quantidade de andares");
	private static JSpinner qtdAndares = new JSpinner(model4);
	
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
	
	
	// Form Ap
	private static JLabel lElevador = new JLabel("O Apartamento possui elevador?");
	private static ButtonGroup buttonGroup4 = new ButtonGroup();
	private static JRadioButton simElevador = new JRadioButton("S");
	private static JRadioButton naoElevador = new JRadioButton("N");
	private static JLabel lSacada = new JLabel("O Apartamento possui Sacada?");
	private static ButtonGroup buttonGroup5 = new ButtonGroup();
	private static JRadioButton simSacada = new JRadioButton("S");
	private static JRadioButton naoSacada = new JRadioButton("N");
	private static JLabel lGaragem = new JLabel("O Apartamento possui Garagem?");
	private static ButtonGroup buttonGroup6 = new ButtonGroup();
	private static JRadioButton simGaragem = new JRadioButton("S");
	private static JRadioButton naoGaragem = new JRadioButton("N");
	private static JLabel lCond = new JLabel("O Apartamento possui Condomínio?");
	private static ButtonGroup buttonGroup7 = new ButtonGroup();
	private static JRadioButton simCond = new JRadioButton("S");
	private static JRadioButton naoCond = new JRadioButton("N");
	
	private static JButton cadastrar = new JButton("Cadastrar");
	private static ControleDados dados;
	
	public ViewCadastroImovel(ControleDados d) {
		dados = d;
		
		
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
		
		lNum.setBounds(400, 190, 100, 20);
		num.setBounds(400, 210, 50, 20);
		num.setValue(0);
		JFormattedTextField numTf = ((JSpinner.DefaultEditor)num.getEditor()).getTextField();
		numTf.setEditable(false);
		
		lValor.setBounds(10, 230, 50, 20);
		valor.setBounds(10, 250, 100, 20);
		
		lQtdQuartos.setBounds(10, 280, 150, 20);
		qtdQuartos.setBounds(160, 280, 40, 20);
		JFormattedTextField quartosTf = ((JSpinner.DefaultEditor)qtdQuartos.getEditor()).getTextField();
		quartosTf.setEditable(false);
		
		lQtdCamas.setBounds(10, 310, 150, 20);
		qtdCamas.setBounds(160, 310, 40, 20);
		JFormattedTextField camastf = ((JSpinner.DefaultEditor)qtdCamas.getEditor()).getTextField();
		camastf.setEditable(false);
		
		lQtdBanheiros.setBounds(10, 340, 150, 20);
		qtdBanheiros.setBounds(160, 340, 40, 20);
		JFormattedTextField banheirosTf = ((JSpinner.DefaultEditor)qtdBanheiros.getEditor()).getTextField();
		banheirosTf.setEditable(false);
		
		lQtdHospedes.setBounds(210, 280, 150, 20);
		qtdHospedes.setBounds(360, 280, 40, 20);
		JFormattedTextField hospedesTf = ((JSpinner.DefaultEditor)qtdHospedes.getEditor()).getTextField();
		hospedesTf.setEditable(false);
		
		lQtdAndares.setBounds(210, 310, 150, 20);
		qtdAndares.setBounds(360, 310, 40, 20);
		JFormattedTextField andaresTf = ((JSpinner.DefaultEditor)qtdAndares.getEditor()).getTextField();
		andaresTf.setEditable(false);
		
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
		janela.add(lNum);
		janela.add(num);
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
		buttonGroup3.add(simPisc);
		buttonGroup3.add(naoPisc);
		lPisc.setBounds(10, 440, 150, 20);
		lPisc.setVisible(false);
		simPisc.setBounds(140, 440, 40, 20);
		simPisc.setVisible(false);
		naoPisc.setBounds(180, 440, 40, 20);
		naoPisc.setVisible(false);
		
		janela.add(lCategoria);
		janela.add(categoria);
		janela.add(lWifi);
		janela.add(simWifi);
		janela.add(naoWifi);
		janela.add(lPisc);
		janela.add(simPisc);
		janela.add(naoPisc);
		
		// Form Apartamento
		lElevador.setBounds(10, 370, 220, 20);
		lElevador.setVisible(false);
		buttonGroup4.add(simElevador);
		buttonGroup4.add(naoElevador);
		simElevador.setBounds(220, 370, 40, 20);
		simElevador.setVisible(false);
		naoElevador.setBounds(260, 370, 40, 20);
		naoElevador.setVisible(false);
		
		lSacada.setBounds(10, 390, 220, 20);
		lSacada.setVisible(false);
		buttonGroup5.add(simSacada);
		buttonGroup5.add(naoSacada);
		simSacada.setBounds(220, 390, 40, 20);
		simSacada.setVisible(false);
		naoSacada.setBounds(260, 390, 40, 20);
		naoSacada.setVisible(false);
		
		lGaragem.setBounds(10, 410, 220, 20);
		lGaragem.setVisible(false);
		buttonGroup6.add(simGaragem);
		buttonGroup6.add(naoGaragem);
		simGaragem.setBounds(220, 410, 40, 20);
		simGaragem.setVisible(false);
		naoGaragem.setBounds(260, 410, 40, 20);
		naoGaragem.setVisible(false);
		
		lCond.setBounds(10, 430, 220, 20);
		lCond.setVisible(false);
		buttonGroup7.add(simCond);
		buttonGroup7.add(naoCond);
		simCond.setBounds(220, 430, 40, 20);
		simCond.setVisible(false);
		naoCond.setBounds(260, 430, 40, 20);
		naoCond.setVisible(false);
		
		janela.add(lElevador);
		janela.add(simElevador);
		janela.add(naoElevador);
		janela.add(naoSacada);
		janela.add(lSacada);
		janela.add(simSacada);
		janela.add(naoSacada);
		janela.add(simGaragem);
		janela.add(lGaragem);
		janela.add(naoGaragem);
		janela.add(lCond);
		janela.add(simCond);
		janela.add(naoCond);
		
		cadastrar.setBounds(380, 475, 100, 30);
		janela.add(cadastrar);
		
		janela.setLayout(null);
	
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
		casa.addActionListener(this);
		ap.addActionListener(this);
		cadastrar.addActionListener(this);
		
		
	}
	
	private static void setVisibleFormCasa(boolean opcao) {
		if(opcao) {
			// Setando o Form Casas visible
			lCategoria.setVisible(true);
			categoria.setVisible(true);
			lWifi.setVisible(true);
			simWifi.setVisible(true);
			naoWifi.setVisible(true);
			lPisc.setVisible(true);
			simPisc.setVisible(true);
			naoPisc.setVisible(true);
		}else {
			// Setando o Form Casa invisivel
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
	
	private static void setVisibleFormAp(boolean opcao) {
		if(opcao) {
			// Setando o Form Ap visivel
			lElevador.setVisible(true);
			simElevador.setVisible(true);
			naoElevador.setVisible(true);
			lSacada.setVisible(true);
			simSacada.setVisible(true);
			naoSacada.setVisible(true);
			lGaragem.setVisible(true);
			simGaragem.setVisible(true);
			naoGaragem.setVisible(true);
			lCond.setVisible(true);
			simCond.setVisible(true);
			naoCond.setVisible(true);
		}else {
			// Setando o Form Ap invisivel
			lElevador.setVisible(false);
			simElevador.setVisible(false);
			naoElevador.setVisible(false);
			lSacada.setVisible(false);
			simSacada.setVisible(false);
			naoSacada.setVisible(false);
			lGaragem.setVisible(false);
			simGaragem.setVisible(false);
			naoGaragem.setVisible(false);
			lCond.setVisible(false);
			simCond.setVisible(false);
			naoCond.setVisible(false);
		}
	}
	
	private static void limparCampos() {
		buttonGroup.clearSelection();
		buttonGroup2.clearSelection();
		buttonGroup3.clearSelection();
		buttonGroup4.clearSelection();
		buttonGroup5.clearSelection();
		buttonGroup6.clearSelection();
		buttonGroup7.clearSelection();
		tituloImovel.setText("");
		cep.setValue(null);
		cidade.setText("");
		bairro.setText("");
		lote.setText("");
		rua.setText("");
		comp.setText("");
		valor.setValue(null);
		qtdQuartos.setValue(0);
		qtdCamas.setValue(0);
		qtdBanheiros.setValue(0);
		qtdHospedes.setValue(0);
		qtdAndares.setValue(0);
		num.setValue(0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == voltar) {
			// Método que limpar todos os campos ja preenchidos
			limparCampos();
			janela.dispose();
			new ViewMenuListas(dados,1);
			
		}
		if(src == casa) {
			// Controle de visibilidade dos formularios
			setVisibleFormCasa(true);
			setVisibleFormAp(false);
	
		}
		if(src == ap) {
			// Controle de visibilidade dos formularios
			setVisibleFormCasa(false);
			setVisibleFormAp(true);

		}
		if(src == cadastrar) {
			ArrayList<String> erros = verificarCampos();
			
			if(erros.size() > 0) {
				JOptionPane.showMessageDialog(null, String.join("\n", erros)
						, null, 
						JOptionPane.ERROR_MESSAGE);
			}else {
				if(ap.isSelected()) {
					String[] dadosApartamento = {tituloImovel.getText(), valor.getText().replace(',', '.'), qtdQuartos.getValue().toString(),
							qtdCamas.getValue().toString(), qtdBanheiros.getValue().toString(), qtdAndares.getValue().toString(),
							qtdHospedes.getValue().toString()};
					String[] endereco = {};
					boolean[] info = getInfoAp();
					dados.inserirApartamento(dadosApartamento, endereco, info);
					
					limparCampos();
					janela.dispose();
					new ViewMenuListas(dados,1);
					// Enviando Mensagem de Sucesso
					JOptionPane.showMessageDialog(null, "Apartamento cadastrado com Sucesso!!"
							, null, 
							JOptionPane.INFORMATION_MESSAGE);
				}else if(casa.isSelected()) {
					String[] dadosCasa = {tituloImovel.getText(), valor.getText().replace(',', '.'), categoria.getText(), qtdQuartos.getValue().toString(),
							qtdCamas.getValue().toString(), qtdBanheiros.getValue().toString(), qtdAndares.getValue().toString(),
							qtdHospedes.getValue().toString()};
					String[] endereco = {};
					boolean[] info = getInfoCs();
				    dados.inserirCasa(dadosCasa, endereco, info);

					limparCampos();
					janela.dispose();
					new ViewMenuListas(dados,1);
					// Enviando Mensagem de Sucesso
					JOptionPane.showMessageDialog(null, "Casa cadastrada com Sucesso!!"
							, null, 
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		}
		
	}

	private static ArrayList<String> verificarCampos() {
		ArrayList<String> erros = new ArrayList<String>();
		
		if(buttonGroup.getSelection() == null)
			erros.add("+ Tipo de imóvel não selecionado!");
		if(tituloImovel.getText().isEmpty())
			erros.add("+ Título do Imóvel não preenchido!");
		if(cep.getValue() == null)
			erros.add("+ Cep inválido");
		if(cidade.getText().isEmpty())
			erros.add("+ Cidade não preenchida!");
		if(uf.getSelectedItem() == null)
			erros.add("+ UF não selecionada!");
		if(bairro.getText().isEmpty())
			erros.add("+ Bairro não preenchido!");
		if(rua.getText().isEmpty())
			erros.add("+ Rua não preenchida!");
		if(lote.getText().isEmpty())
			erros.add("+ Lote não preenchido!");
		if(comp.getText().isEmpty())
			erros.add("+ Complemento não preenchido!");
		if(valor.getValue() == null)
			erros.add("+ Valor inválido");
		if(casa.isSelected()) {
			if(categoria.getText().isEmpty())
				erros.add("+ Categoria não preenchida");
			if(buttonGroup2.getSelection() == null || buttonGroup3.getSelection() == null)
				erros.add("+ Preencha todos os campos de Sim ou Não");
		}else {
			if(buttonGroup4.getSelection() == null || buttonGroup5.getSelection() == null
					|| buttonGroup6.getSelection() == null || buttonGroup7.getSelection() == null)
				erros.add("+ Preencha todos os campos de Sim ou Não");
		}
		return erros;
	}
	
	private static boolean [] getInfoAp() {
		boolean[] info = new boolean[4];
		
		//temElevador
		if(simElevador.isSelected())
			info[0] = true;
		else
			info[0] = false;
		
		// temSacada
		if(simSacada.isSelected())
			info[1] = true;
		else
			info[1] = false;
		
		// temGaragem
		if(simGaragem.isSelected())
			info[2] = true;
		else
			info[2] = false;
		
		// temCondominio
		
		if(simCond.isSelected())
			info[3] = true;
		else
			info[3] = false;
		
			
			
		
		return info;
	}
	
	private static boolean [] getInfoCs() {
		boolean[] info = new boolean[2];
		
		if(simWifi.isSelected())
			info[0] = true;
		else
			info[0] = false;
		
		if(simPisc.isSelected())
			info[1] = true;
		else
			info[1] = false;
		
		return info;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		Object src = e.getSource();
		if(src == num)
			JOptionPane.showMessageDialog(null, "Deubom"
					, null, 
					JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object src = e.getSource();
		if(src == num)
			JOptionPane.showMessageDialog(null, "Deubom"
					, null, 
					JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Object src = e.getSource();
		if(src == num)
			JOptionPane.showMessageDialog(null, "Deubom"
					, null, 
					JOptionPane.ERROR_MESSAGE);
		
	}
	
}