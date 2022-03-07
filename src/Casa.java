import java.util.Scanner;

public class Casa extends Imovel{
	
	
	private String categoria;
	private boolean temPiscina;
	private boolean temWifi;
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public boolean getTemPiscina() {
		return temPiscina;
	}
	public void setTemPiscina(boolean temPiscina) {
		this.temPiscina = temPiscina;
	}
	public boolean getTemWifi() {
		return temWifi;
	}
	public void setTemWifi(boolean temWifi) {
		this.temWifi = temWifi;
	}
	
	static void cadastrar(Casa c) {
		int posicao = encontraPrimeiroNulo();
		
		Dados.catalogoCasas[posicao] = c;
	}
	static void listar() {
		int identificador = 0;
		for(int i = 0;i<100;i++) {
			if(Dados.catalogoCasas[i] != null) {
				identificador++;
				System.out.println(identificador + "\t" + Dados.catalogoCasas[i].getTitulo());
			}
		}
	}
	static void deletar() {
		Scanner ler = new Scanner(System.in);
		
		Casa.listar();
		System.out.println("Digite o código do item que deseja excluir");
		int escolha = ler.nextInt();
		Dados.catalogoCasas[retornaPosicaoReal(escolha)] = null;
		
		
	}
	public static int encontraPrimeiroNulo() {
		for(int posi = 0; posi< 100; posi++) {
			if(Dados.catalogoCasas[posi] == null) {
				return posi;
			}
		}
		System.out.println("Catálogo cheio ! !");
		return 0;
	}
	public static int retornaPosicaoReal(int posicaoLista) {
		int identificador = 0;
		for(int i = 0;i < 100; i++) {
			if(Dados.catalogoCasas[i] != null) {
				identificador++;
			}
			if(identificador == posicaoLista) {
				return i;
			}
		}
		return 0;
	}
}
