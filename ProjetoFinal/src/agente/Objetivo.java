package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import jogo.Comodo;
import midia.Carregador;

public class Objetivo implements IAgente{
	
	private int i;
	private int j;
	private int escala;
	private char tipoAgente;
	
	private Image imgObjetivo;
	private Comodo meuComodo;

	Objetivo(int i, int j, int escala, Comodo meuComodo) {
		this.i = i;
		this.j = j;
		this.escala = escala;
		this.meuComodo = meuComodo;
		tipoAgente = 'O'; //objetivo
		imgObjetivo = new ImageIcon(Carregador.Imagens.get(Carregador.OBJETIVO).getImage().getScaledInstance(escala, escala, 1)).getImage();
	}


	public void mover() {}

	public Image getImagem() {
		return imgObjetivo;
	}


	public char getTipoAgente() {
		return tipoAgente;
	}


	public void keyTyped(KeyEvent e) {}


	public void keyPressed(KeyEvent e) {}


	public void keyReleased(KeyEvent e) {}

	public void colisao(char tipo) {}

}
