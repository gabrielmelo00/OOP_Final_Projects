package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;


public abstract class Agente {
	
	protected int i;
	protected int j;
	protected int ciclos;
	protected int escala;
	protected char tipoAgente;
	
	
	public Agente(int i, int j, int escala, char tipoAgente, int ciclos) {
		this.i = i;
		this.j = j;
		this.escala = escala;
		this.tipoAgente = tipoAgente;
		this.ciclos = ciclos;
	}
  
	public abstract void mover();
	public abstract Image getImagem();
	public abstract char getTipoAgente();
	public abstract void keyTyped(KeyEvent e);
	public abstract void keyPressed(KeyEvent e);
	public abstract void keyReleased(KeyEvent e);
	public abstract void colisao(char tipo);
}
