package mc322.lab06;

public class Componente {
	static Caverna minhaCaverna;
	protected int i;
	protected int j;
	protected char tipo;
	
	public Componente(int i, int j, char tipo) {
		this.i  = i;
		this.j = j;
		this.tipo = tipo;
	}
	public Componente(Caverna x) {
		this (-1,-1,'n');
		minhaCaverna = x;
	}
	
	public void conectaComponente(){
		minhaCaverna.conectaSala(i, j, this);
	}
	
	public char getTipo(){
		return tipo;
	}
	
	
	public void printa() {
		System.out.println("i: " + i);
		System.out.println("j: " + j);
		System.out.println("tipo: " + tipo);
		System.out.println("minhaCav: " + minhaCaverna);
	}

}
