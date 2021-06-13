package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import jogo.Comodo;
import jogo.midia.Carregador;

public class Cachorro extends Agente{
	
	private Image cachorro;
	private Image cachorro_2;
	private Comodo meuComodo;
	private int contadorTempoCelula;
	private int estado;
	private int TEMPO = 30;
	

	public Cachorro(int i, int j, int escala, Comodo meuComodo) {
		super(i, j, escala, 'V');
		this.meuComodo = meuComodo;
		contadorTempoCelula = 0;
		estado = 0;
		cachorro = new ImageIcon(Carregador.Imagens.get(Carregador.CACHORRO).getImage().getScaledInstance(escala,escala-2, 1)).getImage();
		cachorro_2 = new ImageIcon(Carregador.Imagens.get(Carregador.CACHORRO_2).getImage().getScaledInstance(escala,escala-2, 1)).getImage();
	}

	public void mover() {
		contadorTempoCelula ++;
		if(contadorTempoCelula == TEMPO) {
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
			return cachorro;
		}else {
			return cachorro_2;
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
