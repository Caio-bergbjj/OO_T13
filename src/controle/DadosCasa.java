package controle;

import java.util.Scanner;
import modelo.Casa;

public class DadosCasa extends DadosImoveis {
	
	static Scanner ler = new Scanner(System.in);
	
	@Override
	public void addDados(int i) {
		
		//Chamando a funcao da classe herdada
		super.addDados(i);
		
		/*Pegando o imovel que foi criado na classe super para continuar o cadastrado de dados,
		 * o cast foi feito para o tipo casa pois o array list do tipo imovel entao ele
		 * retorna um objeto do tipo imovel, mas queremos adicionar dados especificos da classe
		 * Casa
		 * */
		Casa imovel = (Casa) listaImovel.get(listaImovel.size()-1);
		
		//Pegando dados especificos da classe e gravando no imovel
		System.out.println("\nA casa tem piscina: (Y/N ) ");
		String op = ler.next().toUpperCase();
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

}
