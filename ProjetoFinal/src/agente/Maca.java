package agente;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import jogo.Comodo;
import jogo.midia.Carregador;

public class Maca extends Agente{
	
	private Image maca;
	private Image macaLagarta;
	private Image img;
	private int contadorTempoCelula;
	private Comodo meuComodo;
	
	private Lagarta lagarta;
	
	private int estado;
	
	
	
	Maca(int i, int j, int escala, Comodo meuComodo, int ciclos){
		super(i,j,escala,'V', ciclos);
		this.meuComodo = meuComodo;
		contadorTempoCelula = 0;
		estado = 0;
		maca = new ImageIcon(Carregador.Imagens.get(Carregador.MACA).getImage().getScaledInstance(escala,escala, 1)).getImage();
		macaLagarta = new ImageIcon(Carregador.Imagens.get(Carregador.MACA_LAGARTA).getImage().getScaledInstance(2*escala,escala, 1)).getImage();
		img = maca;
		lagarta = new Lagarta(escala);
	}
	

	public void mover() {
		contadorTempoCelula ++;
		if(contadorTempoCelula == ciclos) {
			contadorTempoCelula = 0;				
			if(meuComodo.inserirCelula(i, j+1, this)) {
				meuComodo.retirarCelula(i,j, this);
				j++;
				if(estado == 0) {
					meuComodo.inserirCelula(i,j+1, lagarta);
					estado =1;
					img = macaLagarta;
				}else {
					meuComodo.retirarCelula(i,j, lagarta);
					img = maca;
					estado = 0;
				}
			}else {
				meuComodo.retirarCelula(i, j,this);
				if(estado == 0) {
					j = meuComodo.inserirCelulaInicioX(i, this);
					meuComodo.inserirCelula(i,  j+1,  lagarta);
					estado = 1;
					img = macaLagarta;
				}else {
					meuComodo.retirarCelula(i, j+1, lagarta);
					j = meuComodo.inserirCelulaInicioX(i, this);
					estado = 0;
					img = maca;
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
