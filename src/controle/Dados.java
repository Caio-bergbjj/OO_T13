package controle;

public interface Dados {
	
	// Interface para padronizar os dados

	public void listar();// lista os dados do array list
	public void addDados(int i); // recebe um parametro i para definir que tipo de imovel(Casa ou Apartamento) sera inserido
	public void addDados(Object objeto); // Adiciona os pre cadastros 
	public void deletar(); // deleta um objeto
	public Object get(int index); // Pega o objeto na posicao i 
	
}
