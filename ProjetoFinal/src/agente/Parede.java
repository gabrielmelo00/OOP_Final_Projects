package agente;

import java.awt.event.KeyEvent;
import java.awt.Image;

public class Parede extends Agente{
	
	public Parede(int i, int j, Image img) {
		super(i, j, 'P', 0, img);
		this.img = img;
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
