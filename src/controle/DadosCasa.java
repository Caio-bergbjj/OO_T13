package controle;

import java.util.Scanner;
import modelo.Casa;

public class DadosCasa extends DadosImoveis {
	
	static Scanner ler = new Scanner(System.in);
	
	@Override
	public void addDados(int i) {
		super.addDados(i);
		
		Casa imovel = (Casa) listaImovel.get(listaImovel.size()-1);
		
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
