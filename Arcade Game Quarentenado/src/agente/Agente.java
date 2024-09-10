package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;


public abstract class Agente {
	
	protected int i;
	protected int j;
	protected int ciclos;
	protected char tipoAgente;
	protected Image img;
	
	
	public Agente(int i, int j, char tipoAgente, int ciclos, Image img) {
		this.i = i;
		this.j = j;
		this.tipoAgente = tipoAgente;
		this.ciclos = ciclos;
		this.img = img;
	}
	
	public int getTempo() {
		return 0;
	}
  
	public abstract void mover();
	public abstract Image getImagem();
	public abstract char getTipoAgente();
	public abstract void keyTyped(KeyEvent e);
	public abstract void keyPressed(KeyEvent e);
	public abstract void keyReleased(KeyEvent e);
	public abstract void colisao(char tipo);
}
