package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;
import jogo.Comodo;

public class VilaoD extends Agente{
	
	private Comodo meuComodo;
	private int contadorTempoCelula;

	public VilaoD(int i, int j,  Comodo meuComodo, int ciclos, Image img) {
		super(i, j,  'V', ciclos, img);
		this.meuComodo = meuComodo;
		contadorTempoCelula = 0;
	}

	public void mover() {
		contadorTempoCelula ++;
		if(contadorTempoCelula == ciclos) {
			contadorTempoCelula = 0;
			meuComodo.retirarCelula(i, j,this);
			if(meuComodo.inserirCelula(i,j+1, this)) {
				j = j+1;
			}else {
				j = meuComodo.inserirCelulaInicioX(i,this);
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
