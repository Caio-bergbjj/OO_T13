package modelo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe para período
 * @author Rafael Nobre e Caio Berg
 * @version 1.0 (Mar 22)
 */

public class Periodo {
	private Date data_inicial;
	private Date data_final;
	
	public Periodo(String data_inicial_str, String data_final_str) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			this.data_inicial = sdf.parse(data_inicial_str);
			this.data_final = sdf.parse(data_final_str);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public Date getData_inicial() {
		return data_inicial;
	}
	public void setData_inicial(Date data_inicial) {
		this.data_inicial = data_inicial;
	}
	public Date getData_final() {
		return data_final;
	}
	public void setData_final(Date data_final) {
		this.data_final = data_final;
	}
	
	/**
	 * Método para retornar o objeto período em um formato de string, de forma mais intuitiva
	 */

	@Override
	public String toString() {
		return "Periodo [data_inicial=" + data_inicial + ", data_final=" + data_final + "]";
	}
	
	
	
}
