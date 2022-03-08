package view;

import java.util.Scanner;
import controle.DadosApartamento;
import controle.DadosCasa;
import controle.DadosPessoa;
import controle.DadosReserva;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Pessoa;

public class Menu {
	
	static int escolha = 0;
	static Scanner ler = new Scanner(System.in);
	
	 
	
	public static void main(String[] args) {
		
		menuPrincipal();
	}
	
	public static void menuPrincipal() {
		DadosCasa dadosCasa = new DadosCasa();
		DadosApartamento dadosApartamento = new DadosApartamento();
		DadosPessoa dadosPessoa = new DadosPessoa();
		DadosReserva dadosReserva = new DadosReserva();
		cadastroInicial(dadosCasa,dadosPessoa,dadosApartamento);
		
		while(escolha != 5) {
			System.out.println("\nEscolha a op��o:");
			System.out.println("1. Gerenciar Im�veis");
			System.out.println("2. Verificar Disponibilidade");
			System.out.println("3. Gerenciar Usu�rios");
			System.out.println("5. Sair");
			
			escolha = ler.nextInt();
			
			switch (escolha) {
			case 1 -> menuGerenciarImoveis(dadosCasa,dadosApartamento,dadosPessoa,dadosReserva);
			case 2 -> menuDisponibilidade(dadosCasa,dadosApartamento);
			case 3 -> menuUsuarios(dadosPessoa);
			case 5 -> System.out.println("\nObrigado por usar o sitema. Fechando...");
			default -> System.out.println("Op��o Inv�lida!");
			}
		}
	}
	

	public static void menuGerenciarImoveis(DadosCasa dadosCasa, DadosApartamento dadosApartamento, DadosPessoa dadosPessoa,DadosReserva dadosReserva) {
		escolha = 0;
		while(escolha != 6) {
			System.out.println("\nEscolha a opcao:");
			System.out.println("1. Cadastrar Casa");
			System.out.println("2. Cadastrar Apartamento");
			System.out.println("3. Listar Im�veis");
			System.out.println("4. Excluir Casa");
			System.out.println("5. Excluir Apartamento");	
			System.out.println("6. Voltar");
			escolha = ler.nextInt();
			
			switch(escolha) {
			case 1 -> dadosCasa.addCasa();
			case 2 -> dadosApartamento.addAp();
			case 3 -> listarImoveis(dadosCasa, dadosApartamento,dadosPessoa,dadosReserva);
			case 4 -> dadosCasa.deletar();
			case 5 -> dadosApartamento.deletar();
			case 6 -> {}
			default -> System.out.println("\nOp��o Inv�lida!\n");
			
			}
		}
		
	}
	public static void menuDisponibilidade(DadosCasa dadosCasa, DadosApartamento dadosApartamento) {
		escolha = 0;
		while(escolha != 3) {
			System.out.println("\nGostaria de verificar a disponibilidade de qual tipo de im�vel?");
			System.out.println("1. Casas");
			System.out.println("2. Apartamentos");
			System.out.println("3. Voltar");
			escolha = ler.nextInt();
			
			switch (escolha) {
			case 1: {
				System.out.println("Selecione a Casa:");
				dadosCasa.listar();
				escolha = ler.nextInt();
				((Casa) dadosCasa.get(escolha-1)).mostraDisponibilidade();
			}
			break;
			case 2: {
				System.out.println("Selecione o apartamento:");
				dadosApartamento.listar();
				escolha = ler.nextInt();
				((Apartamento) dadosApartamento.get(escolha-1)).mostraDisponibilidade();
			}
			break;
			}
		}
	}
	public static void menuUsuarios(DadosPessoa dadosPessoa) {
		escolha = 0;
		while (escolha != 4) {
			System.out.println("\nEscolha a opcao:");
			System.out.println("1. Cadastrar Usu�rio");
			System.out.println("2. Excluir Usu�rio");
			System.out.println("3. Listar Usu�rios");
			System.out.println("4. Voltar");
			escolha = ler.nextInt();
			
			switch(escolha) {
			case 1 -> dadosPessoa.addPessoa();
			case 2 -> dadosPessoa.deletar();
			case 3 -> dadosPessoa.listar();
			case 4 -> {}
			default -> System.out.println("\nOp��o Inv�lida!\n");
			}
		}
	}
	public static void listarImoveis(DadosCasa dadosCasa, DadosApartamento dadosApartamento,DadosPessoa dadosPessoa,DadosReserva dadosReserva) {
		
		String op;
		
		System.out.println("\n==== Apartamentos ====");
		dadosApartamento.listar();
		System.out.println("\n==== Casas ====");
		dadosCasa.listar();
		
		System.out.println("\n\nDeseja reservar algun dos imoveis listados? (Y/N)");
		op = ler.next().toUpperCase();
		switch(op.charAt(0)) {
		case 'Y':{
			System.out.println("\nEscolha o tipo de imovel que ser� reservado: \n 1 - Casa\n 2 - Apartamento");
			op = ler.next().toUpperCase();
			switch(op.charAt(0)) {
			case '1' -> reservar(dadosCasa,dadosPessoa,dadosReserva);
			case '2' -> reservar(dadosApartamento,dadosPessoa,dadosReserva);
			default -> {}
			}
		}break;
		case 'N': {}break;
		default: break;
		}
		
		
	}
		

	public static void reservar(DadosCasa dadosCasa,DadosPessoa dadosPessoa,DadosReserva dadosReserva) {
		
		int op;
		
		System.out.println("\nEscolha uma das pessoas listadas: ");
		dadosPessoa.listar();
		
		op = ler.nextInt();
		Pessoa p = dadosPessoa.get(op);
		
		System.out.println("\nEscolha uma das casas listadas: ");
		dadosCasa.listar();
		
		op = ler.nextInt();
		Casa c = dadosCasa.get(op-1);
		System.out.println("\nDisponibilidade:\n ");
		c.mostraDisponibilidade();
		
		dadosReserva.addRserva(c, p);
		
		System.out.println(dadosReserva.get(0).getPeriodo());
		
	}
	
	public static void reservar(DadosApartamento dadosApartamento,DadosPessoa dadosPessoa,DadosReserva dadosReserva) {
		int op;
		
		
		System.out.println("\nEscolha uma das pessoas listadas: ");
		dadosPessoa.listar();
		
		op = ler.nextInt();
		Pessoa p = dadosPessoa.get(op-1);
		
		System.out.println("\nEscolha uma das casas listadas: ");
		dadosApartamento.listar();
		
		op = ler.nextInt();
		Apartamento ap = dadosApartamento.get(op-1);
	
		System.out.println("\nDisponibilidade:\n ");
		ap.mostraDisponibilidade();
		
		dadosReserva.addRserva(ap, p);
		
		System.out.println(dadosReserva.get(0).getPeriodo());
		
	}
	
	public static void cadastroInicial(DadosCasa dadosCasa, DadosPessoa dadosPessoa, DadosApartamento dadosApartamento ) {
		
	}
	
	
}

