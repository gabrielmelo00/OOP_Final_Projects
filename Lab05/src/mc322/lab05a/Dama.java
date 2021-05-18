package mc322.lab05a;

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
		
		// entrada inválida
		if(tamanho <= 2) {
			saida[0] = false;
			saida[1] = false;
			System.out.println("Jogada inválida: entrada inválida.");
			return saida;
		}
		
		//target não pode estar ocupado por uma peça
		if(caminho[tamanho - 3] != '-') {
			System.out.println("Jogada inválida: a casa para a qual você está querendo se movimentar já contém uma peça.");
			saida[0] = false;
		}
		
		// é uma ataque ou um avanço?
		int count = 0;
		int tipo_mov = 0;	//avanço = 0; ataque = 1;
		for(int x = 0; x < (caminho.length - 2); x++) {
			if(caminho[x] != '-') {
				count += 1;
			}
		}
		if(count == 1) {
			tipo_mov = 1;
		}else if(count > 1) {
			//dama só come uma peça por jogada
			System.out.println("Jogada inválida: você só pode comer uma peça por entrada.");
			saida[0] = false;
		}
		
		//dama pode andar pra frente e para tras quantas casas quiser na diagonal
		if(saida[0]) {
			if(tipo_mov == 1) {
				i = i_target;
				j = j_target;
				saida[1] = true;
			}else {
				i = i_target;
				j = j_target;
				saida[1] = false;
			}
		}
		return(saida);
	}

}