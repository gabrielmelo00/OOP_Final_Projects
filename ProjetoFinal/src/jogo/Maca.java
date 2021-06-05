package jogo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import midia.Carregador;

public class Maca extends Agente{
	
	private Image maca;
	private int deltax;

	Maca(int x, int y) {
		super(x, y);
		deltax = 5;
		maca = new ImageIcon(Carregador.Imagens.get(Carregador.MACA).getImage().getScaledInstance(100, 100, 1)).getImage();
	}

	public void pintarTela(Graphics g) {
        g.drawImage(maca, x, y, null);
	}

	public void mover() {
		x = x + deltax;
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}
	
	

}
