package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import jogo.midia.Carregador;

public class Armario extends Agente {

	private Image imgArmario;

	public Armario(int i, int j,int escala) {
		super(i, j, escala, 'P', 0);
		imgArmario = new ImageIcon(Carregador.Imagens.get(Carregador.ARMARIO_1).getImage().getScaledInstance(escala,escala, 1)).getImage();
	}
	
	public void mover() {}

	public Image getImagem() {
		return imgArmario;
	}

	public char getTipoAgente() {
		return tipoAgente;
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

	public void colisao(char tipo) {}

}
