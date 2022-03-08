package controle;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Pessoa;
import modelo.Telefone;

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
		
		String nome,email,cpf;
		short ddd;
		int numero;
		
		System.out.println("\nInsira o nome do usuário:");
		nome = ler.nextLine();
		
		System.out.println("\nInsira o cpf do usuário (Use pontos e hífen)");
		cpf = ler.nextLine();
		
		System.out.println("\nInsira o email do usuário");
		email = ler.nextLine();
		
		System.out.println("\nInsira o DDD do telefone: ");
		ddd = ler.nextShort();
		
		System.out.println("\nInsira o telefone do usuario (sem o DDD)");
		numero = ler.nextInt();
		
		Telefone telefone = new Telefone(ddd,numero);
		
		Pessoa p = new Pessoa(nome, cpf, telefone, email);
		
		
		listaPessoa.add(p);
		p.setId_pessoa(listaPessoa.size());
	
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
	
	public Pessoa get(int index) {
		return listaPessoa.get(index);
		
	}
	
}
