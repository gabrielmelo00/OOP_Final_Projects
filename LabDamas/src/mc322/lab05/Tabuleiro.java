package mc322.lab05;

import java.awt.desktop.SystemSleepEvent;

public class Tabuleiro {
	Peao[][] matrizPeao;
	Dama[][] matrizDama;
	
	public Tabuleiro() {
		matrizPeao = new Peao[8][8];
		matrizDama = new Dama[8][8];
		
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
				}else if(matrizDama[i][j] != null){
					estado += matrizDama[i][j].getCor();
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
		//checar diagonal
		
		if(Math.abs(s_i - t_i) == Math.abs(s_j - t_j)) {
			int tamanho = Math.abs(s_i - t_i) + 2;
			direcao = new char[tamanho];
			
			for(int x = 1;x <= (tamanho - 2);x++) {
				//subindo direita
				if((t_j > s_j) && (t_i > s_i)) {
					if(matrizPeao[s_i + x][s_j + x] != null) {
						direcao[x - 1] = matrizPeao[s_i + x][s_j + x].getCor();
					}
					else if(matrizDama[s_i + x][s_j + x] != null) {
						direcao[x - 1] = matrizDama[s_i + x][s_j + x].getCor();
					}else {
						direcao[x - 1] = '-';
					}
				}
				
				//subindo esquerda
				if((t_j < s_j) && (t_i > s_i)) {
					if(matrizPeao[s_i + x][s_j - x] != null) {
						direcao[x - 1] = matrizPeao[s_i + x][s_j - x].getCor();
					}
					else if(matrizDama[s_i + x][s_j - x] != null) {
						direcao[x - 1] = matrizDama[s_i + x][s_j - x].getCor();
					}else {
						direcao[x - 1] = '-';
					}
				}
				
				//descendo esquerda
				if((t_j < s_j) && (t_i < s_i)) {
					if(matrizPeao[s_i - x][s_j - x] != null) {
						direcao[x - 1] = matrizPeao[s_i - x][s_j - x].getCor();
					}
					else if(matrizDama[s_i - x][s_j - x] != null) {
						direcao[x - 1] = matrizDama[s_i - x][s_j - x].getCor();
					}else {
						direcao[x - 1] = '-';
					}
				}
				
				//descendo direita
				if((t_j > s_j) && (t_i < s_i)) {
					if(matrizPeao[s_i - x][s_j + x] != null) {
						direcao[x - 1] = matrizPeao[s_i - x][s_j + x].getCor();
					}
					else if(matrizDama[s_i - x][s_j + x] != null) {
						direcao[x - 1] = matrizDama[s_i - x][s_j + x].getCor();
					}else {
						direcao[x - 1] = '-';
					}
				}
			}
			
			direcao[tamanho - 1] = Character.forDigit(t_j, 10);
			direcao[tamanho - 2] = Character.forDigit(t_i, 10);
			
			///////////teste
			System.out.println("tamanho do caminho: " + direcao.length);
			for(int i = 0;i < direcao.length; i++) {
				System.out.println(direcao[i]);
			}
			///////////
			return direcao;
		
		}
		
		System.out.println("Jogada Inválida: não é na diagonal");
		direcao = null;
		return direcao;	
	}
	
	void avancaPeao(int source_i, int source_j, int target_i, int target_j) {
		if(target_i == 0 && matrizPeao[source_i][source_j].getCor() == 'p') {
			matrizDama[target_i][target_j] = new Dama(target_i, target_j, 'P');
		}else if(target_i == 7 && matrizPeao[source_i][source_j].getCor() == 'b') {
			matrizDama[target_i][target_j] = new Dama(target_i, target_j, 'B');
		}else {
			matrizPeao[target_i][target_j] = new Peao(target_i, target_j, matrizPeao[source_i][source_j].getCor());
		}
		matrizPeao[source_i][source_j] = null;
	}
	
	void avancaDama(int source_i, int source_j, int target_i, int target_j) {
		matrizDama[target_i][target_j] = new Dama (target_i, target_j, matrizPeao[source_i][source_j].getCor());
		matrizDama[source_i][source_j] = null;
	}
	
	void comePeca(int s_i, int s_j, int t_i, int t_j, char[] caminho) {
		int aux = 0;
		int comida_i = s_i;
		int comida_j = s_j;
		for(int x = 1;x <= (caminho.length- 2);x++) {
			if (caminho[x - 1] != '-') {
				aux = x;
				break;
			}
		}
		System.out.println("aux: " + aux);
		
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
		
		if(matrizPeao[comida_i][comida_j] != null) {
			matrizPeao[comida_i][comida_j] = null;
		}else {
			matrizDama[comida_i][comida_j] = null;
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
		
		char[] caminho = retornaDirecao(source_i, source_j, target_i, target_j);
		
		if(caminho != null) {
			boolean[] estados;
			//Que peça eu estou mexendo?
			if(matrizPeao[source_i][source_j] != null ) {
				estados = matrizPeao[source_i][source_j].validaMovimento(caminho);
				if(estados[0]) {
					avancaPeao(source_i, source_j, target_i, target_j);
					if(estados[1]) {
						comePeca(source_i, source_j, target_i, target_j, caminho);
					}
				}
			}
			else if(matrizDama[source_i][source_j] != null) {
				estados = matrizDama[source_i][source_j].validaMovimento(caminho);
				if(estados[0]) {
					avancaDama(source_i, source_j, target_i, target_j);
					if(estados[1]) {
						comePeca(source_i, source_j, target_i, target_j, caminho);
					}
				}
				
			}
		}
		
	}
	
	void testaPeao() {
		char [] s = {'-', '4','2'};
		char [] b =  {'-', '-', '4','2'};
		System.out.println("1");
		boolean[] resultado = matrizPeao[5][1].validaMovimento(s);
		System.out.println(resultado[0]);
		System.out.println(resultado[1]);
		System.out.println("2");
		resultado = matrizPeao[2][0].validaMovimento(b);
		System.out.println(resultado[0]);
		System.out.println(resultado[1]);
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

