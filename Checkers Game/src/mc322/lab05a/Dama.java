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
		
		// entrada inv�lida
		if(tamanho <= 2) {
			saida[0] = false;
			saida[1] = false;
			System.out.println("Jogada inv�lida: entrada inv�lida.");
			return saida;
		}
		
		//target n�o pode estar ocupado por uma pe�a
		if(caminho[tamanho - 3] != '-') {
			System.out.println("Jogada inv�lida: a casa para a qual voc� est� querendo se movimentar j� cont�m uma pe�a.");
			saida[0] = false;
		}
		
		// � uma ataque ou um avan�o?
		int count = 0;
		int tipo_mov = 0;	//avan�o = 0; ataque = 1;
		for(int x = 0; x < (caminho.length - 2); x++) {
			if(caminho[x] != '-') {
				count += 1;
			}
		}
		if(count == 1) {
			tipo_mov = 1;
		}else if(count > 1) {
			//dama s� come uma pe�a por jogada
			System.out.println("Jogada inv�lida: voc� s� pode comer uma pe�a por entrada.");
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