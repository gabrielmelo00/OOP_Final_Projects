package jogo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import framework.Modo;
import javax.swing.ImageIcon;

import midia.Carregador;

public class Maca extends Agente{
	
	private Image maca;
	private Image macaLagarta;
	private Image img;
	private int contadorTempoCelula;
	private Quintal meuQuintal;
	
	private Agente lagarta;
	
	private int estado;
	
	private static int TEMPO_CELULA = 50;
	
	Maca(int i, int j, int escala, Quintal meuQuintal){
		super(i, j, escala);
		this.meuQuintal = meuQuintal;
		tipoAgente = 'V'; //vilao
		contadorTempoCelula = 0;
		estado = 0;
		maca = new ImageIcon(Carregador.Imagens.get(Carregador.MACA).getImage().getScaledInstance(escala,escala, 1)).getImage();
		macaLagarta = new ImageIcon(Carregador.Imagens.get(Carregador.MACA_LAGARTA).getImage().getScaledInstance(2*escala,escala, 1)).getImage();
		img = maca;
		lagarta = new Lagarta(escala);
	}

	public void pintarTela(Graphics g) {
       // g.drawImage(maca, xTela, yTela, null);
	}
	
	public Image getImagem() {
		return img;		
	}

	public void mover() {
		contadorTempoCelula ++;
		if(contadorTempoCelula == TEMPO_CELULA) {
			contadorTempoCelula = 0;			
			
			if(meuQuintal.inserirCelula(i, j+1, this)) {
				meuQuintal.retirarCelula(i,j, this);
				j++;
			}else {
				meuQuintal.inserirCelula(i, 0,this);
				meuQuintal.retirarCelula(i, j,this);
				j = 0;
			}
			if(estado == 0) {
				meuQuintal.inserirCelula(i,j+1, lagarta);
				estado = 1;
				img = macaLagarta;
			}else {
				meuQuintal.retirarCelula(i,j, lagarta);
				img = maca;
				estado = 0;
			}
		}
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

	public char getTipoAgente() {
		return tipoAgente;
	}

	public void colisao(char tipo) {
		
	}
	
	

}
