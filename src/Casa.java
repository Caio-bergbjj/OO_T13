
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
	
	
}
