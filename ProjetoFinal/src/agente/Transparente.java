package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

public class Transparente extends Agente{

	public Transparente(int i, int j, int escala) {
		super(i, j, 0,'V', 0);
	}

	public void mover() {}

	public Image getImagem() {
		return null;
	}

	public char getTipoAgente() {
		return tipoAgente;
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

	public void colisao(char tipo) {}

}
