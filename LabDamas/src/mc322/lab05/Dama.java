package mc322.lab05;

public class Dama {
	private int i, j;
	private char cor;
	
	public Dama(int i, int j, char cor) {
		this.i = i;
		this.j = j;
		this.cor = cor;
	}
	
	public char getCor() {
		return cor;
	}
	
	public boolean [] validaMovimento(char[] caminho) {
		boolean [] saida = {true, true};
		int tamanho = caminho.length;
		int i_target = Character.getNumericValue(caminho[tamanho -2]);
		int j_target = Character.getNumericValue(caminho[tamanho -1]);
		
		return(saida);
	}

}