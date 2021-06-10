package framework;

import jogo.Agente;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public abstract class Modo {
	//extends JPanel
	public static GerenciadorModos meuGerenciador;
	
	public Modo() {};
	
	public void setGerenciador(GerenciadorModos meuGerenciador) {
		this.meuGerenciador = meuGerenciador;
	}
	public abstract void pintarTela(Graphics g); 	
	public abstract void loop(); 	
	public abstract void carregarImagens();	
	public abstract void keyTyped(KeyEvent e);
	public abstract void keyPressed(KeyEvent e);
	public abstract void keyReleased(KeyEvent e);

}