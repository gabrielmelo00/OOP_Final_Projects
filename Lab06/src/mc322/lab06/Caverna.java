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
		if(!matrizSala[x][y].adicionaComponente(c)) {
			System.out.println("Erro: caverna não pode adicionar componente");
		}
	}
	
	public void desconectaSala(int x, int y, Componente c) {
		if(!matrizSala[x][y].retiraComponente(c)) {
			System.out.println("Erro: caverna não pode retirar componente");
		}
	}
	
	public void capturaOuro(int x, int y) {
		matrizSala[x][y].retiraOuro();
	}
	
	public void atiraFlecha(int x, int y) {
		matrizSala[x][y].atiraFlecha();
	}
	
	public int tamanho() {
		return matrizSala[0].length;
	}
	
	public String getEstadoCaverna() {
		String estado = "";
		for(int i = 0;i < tamanho();i++) {
			estado += Integer.toString(i+1);
			for(int j = 0;j < tamanho();j++) {
				estado += " ";
				if(matrizSala[i][j].salaConhecida) {
					if(!matrizSala[i][j].meusComponentes.isEmpty()) {
						estado += matrizSala[i][j].meusComponentes.get(0).getTipo();
					}else {
						estado += "#";
					}
				}else {
					estado += "-";
				}
			}
			estado += "\n";
		}
		String linha_final = " ";
		for(int i = 0;i < tamanho();i++) {
			linha_final += " ";
			linha_final += Integer.toString(i+1);
		}
		linha_final += "\n";
		estado += linha_final;
		return estado;
	}
}
