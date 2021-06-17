package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;
import jogo.Comodo;


public class Objetivo extends Agente{

	Objetivo(int i, int j, Comodo meuComodo, int velocidade, Image img) {
		super(i,j,'O', velocidade, img);
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
