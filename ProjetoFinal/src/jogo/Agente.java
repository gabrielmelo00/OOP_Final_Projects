package jogo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import framework.Modo;

public abstract class Agente {

	protected int i;
	protected int j;
	protected char tipoAgente;
	protected int escala;
	
	Agente(int i, int j, int escala){
		this.i = i;
		this.j = j;
		this.escala = escala;
	}
	
	
	public abstract void pintarTela(Graphics g);
	public abstract void mover();
	public abstract Image getImagem();
	public abstract char getTipoAgente();
	public abstract void keyTyped(KeyEvent e);
	public abstract void keyPressed(KeyEvent e);
	public abstract void keyReleased(KeyEvent e);
	public abstract void colisao(char tipo);

}
