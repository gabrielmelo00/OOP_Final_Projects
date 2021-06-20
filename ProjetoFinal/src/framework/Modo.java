package framework;


import java.awt.Graphics;
import java.awt.event.KeyEvent;


public abstract class Modo {
	public static GerenciadorModos meuGerenciador;
	
	public Modo() {};
	
	public void setGerenciador(IGerenciadorModos  meuGerenciador) {
		this.meuGerenciador = meuGerenciador.retornaGerenciadorModo();
	}
	public abstract void pintarTela(Graphics g);	
	public abstract void loop(); 		
	public abstract void keyTyped(KeyEvent e);
	public abstract void keyPressed(KeyEvent e);
	public abstract void keyReleased(KeyEvent e);

}