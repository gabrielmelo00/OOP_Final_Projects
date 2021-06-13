package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import jogo.Comodo;
import jogo.midia.Carregador;

public class Bola extends Agente{
	
	private Image imgBola;
	private Comodo meuComodo;
	private int contadorTempoCelula;
	private int TEMPO = 20;

	public Bola(int i, int j, int escala, Comodo meuComodo) {
		super(i, j, escala, 'V');
		this.meuComodo = meuComodo;
		contadorTempoCelula = 0;
		imgBola = new ImageIcon(Carregador.Imagens.get(Carregador.BOLA).getImage().getScaledInstance(escala,escala-2, 1)).getImage();
	}

	public void mover() {
		contadorTempoCelula ++;
		if(contadorTempoCelula == TEMPO) {
			contadorTempoCelula = 0;
			meuComodo.retirarCelula(i, j,this);
			if(meuComodo.inserirCelula(i,j+1, this)) {
				j = j+1;
			}else {
				meuComodo.inserirCelulaInicioX(i,this);
				j = 0;
			}
		}
		
	}

	public Image getImagem() {
		return imgBola;
	}

	public char getTipoAgente() {
		return tipoAgente;
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

	public void colisao(char tipo) {}
	
	

}
