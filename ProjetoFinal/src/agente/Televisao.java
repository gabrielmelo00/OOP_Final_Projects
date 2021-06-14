package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import jogo.Comodo;
import jogo.midia.Carregador;

public class Televisao extends Agente{
	
	private Image imgTV;
	private Image imgTVSom;
	private Image img;
	private int estado;
	private Comodo meuComodo;
	private Transparente dir;
	//private Transparente esq;
	private int contadorTempoCelula;
	
	public Televisao(int i, int j, int escala, Comodo meuComodo, int ciclos) {
		super(i, j, escala, 'V', ciclos);
		this.meuComodo = meuComodo;
		contadorTempoCelula = 0;
		imgTV = new ImageIcon(Carregador.Imagens.get(Carregador.TV).getImage().getScaledInstance(escala,escala, 1)).getImage();
		imgTVSom = new ImageIcon(Carregador.Imagens.get(Carregador.TV_SOM).getImage().getScaledInstance(escala*2,escala, 1)).getImage();
		dir = new Transparente(i, j, 0);
		//esq = new Transparente(i, j, 0);
		estado = 0;
		img = imgTV;

	}

	public void mover() {
		contadorTempoCelula ++;
		if(contadorTempoCelula == ciclos) {
			contadorTempoCelula = 0;			
			if(meuComodo.inserirCelula(i, j+1, this)) {
				meuComodo.retirarCelula(i,j, this);
				j++;
				if(estado == 0) {
					meuComodo.inserirCelula(i,j+1, dir);
					//meuComodo.inserirCelula(i, j-1, esq);
					estado = 1;
					img = imgTVSom;
				}else {
					meuComodo.retirarCelula(i,j, dir);
					//meuComodo.retirarCelula(i,j-2, esq);
					img = imgTV;
					estado = 0;
				}
				
			}else {
				meuComodo.retirarCelula(i, j,this);
				if(estado == 1) {
					meuComodo.retirarCelula(i, j+1, dir);
					//meuComodo.retirarCelula(i, j-1, esq);
					j = meuComodo.inserirCelulaInicioX(i, this);
					estado = 0;
					img = imgTV;
				}else {
					j = meuComodo.inserirCelulaInicioX(i, this);
					meuComodo.inserirCelula(i, j+1, dir);
					//meuComodo.inserirCelula(i, j-1, esq);
					estado = 1;
					img = imgTVSom;
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
