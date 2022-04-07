package modelo;

/**
 * Classe para Endereço, identifica o endereço de Casas, Apartamentos e Pessoas 
 * @author Rafael Nobre e Caio Berg
 * @version 1.0 (Mar 22)
 *
 */

public class Endereco {
	
	private String cep;
	private String cidade;
	private String uf;
	private String bairro;
	private String lote;
	private String rua;
	private String complemento;
	private int numero;
	
	
	
	public Endereco(String cep, String cidade, String uf, String bairro, String lote, String rua, String complemento,
			String numero) {
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
		this.bairro = bairro;
		this.lote = lote;
		this.rua = rua;
		this.complemento = complemento;
		this.numero = Integer. parseInt(numero);
	}
	
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}


	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
}
