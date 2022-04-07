package modelo;
import java.util.Date;

/**
 * Classe para Disponibilidade, que identifica a ocupação de um imóvel em alguma data
 * @author Rafael Nobre e Caio Berg
 * @version 1.0 (Mar 22)
 *
 */

public class Disponibilidade {
	private Date data;
	private boolean ocupacao;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public boolean getOcupacao() {
		return ocupacao;
	}
	public void setOcupacao(boolean ocupacao) {
		this.ocupacao = ocupacao;
	}

}
