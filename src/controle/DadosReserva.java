package controle;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Imovel;
import modelo.Periodo;
import modelo.Pessoa;
import modelo.Reserva;

public class DadosReserva{
	
	static Scanner ler = new Scanner(System.in);
	private ArrayList<Reserva> listaReserva = new ArrayList<Reserva>();
	
	public void listar() {
		//Verficando se existe reservas cadastrados
		if(listaReserva.isEmpty()){
			System.out.println("Não há casas cadastradas no sistema");
		}else{
			//Pegando cada reserva do array list e printando o nome e a Id da reserva
			for(Reserva casa : listaReserva) {
				System.out.println(casa.getId_reserva() + " - " + casa.getImovel().getTitulo() + "\n");
			}
		}
	}
	
	public void addDados(Imovel imovel, Pessoa p) { // Recebendo a pessoa que fez a reservar e o imovel reservado
		
		String inicio, fim;
		
		//Dados da reserva
		System.out.println("\nEscolha uma data dentre as disponiveis:\n Inicio: (dd/MM/yyyy) ");
		inicio = ler.nextLine();
		System.out.println("\nFim: (dd/MM/yyyy) ");
		fim = ler.nextLine();
		
		//Periodo da reserva
		Periodo periodo = new Periodo(inicio,fim);
		
		//Criando o objreto reserva
		Reserva reserva = new Reserva(imovel,p,periodo);
		
		//Adiconando no array list
		listaReserva.add(reserva);
		
		
	}
	
	public void deletar() {
		
		
	}
	
	public Reserva get(int index) {
		
		//Pegando a reserva na posicao requerida
		return listaReserva.get(index);
	}
	
}
