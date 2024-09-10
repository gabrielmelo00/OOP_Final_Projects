package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

public class VilaoTransparente extends Agente{
	

	public VilaoTransparente(int i, int j) {
		super(i, j, 'V', 0, null);
	}

	public void mover() {}

	public Image getImagem() {
		return img;
	}

	public char getTipoAgente() {
		return tipoAgente;
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

	public void colisao(char tipo) {}

}
