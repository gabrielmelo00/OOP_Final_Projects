package jogo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import midia.Carregador;

public class Maca extends Agente{
	
	private Image maca;
	private int xTelaLimite;
   
	
	Maca(int posicaoInicialX, int posicaoInicialY, int i, int j, int lado, Modo meuComodo) {
		super(posicaoInicialX,  posicaoInicialY,  i,  j,  lado, meuComodo);
		maca = new ImageIcon(Carregador.Imagens.get(Carregador.MACA).getImage().getScaledInstance(lado, lado, 1)).getImage();
		xTelaLimite = xTela + lado;
	}

	public void pintarTela(Graphics g) {
        g.drawImage(maca, xTela, yTela, null);
	}

	public void mover() {
		xTela += 5;	
		if(xTela == xTelaLimite) {
			xTela = xInicio;
			//meuComodo.trocarCelula(i,j,i,j++,this);
		}
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}
	
	

}
