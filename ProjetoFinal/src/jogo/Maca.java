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
	private Image transparente;
	private Image img;
	private int contadorTempoCelula;
	private Quintal meuQuintal;
	
	private int estado;
	
	private static int TEMPO_CELULA = 30;
	//private int xTelaLimite;
   
	
	/*Maca(int posicaoInicialX, int posicaoInicialY, int i, int j, int lado, Modo meuComodo) {
		super(posicaoInicialX,  posicaoInicialY,  i,  j,  lado, meuComodo);
		maca = new ImageIcon(Carregador.Imagens.get(Carregador.MACA).getImage().getScaledInstance(lado, lado, 1)).getImage();
		xTelaLimite = xTela + lado;
	}*/
	
	Maca(int i, int j, int escala, Quintal meuQuintal){
		super(i, j, escala);
		this.meuQuintal = meuQuintal;
		tipoAgente = 'V'; //vilao
		contadorTempoCelula = 0;
		estado = 0;
		maca = new ImageIcon(Carregador.Imagens.get(Carregador.MACA).getImage().getScaledInstance(escala,escala, 1)).getImage();
		macaLagarta = new ImageIcon(Carregador.Imagens.get(Carregador.MACA_LAGARTA).getImage().getScaledInstance(2*escala,escala, 1)).getImage();
		transparente = new ImageIcon(Carregador.Imagens.get(Carregador.TRANSPARENTE).getImage().getScaledInstance(escala,escala, 1)).getImage();
		img = maca;
	}

	public void pintarTela(Graphics g) {
       // g.drawImage(maca, xTela, yTela, null);
	}
	
	public Image getImagem() {
		//Image aux = img;
		//img = transparente;
		return img;		
	}

	public void mover() {
		contadorTempoCelula ++;
		if(contadorTempoCelula == TEMPO_CELULA) {
			contadorTempoCelula = 0;
			/*if(estado == 0) {
				if(meuQuintal.inserirCelula(i, j+1, this)) {
					meuQuintal.inserirCelula(i, j+2, this);
					meuQuintal.retirarCelula(i, j, this);
					j++;
				}else {
					meuQuintal.inserirCelula(i,0,this);
					meuQuintal.retirarCelula(i, 1, this);
					j = 0;
				}
				//img = macaLagarta;
				estado = 1;	
			}else if(estado == 1) {
				if(meuQuintal.inserirCelula(i,  j+1, this)) {
					meuQuintal.retirarCelula(i, j, this);
					meuQuintal.retirarCelula(i, j-1, this);
					j++;
				}else {
					meuQuintal.inserirCelula(i,0,this);
					meuQuintal.retirarCelula(i, j, this);
					meuQuintal.retirarCelula(i, j-1, this);
				}
				//img = maca;
				estado = 0;
			}*/
			
			
			if(estado == 0) {
				estado = 1;
				img = macaLagarta;
			}else {
				estado = 0;
				img = maca;
			}
			if(meuQuintal.inserirCelula(i,j + 1, this)) {
				meuQuintal.retirarCelula(i, j, this);
				this.j++;
			}else {
				meuQuintal.inserirCelula(i,0,this);
				meuQuintal.retirarCelula(i, j, this);
				j = 0;
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
