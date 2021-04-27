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
					estado += matrizPeao[i][j].cor;
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

}
