package modelo;
import java.util.Scanner;

import controle.Dados;

public class Apartamento extends Imovel{
	
	
	private boolean temElevador;
	private boolean temSacada;
	private boolean temGaragem;
	private boolean temCondominio;
	
	public boolean getTemElevador() {
		return temElevador;
	}
	public void setTemElevador(boolean temElevador) {
		this.temElevador = temElevador;
	}
	public boolean getTemSacada() {
		return temSacada;
	}
	public void setTemSacada(boolean temSacada) {
		this.temSacada = temSacada;
	}
	public boolean getTemGaragem() {
		return temGaragem;
	}
	public void setTemGaragem(boolean temGaragem) {
		this.temGaragem = temGaragem;
	}
	public boolean getTemCondominio() {
		return temCondominio;
	}
	public void setTemCondominio(boolean temCondominio) {
		this.temCondominio = temCondominio;
	}

	public static void cadastrar(Apartamento ap) {
		int posicao = Dados.encontraPrimeiroNulo(Dados.getCatalogoApartamentos());
		
		Dados.setCatalogoApartamentos(ap, posicao);
	}
	public static void listar() {
		int identificador = 0;
		if(Dados.isVazia(Dados.getCatalogoApartamentos())) {
			System.out.println("Não há apartamentos cadastradas no sistema");
		}else {		
			for(int i = 0;i<100;i++) {
				if(Dados.getCatalogoApartamentos()[i] != null) {
					identificador++;
					System.out.println(identificador + "\t" + Dados.getCatalogoApartamentos()[i].getTitulo());
				}
			}
		}
		
	}
	public static void deletar() {
		Scanner ler = new Scanner(System.in);
		
		if(Dados.isVazia(Dados.getCatalogoApartamentos())) {
			System.out.println("Não há apartamentos cadastrados no sistema");
		}else {
			Apartamento.listar();
			System.out.println("Digite o código do item que deseja excluir");
			int escolha = ler.nextInt();
			Dados.setCatalogoApartamentos(null, Dados.retornaPosicaoReal(escolha, Dados.getCatalogoApartamentos()));		
		}
		
		
		
	}
} 
