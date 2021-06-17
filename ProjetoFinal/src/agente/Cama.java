package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import jogo.midia.Carregador;

public class Cama extends Agente {

	private Image imgCama;
	int n;
	
	public Cama(int i, int j, int escala, int n) {
		super(i, j, escala, 'P', 0);
		switch(n) {
		case 1:
			imgCama = new ImageIcon(Carregador.Imagens.get(Carregador.CAMA_1).getImage().getScaledInstance(escala,escala, 1)).getImage();
			break;
		case 2:
			imgCama = new ImageIcon(Carregador.Imagens.get(Carregador.CAMA_2).getImage().getScaledInstance(escala,escala, 1)).getImage();
			break;
		case 3:
			imgCama = new ImageIcon(Carregador.Imagens.get(Carregador.CAMA_3).getImage().getScaledInstance(escala,escala, 1)).getImage();
			break;
		case 4:
			imgCama = new ImageIcon(Carregador.Imagens.get(Carregador.CAMA_4).getImage().getScaledInstance(escala,escala, 1)).getImage();
			break;
		}
		
	}

	public void mover() {}

	public Image getImagem() {
		return imgCama;
	}

	public char getTipoAgente() {
		return tipoAgente;
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

	public void colisao(char tipo) {}

}
