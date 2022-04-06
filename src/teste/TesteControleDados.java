package teste;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controle.ControleDados;

class TesteControleDados {
	
	private ControleDados dados;
	String[] endereco;
	
	@BeforeEach
	public void inicializar() {
		this.dados = new ControleDados();
		this.endereco = new String[]{"70650-236", "Brasilia", "DF", "Cruzeiro", "0", "12" , "Apartamento", "403"};
	}

	@Test
	void testInserirEditarPessoa() {
		String[] dadosPessoa = {"Caio Berg", "831.066.245-66", "caioteste24@gmail.com", "61", "997843518"};
		
		assertTrue(dados.inserirEditarPessoa(dadosPessoa, endereco, 1, -1));
		
		dadosPessoa[2] = dadosPessoa[2].replace("@", "1"); // Colocando email invalido
		assertFalse(dados.inserirEditarPessoa(dadosPessoa, endereco, 1, -1));
		
		dadosPessoa[2] = dadosPessoa[2].replace("1", "@");
		dadosPessoa[4] = dadosPessoa[3]; // Numero invalido 
		assertFalse(dados.inserirEditarPessoa(dadosPessoa, endereco, 1, -1));
		
		
	}

	@Test
	void testInserirEditarApartamento() {
		String[] dadosApartamento = {"Ap do Rio", "1000.00","2","3", "2", "2", "4"};
		boolean[] info = {true, false, true, true};

		assertTrue(dados.inserirEditarApartamento(dadosApartamento, endereco, info, 0, 1, -1));
		
		dadosApartamento[2] = dadosApartamento[2].concat("s");
		assertFalse(dados.inserirEditarApartamento(dadosApartamento, endereco, info, 0, 1, -1));
		
		
	}

	@Test
	void testInserirEditarCasa() {
		String[] dadosCasa = {"Ap do Rio", "1000.00","Praia","2","3", "2", "2", "4"};
		boolean[] info = {true, false};
		
		assertTrue(dados.inserirEditarCasa(dadosCasa, endereco, info, 0, 1, -1));
		
		dadosCasa[3] = dadosCasa[3].concat("s");
		assertFalse(dados.inserirEditarCasa(dadosCasa, endereco, info, 0, 1, -1));
	}

	@Test
	void testGetCasaPos() {
		
		String nome = "Casa 5";
		int i = dados.getCasaPos(nome);
		
		assertEquals(nome,dados.getCasas().get(i).getTitulo());
		
		nome = "Casa 16"; // nome nao cadastrado
		i = dados.getCasaPos(nome);
		
		assertEquals(-1,i);

	}

	@Test
	void testGetApPos() {
		String nome = "Apartamento 6";
		int i = dados.getApPos(nome);
		
		assertEquals(nome,dados.getApartamentos().get(i).getTitulo());
		
		nome = "Apartamento 16"; // nome nao cadastrado
		i = dados.getApPos(nome);
		
		assertEquals(-1,i);
	}

	@Test
	void testGetPessoaPos() {
		String nome = "Pessoa 9";
		int i = dados.getPessoaPos(nome);
		
		assertEquals(nome,dados.getPessoas().get(i).getNome());
		
		nome = "Pessoa 17"; // nome nao cadastrado
		i = dados.getPessoaPos(nome);
		
		assertEquals(-1,i);
	}

}
