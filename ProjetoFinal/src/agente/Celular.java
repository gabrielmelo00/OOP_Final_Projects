package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import jogo.Comodo;
import jogo.midia.Carregador;

public class Celular extends Agente {

	private Image imgCelular;
	private Comodo meuComodo;
	private int contadorTempoCelula;
	private int estado;

	public Celular(int i, int j, int escala, Comodo meuComodo, int ciclos) {
		super(i, j, escala, 'V', ciclos);
		this.meuComodo = meuComodo;
		contadorTempoCelula = 0;
		estado = 0;
		imgCelular = new ImageIcon(Carregador.Imagens.get(Carregador.CELULAR).getImage().getScaledInstance(escala,escala, 1)).getImage();
	}

	public void mover() {
		contadorTempoCelula ++;
		if(contadorTempoCelula == ciclos) {
			contadorTempoCelula = 0;
			meuComodo.retirarCelula(i, j,this);
			if(estado == 0) {
				if(meuComodo.inserirCelula(i,j+1,this)) {
					j++;
				}else {
					estado = 1;
					meuComodo.inserirCelula(i, j-1, this);
					j--;
				}
			}else {
				if(meuComodo.inserirCelula(i, j-1, this)) {
					j--;
				}else {
					estado = 0;
					meuComodo.inserirCelula(i,j+1,this);
					j++;
				}
			}
			
		}
		
	}

	public Image getImagem() {
		return imgCelular;
	}

	public char getTipoAgente() {
		return tipoAgente;
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

	public void colisao(char tipo) {}

}
