package teste;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controle.ControleDados;

/**
 * Classe para testes unitários dos metodos do ControleDados
 * @author Rafael Nobre e Caio Berg
 * @version 1.0 (Abr 07)
 * @
 * */

class TesteControleDados {
	
	private ControleDados dados;
	String[] endereco;
	
	/**
	 * Inicialização de Dados para o uso nos testes
	 * 
	 * */
	
	@BeforeEach
	public void inicializar() {
		this.dados = new ControleDados();
		this.endereco = new String[]{"70650-236", "Brasilia", "DF", "Cruzeiro", "0", "12" , "Apartamento", "403"};
	}
	/**
	 * Teste de inserir uma nova pessoa na base de dados 
	 * 
	 * */
	
	@Test
	void testInserirPessoa() {
		String[] dadosPessoa = {"Caio Berg", "831.066.245-66", "caioteste24@gmail.com", "61", "997843518"};
		
		assertTrue(dados.inserirEditarPessoa(dadosPessoa, endereco, 1, -1));
		
		dadosPessoa[2] = dadosPessoa[2].replace("@", "1"); // Colocando email invalido
		assertFalse(dados.inserirEditarPessoa(dadosPessoa, endereco, 1, -1));
		
		dadosPessoa[2] = dadosPessoa[2].replace("1", "@");
		dadosPessoa[4] = dadosPessoa[3]; // Numero invalido 
		assertFalse(dados.inserirEditarPessoa(dadosPessoa, endereco, 1, -1));
		
		
	}
	
	/**
	 * Teste de inserir um novo apartamento na base de dados 
	 * 
	 * */
	
	@Test
	void testInserirApartamento() {
		String[] dadosApartamento = {"Ap do Rio", "1000.00","2","3", "2", "2", "4"};
		boolean[] info = {true, false, true, true};

		assertTrue(dados.inserirEditarApartamento(dadosApartamento, endereco, info, 0, 1, -1));
		
		dadosApartamento[2] = dadosApartamento[2].concat("s");
		assertFalse(dados.inserirEditarApartamento(dadosApartamento, endereco, info, 0, 1, -1));
		
		
	}

	/**
	 * Teste de inserir uma nova casa na base de dados 
	 * 
	 * */
	
	@Test
	void testInserirCasa() {
		String[] dadosCasa = {"Casa do Rio", "1000.00","Praia","2","3", "2", "2", "4"};
		boolean[] info = {true, false};
		
		assertTrue(dados.inserirEditarCasa(dadosCasa, endereco, info, 0, 1, -1));
		
		dadosCasa[3] = dadosCasa[3].concat("s");
		assertFalse(dados.inserirEditarCasa(dadosCasa, endereco, info, 0, 1, -1));
	}
	
	/**
	 * 
	 * Teste para retorno da posicao da posicao do dado(Casa) se ja estiver cadastrado 
	 * 
	 * */

	@Test
	void testGetCasaPos() {
		
		String nome = "Casa 5";
		int i = dados.getCasaPos(nome);
		
		assertEquals(nome,dados.getCasas().get(i).getTitulo());
		
		nome = "Casa 16"; // nome nao cadastrado
		i = dados.getCasaPos(nome);
		
		assertEquals(-1,i);

	}
	
	/**
	 * 
	 * Teste para retorno da posicao da posicao do dado(Apartamento) se ja estiver cadastrado 
	 * 
	 * */

	@Test
	void testGetApPos() {
		String nome = "Apartamento 6";
		int i = dados.getApPos(nome);
		
		assertEquals(nome,dados.getApartamentos().get(i).getTitulo());
		
		nome = "Apartamento 16"; // nome nao cadastrado
		i = dados.getApPos(nome);
		
		assertEquals(-1,i);
	}
	
	/**
	 * 
	 * Teste para retorno da posicao da posicao do dado(Pessoa) se ja estiver cadastrado 
	 * 
	 * */

	@Test
	void testGetPessoaPos() {
		String nome = "Pessoa 9";
		int i = dados.getPessoaPos(nome);
		
		assertEquals(nome,dados.getPessoas().get(i).getNome());
		
		nome = "Pessoa 17"; // nome nao cadastrado
		i = dados.getPessoaPos(nome);
		
		assertEquals(-1,i);
	}
	
	
	/**
	 * Teste para editar uma pessoa já existente na base de dados 
	 * 
	 * */
	@Test
	void testEditarPessoa() {
		String[] dadosNovaPessoa = {"Caio Berg", "831.066.245-66", "caioteste24@gmail.com", "61", "997843518"};
		
		String nomePessoaAntiga = dados.getPessoas().get(5).getNome();
		
		assertFalse(nomePessoaAntiga.equals(dadosNovaPessoa[0])); // dados diferentes
		
		dados.inserirEditarPessoa(dadosNovaPessoa, endereco, 2, 5);// alterando dados
		
		String nomePessoaAtualizada = dados.getPessoas().get(5).getNome();
		assertTrue(nomePessoaAtualizada.equals(dadosNovaPessoa[0])); //dados deveriam ser iguai
		
		
		
	}
	
	/**
	 * Teste para editar um apartamento já existente na base de dados 
	 * 
	 * */
	
	@Test
	void testEditarApartamento() {
		String[] dadosNovoApartamento = {"Ap do Rio", "1000.00","2","3", "2", "2", "4"};
		boolean[] info = {true, false, true, true};
		
		String nomeApAntigo = dados.getApartamentos().get(6).getTitulo();
		assertFalse(nomeApAntigo.equals(dadosNovoApartamento[0]));
		
		dados.inserirEditarApartamento(dadosNovoApartamento, endereco, info, 0, 2, 6);
		
		String nomeApAtualizado = dados.getApartamentos().get(6).getTitulo();
		assertTrue(nomeApAtualizado.equals(dadosNovoApartamento[0]));
		
		
	}
	
	/**
	 * Teste para editar uma casa já existente na base de dados 
	 * 
	 * */
	
	@Test
	void testEditarCasa() {
		String[] dadosNovaCasa = {"Ap do Rio", "1000.00","Praia","2","3", "2", "2", "4"};
		boolean[] info = {true, false};
		
		String nomeCasaAntiga = dados.getCasas().get(4).getTitulo();
		assertFalse(nomeCasaAntiga.equals(dadosNovaCasa[0]));
		
		dados.inserirEditarCasa(dadosNovaCasa, endereco, info, 3, 2, 4);
		
		String nomeCasaAtualizada = dados.getCasas().get(4).getTitulo();
		assertTrue(nomeCasaAtualizada.equals(dadosNovaCasa[0]));
	}

}
