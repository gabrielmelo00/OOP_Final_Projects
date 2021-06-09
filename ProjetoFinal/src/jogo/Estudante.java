package jogo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import midia.Carregador;

public class Estudante extends Agente{
	
	private Image estudante;
	private Quintal meuQuintal;
	
	public Estudante(int x, int y, int escala, Quintal meuQuintal) {
		super(x, y, escala);
		this.meuQuintal = meuQuintal;
		tipoAgente = 'E'; //explorador
		estudante = new ImageIcon(Carregador.Imagens.get(Carregador.ESTUDANTE).getImage().getScaledInstance(escala, escala, 1)).getImage();
	}

	public void pintarTela(Graphics g) {
		//g.drawImage(estudante, x, y, null);
	}

	public void mover() {}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
			if(meuQuintal.inserirCelula( i - 1, j, this)) {
				meuQuintal.retirarCelula(i, j, this);
				i = i-1;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(meuQuintal.inserirCelula( i + 1, j, this)) {
				meuQuintal.retirarCelula(i, j, this);
				i = i+1;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(meuQuintal.inserirCelula( i, j-1, this)) {
				meuQuintal.retirarCelula(i, j, this);
				j = j-1;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(meuQuintal.inserirCelula(i , j+1, this)) {
				meuQuintal.retirarCelula(i, j, this);
				j = j+1;
			}
		}
	}

	public Image getImagem() {
		return estudante;
	}

	public char getTipoAgente() {
		return tipoAgente;
	}
	
	public void colisao(char tipo) {
		switch(tipo) {
		case 'V': meuQuintal.perdeuJogo(); break;
		case 'O': System.out.println("Cheguei no Objetivo"); break;  //meuQuintal.proximoNivel(); break;
		default : break;
		}
	}

}
