package mc322.lab05;

public class Tabuleiro {
	Peao[][] matrizPeao;
	Dama[][] matrizDama;
	
	public Tabuleiro() {
		matrizPeao = new Peao[8][8];
		
		for(int i = 0;i < 3;i = i + 2) {
			for(int j = 0;j < 8;j = j + 2) {
				matrizPeao[i][j] = new Peao(i,j,'b');
				matrizPeao[7 - i][7 - j] = new Peao(7 - i,7 - j,'p');
			}
		}
		for(int j = 1;j < 8;j = j + 2) {
			matrizPeao[1][j] = new Peao(1,j,'b');
			matrizPeao[6][7 - j] = new Peao(6,7 - j,'p');
		}
	}
	
	
	String retornaEstado() {
		String estado = "";
		
		for(int i = 7;i >= 0;i--) {
			estado += Integer.toString(i+1);
			for(int j = 0;j <= 7;j++) {
				estado += " ";
				if(matrizPeao[i][j] != null) {
					estado += matrizPeao[i][j].getCor();
				}else {
					estado += '-';
				}
				
			}
			estado += "\n";
		}
		String linha_final = "  a b c d e f g h\n";
		estado += linha_final;
		return estado;
	}
	
	int[] leitura(String jogada) {
		int j = 0;
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
	
	char[] retornaDirecao(int s_i, int s_j, int t_i, int t_j) {
		char[] direcao;
		
		//horizontal
		if(s_i == t_i) {
			direcao = new char[Math.abs(s_j - t_j) + 2];
			for(int i = 0; i < Math.abs(s_j - t_j); i++) {
				if(matrizPeao[s_i][s_j]) 
			}
		}
	}
	
	void moverPeca(String movimento) {
		String[] jogadas = movimento.split(":");
		int[] source = leitura(jogadas[0]);
		int[] target = leitura(jogadas[1]);
		int source_i = source[0];
		int source_j = source[1];
		int target_i = target[0];
		int target_j = target[1];
		
		char peca = 'x';
		
		char[] direcao = retornaDirecao(source_i, source_j, target_i, target_j);
		
		//Que peça eu estou mexendo?
		if(matrizPeao[source_i][source_j] != null ) {
			peca = 'p';
		}
		else if(matrizDama[source_i][source_j] != null) {
			peca = 'd';
		}
		
		
	}
	
	void testaPeao() {
		char [] s = {'-', '4','2'};
		System.out.println("1");
		boolean[] resultado = matrizPeao[5][1].validaMovimento(s);
		System.out.println(resultado[0]);
		System.out.println(resultado[1]);
		System.out.println("2");
		resultado = matrizPeao[2][0].validaMovimento(s);
		char [] ss = {'-', '3','1'};
		System.out.println("3");
		resultado = matrizPeao[2][0].validaMovimento(ss);
		System.out.println(resultado[0]);
		System.out.println(resultado[1]);
		char [] sss = {'b','-', '2','0'};
		System.out.println("4");
		resultado = matrizPeao[5][1].validaMovimento(sss);
		System.out.println(resultado[0]);
		System.out.println(resultado[1]);
	}

}

