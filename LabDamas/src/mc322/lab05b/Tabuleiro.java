package mc322.lab05b;

public class Tabuleiro {
	Peça [][] matriz;
	
	Tabuleiro(){
		matriz = new Peça[8][8];
	
		for(int i = 0;i < 3;i = i + 2) {
			for(int j = 0;j < 8;j = j + 2) {
				matriz[i][j] = new Peao(i,j,'b');
				matriz[7 - i][7 - j] = new Peao(7 - i,7 - j,'p');
			}
		}
		for(int j = 1;j < 8;j = j + 2) {
			matriz[1][j] = new Peao(1,j,'b');
			matriz[6][7 - j] = new Peao(6,7 - j,'p');
		}
	}
	
	int[] leitura(String jogada) {
		int j = -1;
		int i = Character.getNumericValue(jogada.charAt(1)) - 1;
		switch(jogada.charAt(0)) {
		case 'a': j = 0; break;
		case 'b': j = 1; break;
		case 'c': j = 2; break;
		case 'd': j = 3; break;
		case 'e': j = 4; break;
		case 'f': j = 5; break;
		case 'g': j = 6; break;
		}
		int [] saida = {i,j};
		return saida;
	}
	
	void imprimirTabuleiro() {
		String estado = "";
		
		for(int i = 7;i >= 0;i--) {
			estado += Integer.toString(i+1);
			for(int j = 0;j <= 7;j++) {
				estado += " ";
				if(matriz[i][j] != null) {
					estado += matriz[i][j].getCor();
				}else {
					estado += '-';
				}
			}
			estado += "\n";
		}
		String linha_final = "  a b c d e f g h\n";
		estado += linha_final;
		System.out.println(estado);
	}
	
	char[] retornaDirecao(int s_i, int s_j, int t_i, int t_j) {
		char[] direcao;
		//checar diagonal
		
		if(Math.abs(s_i - t_i) == Math.abs(s_j - t_j)) {
			int tamanho = Math.abs(s_i - t_i) + 2;
			direcao = new char[tamanho];
			
			for(int x = 1;x <= (tamanho - 2);x++) {
				//subindo direita
				if((t_j > s_j) && (t_i > s_i)) {
					if(matriz[s_i + x][s_j + x] != null) {
						direcao[x - 1] = matriz[s_i + x][s_j + x].getCor();
					}else {
						direcao[x - 1] = '-';
					}
				}
				
				//subindo esquerda
				if((t_j < s_j) && (t_i > s_i)) {
					if(matriz[s_i + x][s_j - x] != null) {
						direcao[x - 1] = matriz[s_i + x][s_j - x].getCor();
					}else {
						direcao[x - 1] = '-';
					}
				}
				
				//descendo esquerda
				if((t_j < s_j) && (t_i < s_i)) {
					if(matriz[s_i - x][s_j - x] != null) {
						direcao[x - 1] = matriz[s_i - x][s_j - x].getCor();
					}else {
						direcao[x - 1] = '-';
					}
				}
				
				//descendo direita
				if((t_j > s_j) && (t_i < s_i)) {
					if(matriz[s_i - x][s_j + x] != null) {
						direcao[x - 1] = matriz[s_i - x][s_j + x].getCor();
					}else {
						direcao[x - 1] = '-';
					}
				}
			}
			
			direcao[tamanho - 1] = Character.forDigit(t_j, 10);
			direcao[tamanho - 2] = Character.forDigit(t_i, 10);
			
			return direcao;
		
		}

		System.out.println("Movimento invalido!");
		direcao = null;
		return direcao;	
	}
	
	void avancaPeça(int source_i, int source_j, int target_i, int target_j) {
		if(target_i == 0 && matriz[source_i][source_j].getCor() == 'p') {
			matriz[target_i][target_j] = new Dama(target_i, target_j, 'P');
		}else if(target_i == 7 && matriz[source_i][source_j].getCor() == 'b') {
			matriz[target_i][target_j] = new Dama(target_i, target_j, 'B');
		}else if(matriz[source_i][source_j].getCor() == 'b' || matriz[source_i][source_j].getCor() == 'p'){
			matriz[target_i][target_j] = new Peao(target_i, target_j, matriz[source_i][source_j].getCor());
		}else {
			matriz[target_i][target_j] = new Dama(target_i, target_j, matriz[source_i][source_j].getCor());
		}
		matriz[source_i][source_j] = null;
	}
	
	void comePeça(int s_i, int s_j, int t_i, int t_j, char[] caminho) {
		int aux = 0;
		int comida_i = s_i;
		int comida_j = s_j;
		for(int x = 1;x <= (caminho.length- 2);x++) {
			if (caminho[x - 1] != '-') {
				aux = x;
				break;
			}
		}
		//System.out.println("aux: " + aux);
		
		//subindo direita
		if((t_j > s_j) && (t_i > s_i)) {
			comida_i += aux;
			comida_j += aux;
		}
		
		//subindo esquerda
		if((t_j < s_j) && (t_i > s_i)) {
			comida_i += aux;
			comida_j -= aux;	
		}
		
		//descendo esquerda
		if((t_j < s_j) && (t_i < s_i)) {
			comida_i -= aux;
			comida_j -= aux;
		}
		
		//descendo direita
		if((t_j > s_j) && (t_i < s_i)) {
			comida_i -= aux;
			comida_j += aux;
		}
		
		matriz[comida_i][comida_j] = null;			
	}
	
	void solicitaMovimento(String movimento) {
		String[] jogadas = movimento.split(":");
		int[] source = leitura(jogadas[0]);
		int[] target = leitura(jogadas[1]);
		int source_i = source[0];
		int source_j = source[1];
		int target_i = target[0];
		int target_j = target[1];
		
		char [] caminho = null;
		if(source_i > 7 || source_i < 0 || target_i > 7 || target_i < 0 || source_j == -1 || target_j == -1) {
			System.out.println("Movimento invalido!");
		}else {
			caminho = retornaDirecao(source_i, source_j, target_i, target_j);
		}
		
		if(caminho != null) {
			boolean[] estados;
			//Que peça eu estou mexendo?
			if(matriz[source_i][source_j] != null ) {
				estados = matriz[source_i][source_j].validaMovimento(caminho);
				if(estados[0]) {
					avancaPeça(source_i, source_j, target_i, target_j);
					if(estados[1]) {
						comePeça(source_i, source_j, target_i, target_j, caminho);
					}
				}
			}
		}
	}
}
	
