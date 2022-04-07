package modelo;

/**
 * Classe para Telefone
 * @author Rafael Nobre e Caio Berg
 *
 */

public class Telefone {

	private short ddd;
	private int numero;
	
	public Telefone(short ddd, int numero) {
		this.ddd = ddd;
		this.numero = numero;
	}
	
	public short getDdd() {
		return ddd;
	}
	public void setDdd(short ddd) {
		this.ddd = ddd;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
		
		
}
