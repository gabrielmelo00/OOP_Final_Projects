package jogo;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import agente.Agente;
import framework.Modo;

public abstract class Comodo extends Modo{

	public abstract void pintarTela(Graphics g); 	
	public abstract void loop(); 	
	public abstract void carregarImagens();	
	public abstract void keyTyped(KeyEvent e);
	public abstract void keyPressed(KeyEvent e);
	public abstract void keyReleased(KeyEvent e);
	public abstract void calculoDimensoes();
	public abstract void carregarAgentes();
	public abstract boolean inserirCelula(int i, int j, Agente agente);
	public abstract boolean retirarCelula(int i, int j, Agente agente);
	public abstract void perdeuJogo();
	public abstract void proximoNivel();

}
