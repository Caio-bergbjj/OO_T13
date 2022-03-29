package modelo;
public class Reserva {
	
	private int id_reserva;
	private Imovel imovel;
	private Pessoa hospede;
	private Periodo periodo;
	static int contando = 1;
	
	
	
	public Reserva(Imovel imovel, Pessoa pessoa, Periodo periodo) {
		super();
		this.imovel = imovel;
		this.hospede = pessoa;
		this.periodo = periodo;
		this.id_reserva = contando;
		contando ++;
	}
	
	public int getId_reserva() {
		return id_reserva;
	}
	public void setId(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	public Imovel getImovel() {
		return imovel;
	}
	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
	public Pessoa getPessoa() {
		return hospede;
	}
	public void setPessoa(Pessoa pessoa) {
		this.hospede = pessoa;
	}
	public Periodo getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}	
	
}
