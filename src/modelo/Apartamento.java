package modelo;

public class Apartamento extends Imovel{
	
	private boolean temElevador;//7
	private boolean temSacada;//8
	private boolean temGaragem;//9
	private boolean temCondominio;//10
	
	public Apartamento(String titulo, double valor, Descricao descricao, boolean temElevador, boolean temSacada,
			boolean temGaragem, boolean temCondominio, Pessoa dono, Endereco endereco) {
		super(titulo, valor, descricao, dono, endereco);
		this.temElevador = temElevador;
		this.temSacada = temSacada;
		this.temGaragem = temGaragem;
		this.temCondominio = temCondominio;
	}


	public Apartamento(String titulo, double valor, Descricao descricao, Pessoa dono, Endereco endereco) {
		super(titulo, valor, descricao, dono, endereco);
		
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
