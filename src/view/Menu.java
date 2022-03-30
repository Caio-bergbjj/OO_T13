package view;

import java.util.Scanner;
import controle.DadosApartamento;
import controle.DadosCasa;
import controle.DadosPessoa;
import controle.DadosReserva;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Descricao;
import modelo.Periodo;
import modelo.Pessoa;
import modelo.Telefone;

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
		Periodo p = new Periodo("01/02/2022", "06/02/2022");
		dadosCasa.preencheDisponibilidade(dadosCasa.get(0), p);
		while(escolha != 5) {
			System.out.println("\nEscolha a op��o:");
			System.out.println("1. Gerenciar Im�veis");
			System.out.println("2. Verificar Disponibilidade");
			System.out.println("3. Gerenciar Usu�rios");
			System.out.println("5. Sair");
			
			escolha = ler.nextInt();
			
			switch (escolha) {
			case 1:
				menuGerenciarImoveis(dadosCasa,dadosApartamento,dadosPessoa,dadosReserva);
				break;
			case 2:
				menuDisponibilidade(dadosCasa,dadosApartamento);
				break;
			case 3:
				menuUsuarios(dadosPessoa);
				break;
			case 5:
				System.out.println("\nObrigado por usar o sitema. Fechando...");
				break;
			default:
				System.out.println("Op��o Inv�lida!");
				break;
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
			case 1:
				dadosCasa.addDados(1);
				break;
			case 2:
				dadosApartamento.addDados(0);
				break;
			case 3:
				listarImoveis(dadosCasa, dadosApartamento,dadosPessoa,dadosReserva);
				break;
			case 4:
				dadosCasa.deletar();
				break;
			case 5:
				dadosApartamento.deletar();
				break;
			case 6 :
				break;
			default:
				System.out.println("\nOp��o Inv�lida!\n");
				break;
			
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
			case 1: 
				System.out.println("Selecione a Casa:");
				dadosCasa.listar();
				escolha = ler.nextInt();
				dadosCasa.mostraDisponibilidade(escolha-1);
				break;
			case 2: 
				System.out.println("Selecione o apartamento:");
				dadosApartamento.listar();
				escolha = ler.nextInt();
				dadosApartamento.mostraDisponibilidade(escolha-1);
				break;
			case 3:
				break;
			default:
				System.out.println("\nOp��o Inv�lida!\n");
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
			case 1:
				dadosPessoa.addDados(0);
				break;
			case 2:
				dadosPessoa.deletar();
				break;
			case 3:
				dadosPessoa.listar();
			case 4:
				break;
			default:
				System.out.println("\nOp��o Inv�lida!\n");
				break;	
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
		case 'Y':
			while(!op.contains("1") && !op.contains("2")) {
				System.out.println("\nEscolha o tipo de imovel que ser� reservado: \n 1 - Casa\n 2 - Apartamento");
				op = ler.next();
				switch(op.charAt(0)) {
				case '1':
					reservar(dadosCasa,dadosPessoa,dadosReserva);
					break;
				case '2':
					reservar(dadosApartamento,dadosPessoa,dadosReserva);
					break;
				default:
					System.out.println("\nOp��o Inv�lida!\n");
					break;
				}
			}
			break;
		default: 
			break;
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
		Casa c = (Casa) dadosCasa.get(op-1);
		System.out.println("\nDisponibilidade:\n ");
		dadosCasa.mostraDisponibilidade(op-1);
		
		dadosReserva.addDados(c, p);
		
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
		Apartamento ap = (Apartamento) dadosApartamento.get(op-1);
	
		System.out.println("\nDisponibilidade:\n ");
		dadosApartamento.mostraDisponibilidade(op-1);
		
		dadosReserva.addDados(ap, p);
		
		System.out.println(dadosReserva.get(0).getPeriodo());
		
	}
	
	public static void cadastroInicial(DadosCasa dadosCasa, DadosPessoa dadosPessoa, DadosApartamento dadosApartamento ) {
		for(int i = 0; i <=10; i++) {
			
			Telefone telefone  = new Telefone((short) (61+i),998413564+(i*3));
			Pessoa p = new Pessoa("Pessoa " + i, telefone);
			Descricao desc = new Descricao(i+1, i+1,i,(i>5)? i:i-2, i+2);
			Apartamento ap = new Apartamento("Apartamento " + i, 100050*2, desc);
			Casa casa = new Casa("Casa " + i, 103450*2, desc, true, false);
			
			dadosCasa.addDados(casa);
			dadosApartamento.addDados(ap);
			dadosPessoa.addDados(p);
			
		}
	}
	
	
}

