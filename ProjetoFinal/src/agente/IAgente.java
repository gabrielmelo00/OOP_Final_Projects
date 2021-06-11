package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

public interface IAgente {
	
	public void mover();
	public Image getImagem();
	public char getTipoAgente();
	public void keyTyped(KeyEvent e);
	public void keyPressed(KeyEvent e);
	public void keyReleased(KeyEvent e);
	public void colisao(char tipo);

}
