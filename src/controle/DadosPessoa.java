package controle;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Pessoa;
import modelo.Telefone;

public class DadosPessoa{
	
	static Scanner ler = new Scanner(System.in);
	
	//Array List do tipo pessoa
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
	
	public void addDados(int i) {
		
		String nome,email,cpf;
		short ddd;
		int numero;
		
		//Pegando os dados das pessoas
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
		
		//Criando o objeto telefone para a pessoas que sera cadastrada
		Telefone telefone = new Telefone(ddd,numero);

		//Criando o objeto pessoa
		Pessoa p = new Pessoa(nome, cpf,email, telefone);
		
		
		listaPessoa.add(p); // adicionando o imovel no array list
		p.setId_pessoa(listaPessoa.size()); // colocando o Id como a posição + 1 no array list 
	
	}
	
	public void addDados(Object pessoa) {
		//Cadastrando as pessoas que serao pre cadastrados 
		listaPessoa.add((Pessoa) pessoa);
		((Pessoa) pessoa).setId_pessoa(listaPessoa.size());
	}
	
	public void deletar() {
		
		int oldId;
		this.listar(); // Printa a lista de imoveis para escolher o que deseja excluir;
		
		System.out.println("Digite o código do item que deseja excluir");
		int escolha = ler.nextInt();
		listaPessoa.remove(escolha-1); // Posicao no array (Id da pessoa - 1)
		for(Pessoa pessoa : listaPessoa) {
			// Alterando os ID's das pessoas que estao depois da pessoa deletado para posicao manter a lógica 
			if( (oldId = pessoa.getId_pessoa()) > escolha ) {
				pessoa.setId_pessoa(oldId-1);;
			}
		}
		
	}
	
	public Pessoa get(int index) {
		//Pegando a pessoa da posicao requerida
		return listaPessoa.get(index);
		
	}
	
}
