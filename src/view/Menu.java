package view;
import java.util.Scanner;

import controle.Dados;
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
		
		while(escolha != 5) {
			System.out.println("\nEscolha a opção:");
			System.out.println("1. Gerenciar Imóveis");
			System.out.println("2. Verificar Disponibilidade");
			System.out.println("3. Gerenciar Usuários");
			System.out.println("5. Sair");
			
			escolha = ler.nextInt();
			
			switch (escolha) {
			case 1: menuGerenciarImoveis();
			break;
			case 2: menuDisponibilidade();
			break;
			case 3: menuUsuarios();
			default:
			break;
			}
		}
	}
	

	public static void menuGerenciarImoveis() {
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
			case 1: cadastrarCasa();
			break;
			case 2: cadastrarApartamento();
			break;
			case 3: listarImoveis();
			break;
			case 4: //Casa.deletar();
			break;
			case 5: //Apartamento.deletar();
			break;
			default:
			break;
			}
		}
		
	}
	public static void menuDisponibilidade() {
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
				Casa.listar();
				escolha = ler.nextInt();
				Dados.getCatalogoCasas()[Dados.retornaPosicaoReal(escolha, Dados.getCatalogoCasas())].mostraDisponibilidade();
			}
			break;
			case 2: {
				System.out.println("Selecione o apartamento:");
				Apartamento.listar();
				escolha = ler.nextInt();
				Dados.getCatalogoApartamentos()[Dados.retornaPosicaoReal(escolha, Dados.getCatalogoApartamentos())].mostraDisponibilidade();
			}
			break;
			}
		}
		
	}
	public static void menuUsuarios() {
		escolha = 0;
		while (escolha != 4) {
			System.out.println("\nEscolha a opcao:");
			System.out.println("1. Cadastrar Usuário");
			System.out.println("2. Excluir Usuário");
			System.out.println("3. Listar Usuários");
			System.out.println("4. Voltar");
			escolha = ler.nextInt();
			
			switch(escolha) {
			case 1: cadastrarUser();
			break;
			case 2: Pessoa.deletar();
			break;
			case 3: Pessoa.listar();
			break;
			}
		}
	}
	
	public static void cadastrarCasa(){
		Casa c = new Casa();
		String temp_str;
		Double temp_db;
		System.out.println("\nInforme o nome do imóvel:");
		ler.nextLine();
		temp_str = ler.nextLine();
		c.setTitulo(temp_str);
		System.out.println("\nInforme o valor do imóvel:");
		temp_db = ler.nextDouble();
		c.setValor(temp_db);
		c.geraDisponibilidade();
		Casa.cadastrar(c);
	}
	public static void listarImoveis() {
		System.out.println("\n==== Apartamentos ====");
		Apartamento.listar();
		System.out.println("\n==== Casas ====");
		Casa.listar();
	}
	public static void cadastrarApartamento(){
		Apartamento a = new Apartamento();
		String temp_str;
		Double temp_db;
		System.out.println("\nInforme o nome do imóvel:");
		ler.nextLine();
		temp_str = ler.nextLine();
		a.setTitulo(temp_str);
		System.out.println("\nInforme o valor do imóvel:");
		temp_db = ler.nextDouble();
		a.setValor(temp_db);
		a.geraDisponibilidade();
		Apartamento.cadastrar(a);
	}

	public static void cadastrarUser() {
		System.out.println("\nInsira o nome do usuário:");
		ler.nextLine();
		String nome = ler.nextLine();
		
		System.out.println("\nInsira o cpf do usuário (Use pontos e hífen)");
		String cpf = ler.nextLine();
		
		System.out.println("\nInsira o email do usuário");
		String email = ler.nextLine();
		
		Pessoa p1 = new Pessoa(nome, cpf, email);
		Pessoa.cadastrar(p1);
	}
	
	
	public static void cadastroInicial() {
		// TODO Cadastrar 5 casas, 5 apartamentos e 5 pessoas aleatórias
	}
}

