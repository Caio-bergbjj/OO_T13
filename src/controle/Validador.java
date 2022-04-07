package controle;

import java.util.InputMismatchException;

import javax.swing.text.MaskFormatter;

/**
 * Classe auxiliar para realizar validação e manipulação de strings e máscaras.
 * @author Rafael Nobre
 * @version 1.0 (Apr 22)
 *
 */

public class Validador {
	
	/**
	 * Método para validar cpf de acordo com a estrutura real de geração de Códigos de Pessoa Física
	 * @param CPF
	 * CPF de entrada, no formato 000.000.000-00
	 * @return verdadeiro ou falso, caso o cpf seja ou não válido
	 */
	
	public static boolean validaCpf(String CPF) {
		
		CPF = removeCaracteresEspeciais(CPF);
		
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") || CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555") || CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888") || CPF.equals("99999999999") || (CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0        
				// (48 eh a posicao de '0' na tabela ASCII)        
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}
	
	/**
	 * Método para manipulação de strings, removendo caracteres especiais
	 * Remove caracteres como (".", "-", "/", " ") substituindo por vazio ("")
	 * @param doc, a strinf de entrada
	 * @return string após remoção dos caracteres especiais
	 */
	
	public static String removeCaracteresEspeciais(String doc) {
		if (doc.contains(".")) {
			doc = doc.replace(".", "");
		}
		if (doc.contains("-")) {
			doc = doc.replace("-", "");
		}
		if (doc.contains("/")) {
			doc = doc.replace("/", "");
		}
		if (doc.contains(" ")) {
			doc = doc.replace(" ", "");
		}
		return doc;
	}
	
	/**
	 * Método para geração de um MaskFormatter a partir de uma string
	 * @param Mascara, em formato de string
	 * @return F_Mascara, em formato de MaskFormatter
	 */
	
	public static MaskFormatter Mascara(String Mascara){
        
        MaskFormatter F_Mascara = new MaskFormatter();
        try{
            F_Mascara.setMask(Mascara); //Atribui a mascara
            F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento 
        }
        catch (Exception excecao) {
        excecao.printStackTrace();
        } 
        return F_Mascara;
 }
}
