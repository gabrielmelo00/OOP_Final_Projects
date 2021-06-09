package jogo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import midia.Carregador;

public class Objetivo extends Agente{
	
	private Image imgObjetivo;
	private Quintal meuQuintal;

	Objetivo(int i, int j, int escala, Quintal meuQuintal) {
		super(i, j, escala);
		tipoAgente = 'O'; //objetivo
		imgObjetivo = new ImageIcon(Carregador.Imagens.get(Carregador.OBJETIVO).getImage().getScaledInstance(escala, escala, 1)).getImage();
	}

	public void pintarTela(Graphics g) {
		
	}

	public void mover() {}

	public Image getImagem() {
		return imgObjetivo;
	}

	public char getTipoAgente() {
		return tipoAgente;
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

	public void colisao(char tipo) {}

}
