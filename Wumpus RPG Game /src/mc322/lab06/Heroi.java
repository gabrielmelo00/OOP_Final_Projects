package mc322.lab06;

public class Heroi extends Componente {
	
	private int flechas;
	private boolean equipada;
	private int ouro;
	private int pontuacao;
	private int wumpus;
	private boolean perdeu;

	public Heroi(int i, int j) {
		super(i, j);
		tipo = 'P';
		flechas = 1;
		equipada = false;
		ouro = 0;
		pontuacao = 0;
		wumpus = 0;
		perdeu = false;
	}
	
	public boolean direita() {
		if(j+1 < minhaCaverna.tamanho()) {
			setPontuacao(-15);
			minhaCaverna.desconectaSala(i,j,this);
			j++;
			minhaCaverna.conectaSala(i,j,this);
			if(equipada) {
				minhaCaverna.atiraFlecha(i,j);
				setPontuacao(-100);
				equipada = false;
			} 
			return true;
		}else {
			return false;
		}
	}
	
	public boolean esquerda() {
		if(j -1 >= 0) {
			setPontuacao(-15);
			minhaCaverna.desconectaSala(i,j,this);
			j --;
			minhaCaverna.conectaSala(i, j, this);
			if(equipada) {
				minhaCaverna.atiraFlecha(i,j);
				setPontuacao(-100);
				equipada = false;
			} 
			return true;
		}else {
			return false;
		}
	}
	
	public boolean acima() {
		if(i -1 >= 0) {
			setPontuacao(-15);
			minhaCaverna.desconectaSala(i,j,this);
			i--;
			minhaCaverna.conectaSala(i, j, this);
			if(equipada) {
				minhaCaverna.atiraFlecha(i,j);
				setPontuacao(-100);
				equipada = false;
			} 
			return true;
		}else {
			return false;
		}
	}
	
	public boolean abaixo() {
		if(i+1 < minhaCaverna.tamanho()) {
			setPontuacao(-15);
			minhaCaverna.desconectaSala(i,j,this);
			i++;
			minhaCaverna.conectaSala(i, j, this);
			if(equipada) {
				minhaCaverna.atiraFlecha(i,j);
				setPontuacao(-100);
				equipada = false;
			} 
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
		int ouro_antigo = ouro;
		minhaCaverna.capturaOuro(i, j);
		if(ouro_antigo < ouro) {
			return true;
		}else {
			return false;
		}
	}
	
	public void setOuro(){
		ouro ++;
	}
	
	public int getOuro() {
		return ouro;
	}
	
	public void setWumpus() {
		setPontuacao(500);
		wumpus ++;
	}
	
	public boolean getWumpus() {
		if(wumpus > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void setPerdeu() {
		perdeu = true;
		setPontuacao(-1000);
	}
	
	public boolean getPerdeu() {
		return perdeu;
	}
	
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	private void setPontuacao(int acrescimo) {
		pontuacao = pontuacao + acrescimo; 
	}
	
	public boolean getFlechaEquipada() {
		return equipada;
	}
	
	public int getFlechas() {
		return flechas;
	}
	
	public boolean ganhei() {
		if(ouro == 1 && i == 0 && j == 0) {
			setPontuacao(1000);
			return true;
		}else {
			return false;
		}
	}

}
