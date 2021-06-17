package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import jogo.Comodo;
import jogo.midia.Carregador;

public class Livro extends Agente {

	private Image imgLivro;
	private Comodo meuComodo;
	private int contadorTempoCelula;

	public Livro(int i, int j, int escala, Comodo meuComodo, int ciclos) {
		super(i, j, escala, 'V', ciclos);
		this.meuComodo = meuComodo;
		contadorTempoCelula = 0;
		imgLivro = new ImageIcon(Carregador.Imagens.get(Carregador.LIVRO).getImage().getScaledInstance(escala,escala, 1)).getImage();
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
		}
		
	}

	public Image getImagem() {
		return imgLivro;
	}

	public char getTipoAgente() {
		return tipoAgente;
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

	public void colisao(char tipo) {}
	

}
