package controle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import modelo.*;


public class ControleDados {
	
	private Dados d = new Dados();
	
	public ControleDados() {
		d.fillWithSomeData();
	}
	
	public Dados getDados() {
	
		return d;
	}

	public void setDados(Dados d ) {
		this.d = d;
	}
	
	public ArrayList<Pessoa> getPessoas(){
		return this.d.getPessoas();
	}
	
	public ArrayList<Apartamento> getApartamentos(){
		return this.d.getApartamentos();
	}
	
	public ArrayList<Casa> getCasas(){
		return this.d.getCasas();
	}
	
	public ArrayList<Reserva> getReservas(){
		return this.d.getReservas();
	}
	
	public boolean inserirPessoa(String[] dadosPessoa, String[] endereco, int flag, int index) {
		
		if(!dadosPessoa[1].matches("[0-9.-]+") || !dadosPessoa[3].matches("[0-9]+") || !dadosPessoa[4].matches("[0-9]+")) {
			return false;
		} else {
			Pessoa p = new Pessoa(dadosPessoa[0], dadosPessoa[1], dadosPessoa[2], 
					new Telefone((short) Integer.parseInt(dadosPessoa[3]), Integer.parseInt(dadosPessoa[4])), 
					new Endereco(endereco[0], endereco[1], endereco[2], endereco[3], endereco[4], endereco[5], endereco[6], endereco[7]));
			if(flag == 1)
				d.inserirPessoa(p);
			else if (flag == 2)
				d.getPessoas().set(index, p);
			return true;
		}
	}
	
	public boolean inserirApartamento(String[] dadosApartamento, String[] endereco, boolean[] info, int i, int flag, int index) {
		
		if(!dadosApartamento[1].matches("[0-9.]+") || !dadosApartamento[2].matches("[1-9]+") || !dadosApartamento[3].matches("[1-9]+") 
				|| !dadosApartamento[4].matches("[1-9]+") || !dadosApartamento[6].matches("[1-9]+")) {
			return false;
		} else {
			Pessoa p = d.getPessoas().get(i);
			Apartamento ap = new Apartamento(dadosApartamento[0], Double.parseDouble(dadosApartamento[1]), 
					new Descricao( Integer.parseInt(dadosApartamento[2]), Integer.parseInt(dadosApartamento[3]), Integer.parseInt(dadosApartamento[4]),
							Integer.parseInt(dadosApartamento[5]), Integer.parseInt(dadosApartamento[6])), info[0], info[1], info[2], info[3], p, 
					new Endereco(endereco[0], endereco[1], endereco[2], endereco[3], endereco[4], endereco[5], endereco[6], endereco[7]));
			if(flag == 1)
				d.inserirApartamento(ap);
			else if(flag == 2)
				d.getApartamentos().set(index, ap);
			return true;
		}
	}
	
	public boolean inserirCasa(String[] dadosCasa, String[] endereco, boolean[] info, int i, int flag, int index) {
	
		if(!dadosCasa[1].matches("[0-9.]+") || !dadosCasa[3].matches("[1-9]+") || !dadosCasa[4].matches("[1-9]+") 
				|| !dadosCasa[5].matches("[1-9]+") || !dadosCasa[6].matches("[1-9]+") || !dadosCasa[7].matches("[1-9]+")) {
			return false;
		} else {
			Pessoa p = d.getPessoas().get(i);
			Casa casa = new Casa(dadosCasa[0], Double.parseDouble(dadosCasa[1]), dadosCasa[2], 
					new Descricao( Integer.parseInt(dadosCasa[3]), Integer.parseInt(dadosCasa[4]), Integer.parseInt(dadosCasa[5]),
							Integer.parseInt(dadosCasa[6]), Integer.parseInt(dadosCasa[7])), info[0], info[1], p, 
					new Endereco());
			
			// 1 insere nova, 2 edita alguma
			if(flag == 1) {
				d.inserirCasa(casa);
			}else if (flag == 1){
				d.getCasas().set(index, casa);
			}

			return true;
		}
	}
	
	public boolean inserirReserva() {
			//Falta implementação
			return true;
	}
	
	public boolean removerPessoa(int i) {
		for(Reserva reserva : d.getReservas()) {
			if(reserva.getPessoa().equals(d.getPessoas().get(i))) {
				return false; // Pessoa esta com uma reserva pendente ainda
			}
		}
		d.getPessoas().remove(i);
		return true;
	}
	
	public boolean removerApartamento(int i) {
		for(Reserva reserva : d.getReservas()) {
			if(reserva.getImovel().equals(d.getApartamentos().get(i))) {
				return false; // Pessoa esta com uma reserva pendente ainda
			}
		}
		d.getApartamentos().remove(i);
		return true;
	}
	public boolean removerCasa(int i) {
		for(Reserva reserva : d.getReservas()) {
			if(reserva.getImovel().equals(d.getCasas().get(i))) {
				return false; // Pessoa esta com uma reserva pendente ainda
			}
		}
		d.getApartamentos().remove(i);
		return true;
	}
	
	public boolean removerReserva(int i) {
		d.getReservas().remove(i);
		return true;
	}
	
	public String[] listaCasas() {
		String[] lista = new String[d.getCasas().size()];
		int i = 0;
		
		for(Casa casa : d.getCasas()) {
			lista[i] = casa.getTitulo();
			i++;
		}
		
		
		return lista;
	}
	
	public String[] listaAps() {
		String[] lista = new String[d.getApartamentos().size()];
		int i = 0;
		
		for(Apartamento ap : d.getApartamentos()) {
			lista[i] = ap.getTitulo();
			i++;
		}
		
		
		return lista;
	}
	
	public String[] listaUsuarios() {
		String[] lista = new String[d.getPessoas().size()];
		int i = 0;
		
		for(Pessoa p : d.getPessoas()) {
			lista[i] = p.getNome();
			i++;
		}	
		return lista;
	}
	
	public boolean verificarDisponibilidade(String dataInicial, String dataFinal, int j, int tipo) {
		
		Imovel imovel;
		int i;
		Calendar cal = (Calendar) Calendar.getInstance();
		Calendar cal2 = (Calendar) Calendar.getInstance();
		Calendar cal3 = (Calendar) Calendar.getInstance();
		
		switch(tipo) {
		case 1 -> imovel = d.getCasas().get(j);
		case 2 -> imovel = d.getApartamentos().get(j);
		default -> imovel = d.getCasas().get(j);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data_inicial = null;
		
		try {
			data_inicial = sdf.parse(dataInicial);
			cal2.setTime(sdf.parse("01/01/2022"));
			cal2.setTime(sdf.parse(dataFinal));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.setTime(data_inicial);
		
		System.out.println(cal == cal2);
		for(i = 0; cal.compareTo(cal2) == 0  ;i++  ) {
			cal.add(Calendar.DATE, 1);
			System.out.println(i);
		}
		System.out.println(i);
		
		for( int k = i; cal.compareTo(cal3) == 0  ;k++) {
			if(imovel.getDisponibilidade(k).getOcupacao()) {
				return false;
			}
		}
		return true;
	}
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
