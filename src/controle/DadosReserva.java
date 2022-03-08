package controle;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Imovel;
import modelo.Periodo;
import modelo.Pessoa;
import modelo.Reserva;

public class DadosReserva {
	
	static Scanner ler = new Scanner(System.in);
	private ArrayList<Reserva> listaReserva = new ArrayList<Reserva>();
	
	public void listar() {
		if(listaReserva.isEmpty()){
			System.out.println("Não há casas cadastradas no sistema");
		}else{
			for(Reserva casa : listaReserva) {
			//	System.out.println(casa.getId() + " - " + casa.getTitulo() + "\n");
			}
		}
	}
	
	public void addRserva(Imovel imovel, Pessoa p) {
		
		String inicio, fim;
		
		System.out.println("\nEscolha uma data dentre as disponiveis:\n Inicio: (dd/MM/yyyy) ");
		inicio = ler.nextLine();
		System.out.println("\nFim: (dd/MM/yyyy) ");
		fim = ler.nextLine();
		
		Periodo periodo = new Periodo(inicio,fim);
		
		Reserva reserva = new Reserva(imovel,p,periodo);
		
		listaReserva.add(reserva);
		
		
	}
	
	public void deletar() {
		
		
	}
	
	public Reserva get(int index) {
		
		return listaReserva.get(index);
	}
	
}
