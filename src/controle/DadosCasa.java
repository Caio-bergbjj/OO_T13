package controle;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Casa;
import modelo.Descricao;

public class DadosCasa {
	
	static Scanner ler = new Scanner(System.in);
	private ArrayList<Casa> listaCasa = new ArrayList<Casa>();
	
	public void listar() {
		if(listaCasa.isEmpty()){
			System.out.println("Não há casas cadastradas no sistema");
		}else{
			for(Casa casa : listaCasa) {
				System.out.println(casa.getId() + " - " + casa.getTitulo() + "\n");
			}
		}
	}
	
	public void addCasa() {
		
		int qtdQuartos, qtdCamas, qtdBanheiros, qtdAndar, qtdHospedes;
		String nome,op;
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
		Casa imovel = new Casa(nome, valor, desc);
		
		listaCasa.add(imovel);
		imovel.setId(listaCasa.size());
		
		System.out.println("\nA casa tem piscina: (Y/N ) ");
		op = ler.next().toUpperCase();
		switch(op.charAt(0)) {
		case 'Y' -> imovel.setTemPiscina(true);
		case 'N' -> imovel.setTemPiscina(false);
		}
		
		System.out.println("\nA casa tem Wifi: (Y/N ) ");
		op = ler.next().toUpperCase();
		switch(op.charAt(0)) {
		case 'Y' -> imovel.setTemWifi(true);
		case 'N' -> imovel.setTemWifi(false);
		}
		
	}
	
	public void addCasa(Casa casa) {
		listaCasa.add(casa);
		casa.setId(listaCasa.size());
	}
	
	public void deletar() {
		
		int oldId;
		this.listar();
		System.out.println("Digite o código do item que deseja excluir");
		int escolha = ler.nextInt();
		listaCasa.remove(escolha-1);
		for(Casa casa : listaCasa) {
			if( (oldId = casa.getId()) > escolha ) {
				casa.setId(oldId-1);
			}
		}
		
	}
	
	public Casa get(int index) {
		
		return listaCasa.get(index);
	}
	

	

}
