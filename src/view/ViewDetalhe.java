package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import controle.ControleDados;
import controle.Validador;

public class ViewDetalhe implements ActionListener{
	
	private static String[] listaUF = {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG",
			   "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", 
			   "RS", "SC", "SE", "SP", "TO"};
	
	private JFrame janela = new JFrame("Detalhe Imovel");
	private JLabel titulo;
	
	private JButton voltar = new JButton("Voltar");
	
	private SpinnerModel model0 = new SpinnerNumberModel(1, 1, 20, 1); 
	private SpinnerModel model1 = new SpinnerNumberModel(1, 1, 20, 1); 
	private SpinnerModel model2 = new SpinnerNumberModel(1, 1, 20, 1); 
	private SpinnerModel model3 = new SpinnerNumberModel(1, 1, 20, 1); 
	private SpinnerModel model4 = new SpinnerNumberModel(1, 1, 20, 1); 
	private SpinnerModel model5 = new SpinnerNumberModel(0, 0, 1000, 1); 
	// Form 
	private JLabel lTituloImovel = new JLabel("Título do Imóvel");
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
	private JLabel lLote = new JLabel("Rua");
	private JTextField lote = new JTextField();
	private JLabel lRua = new JLabel("Lote");
	private JTextField rua = new JTextField();
	private JLabel lComp = new JLabel("Complemento");
	private JTextField comp = new JTextField();
	private JLabel lNum = new JLabel("Número");
	private JSpinner num = new JSpinner(model5);
	private JLabel lValor = new JLabel("Valor");
	private JFormattedTextField  valor = new JFormattedTextField (Validador.Mascara("####,##"));
	private JLabel lQtdQuartos = new JLabel("Quantidade de quartos");
	private JSpinner qtdQuartos = new JSpinner(model0);
	private JLabel lQtdCamas = new JLabel("Quantidade de camas");
	private JSpinner qtdCamas = new JSpinner(model1);
	private JLabel lQtdBanheiros = new JLabel("Quantidade de banheiros");
	private JSpinner qtdBanheiros = new JSpinner(model2);
	private JLabel lQtdHospedes = new JLabel("Quantidade de hóspedes");
	private JSpinner qtdHospedes = new JSpinner(model3);
	private JLabel lQtdAndares = new JLabel("Quantidade de andares");
	private JSpinner qtdAndares = new JSpinner(model4);
	
	// Form  Casa
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
	private JLabel lCond = new JLabel("O Apartamento possui Condomínio?");
	private ButtonGroup buttonGroup7 = new ButtonGroup();
	private JRadioButton simCond = new JRadioButton("S");
	private JRadioButton naoCond = new JRadioButton("N");
	
	// Form Usuario
	private static JLabel lNomeUsuario = new JLabel("Nome do Usuario");
	private static JTextField nomeUsuario = new JTextField();
	private static JLabel lCpf = new JLabel("CPF");
	private static JFormattedTextField  cpf = new JFormattedTextField (Validador.Mascara("###.###.###-##"));
	private static JLabel lEmail = new JLabel("Email");
	private static JTextField email = new JTextField();
	private static JFormattedTextField  telefone = new JFormattedTextField (Validador.Mascara("(##) # ####-####"));
	private static JLabel lTelefone = new JLabel("Telefone");
	
	private JButton atualizar = new JButton("Atualizar");
	private ControleDados dados;
	private int opcao;
	private int posi;
	
	public ViewDetalhe(int op, ControleDados d, int index) {
		dados = d;
		opcao = op;
		posi = index;
		
		// Detalhe de Casa
		if(op == 1) {
			titulo  = new JLabel(dados.getCasas().get(index).getTitulo(), SwingConstants.CENTER);
		}
		// Detalhe de Apartamento
		else if(op == 2) {
			titulo  = new JLabel(dados.getApartamentos().get(index).getTitulo(), SwingConstants.CENTER);
		}
		// Detalhe de Usuario
		else if(op == 3) {
			titulo  = new JLabel(dados.getPessoas().get(index).getNome(), SwingConstants.CENTER);
		}
		
		dono = new JComboBox<String>(dados.listaUsuarios());
		
		// Titulo da janela e voltar
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(160, 10, 180, 30);
		voltar.setBounds(10, 10, 100, 30);
		janela.add(titulo);
		janela.add(voltar);
		
		if (op == 1 || op == 2) {
			lTituloImovel.setBounds(10, 60, 100, 20);
			tituloImovel.setBounds(10, 80, 300, 20);
			lCep.setBounds(10, 100, 100, 20);
			cep.setBounds(10, 120, 100, 20);
			
			lCidade.setBounds(120, 100, 100, 20);
			cidade.setBounds(120, 120, 120, 20);
			
			lUf.setBounds(250, 100, 50, 20);
			uf.setBounds(250, 120, 50, 20);
			uf.setSelectedIndex(-1);
			
			LDono.setBounds(320,60,80,20);
			dono.setBounds(320, 80, 80, 20);
			dono.setSelectedIndex(-1);
			
			lBairro.setBounds(310, 100, 80, 20);
			bairro.setBounds(310, 120, 100, 20);
			
			lLote.setBounds(10, 140, 100, 20);
			lote.setBounds(10, 160, 80, 20);
			
			lRua.setBounds(100, 140, 50, 20);
			rua.setBounds(100, 160, 50, 20);
			
			lComp.setBounds(160, 140, 100, 20);
			comp.setBounds(160, 160, 230, 20);
			
			lNum.setBounds(400, 140, 100, 20);
			num.setBounds(400, 160, 50, 20);
			num.setValue(0);
			JFormattedTextField numTf = ((JSpinner.DefaultEditor)num.getEditor()).getTextField();
			numTf.setEditable(false);
			
			lValor.setBounds(10, 180, 50, 20);
			valor.setBounds(10, 200, 100, 20);
			
			lQtdQuartos.setBounds(10, 230, 150, 20);
			qtdQuartos.setBounds(160, 230, 40, 20);
			JFormattedTextField quartosTf = ((JSpinner.DefaultEditor)qtdQuartos.getEditor()).getTextField();
			quartosTf.setEditable(false);
			
			lQtdCamas.setBounds(10, 260, 150, 20);
			qtdCamas.setBounds(160, 260, 40, 20);
			JFormattedTextField camastf = ((JSpinner.DefaultEditor)qtdCamas.getEditor()).getTextField();
			camastf.setEditable(false);
			
			lQtdBanheiros.setBounds(10, 290, 150, 20);
			qtdBanheiros.setBounds(160, 290, 40, 20);
			JFormattedTextField banheirosTf = ((JSpinner.DefaultEditor)qtdBanheiros.getEditor()).getTextField();
			banheirosTf.setEditable(false);
			
			lQtdHospedes.setBounds(210, 230, 150, 20);
			qtdHospedes.setBounds(360, 230, 40, 20);
			JFormattedTextField hospedesTf = ((JSpinner.DefaultEditor)qtdHospedes.getEditor()).getTextField();
			hospedesTf.setEditable(false);
			
			lQtdAndares.setBounds(210, 260, 150, 20);
			qtdAndares.setBounds(360, 260, 40, 20);
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
		}
			
		
		// Form Casa
		if(op == 1)	{
			lCategoria.setBounds(10, 320, 120, 20);
			categoria.setBounds(10, 340, 120, 20);
			buttonGroup2.add(simWifi);
			buttonGroup2.add(naoWifi);
			lWifi.setBounds(10, 370, 130, 20);
			simWifi.setBounds(120, 370, 40, 20);
			naoWifi.setBounds(160, 370, 40, 20);
			buttonGroup3.add(simPisc);
			buttonGroup3.add(naoPisc);
			lPisc.setBounds(10, 390, 150, 20);
			simPisc.setBounds(140, 390, 40, 20);
			naoPisc.setBounds(180, 390, 40, 20);
			
			janela.add(lCategoria);
			janela.add(categoria);
			janela.add(lWifi);
			janela.add(simWifi);
			janela.add(naoWifi);
			janela.add(lPisc);
			janela.add(simPisc);
			janela.add(naoPisc);
			
			this.preencher(1);
		}
			
		
		// Form Apartamento
		if(op == 2) {
			lElevador.setBounds(10, 320, 220, 20);
			buttonGroup4.add(simElevador);
			buttonGroup4.add(naoElevador);
			simElevador.setBounds(220, 320, 40, 20);
			naoElevador.setBounds(260, 320, 40, 20);
			
			lSacada.setBounds(10, 340, 220, 20);
			buttonGroup5.add(simSacada);
			buttonGroup5.add(naoSacada);
			simSacada.setBounds(220, 340, 40, 20);
			naoSacada.setBounds(260, 340, 40, 20);
			
			lGaragem.setBounds(10, 360, 220, 20);
			buttonGroup6.add(simGaragem);
			buttonGroup6.add(naoGaragem);
			simGaragem.setBounds(220, 360, 40, 20);
			naoGaragem.setBounds(260, 360, 40, 20);
			
			lCond.setBounds(10, 380, 220, 20);
			buttonGroup7.add(simCond);
			buttonGroup7.add(naoCond);
			simCond.setBounds(220, 380, 40, 20);
			naoCond.setBounds(260, 380, 40, 20);
			
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
			
			this.preencher(2);
		}
		
		if(op == 3) {
			lNomeUsuario.setBounds(10, 50, 100, 20);
			nomeUsuario.setBounds(10, 70, 300, 20);
			
			lCpf.setBounds(10, 90, 100, 20);
			cpf.setBounds(10, 110, 100, 20);
			
			lEmail.setBounds(120, 90, 100, 20);
			email.setBounds(120, 110, 300, 20);
			
			lCep.setBounds(10, 130, 100, 20);
			cep.setBounds(10, 150, 100, 20);
			
			lCidade.setBounds(120, 130, 100, 20);
			cidade.setBounds(120, 150, 120, 20);
			
			lUf.setBounds(250, 130, 50, 20);
			uf.setBounds(250, 150, 50, 20);
			// Setando -1 pois assim nenhum item aparece selecionado
			uf.setSelectedIndex(-1);
			
			lBairro.setBounds(310, 130, 80, 20);
			bairro.setBounds(310, 150, 100, 20);
			
			lLote.setBounds(10, 170, 100, 20);
			lote.setBounds(10, 190, 80, 20);
			
			lRua.setBounds(100, 170, 50, 20);
			rua.setBounds(100, 190, 50, 20);
			
			lComp.setBounds(160, 170, 100, 20);
			comp.setBounds(160, 190, 230, 20);
			
			lNum.setBounds(400, 170, 100, 20);
			num.setBounds(400, 190, 50, 20);
			num.setValue(0);
			JFormattedTextField numTf = ((JSpinner.DefaultEditor)num.getEditor()).getTextField();
			numTf.setEditable(false);
			
			lTelefone.setBounds(10, 210, 100, 20);
			telefone.setBounds(10, 230, 100, 20);
			
			janela.add(lNomeUsuario);
			janela.add(nomeUsuario);
			janela.add(lCep);
			janela.add(cep);
			janela.add(lCpf);
			janela.add(cpf);
			janela.add(lEmail);
			janela.add(email);
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
			janela.add(lTelefone);
			janela.add(telefone);
			
			this.preencher(3);
		}
		
		janela.setLayout(null);
	
		// Criacao de variaveis para determinar o tamanho da janela
		int jframeW;
		int jframeH;
		if(op == 3) {
			jframeW = 500;
			jframeH= 350;
			atualizar.setBounds(380, 275, 100, 30);
		}	
		else {
			jframeW = 500;
			jframeH= 550;
			atualizar.setBounds(380, 475, 100, 30);
		}
		
		janela.add(atualizar);
		
		janela.setSize(jframeW, jframeH);
		
		// Codigo para colocar a janela no meio da tela, essa variavel dim pega o tamanho do display
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int locationX = (dim.width - jframeW)/2;
		int locationY = (dim.height - jframeH)/2;
		janela.setLocation(locationX, locationY);
		
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		voltar.addActionListener(this);
		atualizar.addActionListener(this);
		
	}
	
	private void preencher(int op) {
		
		String titulo = null;
		String valor = null;
		// Comum a todos
		String cep = null;
		String cidade = null;
		String uf = null;
		String bairro = null;
		String rua = null;
		String lote = null;
		String complemento = null;
		int num = 0;
		String  dono = null;
		
		// Apenas de imoveis
		int qtdQuartos = 0;
		int qtdCamas = 0;
		int qtdBanheiros = 0;
		int qtdHospedes = 0;
		int qtdAndares = 0;
		
		// Apenas Casa
		String categoria = null;
		boolean temWifi = false;
		boolean temPisc = false;
		
		// Apenas Ap
		boolean temEl = false;
		boolean temSac = false;
		boolean temGarag = false;
		boolean temCond = false;
		
		// Apenas Pessoa
		String nome = null;
		
		// Preencher Casa
		if(op == 1) {
			titulo = dados.getCasas().get(posi).getTitulo();
			cep = dados.getCasas().get(posi).getEndereco().getCep();
			cidade = dados.getCasas().get(posi).getEndereco().getCidade();
			uf = dados.getCasas().get(posi).getEndereco().getUf();
			bairro = dados.getCasas().get(posi).getEndereco().getBairro();
			rua = dados.getCasas().get(posi).getEndereco().getRua();
			lote = dados.getCasas().get(posi).getEndereco().getLote();
			complemento = dados.getCasas().get(posi).getEndereco().getComplemento();
			num = dados.getCasas().get(posi).getEndereco().getNumero();
			valor =  Validador.removeCaracteresEspeciais(Double.toString(dados.getCasas().get(posi).getValor()));
			qtdQuartos = dados.getCasas().get(posi).getDescricao().getQtdQuartos();
			qtdCamas = dados.getCasas().get(posi).getDescricao().getQtdQuartos();
			qtdBanheiros = dados.getCasas().get(posi).getDescricao().getQtdBanheiros();
			qtdHospedes = dados.getCasas().get(posi).getDescricao().getQtdHospedes();
			qtdAndares = dados.getCasas().get(posi).getDescricao().getQtdAndar();
			categoria = dados.getCasas().get(posi).getCategoria();
			temWifi = dados.getCasas().get(posi).getTemWifi();
			temPisc = dados.getCasas().get(posi).getTemPiscina();
			dono = dados.getCasas().get(posi).getDono().getNome();
				
		}else if (op == 2) {
			titulo = dados.getApartamentos().get(posi).getTitulo();
			cep = dados.getApartamentos().get(posi).getEndereco().getCep();
			cidade = dados.getApartamentos().get(posi).getEndereco().getCidade();
			uf = dados.getApartamentos().get(posi).getEndereco().getUf();
			bairro = dados.getApartamentos().get(posi).getEndereco().getBairro();
			rua = dados.getApartamentos().get(posi).getEndereco().getRua();
			lote = dados.getApartamentos().get(posi).getEndereco().getLote();
			complemento = dados.getApartamentos().get(posi).getEndereco().getComplemento();
			num = dados.getApartamentos().get(posi).getEndereco().getNumero();
			valor =  Validador.removeCaracteresEspeciais(Double.toString(dados.getApartamentos().get(posi).getValor()));
			qtdQuartos = dados.getApartamentos().get(posi).getDescricao().getQtdQuartos();
			qtdCamas = dados.getApartamentos().get(posi).getDescricao().getQtdQuartos();
			qtdBanheiros = dados.getApartamentos().get(posi).getDescricao().getQtdBanheiros();
			qtdHospedes = dados.getApartamentos().get(posi).getDescricao().getQtdHospedes();
			qtdAndares = dados.getApartamentos().get(posi).getDescricao().getQtdAndar();
			temEl = dados.getApartamentos().get(posi).getTemElevador();
			temSac = dados.getApartamentos().get(posi).getTemSacada();
			temGarag = dados.getApartamentos().get(posi).getTemGaragem();
			temCond = dados.getApartamentos().get(posi).getTemCondominio();
			dono = dados.getApartamentos().get(posi).getDono().getNome();
		}else if (op == 3) {
			nome = dados.getPessoas().get(posi).getNome();
			cep = dados.getPessoas().get(posi).getEndereco().getCep();
			cidade = dados.getPessoas().get(posi).getEndereco().getCidade();
			uf = dados.getPessoas().get(posi).getEndereco().getUf();
			bairro = dados.getPessoas().get(posi).getEndereco().getBairro();
			rua = dados.getPessoas().get(posi).getEndereco().getRua();
			lote = dados.getPessoas().get(posi).getEndereco().getLote();
			complemento = dados.getPessoas().get(posi).getEndereco().getComplemento();
			num = dados.getPessoas().get(posi).getEndereco().getNumero();
		}
		
		this.tituloImovel.setText(titulo);
		this.cep.setText(cep);
		this.cidade.setText(cidade);
		this.uf.setSelectedItem(uf);
		this.bairro.setText(bairro);
		this.rua.setText(rua);
		this.lote.setText(lote);
		this.comp.setText(complemento);
		this.num.setValue(num);
		this.valor.setText(valor);
		this.qtdQuartos.setValue(qtdQuartos);
		this.qtdCamas.setValue(qtdCamas);
		this.qtdBanheiros.setValue(qtdBanheiros);
		this.qtdHospedes.setValue(qtdHospedes);
		this.qtdAndares.setValue(qtdAndares);
		this.dono.setSelectedItem(dono);
		
		//Apenas Casa
		this.categoria.setText(categoria);
		if(temWifi)
			simWifi.setSelected(true);
		else
			naoWifi.setSelected(true);
		if(temPisc)
			simPisc.setSelected(true);
		else
			naoPisc.setSelected(true);
		
		// Apenas Ap
		if(temEl)
			simElevador.setSelected(true);
		else
			naoElevador.setSelected(true);
		if(temSac)
			simSacada.setSelected(true);
		else
			naoSacada.setSelected(true);
		if(temGarag)
			simGaragem.setSelected(true);
		else
			naoGaragem.setSelected(true);
		if(temCond)
			simCond.setSelected(true);
		else
			naoCond.setSelected(true);
		// Apenas usuario
		nomeUsuario.setText(nome);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == voltar) {
			janela.dispose();
			if(opcao == 1 || opcao == 2)
				new ViewMenuListas(dados,1);
			else
				new ViewMenuListas(dados, 2);
		}
		if(src == atualizar) {
			if(opcao == 2) {
				String[] dadosApartamento = {tituloImovel.getText(), valor.getText().replace(',', '.'), qtdQuartos.getValue().toString(),
						qtdCamas.getValue().toString(), qtdBanheiros.getValue().toString(), qtdAndares.getValue().toString(),
						qtdHospedes.getValue().toString()};
				String[] endereco = {cep.getText(), cidade.getText(), uf.getSelectedItem().toString(), bairro.getText(),
						lote.getText(), rua.getText(), comp.getText(), num.getValue().toString()};
				boolean[] info = getInfoAp();
				int i = dono.getSelectedIndex();
				boolean inserir = dados.inserirApartamento(dadosApartamento, endereco, info, i, 2, posi);

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
				
			}else if(opcao == 1) {
				String[] dadosCasa = {tituloImovel.getText(), valor.getText().replace(',', '.'), categoria.getText(), qtdQuartos.getValue().toString(),
						qtdCamas.getValue().toString(), qtdBanheiros.getValue().toString(), qtdAndares.getValue().toString(),
						qtdHospedes.getValue().toString()};
				String[] endereco = {cep.getText(), cidade.getText(), uf.getSelectedItem().toString(), bairro.getText(),
						lote.getText(), rua.getText(), comp.getText(), num.getValue().toString()};
				boolean[] info = getInfoCs();
				int i = dono.getSelectedIndex();
				boolean inserir = dados.inserirCasa(dadosCasa, endereco, info, i, 2, posi);

				janela.dispose();
				new ViewMenuListas(dados,1);
				// Enviando Mensagem de Sucesso
				if(inserir) {
					JOptionPane.showMessageDialog(null, "Casa cadastrado com Sucesso!!" + dados.getCasas().get(0).getTitulo()
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
