package controle;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Descricao;
import modelo.Imovel;
import modelo.Apartamento;
import modelo.Casa;

public abstract class DadosImoveis implements Dados {
	
	static Scanner ler = new Scanner(System.in);
	protected ArrayList<Imovel> listaImovel = new ArrayList<Imovel>();
	
	@Override
	public void listar() {
		if(listaImovel.isEmpty()){
			System.out.println("Não há apartamentos cadastrados no sistema");
		}else{
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
		
		Descricao desc  = new Descricao(qtdQuartos, qtdCamas, qtdBanheiros, qtdAndar, qtdHospedes);
		Imovel imovel = ( i > 0) ? (new Casa(nome, valor, desc)):(new Apartamento(nome, valor, desc));
		
		listaImovel.add(imovel);
		imovel.setId(listaImovel.size());
	}
	
	@Override
	public void deletar() {
		
		int oldId;
		this.listar();
		System.out.println("Digite o código do item que deseja excluir");
		int escolha = ler.nextInt();
		listaImovel.remove(escolha-1);
		for(Imovel casa : listaImovel) {
			if( (oldId = casa.getId()) > escolha ) {
				casa.setId(oldId-1);
			}
		}
		
	}
	
	@Override
	public void addDados(Object imovel) {
		listaImovel.add((Imovel) imovel);
		((Imovel) imovel).setId(listaImovel.size());
	}
	
	@Override
	public Imovel get(int index) {
		
		return listaImovel.get(index);
	}
	
}
