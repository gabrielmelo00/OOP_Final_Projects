package jogo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import framework.Modo;
import javax.swing.ImageIcon;

import midia.Carregador;

public class Tijolo extends Agente {
	
	private Image tijolo;
	private int altura;
	private int largura;
	
	public Tijolo(int x, int y, int altura, int largura) {
		super(x, y);
		tipoAgente = 'L'; //limitador
		this.altura = altura;
		this.largura = largura;
		tijolo = new ImageIcon(Carregador.Imagens.get(Carregador.TIJOLO).getImage().getScaledInstance(largura, altura, 1)).getImage();
	}

	public void pintarTela(Graphics g) {
		g.drawImage(tijolo, x, y, null);
	}

	public void mover() {}
	
	public Rectangle retornaFronteira() {
		return  new Rectangle(x, y, largura, altura);
	}
	
	public void verificaIntercecao(Agente agente) {
		Rectangle rAgente = agente.retornaFronteira();
		Rectangle rTijolo = retornaFronteira();
		if(rTijolo.contains(agente.getX(), agente.getY())) {
			agente.setVisivel(false);
		}
	}
	
	public void verificaColisao(Agente agente) {
		Rectangle rAgente = agente.retornaFronteira();
		Rectangle rTijolo = retornaFronteira();
		if(rTijolo.intersects(rAgente)) {
			agente.colisao();
		}
	}
	
	public void colisao() {
		
	}
	
	public void setVisivel(boolean estado) {
		visivel = estado;
	}
	
	public boolean getVisivel() {
		return visivel;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {}

}
