package view;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JFormattedTextField;
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
	private static JLabel LDono = new JLabel("Locatario");
	private static JComboBox<String> dono;
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
		dono = new JComboBox<String>(dados.listaUsuarios());
		
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		voltar.setBounds(10, 10, 100, 30);
		reservar.setBounds(190,230,100,30);
		titulo.setBounds(160, 10, 180, 30);
		filtros.setFont(new Font("Arial", Font.BOLD, 15));
		filtros.setBounds(20, 60, 180, 30);
		casa.setBounds(50, 90, 100, 20);
		casa.setSelected(true);
		ap.setBounds(50, 110, 120, 20);
		LDono.setBounds(200,60,100,20);
		dono.setBounds(200, 80, 100, 20);
		dono.setSelectedIndex(-1);
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
		janela.add(LDono);
		janela.add(dono);
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
			
			if(ap.isSelected()) {
				if(dados.verificarDisponibilidade(jFormattedTextDataI.getText(),
						jFormattedTextDataF.getText(), im.getSelectedIndex(), 1) ) {
					System.out.println("Certo");
				} else {
					System.out.println("errado");
				}
			} else {
				if(dados.verificarDisponibilidade(jFormattedTextDataI.getText(),
						jFormattedTextDataF.getText(), im.getSelectedIndex(), 2)) {
					System.out.println("Certo");
				} else {
					System.out.println("errado");
				}
			}
		}
		
	}
}
