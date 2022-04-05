package modelo;

public class Pessoa {
	private int id_pessoa; 
	private String nome; //0
	private String cpf; //1
	private String email; //2
	private Endereco endereco; 
	private Telefone telefone; //3, 4
	
	
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
	
	public Pessoa(String nome, String cpf, String email, Telefone telefone, Endereco endereco){
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	

	
}
