public class Dados {
	private static Casa[] catalogoCasas = new Casa[100];
	private static Apartamento[] catalogoApartamentos = new Apartamento[100];
	private static Reserva[] catalogoReservas = new Reserva[100];
	private static Pessoa[] catalogoPessoas = new Pessoa[100];
	
	
	public static Casa[] getCatalogoCasas() {
		return catalogoCasas;
	}
	public static void setCatalogoCasas(Casa casa, int posi) {
		Dados.catalogoCasas[posi] = casa;
	}
	public static Apartamento[] getCatalogoApartamentos() {
		return catalogoApartamentos;
	}
	public static void setCatalogoApartamentos(Apartamento apartamento, int posi) {
		Dados.catalogoApartamentos[posi] = apartamento;
	}
	public static Pessoa[] getCatalogoPessoas() {
		return catalogoPessoas;
	}
	public static void setCatalogoPessoas(Pessoa pessoa, int posi) {
		Dados.catalogoPessoas[posi] = pessoa;
	}
	
	public static int encontraPrimeiroNulo(Imovel[] lista) {
		for(int posi = 0; posi< 100; posi++) {
			if(lista[posi] == null) {
				return posi;
			}
		}
		System.out.println("Catálogo cheio ! !");
		return 0;
	}	
	public static int encontraPrimeiroNulo(Pessoa[] lista) {
		for(int posi = 0; posi< 100; posi++) {
			if(lista[posi] == null) {
				return posi;
			}
		}
		System.out.println("Catálogo cheio ! !");
		return 0;
	}	
	public static int retornaPosicaoReal(int posicaoLista, Imovel[] lista) {
		int identificador = 0;
		for(int i = 0;i < 100; i++) {
			if(lista[i] != null) {
				identificador++;
			}
			if(identificador == posicaoLista) {
				return i;
			}
		}
		return 0;
	}
	public static int retornaPosicaoReal(int posicaoLista, Pessoa[] lista) {
		int identificador = 0;
		for(int i = 0;i < 100; i++) {
			if(lista[i] != null) {
				identificador++;
			}
			if(identificador == posicaoLista) {
				return i;
			}
		}
		return 0;
	}
	
	public static boolean isVazia(Imovel[] lista) {
		for(int i = 0; i< 100;i++) {
			if(lista[i] != null) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isVazia(Reserva[] lista) {
		for(int i = 0; i< 100;i++) {
			if(lista[i] != null) {
				return false;
			}
		}
		return true;
	}

	public static boolean isVazia(Pessoa[] lista) {
		for(int i = 0; i< 100;i++) {
			if(lista[i] != null) {
				return false;
			}
		}
		return true;
	}
}
