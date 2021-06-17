package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import jogo.midia.Carregador;

public class Desktop extends Agente {

	private Image imgDesktop;
	 
	public Desktop(int i, int j, int escala) {
		super(i, j, escala, 'P', 0);
		imgDesktop = new ImageIcon(Carregador.Imagens.get(Carregador.DESKTOP).getImage().getScaledInstance(escala,escala, 1)).getImage();
	}

	public void mover() {}

	public Image getImagem() {
		return imgDesktop;
	}

	public char getTipoAgente() {
		return tipoAgente;
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

	public void colisao(char tipo) {}

}
