import java.util.Scanner;

public class Apartamento extends Imovel{
	
	
	private boolean temElevador;
	private boolean temSacada;
	private boolean temGaragem;
	private boolean temCondominio;
	
	public boolean getTemElevador() {
		return temElevador;
	}
	public void setTemElevador(boolean temElevador) {
		this.temElevador = temElevador;
	}
	public boolean getTemSacada() {
		return temSacada;
	}
	public void setTemSacada(boolean temSacada) {
		this.temSacada = temSacada;
	}
	public boolean getTemGaragem() {
		return temGaragem;
	}
	public void setTemGaragem(boolean temGaragem) {
		this.temGaragem = temGaragem;
	}
	public boolean getTemCondominio() {
		return temCondominio;
	}
	public void setTemCondominio(boolean temCondominio) {
		this.temCondominio = temCondominio;
	}

	static void cadastrar(Apartamento ap) {
		int posicao = encontraPrimeiroNulo();
		
		Dados.catalogoApartamentos[posicao] = ap;
	}
	static void listar() {
		int identificador = 0;
		for(int i = 0;i<100;i++) {
			if(Dados.catalogoApartamentos[i] != null) {
				identificador++;
				System.out.println(identificador + "\t" + Dados.catalogoApartamentos[i].getTitulo());
			}
		}
	}
	static void deletar() {
		Scanner ler = new Scanner(System.in);
		
		Apartamento.listar();
		System.out.println("Digite o código do item que deseja excluir");
		int escolha = ler.nextInt();
		Dados.catalogoApartamentos[retornaPosicaoReal(escolha)] = null;
		
		
	}
	public static int encontraPrimeiroNulo() {
		for(int posi = 0; posi< 100; posi++) {
			if(Dados.catalogoApartamentos[posi] == null) {
				return posi;
			}
		}
		System.out.println("Catálogo cheio ! !");
		return 0;
	}
	public static int retornaPosicaoReal(int posicaoLista) {
		int identificador = 0;
		for(int i = 0;i < 100; i++) {
			if(Dados.catalogoApartamentos[i] != null) {
				identificador++;
			}
			if(identificador == posicaoLista) {
				return i;
			}
		}
		return 0;
	}
} 
