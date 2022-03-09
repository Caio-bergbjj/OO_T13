package controle;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Apartamento;
import modelo.Descricao;

public class DadosApartamento {
	
	static Scanner ler = new Scanner(System.in);
	private ArrayList<Apartamento> listaApartamento = new ArrayList<Apartamento>();
	
	public void listar() {
		if(listaApartamento.isEmpty()){
			System.out.println("N�o h� apartamentos cadastrados no sistema");
		}else{
			for(Apartamento apartamento : listaApartamento) {
				System.out.println(apartamento.getId() + " - " + apartamento.getTitulo() + "\n");
			}
		}
	}
	
	public void addAp() {
		
		int qtdQuartos, qtdCamas, qtdBanheiros, qtdAndar, qtdHospedes;
		String nome;
		Double valor;
		String op;
		
		System.out.println("\nInforme o nome do im�vel:");
		nome = ler.nextLine();
		System.out.println("\nQuantos quartos tem: ");	
		qtdQuartos = ler.nextInt();
		System.out.println("\nQuantas camas tem: ");	
		qtdCamas = ler.nextInt();
		System.out.println("\nQuantos banheiros tem: ");	
		qtdBanheiros = ler.nextInt();
		System.out.println("\nQuantos andares tem: ");	
		qtdAndar = ler.nextInt();
		System.out.println("\nQuantos h�spedes cabe no im�vel: ");	
		qtdHospedes = ler.nextInt();
		System.out.println("\nInforme o valor do im�vel:");
		valor = ler.nextDouble();
		
		Descricao desc  = new Descricao(qtdQuartos, qtdCamas, qtdBanheiros, qtdAndar, qtdHospedes);
		Apartamento imovel = new Apartamento(nome, valor, desc);
		
		listaApartamento.add(imovel);
		imovel.setId(listaApartamento.size());
		
		System.out.println("\nO local do apartamento possui elevador: (Y/N ) ");
		op = ler.next().toUpperCase();
		switch(op.charAt(0)) {
		case 'Y' -> imovel.setTemElevador(true);
		case 'N' -> imovel.setTemElevador(false);
		}
		
		System.out.println("\nO apartamento possui sacada: (Y/N ) ");
		op = ler.next().toUpperCase();
		switch(op.charAt(0)) {
		case 'Y' -> imovel.setTemElevador(true);
		case 'N' -> imovel.setTemElevador(false);
		}
		
		System.out.println("\nO apartamento possui garagem: (Y/N ) ");
		op = ler.next().toUpperCase();
		switch(op.charAt(0)) {
		case 'Y' -> imovel.setTemElevador(true);
		case 'N' -> imovel.setTemElevador(false);
		}
		
		System.out.println("\nO apartamento fica em um condom�nio: (Y/N ) ");
		op = ler.next().toUpperCase();
		switch(op.charAt(0)) {
		case 'Y' -> imovel.setTemElevador(true);
		case 'N' -> imovel.setTemElevador(false);
		}
	}
	
	public void addAp(Apartamento apartamento) {
		listaApartamento.add(apartamento);
		apartamento.setId(listaApartamento.size());
	}
	
	public void deletar() {
		
		int oldId;
		this.listar();
		System.out.println("Digite o c�digo do item que deseja excluir");
		int escolha = ler.nextInt();
		listaApartamento.remove(escolha-1);
		for(Apartamento casa : listaApartamento) {
			if( (oldId = casa.getId()) > escolha ) {
				casa.setId(oldId-1);
			}
		}
		
	}
	
	public Apartamento get(int index) {
		
		return listaApartamento.get(index);
	}
	
	
	
	

}
