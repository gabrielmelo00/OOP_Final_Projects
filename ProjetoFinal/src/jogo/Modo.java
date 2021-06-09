package jogo;

import framework.GerenciadorModos;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public abstract class Modo {
	//extends JPanel
	public static GerenciadorModos meuGerenciador;


	public Modo(GerenciadorModos meuGerenciador) {
		this.meuGerenciador = meuGerenciador;
	}
	
	public Modo() {};
	
	public abstract boolean trocarCelula(int i, int j, int novoi, int novoj, Agente g);
	public abstract void pintarTela(Graphics g); 	
	public abstract void loop(); 	
	public abstract void carregarImagens();	
	public abstract void keyTyped(KeyEvent e);
	public abstract void keyPressed(KeyEvent e);
	public abstract void keyReleased(KeyEvent e);
	


}