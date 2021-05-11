package mc322.lab06;

public class Caverna {
	
	public Sala [][] matrizSala;
	
	public Caverna() {
		matrizSala = new Sala [4][4];
	}
	
	public void conectaSala(int x, int y, Componente c) {
		if(matrizSala[x-1][y-1] == null) {
			matrizSala[x-1][y-1] = new Sala(c);
		}else {
			matrizSala[x-1][y-1].adicionaComponente(c);
		}
	}
}
