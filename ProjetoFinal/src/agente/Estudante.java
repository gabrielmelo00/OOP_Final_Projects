package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


import jogo.Comodo;
import midia.Carregador;

public class Estudante implements IAgente{
	
	private int i;
	private int j;
	private char tipoAgente;

	private Image imgEstudante;
	private Comodo meuComodo;
	
	public Estudante(int i, int j, int escala, Comodo meuComodo) {
		this.i = i;
		this.j = j;
		this.meuComodo = meuComodo;
		tipoAgente = 'E'; //explorador
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

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {
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

	public void colisao(char tipo) {
		switch(tipo) {
		case 'V': meuComodo.perdeuJogo(); break;
		case 'O': System.out.println("Cheguei no Objetivo"); break;  //meuQuintal.proximoNivel(); break;
		default : break;
		}
	}
	
	

}
