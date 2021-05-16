package mc322.lab06;

public class Componente {
	static Caverna minhaCaverna;
	protected int i;
	protected int j;
	protected char tipo;
	
	public Componente(int i, int j) {
		this.i  = i-1;
		this.j = j-1;
	}
	public Componente(Caverna x) {
		this (-1,-1);
		minhaCaverna = x;
	}
	
	public void conectaComponente(){
		minhaCaverna.conectaSala(i, j, this);
	}
	
	public char getTipo(){
		return tipo;
	}
	
	public int getX() {
		return i;
	}
	
	public int getY() {
		return j;
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
	
	public void setOuro() {}
	public void setWumpus() {}
	public void setPerdeu() {}
	public boolean getPerdeu() {
		return false;
	}
	public boolean getFlechaEquipada() {
		return false;
	}
	public boolean ganhei() {
		return false;
	}
	
	public int getOuro() {
		return 0;
	}
	
	public int getFlechas() {
		return 0;
	}
	
	public boolean getWumpus() {
		return false;
	}
	
	//métodos do Wumpus
	
	public boolean atacarWumpus() {
		return false;
	}
	

}
