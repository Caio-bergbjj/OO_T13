package controle;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Pessoa;

public class DadosPessoa {
	
	static Scanner ler = new Scanner(System.in);
	private ArrayList<Pessoa> listaPessoa = new ArrayList<Pessoa>();
	
	public void listar() {
		if(listaPessoa.isEmpty()){
			System.out.println("\nNão há usuários cadastrados no sistema");
		}else{
			for(Pessoa pessoa : listaPessoa) {
				System.out.println(pessoa.getId_pessoa() + " - " + pessoa.getNome() + "\n");
			}
		}
	}
	
	public void addPessoa() {
		
		System.out.println("\nInsira o nome do usuário:");
		ler.next();
		String nome = ler.nextLine();
		
		System.out.println("\nInsira o cpf do usuário (Use pontos e hífen)");
		String cpf = ler.nextLine();
		
		System.out.println("\nInsira o email do usuário");
		String email = ler.nextLine();
		
		Pessoa p = new Pessoa(nome, cpf, email);
		
		listaPessoa.add(p);
	
	}
	
	public void deletar() {
		
		int oldId;
		this.listar();
		
		System.out.println("Digite o código do item que deseja excluir");
		int escolha = ler.nextInt();
		listaPessoa.remove(escolha-1);
		for(Pessoa pessoa : listaPessoa) {
			if( (oldId = pessoa.getId_pessoa()) > escolha ) {
				pessoa.setId_pessoa(oldId-1);;
			}
		}
		
	}
	
	public Object get(int index) {
		return listaPessoa.get(index);
		
	}
	
}
