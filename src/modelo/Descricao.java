package modelo;

/**
 * Classe para Descricao, um conjunto de características de um Imóvel
 * @author Rafael Nobre e Caio Berg
 * @version 1.0 (Mar 22)
 *
 */

public class Descricao {
	private int qtdQuartos;
	private int qtdCamas;
	private int qtdBanheiros;
	private int qtdAndar;
	private int qtdHospedes;
	
	
	
	public Descricao(int qtdQuartos, int qtdCamas, int qtdBanheiros, int qtdAndar, int qtdHospedes) {
		
		this.qtdQuartos = qtdQuartos;
		this.qtdCamas = qtdCamas;
		this.qtdBanheiros = qtdBanheiros;
		this.qtdAndar = qtdAndar;
		this.qtdHospedes = qtdHospedes;
		
	}
	
	public int getQtdQuartos() {
		return qtdQuartos;
	}
	public void setQtdQuartos(int qtdQuartos) {
		this.qtdQuartos = qtdQuartos;
	}
	public int getQtdCamas() {
		return qtdCamas;
	}
	public void setQtdCamas(int qtdCamas) {
		this.qtdCamas = qtdCamas;
	}
	public int getQtdBanheiros() {
		return qtdBanheiros;
	}
	public void setQtdBanheiros(int qtdBanheiros) {
		this.qtdBanheiros = qtdBanheiros;
	}
	public int getQtdAndar() {
		return qtdAndar;
	}
	public void setQtdAndar(int qtdAndar) {
		this.qtdAndar = qtdAndar;
	}
	public int getQtdHospedes() {
		return qtdHospedes;
	}
	public void setQtdHospedes(int qtdHospedes) {
		this.qtdHospedes = qtdHospedes;
	}
	
}
