package mc322.lab06;

public class Heroi extends Componente {
	
	private int flechas;
	private boolean equipada;
	private int ouro;
	private int pontuacao;

	public Heroi(int i, int j) {
		super(i, j);
		tipo = 'P';
		flechas = 1;
		equipada = false;
		ouro = 0;
		pontuacao = 0;
		System.out.println("Heroi:");
		System.out.println(i);
		System.out.println(j);
	}
	
	public boolean direita() {
		if(j+1 < minhaCaverna.tamanho()) {
			pontuacao = pontuacao -15;
			//if(equipada) -> atirarFlecha
			minhaCaverna.desconectaSala(i,j,this);
			j++;
			minhaCaverna.conectaSala(i,j,this);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean esquerda() {
		if(j -1 >= 0) {
			pontuacao = pontuacao -15;
			//if(equipada) -> atirarFlecha
			minhaCaverna.desconectaSala(i,j,this);
			j --;
			minhaCaverna.conectaSala(i, j, this);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean acima() {
		if(i -1 >= 0) {
			pontuacao = pontuacao -15;
			//if(equipada) -> atirarFlecha
				// pontuacao = pontuacao -100;
			minhaCaverna.desconectaSala(i,j,this);
			i--;
			minhaCaverna.conectaSala(i, j, this);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean abaixo() {
		if(i+1 < minhaCaverna.tamanho()) {
			pontuacao = pontuacao -15;
			//if(equipada) -> atirarFlecha
			minhaCaverna.desconectaSala(i,j,this);
			i++;
			minhaCaverna.conectaSala(i, j, this);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean equipaFlecha() {
		if(flechas != 0) {
			flechas --;
			equipada = true;
			return true;
		}
		return false;
	}
	
	public boolean capturaOuro() {
		//if(pedeParaPegarOuro)
		ouro ++;
		return true;
		//else return false
	}
	
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	// para ser usado se o héroi mata o wumpus, é morto pelo wumpus, cai em um buraco ...
	public void setPontuacao(int acrescimo) {
		pontuacao = pontuacao + acrescimo; 
	}

}
