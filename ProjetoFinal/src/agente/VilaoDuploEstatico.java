package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

import jogo.Comodo;

public class VilaoDuploEstatico extends Agente{
	
	private Comodo meuComodo;
	private int contadorTempoCelula;
	private Agente transparente;

	public VilaoDuploEstatico(int i, int j, Comodo meuComodo, int ciclos, Image img) {
		super(i, j,  'V', ciclos, img);
		this.meuComodo = meuComodo;
		contadorTempoCelula = 0;
		transparente = new VilaoTransparente(i, j+1);
	}

	public void mover() {
		contadorTempoCelula ++;
		if(contadorTempoCelula == ciclos) {
			contadorTempoCelula = 0;
			meuComodo.retirarCelula(i, j,this);
			meuComodo.retirarCelula(i, j+1, transparente);
			if(meuComodo.inserirCelula(i,j+1, this)) {
				meuComodo.inserirCelula(i, j + 2, transparente);
				j = j+1;
			}else {
				j = meuComodo.inserirCelulaInicioX(i,this);
				meuComodo.inserirCelula(i, j+1, transparente);
			}
		}
	}

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
