package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;
import jogo.Comodo;


public class Estudante extends Agente{
	
	private Comodo meuComodo;
	private static Estudante instanciaEstudante = new Estudante();
	private int tempo;
	
	private Estudante() {
		super(0,0,'E', 0, null);
		tempo = 0;
	}
	
	public static Estudante getInstancia() {
		return instanciaEstudante;
	}
	
	public void setParametros(int i, int j, Comodo meuComodo, Image img) {
		this.i = i;
		this.j = j;
		this.meuComodo = meuComodo;
		this.img = img;
	}
	
	public void mover() {
		tempo++;
	}
	
	@Override
	public int getTempo() {
		int aux = tempo;
		tempo = 0;
		return aux;
	}


	public Image getImagem() {
		return img;
	}

	public char getTipoAgente() {
		return tipoAgente;
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
			if(meuComodo.inserirCelula( i - 1, j, this)) {
				meuComodo.retirarCelula(i, j, this);
				i = i-1;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(meuComodo.inserirCelula( i + 1, j, this)) {
				meuComodo.retirarCelula(i, j, this);
				i = i+1;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(meuComodo.inserirCelula( i, j-1, this)) {
				meuComodo.retirarCelula(i, j, this);
				j = j-1;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(meuComodo.inserirCelula(i , j+1, this)) {
				meuComodo.retirarCelula(i, j, this);
				j = j+1;
			}
		}
	}

	public void keyReleased(KeyEvent e) {}

	public void colisao(char tipo) {
		switch(tipo) {
		case 'V': meuComodo.perdeuJogo(); break;
		case 'O': meuComodo.proximoNivel(); break; 
		default : break;
		}
	}
	
	

}
