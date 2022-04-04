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
		
		if(!dadosPessoa[1].matches("[0-9.-]+") || !dadosPessoa[3].matches("[0-9]+") || !dadosPessoa[4].matches("[0-9]+")) {
			return false;
		} else {
			Pessoa p = new Pessoa(dadosPessoa[0], dadosPessoa[1], dadosPessoa[2], 
					new Telefone((short) Integer.parseInt(dadosPessoa[3]), Integer.parseInt(dadosPessoa[4])));
			d.inserirPessoa(p);
			return true;
		}
	}
	
	public boolean inserirApartamento(String[] dadosApartamento, String[] endereco, boolean[] info) {
		
		if(!dadosApartamento[1].matches("[0-9.]+") || !dadosApartamento[2].matches("[1-9]+") || !dadosApartamento[3].matches("[1-9]+") 
				|| !dadosApartamento[4].matches("[1-9]+") || !dadosApartamento[6].matches("[1-9]+")) {
			return false;
		} else {
			Apartamento ap = new Apartamento(dadosApartamento[0], Double.parseDouble(dadosApartamento[1]), 
					new Descricao( Integer.parseInt(dadosApartamento[2]), Integer.parseInt(dadosApartamento[3]), Integer.parseInt(dadosApartamento[4]),
							Integer.parseInt(dadosApartamento[5]), Integer.parseInt(dadosApartamento[6])), info[0], info[1], info[2], info[3] );
			d.inserirApartamento(ap);
			return true;
		}
	}
	
	public boolean inserirCasa(String[] dadosCasa, String[] endereco, boolean[] info) {
	
		if(!dadosCasa[1].matches("[0-9.]+") || !dadosCasa[3].matches("[1-9]+") || !dadosCasa[4].matches("[1-9]+") 
				|| !dadosCasa[5].matches("[1-9]+") || !dadosCasa[6].matches("[1-9]+") || !dadosCasa[7].matches("[1-9]+")) {
			return false;
		} else {
			Casa casa = new Casa(dadosCasa[0], Double.parseDouble(dadosCasa[1]), dadosCasa[2], 
					new Descricao( Integer.parseInt(dadosCasa[3]), Integer.parseInt(dadosCasa[4]), Integer.parseInt(dadosCasa[5]),
							Integer.parseInt(dadosCasa[6]), Integer.parseInt(dadosCasa[7])), info[0], info[1] );
			d.inserirCasa(casa);
			return true;
		}
	}
	
	public boolean inserirReserva() {
			//Falta implementação
			return true;
	}
	
	public boolean removerPessoa(int i) {
		for(Reserva reserva : d.getReservas()) {
			if(reserva.getPessoa().equals(d.getPessoas().get(i))) {
				return false; // Pessoa esta com uma reserva pendente ainda
			}
		}
		d.getPessoas().remove(i);
		return true;
	}
	
	public boolean removerApartamento(int i) {
		for(Reserva reserva : d.getReservas()) {
			if(reserva.getImovel().equals(d.getApartamentos().get(i))) {
				return false; // Pessoa esta com uma reserva pendente ainda
			}
		}
		d.getApartamentos().remove(i);
		return true;
	}
	public boolean removerCasa(int i) {
		for(Reserva reserva : d.getReservas()) {
			if(reserva.getImovel().equals(d.getCasas().get(i))) {
				return false; // Pessoa esta com uma reserva pendente ainda
			}
		}
		d.getApartamentos().remove(i);
		return true;
	}
	
	public boolean removerReserva(int i) {
		d.getReservas().remove(i);
		return true;
	}
	
	public String[] listaCasas() {
		String[] lista = new String[d.getCasas().size()];
		int i = 0;
		
		for(Casa casa : d.getCasas()) {
			lista[i] = casa.getTitulo();
			i++;
		}
		
		
		return lista;
	}
	
	public String[] listaAps() {
		String[] lista = new String[d.getApartamentos().size()];
		int i = 0;
		
		for(Apartamento ap : d.getApartamentos()) {
			lista[i] = ap.getTitulo();
			i++;
		}
		
		
		return lista;
	}
	
	public String[] listaUsuarios() {
		String[] lista = new String[d.getPessoas().size()];
		int i = 0;
		
		for(Pessoa p : d.getPessoas()) {
			lista[i] = p.getNome();
			i++;
		}
		
		
		return lista;
	}
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
