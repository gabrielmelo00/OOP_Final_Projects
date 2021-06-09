package jogo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import framework.Modo;

public abstract class Agente {
	
	//protected Modo meuComodo;
	//protected int xInicio;
//	protected int yInicio;
	protected int i;
	protected int j;
	//protected int lado;
	//protected int xTela;
	//protected int yTela;
	protected char tipoAgente;
	protected int escala;
	/*Agente(int xInicio, int yInicio, int i, int j, int lado, Modo meuComodo){
		this.yInicio = yInicio;
		this.xInicio = xInicio;
		this.i = i;
		this.j = j;
		this.lado = lado;
		this.meuComodo = meuComodo;
		xTela = xInicio + j*(lado);
		yTela = yInicio + i*(lado);
		
	}*/
	
	Agente(int i, int j, int escala){
		this.i = i;
		this.j = j;
		this.escala = escala;
		//this.meuComodo = meuComodo;
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
