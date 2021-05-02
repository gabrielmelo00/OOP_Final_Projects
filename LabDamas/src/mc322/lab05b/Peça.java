package mc322.lab05b;

public class Peça {
	protected int i, j;
	protected char cor;
	
	public Peça(int i, int j, char cor) {
		this.i = i;
		this.j = j;
		this.cor = cor;
	}
	
	public char getCor() {
		return cor;
	}
	
	public boolean [] validaMovimento(char[] caminho) {
		// saida = [true = movimento valido, true = ataque/false = avanço]
		boolean [] saida = {true, true};
		int tamanho = caminho.length;
		
		
		// entrada inválida
		if(tamanho <= 2) {
			saida[0] = false;
			saida[1] = false;
			return saida;
		}
		
		//target não pode estar ocupado por uma peça
		if(caminho[tamanho - 3] != '-') {
			saida[0] = false;
		}
		
		return saida;
	}
}

