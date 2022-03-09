package controle;

import java.util.Scanner;
import modelo.Apartamento;

public class DadosApartamento extends DadosImoveis{
	
	static Scanner ler = new Scanner(System.in);

	@Override
	public void addDados(int i) {
		super.addDados(i);
		
		Apartamento imovel =  (Apartamento) listaImovel.get(listaImovel.size()-1);
		
		System.out.println("\nO local do apartamento possui elevador: (Y/N ) ");
		String op = ler.next().toUpperCase();
		switch(op.charAt(0)) {
		case 'Y' -> imovel.setTemElevador(true);
		case 'N' -> imovel.setTemElevador(false);
		}
		
		System.out.println("\nO apartamento possui sacada: (Y/N ) ");
		op = ler.next().toUpperCase();
		switch(op.charAt(0)) {
		case 'Y' -> imovel.setTemElevador(true);
		case 'N' -> imovel.setTemElevador(false);
		}
		
		System.out.println("\nO apartamento possui garagem: (Y/N ) ");
		op = ler.next().toUpperCase();
		switch(op.charAt(0)) {
		case 'Y' -> imovel.setTemElevador(true);
		case 'N' -> imovel.setTemElevador(false);
		}
		
		System.out.println("\nO apartamento fica em um condomínio: (Y/N ) ");
		op = ler.next().toUpperCase();
		switch(op.charAt(0)) {
		case 'Y' -> imovel.setTemElevador(true);
		case 'N' -> imovel.setTemElevador(false);
		}
	}
}
