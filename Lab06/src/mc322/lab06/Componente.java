package mc322.lab06;

public class Componente {
	static Caverna minhaCaverna;
	protected int i;
	protected int j;
	protected char tipo;
	
	public Componente(int i, int j, char tipo) {
		this.i  = i - 1;
		this.j = j - 1;
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
		System.out.println("eu: " + this);
	}
	
	
	//=== métodos do Heroi ===
	
	public boolean direita() {
		return true;
	}
	
	public boolean esquerda() {
		return true;
	}
	
	public boolean acima() {
		return true;
	}
	
	public boolean abaixo() {
		return true;
	}
	
	public boolean equipaFlecha() {
		return true;
	}
	
	public boolean capturaOuro() {
		return true;
	}
	
	
	public int getPontuacao() {
		return 0;
	}
	
	public void setPontuacao(int acrescimo) {
	}

}
