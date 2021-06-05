package jogo;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public interface IComodo {
	
	public void pintarTela(Graphics g);
	public void mover();
	public void keyTyped(KeyEvent e);
	public void keyPressed(KeyEvent e);
	public void keyReleased(KeyEvent e);

}
