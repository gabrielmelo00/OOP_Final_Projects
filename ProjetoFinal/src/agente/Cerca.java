package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import jogo.midia.Carregador;

public class Cerca extends Agente{
	
	private Image imgCerca;

	public Cerca(int i, int j, int escala) {
		super(i, j, escala, 'P', 0);
		imgCerca = new ImageIcon(Carregador.Imagens.get(Carregador.CERCA).getImage().getScaledInstance(escala,escala, 1)).getImage();
		
	}

	public void mover() {}

	public Image getImagem() {
		return imgCerca;
	}

	public char getTipoAgente() {
		return tipoAgente;
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

	public void colisao(char tipo) {}
	
	

}
