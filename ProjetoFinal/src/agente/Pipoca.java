package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;

import jogo.Comodo;
import jogo.midia.Carregador;

public class Pipoca extends Agente{
	
	private Image imgPipoca;
	private Comodo meuComodo;
	private int contadorTempoCelula;
	private int estado;

	public Pipoca(int i, int j, int escala, Comodo meuComodo, int ciclos) {
		super(i, j, escala, 'V', ciclos);
		this.meuComodo = meuComodo;
		contadorTempoCelula = 0;
		estado = 0;
		imgPipoca = new ImageIcon(Carregador.Imagens.get(Carregador.PIPOCA).getImage().getScaledInstance(escala,escala, 1)).getImage();	
	}	
	

	public void mover() {
		contadorTempoCelula ++;
		if(contadorTempoCelula == ciclos) {
			contadorTempoCelula = 0;
			meuComodo.retirarCelula(i, j, this);
			if(estado == 0) {
				estado = 1;
				if(meuComodo.inserirCelula(i, j+1, this)) {
					j = j+1;
				}else {
					j = meuComodo.inserirCelulaInicioX(i, this);
				}
			}else if(estado == 1) {
				estado = 2;
				if(meuComodo.inserirCelula(i+1, j, this)) {
					i = i+1;
				}else {
					i = meuComodo.inserirCelulaInicioY(j, this);
				}
			}else if(estado == 2) {
				estado = 3;
				if(meuComodo.inserirCelula(i, j-1, this)) {
					j = j-1;
				}else {
					j = meuComodo.inserirCelulaFimX(i,this);
				}
			}else if(estado == 3) {
				estado = 0;
				if(meuComodo.inserirCelula(i-1, j, this)) {
					i = i-1;
				}else {
					i = meuComodo.inserirCelulaFimY(j, this);
				}
			}
			
		}
		
	}
	
	

	public Image getImagem() {
		return imgPipoca;
	}

	public char getTipoAgente() {
		return tipoAgente;
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

	public void colisao(char tipo) {}

}
