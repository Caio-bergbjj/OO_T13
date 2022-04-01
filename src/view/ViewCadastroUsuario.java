package view;

import controle.Validador;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import controle.ControleDados;

public class ViewCadastroUsuario implements ActionListener{
	
	private static String[] listaUF = {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG",
			   "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", 
			   "RS", "SC", "SE", "SP", "TO"};
	
	private static JFrame janela = new JFrame("CadastroUsuario");
	private static JLabel titulo = new JLabel("Cadastrar Usuario", SwingConstants.CENTER);
	private static JButton voltar = new JButton("Voltar");
	
	// Form Geral
	private static JLabel lNomeUsuario = new JLabel("Nome do Usuario");
	private static JTextField nomeUsuario = new JTextField();
	private static JLabel lCpf = new JLabel("CPF");
	private static JFormattedTextField  cpf = new JFormattedTextField (Validador.Mascara("###.###.###-##"));
	private static JLabel lEmail = new JLabel("Email");
	private static JTextField email = new JTextField();
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
	private static JFormattedTextField  telefone = new JFormattedTextField (Validador.Mascara("(##) # ####-####"));
	private static JLabel lTelefone = new JLabel("Telefone");
	private static JButton cadastrar = new JButton("Cadastrar");
	private static ControleDados dados;
	
	public ViewCadastroUsuario(ControleDados d) {
		dados = d;
	
		// Titulo da janela e voltar
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(160, 10, 180, 30);
		voltar.setBounds(10, 10, 100, 30);
		janela.add(titulo);
		janela.add(voltar);
		
		// Form Geral
		lNomeUsuario.setBounds(10, 80, 100, 20);
		nomeUsuario.setBounds(10, 100, 300, 20);
		
		lCpf.setBounds(10, 120, 100, 20);
		cpf.setBounds(10, 140, 100, 20);
		
		lEmail.setBounds(120, 120, 100, 20);
		email.setBounds(120, 140, 300, 20);
		
		lCep.setBounds(10, 160, 100, 20);
		cep.setBounds(10, 180, 100, 20);
		
		lCidade.setBounds(120, 160, 100, 20);
		cidade.setBounds(120, 180, 120, 20);
		
		lUf.setBounds(250, 160, 50, 20);
		uf.setBounds(250, 180, 50, 20);
		// Setando -1 pois assim nenhum item aparece selecionado
		uf.setSelectedIndex(-1);
		
		lBairro.setBounds(310, 160, 80, 20);
		bairro.setBounds(310, 180, 100, 20);
		
		lLote.setBounds(10, 200, 100, 20);
		lote.setBounds(10, 220, 80, 20);
		
		lRua.setBounds(100, 200, 50, 20);
		rua.setBounds(100, 220, 50, 20);
		
		lComp.setBounds(160, 200, 100, 20);
		comp.setBounds(160, 220, 230, 20);
		
		lTelefone.setBounds(10, 240, 100, 20);
		telefone.setBounds(10, 260, 100, 20);
		
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
		janela.add(lTelefone);
		janela.add(telefone);
		
	
		
		cadastrar.setBounds(380, 375, 100, 30);
		janela.add(cadastrar);
		
		janela.setLayout(null);
		
		// Criacao de variaveis para determinar o tamanho da janela
		int jframeW = 500;
		int jframeH= 450;
		janela.setSize(jframeW, jframeH);
		
		// Codigo para colocar a janela no meio da tela, essa variavel dim pega o tamanho do display
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int locationX = (dim.width - jframeW)/2;
		int locationY = (dim.height - jframeH)/2;
		janela.setLocation(locationX, locationY);
		
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		
		voltar.addActionListener(this);	
		cadastrar.addActionListener(this);
	}
	
	private static void limparCampos() {
		nomeUsuario.setText("");
		cep.setValue(null);
		cpf.setValue(null);
		email.setText("");
		telefone.setValue(null);
		cidade.setText("");
		bairro.setText("");
		lote.setText("");
		rua.setText("");
		comp.setText("");

	}
	 
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == voltar) {
			// Método que limpar todos os campos ja preenchidos
			limparCampos();
			janela.dispose();
			new ViewMenuListas(dados, 2);	
		}
		if(src == cadastrar) {	
				ArrayList<String> erros = verificarCampos();
				
				if(erros.size() > 0) {
					JOptionPane.showMessageDialog(null, String.join("\n", erros)
							, null, 
							JOptionPane.ERROR_MESSAGE);
			}
		}
			
	}
	
	private static ArrayList<String> verificarCampos() {
		ArrayList<String> erros = new ArrayList<String>();
		
		if(nomeUsuario.getText().isEmpty())
			erros.add("+ Nome não foi preenchido!");
		if(!Validador.validaCpf(cpf.getText()))
			erros.add("+ CPF inválido");
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
		if(telefone.getValue() == null)
			erros.add("+ Telefone inválido");
		return erros;
	}
}
