package controle;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Descricao;
import modelo.Imovel;
import modelo.Apartamento;
import modelo.Casa;

//Classe de Dados para imoveis
public abstract class DadosImoveis implements Dados {
	
	
	static Scanner ler = new Scanner(System.in);
	
	//Criando um array list, do tipo imovel, para salvar os dados dos imoveis
	protected ArrayList<Imovel> listaImovel = new ArrayList<Imovel>();
	
	@Override
	public void listar() {
		//Verficando se existe imoveis cadastrados
		if(listaImovel.isEmpty()){
			System.out.println("Não há apartamentos cadastrados no sistema");
		}else{
			//Pegando cada imovel do array list e printando o nome e a Id do imovel
			for(Imovel apartamento : listaImovel) { 
				System.out.println(apartamento.getId() + " - " + apartamento.getTitulo() + "\n");
			}
		}
	}
	
	@Override
	public void addDados(int i) {
		
		int qtdQuartos, qtdCamas, qtdBanheiros, qtdAndar, qtdHospedes;
		final String nome;
		Double valor;
		
		//Pegando os dados comuns dos imoveis (Casa e Apartamento) 
		System.out.println("\nInforme o nome do imóvel:");
		nome = ler.nextLine();
		System.out.println("\nQuantos quartos tem: ");	
		qtdQuartos = ler.nextInt();
		System.out.println("\nQuantas camas tem: ");	
		qtdCamas = ler.nextInt();
		System.out.println("\nQuantos banheiros tem: ");	
		qtdBanheiros = ler.nextInt();
		System.out.println("\nQuantos andares tem: ");	
		qtdAndar = ler.nextInt();
		System.out.println("\nQuantos hóspedes cabe no imóvel: ");	
		qtdHospedes = ler.nextInt();
		System.out.println("\nInforme o valor do imóvel:");
		valor = ler.nextDouble();
		
		//Criando o objeto de descrição do imovel e o objeto imovel
		Descricao desc  = new Descricao(qtdQuartos, qtdCamas, qtdBanheiros, qtdAndar, qtdHospedes);
		
		// Cria o imovel do tipo requrido; Casa para i = 1 , Apartamento para i != 1;  
		Imovel imovel = ( i == 1) ? (new Casa(nome, valor, desc)):(new Apartamento(nome, valor, desc));
		
		listaImovel.add(imovel); // adicionando o imovel no array list
		imovel.setId(listaImovel.size()); // colocando o Id como a posição + 1 no array list  
	}
	
	@Override
	public void deletar() {
		
		int oldId;
		this.listar(); // Printa a lista de imoveis para escolher o que deseja excluir;
		System.out.println("Digite o código do item que deseja excluir");
		int escolha = ler.nextInt();
		listaImovel.remove(escolha-1); // Posicao no array (Id do imovel - 1)
		for(Imovel casa : listaImovel) {
			// Alterando os ID's dos imoveis que estao depois do imovel deletado para posicao manter a lógica  
			if( (oldId = casa.getId()) > escolha ) {
				casa.setId(oldId-1);
			}
		}
		
	}
	
	@Override
	public void addDados(Object imovel) {
		//Cadastrando os imoveis que serao pre cadastrados 
		listaImovel.add((Imovel) imovel);
		((Imovel) imovel).setId(listaImovel.size());
	}
	
	@Override
	public Imovel get(int index) {
		
		//Pegando o imovel na posicao requerida
		return listaImovel.get(index);
	}
	
}
