package view;

import controle.DadosApartamento;
import controle.DadosCasa;
import controle.DadosPessoa;
import controle.DadosReserva;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Descricao;
import modelo.Pessoa;
import modelo.Telefone;

public class MainMenu {

	public static void main(String[] args) {
		DadosCasa dadosCasa = new DadosCasa();
		DadosApartamento dadosApartamento = new DadosApartamento();
		DadosPessoa dadosPessoa = new DadosPessoa();
		DadosReserva dadosReserva = new DadosReserva();
		cadastroInicial(dadosCasa,dadosPessoa,dadosApartamento);
		new ViewMenu();
		

	}
	
	public static void cadastroInicial(DadosCasa dadosCasa, DadosPessoa dadosPessoa, DadosApartamento dadosApartamento ) {
		for(int i = 0; i <=10; i++) {
			
			Telefone telefone  = new Telefone((short) (61+i),998413564+(i*3));
			Pessoa p = new Pessoa("Pessoa " + i, telefone);
			Descricao desc = new Descricao(i+1, i+1,i,(i>5)? i:i-2, i+2);
			Apartamento ap = new Apartamento("Apartamento " + i, 100050*2, desc);
			Casa casa = new Casa("Casa " + i, 103450*2, desc);
			
			dadosCasa.addDados(casa);
			dadosApartamento.addDados(ap);
			dadosPessoa.addDados(p);
			
		}
	}

}
