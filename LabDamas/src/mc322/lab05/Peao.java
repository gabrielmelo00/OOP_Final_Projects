package mc322.lab05;

public class Peao {
	private int i,j;
	private char cor;
	
	public char getCor() {
		return cor;
	}
	
	public Peao(int i, int j, char cor) {
		this.i = i;
		this.j = j;
		this.cor = cor;
	}
	
	//vetor: preto: 1, branco:-1, vazio: 0 [caminho, i, j]
	
	public boolean [] validaMovimento(char[] caminho) {
		
		// saida = [true = movimento valido, true = ataque/false = avanço]
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
			saida[0] = false;
			System.out.println("Jogada inválida: a casa para a qual você está querendo se movimentar já contém uma peça.");
		}
		
		if(saida[0] == true) {
			
			//apenas avançando
			if(tamanho == 3) {
				if(cor == 'p') {
					//System.out.println("entrou em p");
					if(i - i_target > 0) {
						//System.out.println("if > 0");
						i = i_target;
						j = j_target;
						saida[1] = false;
					}
					else {
						//System.out.println("else if > 0");
						System.out.println("Jogada inválida: peão só avança para frente");
						saida[0] = false;
					}
				}
				else if(cor == 'b') {
					//System.out.println("entrou em b");
					if(i - i_target < 0) {
						//System.out.println("if < 0");
						i = i_target;
						j = j_target;
						saida[1] = false;
					}
					else {
						//System.out.println("else if < 0");
						System.out.println("Jogada inválida: peão só avança para frente");
						saida[0] = false;
					}
				}
			}
			//ataque
			else if(tamanho == 4) {
				//System.out.println("tam 4");
				if(caminho[0] != '-') {
					if(caminho[0] != cor) {
						i = i_target;
						j = j_target;
						saida[1] = true;
					}
					else {
						System.out.println("Jogada inválida: você não pode comer uma peça da sua cor.");
						saida[0] = false; 
					}
				}
				else {
					System.out.println("Jogada inválida: você só pode avançar uma casa por jogada.");
					saida[0] = false;
				}
			}
			else {
				System.out.println("Jogada inválida: número de casas do avanço incompatível com peão.");
				saida[0] = false;
			}
		}
		
	return saida;
	}
}
