package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import jogo.Comodo;
import jogo.midia.Carregador;

public class Mangueira extends Agente{
	
	private Image imgMangueira;
	private Comodo meuComodo;
	private int contadorTempoCelula;
	private Agente transparente;

	public Mangueira(int i, int j, int escala, Comodo meuComodo, int ciclos) {
		super(i, j, escala, 'V', ciclos);
		this.meuComodo = meuComodo;
		contadorTempoCelula = 0;
		transparente = new Transparente(i, j+1, escala);
		imgMangueira = new ImageIcon(Carregador.Imagens.get(Carregador.MANGUEIRA).getImage().getScaledInstance(2*escala,escala, 1)).getImage();
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
		return imgMangueira;
	}

	public char getTipoAgente() {
		return tipoAgente;
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

	public void colisao(char tipo) {}

}
