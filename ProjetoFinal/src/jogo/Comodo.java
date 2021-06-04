package jogo;

public class Comodo {
	
	private Celula [][] matrizCelulas;
	public static final byte LARGURA = 8;
	public static final byte ALTURA = 8;
	
	public Comodo(char c) {
		matrizCelulas = new Celula[ALTURA][LARGURA];
		for(int i = 0; i < ALTURA; i++) {
			for(int j = 0; j < LARGURA; j++) {
				matrizCelulas[i][j] = new Celula(c);
			}
		}
	}
	
	public void imprimeComodo() {
		for(int i = 0; i < ALTURA; i++) {
			for(int j = 0; j < LARGURA; j++) {
				System.out.println(matrizCelulas[i][j].getCelula());
			}
		}
	}

}
