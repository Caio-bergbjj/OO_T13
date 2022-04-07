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
	public ArrayList<Pessoa> getPessoas(){
		return this.d.getPessoas();
	}
	
	public ArrayList<Apartamento> getApartamentos(){
		return this.d.getApartamentos();
	}
	
	public ArrayList<Casa> getCasas(){
		return this.d.getCasas();
	}
	
	/**
	 * Método para inserir ou editar informações na lista de pessoas
	 * @param dadosPessoa, dados necessário para criar um objeto tipo Casa
	 * @param endereco, dados necessário para criar um objeto tipo Endereço
	 * @param flag, indicador para determinar se a ação será de inserção ou de edição
	 * flag = 1, inserção de nova pessoa
	 * flag = 2, alteração de pessoa
	 * @param index, caso seja para edição, o index passa a posição da pessoa dentro da lista
	 * @return verdadeiro ou falso, caso a operação seja realizada ou não
	 */
	
	public boolean inserirEditarPessoa(String[] dadosPessoa, String[] endereco, int flag, int index) {
		
		//   cpf composto somente de numeros       dd composto somente de numeros       somente numeros                          minimo de 9 numeros
		if(!dadosPessoa[1].matches("[0-9.-]+") || !dadosPessoa[3].matches("[0-9]+") || !dadosPessoa[4].matches("[0-9]+") || !(dadosPessoa[4].length() == 9)
				|| !dadosPessoa[2].contains("@")) {
			return false;
		} else {
			Pessoa p = new Pessoa(dadosPessoa[0], dadosPessoa[1], dadosPessoa[2], 
					new Telefone((short) Integer.parseInt(dadosPessoa[3]), Integer.parseInt(dadosPessoa[4])), 
					new Endereco(endereco[0], endereco[1], endereco[2], endereco[3], endereco[4], endereco[5], endereco[6], endereco[7]));
			// 1 -> insere nova, 2 -> edita alguma
			if(flag == 1)
				d.inserirPessoa(p);
			else if (flag == 2)
				d.getPessoas().set(index, p);
			return true;
		}
	}
	
	/**
	 * Método para inserir ou editar informações na lista de apartamentos
	 * @param dadosApartamento, dados necessário para criar um objeto tipo Apartamento
	 * @param endereco, dados necessário para criar um objeto tipo Endereço
	 * @param info, dados específicos de objeto tipo Apartamento
	 * @param flag, indicador para determinar se a ação será de inserção ou de edição
	 * flag = 1, inserção de novo apartamento
	 * flag = 2, alteração de apartamento
	 * @param index, caso seja para edição, o index passa a posição do apartamento dentro da lista
	 * @return verdadeiro ou falso, caso a operação seja realizada ou não
	 */
	
	public boolean inserirEditarApartamento(String[] dadosApartamento, String[] endereco, boolean[] info, int i, int flag, int index) {
		
		if(!dadosApartamento[1].matches("[0-9.]+") || !dadosApartamento[2].matches("[1-9]+") || !dadosApartamento[3].matches("[1-9]+") 
				|| !dadosApartamento[4].matches("[1-9]+") || !dadosApartamento[6].matches("[1-9]+")) {
			return false;
		} else {
			Pessoa p = d.getPessoas().get(i);
			Apartamento ap = new Apartamento(dadosApartamento[0], Double.parseDouble(dadosApartamento[1]), 
					new Descricao( Integer.parseInt(dadosApartamento[2]), Integer.parseInt(dadosApartamento[3]), Integer.parseInt(dadosApartamento[4]),
							Integer.parseInt(dadosApartamento[5]), Integer.parseInt(dadosApartamento[6])), info[0], info[1], info[2], info[3], p, 
					new Endereco(endereco[0], endereco[1], endereco[2], endereco[3], endereco[4], endereco[5], endereco[6], endereco[7]));
			// 1 -> insere nova, 2 -> edita alguma
			if(flag == 1)
				d.inserirApartamento(ap);
			else if(flag == 2)
				d.getApartamentos().set(index, ap);
			return true;
		}
	}
	
	/**
	 * Método para inserir ou editar informações na lista de casas
	 * @param dadosCasa, dados necessário para criar um objeto tipo Casa
	 * @param endereco, dados necessário para criar um objeto tipo Endereço
	 * @param info, dados específicos de objeto tipo Casa
	 * @param flag, indicador para determinar se a ação será de inserção ou de edição
	 * flag = 1, inserção de nova casa
	 * flag = 2, alteração de casa
	 * @param index, caso seja para edição, o index passa a posição da casa dentro da lista
	 * @return verdadeiro ou falso, caso a operação seja realizada ou não
	 */
	
	public boolean inserirEditarCasa(String[] dadosCasa, String[] endereco, boolean[] info, int i, int flag, int index) {
	
		if(!dadosCasa[1].matches("[0-9.]+") || !dadosCasa[3].matches("[1-9]+") || !dadosCasa[4].matches("[1-9]+") 
				|| !dadosCasa[5].matches("[1-9]+") || !dadosCasa[6].matches("[1-9]+") || !dadosCasa[7].matches("[1-9]+")) {
			return false;
		} else {
			Pessoa p = d.getPessoas().get(i);
			Casa casa = new Casa(dadosCasa[0], Double.parseDouble(dadosCasa[1]), dadosCasa[2], 
					new Descricao( Integer.parseInt(dadosCasa[3]), Integer.parseInt(dadosCasa[4]), Integer.parseInt(dadosCasa[5]),
							Integer.parseInt(dadosCasa[6]), Integer.parseInt(dadosCasa[7])), info[0], info[1], p, 
					new Endereco(endereco[0], endereco[1], endereco[2], endereco[3], endereco[4], endereco[5], endereco[6], endereco[7]));
			
			// 1 -> insere nova, 2 -> edita alguma
			if(flag == 1) {
				d.inserirCasa(casa);
			}else if (flag == 2){
				d.getCasas().set(index, casa);
			}

			return true;
		}
	}
	
	/**
	 * Método para remover uma pessoa de dentro da lista de pessoas
	 * @param i, o index da pessoa que deve ser removida
	 * @return verdadeiro ou falso, caso a operação seja realizada ou não
	 */
	
	public boolean removerPessoa(int i) {
		for(Reserva reserva : d.getReservas()) {
			if(reserva.getPessoa().equals(d.getPessoas().get(i))) {
				return false; // Pessoa esta com uma reserva pendente ainda
			}
		}
		d.getPessoas().remove(i);
		return true;
	}
	
	/**
	 * Método para remvoer um Apartamento de dentro da lista de apartamentos
	 * @param i, o index do apartamento a ser removido
	 * @return verdadeiro ou falos, caso a operação seja realizada ou não
	 */
	
	public boolean removerApartamento(int i) {
		for(Reserva reserva : d.getReservas()) {
			if(reserva.getImovel().equals(d.getApartamentos().get(i))) {
				return false; // Pessoa esta com uma reserva pendente ainda
			}
		}
		d.getApartamentos().remove(i);
		return true;
	}
	
	/**
	 * Método para remover uma Casa de dentro da lista de casas
	 * @param i, o index da casa a ser removida
	 * @return verdadeiro ou falso, caso a operação seja realizada ou não
	 */
	
	public boolean removerCasa(int i) {
		for(Reserva reserva : d.getReservas()) {
			if(reserva.getImovel().equals(d.getCasas().get(i))) {
				return false; // Pessoa esta com uma reserva pendente ainda
			}
		}
		d.getCasas().remove(i);
		return true;
	}
	
	/**
	 * Método para remover uma Reserva de dentro da lista de reservas
	 * @param i, o index da reserva a ser removida
	 * @return verdadeiro
	 */
	
	public boolean removerReserva(int i) {
		d.getReservas().remove(i);
		return true;
	}
	
	/**
	 * Método para retorno da lista de nomes das casas cadastradas no sistema
	 * @return lista com os títulos das casas cadastradas
	 */
	
	public String[] listaCasas() {
		String[] lista = new String[d.getCasas().size()];
		int i = 0;
		
		for(Casa casa : d.getCasas()) {
			lista[i] = casa.getTitulo();
			i++;
		}
		
		
		return lista;
	}
	
	/**
	 * Método para retorno da lista de nomes dos apartamentos cadastrados no sistema
	 * @return lista com os títulos dos apartamentos cadastrados
	 */
	
	public String[] listaAps() {
		String[] lista = new String[d.getApartamentos().size()];
		int i = 0;
		
		for(Apartamento ap : d.getApartamentos()) {
			lista[i] = ap.getTitulo();
			i++;
		}
		
		
		return lista;
	}
	
	/**
	 * Método para retorno da lista de nomes dos usuário cadastrados no sistema
	 * @return lista com os nomes das pesosas cadastradas
	 */
	
	public String[] listaUsuarios() {
		String[] lista = new String[d.getPessoas().size()];
		int i = 0;
		
		for(Pessoa p : d.getPessoas()) {
			lista[i] = p.getNome();
			i++;
		}	
		return lista;
	}
	
	public String[] verificarDisponibilidade(String dataInicial, String dataFinal, int indexImovel, int tipo ) {
		
		Imovel imovel = null;
		Calendar calI = (Calendar) Calendar.getInstance();
		Calendar  calF = (Calendar) Calendar.getInstance();
		String[] dataOcupada = new String[90];
		
		int k = 0;
		
		switch(tipo) { //  pegando o imovel de acordo com o tipo de imovel selecionado
		case 1 -> imovel = d.getCasas().get(indexImovel);
		case 2 -> imovel = d.getApartamentos().get(indexImovel);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try { 
			calI.setTime(sdf.parse(dataInicial));
			calF.setTime(sdf.parse(dataFinal));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		for(int i = (calI.get(Calendar.DAY_OF_YEAR)-1); i<= (calF.get(Calendar.DAY_OF_YEAR)-1);i++) { 
			// verificando a disponibilidade no intervalo fornecido
			
			if(imovel.getDisponibilidade(i).getOcupacao()) {
				dataOcupada[k] = imovel.getDisponibilidade(i).getData().toString();
				k++;
			}
			
		}
		String [] data = new String[k+1];
		for(int z = 0; z < k; z++) data[z] = dataOcupada[z];
		return data; // retornando as datas que nao estavam disponiveis, se estiver disponivel retorna null
	}
	
	/**
	 * Método para inserção de uma nova reserva dentro da lista de reservas
	 * @param dataInicial, data inicial do período de reserva
	 * @param dataFinal, data final do período de resera
	 * @param indexImovel, índice do imóvel a ser reservado, dentro da lista específica do tipo de imóvel
	 * @param indexPessoa, índice do locatário da reserva
	 * @param tipo, tipo do imóvel. 1 para Casa, 2 para Apartamento
	 */
	
	public void inserirReserva(String dataInicial, String dataFinal, int indexImovel, int indexPessoa, int tipo) {
		
		Imovel imovel = null;
		Calendar calI = (Calendar) Calendar.getInstance();
		Calendar  calF = (Calendar) Calendar.getInstance();
		Pessoa locatario = d.getPessoas().get(indexPessoa);
		Periodo periodo = new Periodo(dataInicial, dataFinal);
		
		switch(tipo) {
		case 1 -> imovel = d.getCasas().get(indexImovel);
		case 2 -> imovel = d.getApartamentos().get(indexImovel);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data_inicial = null;
		Date data_final = null;
		
		try {
			data_inicial = sdf.parse(dataInicial);
			data_final = sdf.parse(dataFinal);
			calI.setTime(data_inicial);
			calF.setTime(data_final);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		for(int i = (calI.get(Calendar.DAY_OF_YEAR)-1); i<= (calF.get(Calendar.DAY_OF_YEAR)-1);i++) {
			imovel.getDisponibilidade(i).setOcupacao(true);
		}
		
		Reserva reserva = new Reserva(imovel,locatario, periodo);
		d.getReservas().add(reserva);
		
			
	}
		
	/**
	 * Método para obter a posição da casa dentro da lista de casas cadastradas a partir do nome de entrada
	 * @param titulo da casa
	 * @return a posição da casa dentro da lista
	 */
	
	public int getCasaPos(String tituloCasa) {
		int posi = 0;
		for(Casa casa: d.getCasas()) {
			if(casa.getTitulo().equals(tituloCasa))
				return posi;	
			posi++;
		}
		return -1;
	}
	
	/**
	 * Método para obter a posição do apartamento dentro da lista de apartamentos cadastrados a partir do nome de entrada
	 * @param titulo do apartamento
	 * @return a posição do apartamento dentro da lista
	 */
	
	public int getApPos(String tituloAp) {
		int posi = 0;
		for(Apartamento ap: d.getApartamentos()) {
			if(ap.getTitulo().equals(tituloAp))
				return posi;	
			posi++;
		}
		return -1;
	}
	
	/**
	 * Método para obter a posição da pessoa dentro da lista de pessoas cadastradas a partir do nome de entrada
	 * @param nome da pessoa
	 * @return a posição da pessoa dentro da lista
	 */
	public int getPessoaPos(String nome) {
		int posi = 0;
		for(Pessoa p: d.getPessoas()) {
			if(p.getNome().equals(nome))
				return posi;	
			posi++;
		}
		return -1;
	}
}