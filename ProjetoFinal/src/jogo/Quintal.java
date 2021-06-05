package jogo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import midia.Carregador;

public class Quintal implements IComodo {
	
	private Image imgQuintal;
	private int altura;
	private int largura;
	private int inicioQuintalX;
	private int fimQuintalX;
	private ArrayList<Agente> meusAgentes;
	
	public Quintal(){
		meusAgentes = new ArrayList<Agente>();
		carregarImagens();
		adicionarAgentes();
	}
	
	public void carregarImagens() {
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	    altura = (int) tela.getHeight();
	    largura =(int)  tela.getWidth();
	    inicioQuintalX = (largura - altura)/2;
	    fimQuintalX = inicioQuintalX + altura;
		imgQuintal = new ImageIcon(Carregador.Imagens.get(Carregador.BACKGROUND_QUINTAL).getImage().getScaledInstance( altura, altura, 1)).getImage();
	}
	
	public void adicionarAgentes() {
		meusAgentes.add(0, new Estudante(inicioQuintalX, altura -200));
		meusAgentes.add(1, new Maca(inicioQuintalX,10));
	}

	public void pintarTela(Graphics g) {
		g.drawImage(imgQuintal, inicioQuintalX, 0, null);
		for(int i = 0; i < meusAgentes.size(); i++) {
			meusAgentes.get(i).pintarTela(g);
		}	
	}

	public void mover() {
		for(int i = 0; i < meusAgentes.size(); i++) {
			meusAgentes.get(i).mover();
		}
		
	}

	public void keyTyped(KeyEvent e) {
		meusAgentes.get(0).keyTyped(e);
	}

	public void keyPressed(KeyEvent e) {
		meusAgentes.get(0).keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		meusAgentes.get(0).keyReleased(e);
		
	}


}
