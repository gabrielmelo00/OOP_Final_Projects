package mc322.lab06;

public class Caverna {
	
	public Sala [][] matrizSala;
	
	
	public Caverna() {
		matrizSala = new Sala [4][4];
		for(int i = 0;i < 4;i++) {
			for(int j = 0;j < 4;j++) {
				matrizSala[i][j] = new Sala();
			}
		}
	}
	
	public void conectaSala(int x, int y, Componente c) {
		if(!matrizSala[x-1][y-1].adicionaComponente(c)) {
			System.out.println("Erro: caverna não pode adicionar componente");
		}
	}
	
	public int tamanho() {
		return matrizSala[0].length;
	}
}
