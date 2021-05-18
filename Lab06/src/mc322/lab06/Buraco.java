package mc322.lab06;

public class Buraco extends Componente {

	public Buraco(int x, int y) {
		super(x, y);
		tipo = 'B';
		
		Componente minhaBrisa;

		if(j+1 < minhaCaverna.tamanho()) {
			minhaBrisa = new Brisa(i, j+1);
			minhaCaverna.conectaSala(i,j+1, minhaBrisa);
		}
		if(j-1 >= 0) {
			minhaBrisa = new Brisa(i, j-1);
			minhaCaverna.conectaSala(i,j-1, minhaBrisa);
		}
		if(i+1 < minhaCaverna.tamanho()) {
			
			minhaBrisa = new Brisa(i+1, j);
			minhaCaverna.conectaSala(i+1,j, minhaBrisa);
		}
		if(i-1 >= 0) {
			minhaBrisa = new Brisa(i-1, j);
			minhaCaverna.conectaSala(i-1,j, minhaBrisa);
		}
	}

}
