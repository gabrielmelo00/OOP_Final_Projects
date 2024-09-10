package mc322.lab05b;

public class Pe�a {
	protected int i, j;
	protected char cor;
	
	public Pe�a(int i, int j, char cor) {
		this.i = i;
		this.j = j;
		this.cor = cor;
	}
	
	public char getCor() {
		return cor;
	}
	
	public boolean [] validaMovimento(char[] caminho) {
		// saida = [true = movimento valido, true = ataque/false = avan�o]
		boolean [] saida = {true, true};
		int tamanho = caminho.length;
		
		
		// entrada inv�lida
		if(tamanho <= 2) {
			saida[0] = false;
			saida[1] = false;
			return saida;
		}
		
		//target n�o pode estar ocupado por uma pe�a
		if(caminho[tamanho - 3] != '-') {
			saida[0] = false;
		}
		
		return saida;
	}
}

