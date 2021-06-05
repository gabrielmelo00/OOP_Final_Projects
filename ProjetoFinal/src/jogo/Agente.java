package jogo;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public abstract class Agente {
	
	protected int x;
	protected int y;
	
	Agente(int x, int y){
		this.y = y;
		this.x = x;
	}
	
	public abstract void pintarTela(Graphics g);
	public abstract void mover();
	public abstract void keyTyped(KeyEvent e);
	public abstract void keyPressed(KeyEvent e);
	public abstract void keyReleased(KeyEvent e);

}
