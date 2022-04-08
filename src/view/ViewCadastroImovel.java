package view;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import controle.*;

/**
 * Tela para cadastro de imóvel, possui campos de inserção e seleção para criação dos objetos Casa e Apartamento
 * @author Rafael Nobre e Caio Berg
 */

public class ViewCadastroImovel implements ActionListener{
	
	private static String[] listaUF = {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG",
					 				   "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", 
					 				   "RS", "SC", "SE", "SP", "TO"};
		
	private JFrame janela = new JFrame("CadastroImovel");
	private JLabel titulo = new JLabel("Cadastrar Imoveis", SwingConstants.CENTER);
	
	private JLabel lbutton = new JLabel("Tipo de imovel");
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton casa = new JRadioButton("Casa");
	private JRadioButton ap = new JRadioButton("Apartamento");
	private JButton voltar = new JButton("Voltar");
	
	private SpinnerModel model0 = new SpinnerNumberModel(1, 1, 20, 1); 
	private SpinnerModel model1 = new SpinnerNumberModel(1, 1, 20, 1); 
	private SpinnerModel model2 = new SpinnerNumberModel(1, 1, 20, 1); 
	private SpinnerModel model3 = new SpinnerNumberModel(1, 1, 20, 1); 
	private SpinnerModel model4 = new SpinnerNumberModel(1, 1, 20, 1); 
	private SpinnerModel model5 = new SpinnerNumberModel(0, 0, 1000, 1); 
	// Form Geral
	private JLabel lTituloImovel = new JLabel("Titulo do Imovel");
	private JTextField tituloImovel = new JTextField();
	private JLabel lCep = new JLabel("CEP");
	private JFormattedTextField  cep = new JFormattedTextField (Validador.Mascara("#####-###"));
	private JLabel lCidade = new JLabel("Cidade");
	private JTextField cidade = new JTextField();
	private JLabel lUf = new JLabel("UF");
	private JComboBox<String> uf = new JComboBox<String>(listaUF);
	private JLabel LDono = new JLabel("Proprietario");
	private JComboBox<String> dono;
	private JLabel lBairro = new JLabel("Bairro");
	private JTextField bairro = new JTextField();
	private JLabel lLote = new JLabel("Lote");
	private JTextField lote = new JTextField();
	private JLabel lRua = new JLabel("Rua");
	private JTextField rua = new JTextField();
	private JLabel lComp = new JLabel("Complemento");
	private JTextField comp = new JTextField();
	private JLabel lNum = new JLabel("Numero");
	private JSpinner num = new JSpinner(model5);
	private JLabel lValor = new JLabel("Valor");
	private JFormattedTextField  valor = new JFormattedTextField (Validador.Mascara("####,##"));
	private JLabel lQtdQuartos = new JLabel("Quantidade de quartos");
	private JSpinner qtdQuartos = new JSpinner(model0);
	private JLabel lQtdCamas = new JLabel("Quantidade de camas");
	private JSpinner qtdCamas = new JSpinner(model1);
	private JLabel lQtdBanheiros = new JLabel("Quantidade de banheiros");
	private JSpinner qtdBanheiros = new JSpinner(model2);
	private JLabel lQtdHospedes = new JLabel("Quantidade de hospedes");
	private JSpinner qtdHospedes = new JSpinner(model3);
	private JLabel lQtdAndares = new JLabel("Quantidade de andares");
	private JSpinner qtdAndares = new JSpinner(model4);

	// Form Casa
	private JLabel lCategoria = new JLabel("Categoria da Casa");
	private JTextField categoria = new JTextField();
	private JLabel lWifi = new JLabel("A casa possui Wifi?");
	private ButtonGroup buttonGroup2 = new ButtonGroup();
	private JRadioButton simWifi = new JRadioButton("S");
	private JRadioButton naoWifi = new JRadioButton("N");
	private JLabel lPisc = new JLabel("A casa possui Piscina?");
	private ButtonGroup buttonGroup3 = new ButtonGroup();
	private JRadioButton simPisc = new JRadioButton("S");
	private JRadioButton naoPisc = new JRadioButton("N");
	
	
	// Form Ap
	private JLabel lElevador = new JLabel("O Apartamento possui elevador?");
	private ButtonGroup buttonGroup4 = new ButtonGroup();
	private JRadioButton simElevador = new JRadioButton("S");
	private JRadioButton naoElevador = new JRadioButton("N");
	private JLabel lSacada = new JLabel("O Apartamento possui Sacada?");
	private ButtonGroup buttonGroup5 = new ButtonGroup();
	private JRadioButton simSacada = new JRadioButton("S");
	private JRadioButton naoSacada = new JRadioButton("N");
	private JLabel lGaragem = new JLabel("O Apartamento possui Garagem?");
	private ButtonGroup buttonGroup6 = new ButtonGroup();
	private JRadioButton simGaragem = new JRadioButton("S");
	private JRadioButton naoGaragem = new JRadioButton("N");
	private JLabel lCond = new JLabel("O Apartamento possui Condominio?");
	private ButtonGroup buttonGroup7 = new ButtonGroup();
	private JRadioButton simCond = new JRadioButton("S");
	private JRadioButton naoCond = new JRadioButton("N");
	
	private JButton cadastrar = new JButton("Cadastrar");
	private ControleDados dados;
	
	/**
	 * Construtor da classe, cria toda a view
	 * @param d
	 * Controle de dados
	 */
	
	public ViewCadastroImovel(ControleDados d) {
		dados = d;
		
		
		dono = new JComboBox<String>(dados.listaUsuarios());
		
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
		
		LDono.setBounds(320,110,80,20);
		dono.setBounds(320, 130, 80, 20);
		dono.setSelectedIndex(-1);
		
		lBairro.setBounds(310, 150, 80, 20);
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
		janela.add(LDono);
		janela.add(dono);
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
	
	/**
	 * Controle da visibilidade dos campos específicos de Casa
	 * @param opcao
	 * true para tornar o form visível, e false para tornar o form invisível
	 */
	
	private void setVisibleFormCasa(boolean opcao) {
		if(opcao) {
			// Setando o Form Casas visible
			this.lCategoria.setVisible(true);
			this.categoria.setVisible(true);
			this.lWifi.setVisible(true);
			this.simWifi.setVisible(true);
			this.naoWifi.setVisible(true);
			this.lPisc.setVisible(true);
			this.simPisc.setVisible(true);
			this.naoPisc.setVisible(true);
		}else {
			// Setando o Form Casa invisivel
			this.lCategoria.setVisible(false);
			this.categoria.setVisible(false);
			this.lWifi.setVisible(false);
			this.simWifi.setVisible(false);
			this.naoWifi.setVisible(false);
			this.lPisc.setVisible(false);
			this.simPisc.setVisible(false);
			this.naoPisc.setVisible(false);
		}
	}
	
	/**
	 * Controle da visibilidade dos campos específicos de Apartamento
	 * @param opcao
	 * true para tornar o form visível, e false para tornar o form invisível
	 */
	
	private  void setVisibleFormAp(boolean opcao) {
		if(opcao) {
			// Setando o Form Ap visivel
			this.lElevador.setVisible(true);
			this.simElevador.setVisible(true);
			this.naoElevador.setVisible(true);
			this.lSacada.setVisible(true);
			this.simSacada.setVisible(true);
			this.naoSacada.setVisible(true);
			this.lGaragem.setVisible(true);
			this.simGaragem.setVisible(true);
			this.naoGaragem.setVisible(true);
			this.lCond.setVisible(true);
			this.simCond.setVisible(true);
			this.naoCond.setVisible(true);
		}else {
			// Setando o Form Ap invisivel
			this.lElevador.setVisible(false);
			this.simElevador.setVisible(false);
			this.naoElevador.setVisible(false);
			this.lSacada.setVisible(false);
			this.simSacada.setVisible(false);
			this.naoSacada.setVisible(false);
			this.lGaragem.setVisible(false);
			this.simGaragem.setVisible(false);
			this.naoGaragem.setVisible(false);
			this.lCond.setVisible(false);
			this.simCond.setVisible(false);
			this.naoCond.setVisible(false);
		}
	}
	
	/**
	 * Método para limpar todos os campos dos formulários, a fim de manter controle das informações
	 */
	
	private  void limparCampos() {
		this.buttonGroup.clearSelection();
		this.buttonGroup2.clearSelection();
		this.buttonGroup3.clearSelection();
		this.buttonGroup4.clearSelection();
		this.buttonGroup5.clearSelection();
		this.buttonGroup6.clearSelection();
		this.buttonGroup7.clearSelection();
		this.tituloImovel.setText("");
		this.cep.setValue(null);
		this.cidade.setText("");
		this.bairro.setText("");
		this.lote.setText("");
		this.rua.setText("");
		this.comp.setText("");
		this.valor.setValue(null);
		this.qtdQuartos.setValue(1);
		this.qtdCamas.setValue(1);
		this.qtdBanheiros.setValue(1);
		this.qtdHospedes.setValue(1);
		this.qtdAndares.setValue(1);
		this.num.setValue(0);
		this.categoria.setText("");
	}
	
	/**
	 * Método para controle dos enventos disparados dentro da janela
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == voltar) {
			// Mï¿½todo que limpar todos os campos ja preenchidos
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
					String[] endereco = {cep.getText(), cidade.getText(), uf.getSelectedItem().toString(), bairro.getText(),
							lote.getText(), rua.getText(), comp.getText(), num.getValue().toString()};
					boolean[] info = getInfoAp();
					int i = dono.getSelectedIndex();
					boolean inserir = dados.inserirEditarApartamento(dadosApartamento, endereco, info, i, 1, 0);
	
					limparCampos();
					janela.dispose();
					new ViewMenuListas(dados,1);
					// Enviando Mensagem de Sucesso
					if(inserir) {
						JOptionPane.showMessageDialog(null, "Apartamento cadastrado com Sucesso!!"
								, null, 
								JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Tivemos algum problema inesperado"
								, null, 
								JOptionPane.INFORMATION_MESSAGE);
					}
					
				}else if(casa.isSelected()) {
					String[] dadosCasa = {tituloImovel.getText(), valor.getText().replace(',', '.'), categoria.getText(), qtdQuartos.getValue().toString(),
							qtdCamas.getValue().toString(), qtdBanheiros.getValue().toString(), qtdAndares.getValue().toString(),
							qtdHospedes.getValue().toString()};
					String[] endereco = {cep.getText(), cidade.getText(), uf.getSelectedItem().toString(), bairro.getText(),
							lote.getText(), rua.getText(), comp.getText(), num.getValue().toString()};
					boolean[] info = getInfoCs();
					int i = dono.getSelectedIndex();
					boolean inserir = dados.inserirEditarCasa(dadosCasa, endereco, info, i, 1, -1);


					limparCampos();
					janela.dispose();
					new ViewMenuListas(dados,1);
					// Enviando Mensagem de Sucesso
					if(inserir) {
						JOptionPane.showMessageDialog(null, "Casa cadastrado com Sucesso!!"
								, null, 
								JOptionPane.INFORMATION_MESSAGE);
					}else {					
						JOptionPane.showMessageDialog(null, "Tivemos algum problema inesperado"
								, null, 
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		}
		
	}
	
	/**
	 * Método para controlar os campos, fazendo validações em cada campo, garantindo que ele não esteja em branco, ou não selecionado
	 * @return
	 * retorna uma lista de mensagens de erros, dos campos inválidos
	 */
	
	private ArrayList<String> verificarCampos() {
		ArrayList<String> erros = new ArrayList<String>();
		
		if(buttonGroup.getSelection() == null)
			erros.add("+ Tipo de imovel nao selecionado!");
		if(tituloImovel.getText().isEmpty())
			erros.add("+ Titulo do Imovel nao preenchido!");
		if(cep.getValue() == null)
			erros.add("+ Cep invalido");
		if(cidade.getText().isEmpty())
			erros.add("+ Cidade nao preenchida!");
		if(uf.getSelectedItem() == null)
			erros.add("+ UF nao selecionada!");
		if(bairro.getText().isEmpty())
			erros.add("+ Bairro nao preenchido!");
		if(rua.getText().isEmpty())
			erros.add("+ Rua nao preenchida!");
		if(lote.getText().isEmpty())
			erros.add("+ Lote nao preenchido!");
		if(comp.getText().isEmpty())
			erros.add("+ Complemento nao preenchido!");
		if(valor.getValue() == null)
			erros.add("+ Valor invalido");
		if(casa.isSelected()) {
			if(categoria.getText().isEmpty())
				erros.add("+ Categoria nao preenchida");
			if(buttonGroup2.getSelection() == null || buttonGroup3.getSelection() == null)
				erros.add("+ Preencha todos os campos de Sim ou Nao");
		}else {
			if(buttonGroup4.getSelection() == null || buttonGroup5.getSelection() == null
					|| buttonGroup6.getSelection() == null || buttonGroup7.getSelection() == null)
				erros.add("+ Preencha todos os campos de Sim ou Nao");
		}
		return erros;
	}
	
	/**
	 * Método para obter os textos dentro dos campos que são específicos do tipo Apartamento
	 * @return
	 * retorna uma lista de valores booleanos
	 */
	
	private boolean [] getInfoAp() {
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
	
	/**
	 * Método para obter os textos dentro dos campos que são específicos do tipo Casa
	 * @return
	 * retorna uma lista de valores booleanos
	 */
	
	private boolean [] getInfoCs() {
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

}