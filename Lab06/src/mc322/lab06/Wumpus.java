package mc322.lab06;

import java.util.ArrayList;
import java.util.Random;

public class Wumpus extends Componente {
	
	ArrayList<Fedor> meusFedores;

	public Wumpus(int x, int y) {
		super(x, y);
		tipo = 'W';
		meusFedores = new ArrayList<Fedor>();
		Fedor meuFedor;

		if(j+1 < minhaCaverna.tamanho()) {
			meuFedor = new Fedor(i, j+1);
			meusFedores.add(meuFedor);
			minhaCaverna.conectaSala(i,j+1, meuFedor);
		}
		if(j-1 >= 0) {
			meuFedor = new Fedor(i, j-1);
			meusFedores.add(meuFedor);
			minhaCaverna.conectaSala(i,j-1, meuFedor);
		}
		if(i+1 < minhaCaverna.tamanho()) {
			meuFedor = new Fedor(i+1, j);
			meusFedores.add(meuFedor);
			minhaCaverna.conectaSala(i+1,j, meuFedor);
		}
		if(i-1 >= 0) {
			meuFedor = new Fedor(i-1, j);
			meusFedores.add(meuFedor);
			minhaCaverna.conectaSala(i-1,j, meuFedor);
		}
	}
	
	public boolean atacarWumpus() {
		Random random = new Random();
		int derrotei = random.nextInt(2 - 0);
		if(derrotei == 1) {
			retiraFedor();
			return true;
		}else {
			return false;
		}
	}
	
	private void retiraFedor() {
		for(int i = 0; i < meusFedores.size(); i++) {
			minhaCaverna.desconectaSala(meusFedores.get(i).getX(), meusFedores.get(i).getY(), meusFedores.get(i));
		}
		meusFedores.clear();
	}

}
