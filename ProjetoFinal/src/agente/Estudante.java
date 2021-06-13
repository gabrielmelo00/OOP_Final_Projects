package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


import jogo.Comodo;
import jogo.midia.Carregador;

public class Estudante extends Agente{
	
	private Image imgEstudante;
	private Comodo meuComodo;
	private static Estudante instanciaEstudante = new Estudante();
	
	private Estudante() {
		super(0,0,65,'E', 0);
	}
	
	public static Estudante getInstancia() {
		return instanciaEstudante;
	}
	
	public void setParametros(int i, int j, int escala, Comodo meuComodo) {
		this.i = i;
		this.j = j;
		this.escala = escala;
		this.meuComodo = meuComodo;
		imgEstudante = new ImageIcon(Carregador.Imagens.get(Carregador.ESTUDANTE).getImage().getScaledInstance(escala, escala, 1)).getImage();
	}
	
	public void mover() {}


	public Image getImagem() {
		return imgEstudante;
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
