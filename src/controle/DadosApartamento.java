package controle;

import java.util.Scanner;
import modelo.Apartamento;

public class DadosApartamento extends DadosImoveis{
	
	static Scanner ler = new Scanner(System.in);

	@Override
	public void addDados(int i) {
		
		//Chamando a funcao da classe herdada
		super.addDados(i);
		
		/*Pegando o imovel que foi criado na classe super para continuar o cadastrado de dados,
		 * o cast foi feito para o tipo apartamento pois o array list do tipo imovel entao ele
		 * retorna um objeto do tipo imovel, mas queremos adicionar dados especificos da classe
		 * Apartamento
		 * */
		Apartamento imovel =  (Apartamento) listaImovel.get(listaImovel.size()-1);
		
		//Pegando dados especificos da classe e gravando no imovel
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
