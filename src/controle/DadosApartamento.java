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
			System.out.println("Não há apartamentos cadastrados no sistema");
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
		
		System.out.println("\nInforme o nome do imóvel:");
		ler.next();
		nome = ler.nextLine();
		System.out.println("\nQuantos quartos tem: ");	
		qtdQuartos = ler.nextInt();
		System.out.println("\nQuantas camas tem: ");	
		qtdCamas = ler.nextInt();
		System.out.println("\nQuantos banheiros tem: ");	
		qtdBanheiros = ler.nextInt();
		System.out.println("\nQuantos andares tem: ");	
		qtdAndar = ler.nextInt();
		System.out.println("\nQuantos hóspedes cabe no imóvel: ");	
		qtdHospedes = ler.nextInt();
		System.out.println("\nInforme o valor do imóvel:");
		valor = ler.nextDouble();
		
		Descricao desc  = new Descricao(qtdQuartos, qtdCamas, qtdBanheiros, qtdAndar, qtdHospedes);
		Apartamento imovel = new Apartamento(nome, valor, desc);
		
		imovel.setId(listaApartamento.size()+1);
		listaApartamento.add(imovel);
		
		System.out.println("\nO local do apartamento possui elevador: (Y/N ) ");
		op = ler.next().toUpperCase();
		switch(op.charAt(0)) {
		case 'Y' -> imovel.setTemElevador(true);
		case 'N' -> imovel.setTemElevador(false);
		}
		
		System.out.println("\nO local do apartamento possui sacada: (Y/N ) ");
		op = ler.next().toUpperCase();
		switch(op.charAt(0)) {
		case 'Y' -> imovel.setTemElevador(true);
		case 'N' -> imovel.setTemElevador(false);
		}
		
		System.out.println("\nO local do apartamento possui garagem: (Y/N ) ");
		op = ler.next().toUpperCase();
		switch(op.charAt(0)) {
		case 'Y' -> imovel.setTemElevador(true);
		case 'N' -> imovel.setTemElevador(false);
		}
		
		System.out.println("\nO local do apartamento fica em um condomínio: (Y/N ) ");
		op = ler.next().toUpperCase();
		switch(op.charAt(0)) {
		case 'Y' -> imovel.setTemElevador(true);
		case 'N' -> imovel.setTemElevador(false);
		}
	}
	

	public void deletar() {
		
		int oldId;
		this.listar();
		System.out.println("Digite o código do item que deseja excluir");
		int escolha = ler.nextInt();
		listaApartamento.remove(escolha-1);
		for(Apartamento casa : listaApartamento) {
			if( (oldId = casa.getId()) > escolha ) {
				casa.setId(oldId-1);
			}
		}
		
	}
	
	public Object get(int index) {
		
		return listaApartamento.get(index);
	}
	
	
	
	

}
