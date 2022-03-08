package modelo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;  

public abstract class Imovel {
	
	private int id; 
	private String titulo; 
	private Endereco endereco; 
	private double valor; 
	private Disponibilidade disponibilidade[]; 
	private double nota; 
	private Descricao descricao;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Disponibilidade getDisponibilidade(int posi) {
		return disponibilidade[posi];
	}
	public void setDisponibilidade(int posi, Disponibilidade disponibilidade) {
		this.disponibilidade[posi] = disponibilidade;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public Descricao getDescricao() {
		return descricao;
	}
	public void setDescricao(Descricao descricao) {
		this.descricao = descricao;
	} 
	
	public void geraDisponibilidade() {
		this.disponibilidade = new Disponibilidade[365];
		for(int i = 0; i<365; i++) {
			this.disponibilidade[i] = new Disponibilidade();
		}
		Calendar cal = (Calendar) Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String data_inicial_str = "01/01/2022";
		Date data_inicial = null;
		
		try {
			data_inicial = sdf.parse(data_inicial_str);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		cal.setTime(data_inicial);
		
		for(int i = 0; i<365;i++) {
			this.disponibilidade[i].setData(cal.getTime());
			this.disponibilidade[i].setOcupacao(false);
			cal.add(Calendar.DATE, 1);
		}
	}
	public void mostraDisponibilidade() {
		String dateToStr;
		String ocupacao;
		System.out.println("Data\t\tOcupação");
		for(int i = 0;i<365;i++) {
			dateToStr = DateFormat.getDateInstance(DateFormat.SHORT).format(this.disponibilidade[i].getData());
			if(this.disponibilidade[i].getOcupacao()) {
				ocupacao = "Ocupado";
			}else {
				ocupacao = "Livre";
			}
			System.out.println(dateToStr + "\t" + ocupacao);
		}
	}
}
