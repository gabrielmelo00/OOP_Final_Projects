package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import jogo.Comodo;
import midia.Carregador;

public class Maca implements IAgente{
	
	private int i;
	private int j;
	protected char tipoAgente;
	
	private Image maca;
	private Image macaLagarta;
	private Image img;
	private int contadorTempoCelula;
	private Comodo meuComodo;
	
	private Lagarta lagarta;
	
	private int estado;
	
	private static int TEMPO_CELULA = 50;
	
	
	Maca(int i, int j, int escala, Comodo meuComodo){
	
		this.i = i;
		this.j = j;
		this.meuComodo = meuComodo;
		tipoAgente = 'V'; //vilao
		contadorTempoCelula = 0;
		estado = 0;
		
		maca = new ImageIcon(Carregador.Imagens.get(Carregador.MACA).getImage().getScaledInstance(escala,escala, 1)).getImage();
		macaLagarta = new ImageIcon(Carregador.Imagens.get(Carregador.MACA_LAGARTA).getImage().getScaledInstance(2*escala,escala, 1)).getImage();
		img = maca;
		lagarta = new Lagarta(escala);
	}
	

	public void mover() {
		contadorTempoCelula ++;
		if(contadorTempoCelula == TEMPO_CELULA) {
			contadorTempoCelula = 0;			
			
			if(meuComodo.inserirCelula(i, j+1, this)) {
				meuComodo.retirarCelula(i,j, this);
				j++;
			}else {
				meuComodo.inserirCelula(i, 0,this);
				meuComodo.retirarCelula(i, j,this);
				j = 0;
			}
			if(estado == 0) {
				meuComodo.inserirCelula(i,j+1, lagarta);
				estado = 1;
				img = macaLagarta;
			}else {
				meuComodo.retirarCelula(i,j, lagarta);
				img = maca;
				estado = 0;
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
