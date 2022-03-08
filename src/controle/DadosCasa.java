package controle;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Descricao;

public class DadosCasa {
	
	static Scanner ler = new Scanner(System.in);
	private ArrayList<Casa> listaCasa = new ArrayList<Casa>();
	
	public void listar() {
		if(listaCasa.isEmpty()){
			System.out.println("N�o h� casas cadastradas no sistema");
		}else{
			for(Casa casa : listaCasa) {
				System.out.println(casa.getId() + " - " + casa.getTitulo() + "\n");
			}
		}
	}
	
	public void addCasa() {
		
		int qtdQuartos, qtdCamas, qtdBanheiros, qtdAndar, qtdHospedes;
		String nome;
		Double valor;
		
		System.out.println("\nInforme o nome do im�vel:");
		ler.next();
		nome = ler.nextLine();
		System.out.println("\nQuantos quartos tem: ");	
		qtdQuartos = ler.nextInt();
		System.out.println("\nQuantas camas tem: ");	
		qtdCamas = ler.nextInt();
		System.out.println("\nQuantos banheiros tem: ");	
		qtdBanheiros = ler.nextInt();
		System.out.println("\nQuantos andares tem: ");	
		qtdAndar = ler.nextInt();
		System.out.println("\nQuantos h�spedes cabe no im�vel: ");	
		qtdHospedes = ler.nextInt();
		System.out.println("\nInforme o valor do im�vel:");
		valor = ler.nextDouble();
		
		Descricao desc  = new Descricao(qtdQuartos, qtdCamas, qtdBanheiros, qtdAndar, qtdHospedes);
		Casa imovel = new Casa(nome, valor, desc);
		
		imovel.setId(listaCasa.size()+1);
		listaCasa.add(imovel);
		
	}
	
	public void deletar() {
		
		int oldId;
		this.listar();
		System.out.println("Digite o c�digo do item que deseja excluir");
		int escolha = ler.nextInt();
		listaCasa.remove(escolha-1);
		for(Casa casa : listaCasa) {
			if( (oldId = casa.getId()) > escolha ) {
				casa.setId(oldId-1);
			}
		}
		
	}
	
	public Object get(int index) {
		
		return listaCasa.get(index);
	}
	

	

}
