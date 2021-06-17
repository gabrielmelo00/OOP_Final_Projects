package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import jogo.midia.Carregador;

public class Pia  extends Agente{
	
	private Image imgPia;
 
	public Pia(int i, int j, int escala) {
		super(i, j, escala, 'P', 0);
		imgPia = new ImageIcon(Carregador.Imagens.get(Carregador.PIA).getImage().getScaledInstance(escala,escala, 1)).getImage();
	}

	public void mover() {}

	public Image getImagem() {
		return imgPia;
	}

	public char getTipoAgente() {
		return tipoAgente;
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

	public void colisao(char tipo) {}
}
