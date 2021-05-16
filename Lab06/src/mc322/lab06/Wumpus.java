package mc322.lab06;

public class Wumpus extends Componente {

	public Wumpus(int i, int j) {
		super(i, j);
		tipo = 'W';
		System.out.println("Wumpus:");
		System.out.println(i);
		System.out.println(j);
		/*Componente meuFedor;

		if(j+1 < minhaCaverna.tamanho()) {
			meuFedor = new Fedor(i, j+1);
			minhaCaverna.conectaSala(i,j+1, meuFedor);
		}
		if(j-1 >= 0) {
			meuFedor = new Fedor(i, j-1);
			minhaCaverna.conectaSala(i,j-1, meuFedor);
		}
		if(i+1 < minhaCaverna.tamanho()) {
			meuFedor = new Fedor(i+1, j);
			minhaCaverna.conectaSala(i+1,j, meuFedor);
		}
		if(i-1 >= 0) {
			meuFedor = new Fedor(i-1, j);
			minhaCaverna.conectaSala(i-1,j, meuFedor);
		}*/
	}

}
