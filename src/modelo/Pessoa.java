package modelo;
import java.util.Scanner;

import controle.Dados;

public class Pessoa {
	private int id_pessoa;
	private String nome;
	private String cpf;
	private String email;
	private Endereco endereco;
	private Telefone telefone;
	
	
	public int getId_pessoa() {
		return id_pessoa;
	}
	
	public void setId_pessoa(int id_pessoa) {
		this.id_pessoa = id_pessoa;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		
		this.endereco = endereco;
	}
	
	public Telefone getTelefone() {
		return telefone;
	}
	
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
		
	public Pessoa(String nome, String cpf, String email){
		this.nome = nome;
		this.cpf = cpf;
//		this.email = email;
////		this.endereco = endereco;
////		this.telefone = telefone;
	}
	
	public static void cadastrar(Pessoa p) {
		int posicao = Dados.encontraPrimeiroNulo(Dados.getCatalogoPessoas());
		
		Dados.setCatalogoPessoas(p, posicao);
	}
	
	public static void listar() {
		if(Dados.isVazia(Dados.getCatalogoPessoas())) {
			System.out.println("Não há pessoas cadastradas no Sistema");
		}else {	
			System.out.println("\n==== Usuários ====\n");
			int identificador = 0;
			for(int i = 0;i<100;i++) {
				if(Dados.getCatalogoPessoas()[i] != null) {
					identificador++;
					System.out.println(identificador + "\t" + Dados.getCatalogoPessoas()[i].getNome());
				}
			}
			
		}
	}
	
	public static void deletar() {
		Scanner ler = new Scanner(System.in);
		
		if(Dados.isVazia(Dados.getCatalogoPessoas())) {
			System.out.println("Não há pessoas cadastradas no sistema");
		}else {
			
			Pessoa.listar();
			System.out.println("Digite o código do item que deseja excluir");
			int escolha = ler.nextInt();
			Dados.setCatalogoPessoas(null, Dados.retornaPosicaoReal(escolha, Dados.getCatalogoPessoas()));
		}
		
	}
	
}
