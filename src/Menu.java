import java.util.Scanner;

public class Menu {
	
	static int escolha = 0;
	static Scanner ler = new Scanner(System.in);
	
	public static void main(String[] args) {
		menuPrincipal();
	}
	
	public static void menuPrincipal() {
		
		while(escolha != 5) {
			System.out.println("Escolha a opção:");
			System.out.println("1. Gerenciar Imóveis");
			System.out.println("2. Verificar Disponibilidade");
			System.out.println("5. Sair");
			
			escolha = ler.nextInt();
			
			switch (escolha) {
			case 1: menuGerenciarImoveis();
			break;
			case 2: menuDisponibilidade();
			default:
			break;
			}
		}
	}
	
	public static void menuGerenciarImoveis() {
		escolha = 0;
		while(escolha != 6) {
			System.out.println("Escolha a opcao:");
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
			case 4: Casa.deletar();
			break;
			case 5: Apartamento.deletar();
			break;
			default:
			break;
			}
		}
		
	}
	public static void menuDisponibilidade() {
		escolha = 0;
		while(escolha != 3) {
			System.out.println("Gostaria de verificar a disponibilidade de qual tipo de imóvel?");
			System.out.println("1. Casas");
			System.out.println("2. Apartamentos");
			System.out.println("3. Voltar");
			escolha = ler.nextInt();
			
			switch (escolha) {
			case 1: {
				System.out.println("Selecione a Casa:");
				Casa.listar();
				escolha = ler.nextInt();
				Casa.catalogoCasas[Casa.retornaPosicaoReal(escolha)].mostraDisponibilidade();
			}
			break;
			case 2: {
				System.out.println("Selecione o apartamento:");
				Apartamento.listar();
				escolha = ler.nextInt();
				Apartamento.catalogoApartamentos[Apartamento.retornaPosicaoReal(escolha)].mostraDisponibilidade();
			}
			break;
			}
		}
		
	}
	
	public static void cadastrarCasa(){
		Casa c = new Casa();
		String temp_str;
		Double temp_db;
		System.out.println("Informe o nome do imóvel:");
		ler.nextLine();
		temp_str = ler.nextLine();
		c.setTitulo(temp_str);
		System.out.println("Informe o valor do imóvel:");
		temp_db = ler.nextDouble();
		c.setValor(temp_db);
		c.geraDisponibilidade();
		Casa.cadastrar(c);
	}
	public static void listarImoveis() {
		System.out.println("==== Apartamentos ====");
		Apartamento.listar();
		System.out.println("==== Casas ====");
		Casa.listar();
	}
	public static void cadastrarApartamento(){
		Apartamento a = new Apartamento();
		String temp_str;
		Double temp_db;
		System.out.println("Informe o nome do imóvel:");
		ler.nextLine();
		temp_str = ler.nextLine();
		a.setTitulo(temp_str);
		System.out.println("Informe o valor do imóvel:");
		temp_db = ler.nextDouble();
		a.setValor(temp_db);
		a.geraDisponibilidade();
		Apartamento.cadastrar(a);
	}
}

