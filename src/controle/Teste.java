package controle;
import java.util.Scanner;

import modelo.Apartamento;
import modelo.Casa;

public class Teste {
	
	static int escolha = 0;
	static Scanner ler = new Scanner(System.in);
	
	 
	
	public static void main(String[] args) {
		
		menuPrincipal();
	}
	
	public static void menuPrincipal() {
		
		DadosCasa dadosCasa = new DadosCasa();
		DadosApartamento dadosApartamento = new DadosApartamento();
		DadosPessoa dadosPessoa = new DadosPessoa();
		
		
		while(escolha != 5) {
			System.out.println("\nEscolha a op��o:");
			System.out.println("1. Gerenciar Im�veis");
			System.out.println("2. Verificar Disponibilidade");
			System.out.println("3. Gerenciar Usu�rios");
			System.out.println("5. Sair");
			
			escolha = ler.nextInt();
			
			switch (escolha) {
			case 1 -> menuGerenciarImoveis(dadosCasa,dadosApartamento);
			case 2 -> menuDisponibilidade(dadosCasa,dadosApartamento);
			case 3 -> menuUsuarios(dadosPessoa);
			case 5 -> System.out.println("\nObrigado por usar o sitema. Fechando...");
			default -> System.out.println("Op��o Inv�lida!");
			}
		}
	}
	

	public static void menuGerenciarImoveis(DadosCasa dadosCasa, DadosApartamento dadosApartamento) {
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
			case 3 -> listarImoveis(dadosCasa, dadosApartamento);
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
	public static void listarImoveis(DadosCasa dadosCasa, DadosApartamento dadosApartamento) {
		System.out.println("\n==== Apartamentos ====");
		dadosApartamento.listar();
		System.out.println("\n==== Casas ====");
		dadosCasa.listar();
	}


	public static void cadastroInicial() {
		// TODO Cadastrar 5 casas, 5 apartamentos e 5 pessoas aleat�rias
	}
	
	
}

