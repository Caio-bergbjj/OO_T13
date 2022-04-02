package modelo;

import java.util.ArrayList;

public class Dados {
	
	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	private ArrayList<Casa> casas = new ArrayList<Casa>();
	private ArrayList<Apartamento> apartamentos = new ArrayList<Apartamento>();
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	
	public void fillWithSomeData() {
		for (int i = 0; i <= 10; i++) {

			Telefone telefone = new Telefone((short) (61 + i), 998413564 + (i * 3));
			Pessoa p = new Pessoa("Pessoa " + i, telefone);
			Descricao desc = new Descricao(i + 1, i + 1, i, (i > 5) ? i : i - 2, i + 2);
			Apartamento ap = new Apartamento("Apartamento " + i, 100050 * 2, desc);
			Casa casa = new Casa("Casa " + i,103450 * 2, "categoria"+i, desc, true, false);

			pessoas.add(p);
			casas.add(casa);
			apartamentos.add(ap);
		}
	}
	
	public ArrayList<Pessoa> getPessoas(){
		return pessoas;
	}
	
	public ArrayList<Apartamento> getApartamentos(){
		return apartamentos;
	}
	
	public ArrayList<Casa> getCasas(){
		return casas;
	}
	
	public ArrayList<Reserva> getReservas() {
		return reservas;
	}
	
	public void inserirPessoa(Pessoa p) {
		this.pessoas.add(p);
	}
	public void inserirCasa(Casa casa) {
		this.casas.add(casa);
		casa.setId(casas.size()); // colocando o Id como a posicao + 1 no array list 
		
	}
	public void inserirApartamento(Apartamento ap) {
		this.apartamentos.add(ap);
		ap.setId(apartamentos.size()); // colocando o Id como a posicao + 1 no array list 
		
	}
	public void inserirReserva(Reserva reserva) {
		this.reservas.add(reserva);
		reserva.setId(reservas.size()); // colocando o Id como a posicao + 1 no array list 
	}

	
	
	

	
	
	

}
