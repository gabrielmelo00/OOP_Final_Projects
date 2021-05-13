package mc322.lab06;

public class Heroi extends Componente {
	
	int flechas;
	boolean equipada;
	int ouro;
	int pontuacao;

	public Heroi(int i, int j, char tipo) {
		super(i, j, tipo);
		flechas = 1;
		equipada = false;
		ouro = 0;
		pontuacao = 0;
	}
	
	public boolean direita() {
		if(i+1 < minhaCaverna.tamanho()) {
			pontuacao = pontuacao -15;
			//if(equipada) -> atirarFlecha
			//minhaCaverna.retiraHeroiSala
			i++;
			minhaCaverna.conectaSala(i,j,this);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean esquerda() {
		if(i -1 >= 0) {
			pontuacao = pontuacao -15;
			//if(equipada) -> atirarFlecha
			//minhaCaverna.retiraHeroiSala
			i --;
			minhaCaverna.conectaSala(i, j, this);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean acima() {
		if(j + 1 < minhaCaverna.tamanho()) {
			pontuacao = pontuacao -15;
			//if(equipada) -> atirarFlecha
				// pontuacao = pontuacao -100;
			//minhaCaverna.retiraHeroiSala
			j++;
			minhaCaverna.conectaSala(i, j, this);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean abaixo() {
		if(j-1 >= 0) {
			pontuacao = pontuacao -15;
			//if(equipada) -> atirarFlecha
			//minhaCaverna.retiraHeroiSala
			j--;
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
