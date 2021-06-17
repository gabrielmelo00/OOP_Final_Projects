package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

import jogo.Comodo;

public class VilaoDuploDinamico extends Agente{
	
	private Image img1;
	private Image img2;
	private int contadorTempoCelula;
	private int estado;
	private Comodo meuComodo;
	private Agente transparente;
	

	public VilaoDuploDinamico(int i, int j, Comodo meuComodo, int ciclos, Image img1, Image img2) {
		super(i, j, 'V', ciclos, null);
		this.meuComodo = meuComodo;
		this.img1 = img1;
		this.img2 = img2;
		contadorTempoCelula = 0;
		estado = 0;
		img = img1;
		transparente = new VilaoTransparente(i, j);
		
	}

	public void mover() {
		contadorTempoCelula ++;
		if(contadorTempoCelula == ciclos) {
			contadorTempoCelula = 0;				
			if(meuComodo.inserirCelula(i, j+1, this)) {
				meuComodo.retirarCelula(i,j, this);
				j++;
				if(estado == 0) {
					meuComodo.inserirCelula(i,j+1, transparente);
					estado =1;
					img = img2;
				}else {
					meuComodo.retirarCelula(i,j, transparente);
					img = img1;
					estado = 0;
				}
			}else {
				meuComodo.retirarCelula(i, j,this);
				if(estado == 0) {
					j = meuComodo.inserirCelulaInicioX(i, this);
					meuComodo.inserirCelula(i,  j+1,  transparente);
					estado = 1;
					img = img2;
				}else {
					meuComodo.retirarCelula(i, j+1, transparente);
					j = meuComodo.inserirCelulaInicioX(i, this);
					estado = 0;
					img = img1;
				}
				
				
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
