package modelo;

import java.util.ArrayList;

/**
 * Classe de dados, onde será armazenado as listas de objetos, com os métodos de inserção
 * @author Rafael Nobre e Caio Berg
 *
 */

public class Dados {
	
	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	private ArrayList<Casa> casas = new ArrayList<Casa>();
	private ArrayList<Apartamento> apartamentos = new ArrayList<Apartamento>();
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	
	/**
	 * Método para cadastro de dados aleatórios na inicialização do sistema
	 * Adiciona 9 casas, 9 apartamentos e 9 pesosas dentro das listas de objetos
	 */
	
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
	
	/**
	 * Método para inserção de uma nova pessoa dentro da lista de pessoas
	 * @param p
	 * Um objeto do tipo Pessoa
	 */
	
	public void inserirPessoa(Pessoa p) {
		this.pessoas.add(p);
	}
	
	/**
	 * Método para inserção de uma nova casa dentro da lista de casas
	 * @param casa
	 * Um objeto do tipo Casa
	 */
	public void inserirCasa(Casa casa) {
		this.casas.add(casa);
		casa.setId(casas.size()); // colocando o Id como a posicao + 1 no array list 
		
	}
	
	/**
	 * Método para inserção de um novo apartamento dentro da lista de apartamentos
	 * @param ap
	 * Um objeto do tipo Apartamento
	 */
	
	public void inserirApartamento(Apartamento ap) {
		this.apartamentos.add(ap);
		ap.setId(apartamentos.size()); // colocando o Id como a posicao + 1 no array list 
		
	}
	
	/**
	 * Método para inserção de uma nova reserva dentro da lista de reservas
	 * @param reserva
	 * Um objeto do tipo Reserva
	 */
	
	public void inserirReserva(Reserva reserva) {
		this.reservas.add(reserva);
		reserva.setId(reservas.size()); // colocando o Id como a posicao + 1 no array list 
	}

}
