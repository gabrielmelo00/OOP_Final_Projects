package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import jogo.Comodo;
import jogo.midia.Carregador;

public class Gato extends Agente{
	
	private Image imgGato;
	private Image imgGato_2;
	private Comodo meuComodo;
	private int contadorTempoCelula;
	private int estado;

	public Gato(int i, int j, int escala, Comodo meuComodo, int ciclos) {
		super(i, j, escala, 'V', ciclos);
		this.meuComodo = meuComodo;
		contadorTempoCelula = 0;
		estado = 0;
		imgGato = new ImageIcon(Carregador.Imagens.get(Carregador.GATO).getImage().getScaledInstance(escala,escala, 1)).getImage();
		imgGato_2 = new ImageIcon(Carregador.Imagens.get(Carregador.GATO_2).getImage().getScaledInstance(escala,escala, 1)).getImage();
	}


	public void mover() {
		contadorTempoCelula ++;
		if(contadorTempoCelula == ciclos) {
			contadorTempoCelula = 0;
			meuComodo.retirarCelula(i, j, this);
			if(meuComodo.inserirCelula(i, j-1, this)) {
				j = j-1;
			}else {
				j = meuComodo.inserirCelulaFimX(i, this);
			}
			if(estado == 0) {
				estado = 1;
			}else {
				estado = 0;
			}
		}
		
	}

	public Image getImagem() {
		if(estado == 0) {
			return imgGato;
		}else {
			return imgGato_2;
		}
	}

	public char getTipoAgente() {
		return tipoAgente;
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

	public void colisao(char tipo) {}

}
