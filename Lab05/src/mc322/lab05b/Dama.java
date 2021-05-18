package mc322.lab05b;

public class Dama extends Peça {

	public Dama(int i, int j, char cor) {
		super(i, j, cor);
	}
	
	public boolean [] validaMovimento(char[] caminho) {
		boolean [] saida = super.validaMovimento(caminho);
		int tamanho = caminho.length;
		int i_target = Character.getNumericValue(caminho[tamanho -2]);
		int j_target = Character.getNumericValue(caminho[tamanho -1]);
		
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
