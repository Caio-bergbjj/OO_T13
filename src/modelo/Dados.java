package modelo;

import java.util.ArrayList;

public class Dados {
	
	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	private ArrayList<Casa> casas = new ArrayList<Casa>();
	private ArrayList<Apartamento> apartamentos = new ArrayList<Apartamento>();
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	
	public void fillWithSomeData() {
		
		String[] listaCidade = {"Rio Branco", "Maceio" , "Manaus", "Macapa", "Salvador", "Fortaleza", "Brasilia", "Vitoria", "Goiania", "Sao Luis" , "Belo Horizonte"};
		String[] listaUF = {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG"};
		for (int i = 0; i <= 9; i++) {
			
			Endereco end = new Endereco("70"+i+"43-23"+i, listaCidade[i], listaUF[i], "bairro", Integer.toString(i), Integer.toString(i+2), "imovel", String.valueOf(i+1));
			Telefone telefone = new Telefone((short) (61 + i), 998413564 + (i * 3));
			Pessoa p = new Pessoa("Pessoa " + i, "154.186.552-99", "pessoa" + i+"@gmail.com", telefone, end);
			Descricao desc = new Descricao(i, i , i, (i > 5) ? i : i , i);
			Apartamento ap = new Apartamento("Apartamento " + i, 1500 * 2, desc, p, end);
			Casa casa = new Casa("Casa " + i,2500 * 2, "categoria"+i, desc, true, false, p, end);

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
