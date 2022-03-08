package modelo;

public class Apartamento extends Imovel{
	
	private boolean temElevador;
	private boolean temSacada;
	private boolean temGaragem;
	private boolean temCondominio;
	
	public Apartamento(String titulo, double valor, Descricao descricao) {
		super(titulo, valor, descricao);
		
	}
	
	
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

} 
