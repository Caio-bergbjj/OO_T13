package view;

import java.util.Scanner;
import controle.DadosApartamento;
import controle.DadosCasa;
import controle.DadosPessoa;
import controle.DadosReserva;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Periodo;
import modelo.Pessoa;
import modelo.Reserva;

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
		
		
		while(escolha != 5) {
			System.out.println("\nEscolha a opção:");
			System.out.println("1. Gerenciar Imóveis");
			System.out.println("2. Verificar Disponibilidade");
			System.out.println("3. Gerenciar Usuários");
			System.out.println("5. Sair");
			
			escolha = ler.nextInt();
			
			switch (escolha) {
			case 1 -> menuGerenciarImoveis(dadosCasa,dadosApartamento,dadosPessoa,dadosReserva);
			case 2 -> menuDisponibilidade(dadosCasa,dadosApartamento);
			case 3 -> menuUsuarios(dadosPessoa);
			case 5 -> System.out.println("\nObrigado por usar o sitema. Fechando...");
			default -> System.out.println("Opção Inválida!");
			}
		}
	}
	

	public static void menuGerenciarImoveis(DadosCasa dadosCasa, DadosApartamento dadosApartamento, DadosPessoa dadosPessoa,DadosReserva dadosReserva) {
		escolha = 0;
		while(escolha != 6) {
			System.out.println("\nEscolha a opcao:");
			System.out.println("1. Cadastrar Casa");
			System.out.println("2. Cadastrar Apartamento");
			System.out.println("3. Listar Imóveis");
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
			default -> System.out.println("\nOpção Inválida!\n");
			
			}
		}
		
	}
	public static void menuDisponibilidade(DadosCasa dadosCasa, DadosApartamento dadosApartamento) {
		escolha = 0;
		while(escolha != 3) {
			System.out.println("\nGostaria de verificar a disponibilidade de qual tipo de imóvel?");
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
			System.out.println("1. Cadastrar Usuário");
			System.out.println("2. Excluir Usuário");
			System.out.println("3. Listar Usuários");
			System.out.println("4. Voltar");
			escolha = ler.nextInt();
			
			switch(escolha) {
			case 1 -> dadosPessoa.addPessoa();
			case 2 -> dadosPessoa.deletar();
			case 3 -> dadosPessoa.listar();
			case 4 -> {}
			default -> System.out.println("\nOpção Inválida!\n");
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
			System.out.println("\nEscolha o tipo de imovel que será reservado: \n 1 - Casa\n 2 - Apartamento");
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
		String inicio, fim;
		
		System.out.println("\nEscolha uma das pessoas listadas: ");
		dadosPessoa.listar();
		
		op = ler.nextInt();
		Pessoa p = dadosPessoa.get(op);
		
		System.out.println("\nEscolha uma das casas listadas: ");
		dadosCasa.listar();
		
		op = ler.nextInt();
	
		System.out.println("\nDisponibilidade:\n ");
		dadosCasa.get(op-1).mostraDisponibilidade();
		
		System.out.println("\nEscolha uma data dentre as disponiveis:\n Inicio: (dd/MM/yyyy) ");
		inicio = ler.nextLine();
		System.out.println("\nFim: (dd/MM/yyyy) ");
		fim = ler.nextLine();
		
		Periodo periodo = new Periodo(inicio,fim);
		
		Reserva reserva = new Reserva(dadosCasa.get(op-1),p,periodo);
		
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
	
	public static void cadastroInicial() {
		// TODO Cadastrar 5 casas, 5 apartamentos e 5 pessoas aleatórias
	}
	
	
}

