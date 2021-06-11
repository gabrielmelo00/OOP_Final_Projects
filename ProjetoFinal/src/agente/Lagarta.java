package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import jogo.Comodo;
import midia.Carregador;

public class Lagarta implements IAgente{
	
	private int i;
	private int j;
	private char tipoAgente;
	
	private Image transparente;

	Lagarta(int i, int j, int escala) {
		this.i  = i;
		this.j = j;
		tipoAgente = 'V';
		transparente = new ImageIcon(Carregador.Imagens.get(Carregador.TRANSPARENTE).getImage().getScaledInstance(escala,escala, 1)).getImage();
	}
	
	Lagarta(int escala) {
		this(0,0,escala);
	}

	public void mover() {}

	public Image getImagem() {
		return transparente;
	}

	public char getTipoAgente() {
		return tipoAgente;
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

	public void colisao(char tipo) {}
	
	

}
