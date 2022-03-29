package controle;

import java.util.ArrayList;

import modelo.*;


public class ControleDados {
	
	private Dados d = new Dados();
	
	public ControleDados() {
		d.fillWithSomeData();
	}
	
	public Dados getDados() {
	
		return d;
	}

	public void setDados(Dados d ) {
		this.d = d;
	}
	
	public ArrayList<Pessoa> getPessoas(){
		return this.d.getPessoas();
	}
	
	public ArrayList<Apartamento> getApartamentos(){
		return this.d.getApartamentos();
	}
	
	public ArrayList<Casa> getCasas(){
		return this.d.getCasas();
	}
	
	public ArrayList<Reserva> getReservas(){
		return this.d.getReservas();
	}
	
	public boolean inserirPessoa(String[] dadosPessoa, String[] endereco) {
		
		if(!dadosPessoa[1].matches("[0-9]+") || !dadosPessoa[3].matches("[0-9]+") || !dadosPessoa[4].matches("[0-9]+")) {
			return false;
		} else {
			Pessoa p = new Pessoa(dadosPessoa[0], dadosPessoa[1], dadosPessoa[2], 
					new Telefone((short) Integer.parseInt(dadosPessoa[3]), Integer.parseInt(dadosPessoa[4])));
			d.inserirPessoa(p);
			return true;
		}
	}
	
	public boolean inserirApartamento(String[] dadosApartamento, String[] endereco, boolean[] info) {
		
		if(!dadosApartamento[1].matches("[1-9]+") || !dadosApartamento[2].matches("[1-9]+") || !dadosApartamento[3].matches("[1-9]+") 
				|| !dadosApartamento[4].matches("[1-9]+") || !dadosApartamento[6].matches("[1-9]+")) {
			return false;
		} else {
			Apartamento ap = new Apartamento(dadosApartamento[0], Double.parseDouble(dadosApartamento[1]), 
					new Descricao( Integer.parseInt(dadosApartamento[2]), Integer.parseInt(dadosApartamento[3]), Integer.parseInt(dadosApartamento[4]),
							Integer.parseInt(dadosApartamento[5]), Integer.parseInt(dadosApartamento[6])), info[0], info[1], info[2], info[3] );
			return true;
		}
	}
	
	public boolean inserirCasa(String[] dadosCasa, String[] endereco) {
	
	if(!dadosCasa[1].matches("[0-9]+") || !dadosCasa[3].matches("[0-9]+") || !dadosCasa[4].matches("[0-9]+")) {
		return false;
	} else {
		Pessoa p = new Pessoa(dadosCasa[0], dadosCasa[1], dadosCasa[2], 
				new Telefone((short) Integer.parseInt(dadosCasa[3]), Integer.parseInt(dadosCasa[4])));
		d.inserirPessoa(p);
		return true;
	}
}
}
