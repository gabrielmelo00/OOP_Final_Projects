package jogo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import midia.Carregador;

public class Estudante extends Agente{
	
	private Image estudante;
	private int deltaY;
	private int deltaX;
	
	public Estudante(int x, int y) {
		super(x, y);
		deltaY = 20;
		deltaX = 20;
		estudante = new ImageIcon(Carregador.Imagens.get(Carregador.ESTUDANTE).getImage().getScaledInstance(200, 100, 1)).getImage();
	}

	public void pintarTela(Graphics g) {
		g.drawImage(estudante, x, y, null);
		
	}

	public void mover() {}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {
			y = y - deltaY;
		}else if(e.getKeyCode() == KeyEvent.VK_S) {
			y = y + deltaY;
		}else if(e.getKeyCode() == KeyEvent.VK_A) {
			x = x - deltaX;
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			x = x + deltaX;
		}
	}

}
