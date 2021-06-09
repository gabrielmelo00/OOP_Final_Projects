package jogo;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public abstract class Agente {
	
	protected Modo meuComodo;
	protected int xInicio;
	protected int yInicio;
	protected int i;
	protected int j;
	protected int lado;
	protected int xTela;
	protected int yTela;
	
	Agente(int xInicio, int yInicio, int i, int j, int lado, Modo meuComodo){
		this.yInicio = yInicio;
		this.xInicio = xInicio;
		this.i = i;
		this.j = j;
		this.lado = lado;
		this.meuComodo = meuComodo;
		xTela = xInicio + j*(lado);
		yTela = yInicio + i*(lado);
		
	}
	
	
	public abstract void pintarTela(Graphics g);
	public abstract void mover();
	public abstract void keyTyped(KeyEvent e);
	public abstract void keyPressed(KeyEvent e);
	public abstract void keyReleased(KeyEvent e);

}
