package view;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
import controle.ControleDados;

public class ViewReservar implements ListSelectionListener, ActionListener {
	
	String[]listaTotalUsuarios;
	
	private static JFrame janela = new JFrame("Reserva");
	private static JLabel titulo = new JLabel("Reservar Imovel", SwingConstants.CENTER);
	private static JButton voltar = new JButton("Voltar");
	private static JButton reservar = new JButton("Reservar");
	private static JLabel filtros = new JLabel("Filtros", SwingConstants.CENTER);
	private static ButtonGroup buttonGroup = new ButtonGroup();
	private static JRadioButton casa = new JRadioButton("Casas");
	private static JRadioButton ap = new JRadioButton("Apartamentos");
	private static JLabel LIm = new JLabel("Imovel");
	private static JComboBox<String> im;
	private static JLabel lLocatario = new JLabel("Locatario");
	private static JComboBox<String> locatario;
	private static JLabel labelDataI = new JLabel("Data Inicial: ");
	private static JLabel labelDataF = new JLabel("Data Final: ");
	private static ControleDados dados;
	private static JFormattedTextField jFormattedTextDataI;
	private static JFormattedTextField jFormattedTextDataF;
	
	public ViewReservar(ControleDados d) {
	
		dados = d;
		
		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			 System.err.println("Erro na formatação: " + e.getMessage());
             System.exit(-1);
		}
		
		jFormattedTextDataI = new JFormattedTextField(mascaraData);
		jFormattedTextDataF = new JFormattedTextField(mascaraData);
		
		
		
		
		im = new JComboBox<String>(dados.listaCasas());
		locatario = new JComboBox<String>(dados.listaUsuarios());
		
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		voltar.setBounds(10, 10, 100, 30);
		reservar.setBounds(190,230,100,30);
		titulo.setBounds(160, 10, 180, 30);
		filtros.setFont(new Font("Arial", Font.BOLD, 15));
		filtros.setBounds(20, 60, 180, 30);
		casa.setBounds(50, 90, 100, 20);
		casa.setSelected(true);
		ap.setBounds(50, 110, 120, 20);
		lLocatario.setBounds(200,60,100,20);
		locatario.setBounds(200, 80, 100, 20);
		locatario.setSelectedIndex(-1);
		LIm.setBounds(310, 60, 140, 20);
		im.setBounds(310, 80, 140, 20);
		im.setSelectedIndex(-1);
		labelDataI.setBounds(10,160,100,20);
		jFormattedTextDataI.setBounds(80,160,100,20);
		labelDataF.setBounds(240,160,100,20);
		jFormattedTextDataF.setBounds(310,160,100,20);
		
		janela.setLayout(null);
		
		buttonGroup.add(casa);
		buttonGroup.add(ap);
		janela.add(titulo);
		janela.add(voltar);
		janela.add(casa);
		janela.add(ap);
		janela.add(filtros);
		janela.add(lLocatario);
		janela.add(locatario);
		janela.add(LIm);
		janela.add(im);
		janela.add(labelDataI);
		janela.add(jFormattedTextDataI);
		janela.add(labelDataF);
		janela.add(jFormattedTextDataF);
		janela.add(reservar);
		
		int jframeW = 500;
		int jframeH= 350;
		janela.setSize(jframeW, jframeH);
		
		// Codigo para colocar a janela no meio da tela, essa variavel dim pega o tamanho do display
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int locationX = (dim.width - jframeW)/2;
		int locationY = (dim.height - jframeH)/2;
		janela.setLocation(locationX, locationY);

		casa.addActionListener(this);
		ap.addActionListener(this);
		voltar.addActionListener(this);
		reservar.addActionListener(this);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}


	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == casa) {
			im.removeAllItems();
			for(String s : dados.listaCasas()) {im.addItem(s);}
			im.setSelectedIndex(-1);
			im.updateUI();
		}
		if(src == ap) {
			
			im.removeAllItems();
			for(String s : dados.listaAps()) {im.addItem(s);}
			im.setSelectedIndex(-1);
			im.updateUI();
		}
		if(src == voltar) {
			janela.dispose();
			new ViewMenuListas(dados,1);		
		}
		if(src == reservar) { 
			String[] dataOcupada;
			
			if(ap.isSelected()) {
				try {
					dataOcupada = dados.verificarDisponibilidade(jFormattedTextDataI.getText(),
							jFormattedTextDataF.getText(), im.getSelectedIndex(), 1);
					if( dataOcupada [0] == null ) {
						dados.reservar(jFormattedTextDataI.getText(),
								jFormattedTextDataF.getText(), im.getSelectedIndex(), locatario.getSelectedIndex() , 1);
						mensagemSucessoCadastro();
					} else {
						mensagemErroCadastro(dataOcupada);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Dados Incompletos ou errados"
					, null, 
					JOptionPane.ERROR_MESSAGE);
				}
				
			} else {
				try {
					dataOcupada = dados.verificarDisponibilidade(jFormattedTextDataI.getText(),
							jFormattedTextDataF.getText(), im.getSelectedIndex(), 2);
					if(dataOcupada[0] == null) {
						dados.reservar(jFormattedTextDataI.getText(),
								jFormattedTextDataF.getText(), im.getSelectedIndex(),locatario.getSelectedIndex(), 2);
						mensagemSucessoCadastro();
					} else {
						mensagemErroCadastro(dataOcupada);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Dados Incompletos ou errados"
							, null, 
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
	}
	
	public void mensagemErroCadastro(String [] dataOcupada) {
		JOptionPane.showMessageDialog(null, "As seguintes datas escolhidas estao ocupadas:\n"+String.join("\n", dataOcupada)
		, null, 
		JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Reservado com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
		new ViewMenuListas(dados, 1);
	}
}
