package mc322.lab05b;

public class Peao extends Pe�a {

	public Peao(int i, int j, char cor) {
		super(i, j, cor);
	}
	
	public boolean [] validaMovimento(char[] caminho) {
		
		boolean [] saida = super.validaMovimento(caminho);
		int tamanho = caminho.length;
		int i_target = Character.getNumericValue(caminho[tamanho -2]);
		int j_target = Character.getNumericValue(caminho[tamanho -1]);
		
		if(saida[0] == true) {
			//apenas avan�ando
			if(tamanho == 3) {
				if(cor == 'p') {
					if(i - i_target > 0) {
						i = i_target;
						j = j_target;
						saida[1] = false;
					}
					else {
						saida[0] = false;
					}
				}
				else if(cor == 'b') {
					if(i - i_target < 0) {
						i = i_target;
						j = j_target;
						saida[1] = false;
					}
					else {
						saida[0] = false;
					}
				}
			}
			//ataque
			else if(tamanho == 4) {
				if(caminho[0] != '-') {
					if(caminho[0] != cor) {
						i = i_target;
						j = j_target;
						saida[1] = true;
					}
					else {
						saida[0] = false; 
					}
				}
				else {
					saida[0] = false;
				}
			}
			else {
				saida[0] = false;
			}
		}
		return saida;
		
	}
}
