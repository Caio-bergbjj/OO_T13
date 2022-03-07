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
		int posicao = Dados.encontraPrimeiroNulo(Dados.getCatalogoCasas());
		
		Dados.setCatalogoCasas(c, posicao);
	}
	static void listar() {
		int identificador = 0;
		if(Dados.isVazia(Dados.getCatalogoCasas())) {
			System.out.println("Não há casas cadastradas no sistema");
		}else {		
			for(int i = 0;i<100;i++) {
				if(Dados.getCatalogoCasas()[i] != null) {
					identificador++;
					System.out.println(identificador + "\t" + Dados.getCatalogoCasas()[i].getTitulo());
				}
			}
		}
		
	}
	static void deletar() {
		Scanner ler = new Scanner(System.in);
		if(Dados.isVazia(Dados.getCatalogoCasas())) {
			System.out.println("Não há casas cadastradas no sistema");
		}else {
			Casa.listar();
			System.out.println("Digite o código do item que deseja excluir");
			int escolha = ler.nextInt();
			Dados.setCatalogoCasas(null, Dados.retornaPosicaoReal(escolha, Dados.getCatalogoCasas()));		
		}
		
		
		
	}

}
