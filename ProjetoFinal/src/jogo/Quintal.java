package jogo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import midia.Carregador;

public class Quintal extends Modo {
	
	private int altura;
	private int largura;
	private int inicioQuintalX; 
    private Image imgQuintal;
    private Image background;
    private Celula[][] matrizCelulas;
    private static final int TAMANHO = 11; 
    
	
	public Quintal(){
		carregarImagens();
		matrizCelulas = new Celula[TAMANHO][TAMANHO];
		carregarAgentes();
		
	}
	
	public void pintarTela(Graphics g) {
		Image imagem = new ImageIcon(background.getScaledInstance((int) largura, (int) altura, 1)).getImage();
        g.drawImage(imagem, 0, 0, null);
		g.drawImage(imgQuintal, inicioQuintalX, 0, null);
		
		for(int i = 0; i < TAMANHO; i++) {
			for(int j = 0; j < TAMANHO; j++) {
				if(matrizCelulas[i][j] != null) {
					matrizCelulas[i][j].pintarTela(g);
				}
			}
		}
		
	}

	
	public void loop() {
		for(int i = 0; i < TAMANHO; i++) {
			for(int j = 0; j < TAMANHO; j++) {
				matrizCelulas[i][j].mover();
			}
		}
		
	}

	
	public void carregarImagens() {
		background = Carregador.Imagens.get(Carregador.BACKGROUND_JOGO).getImage();
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	    altura = (int) tela.getHeight();
	    largura =(int)  tela.getWidth();
	    inicioQuintalX = (largura - altura)/2;
		imgQuintal = new ImageIcon(Carregador.Imagens.get(Carregador.BACKGROUND_QUINTAL).getImage().getScaledInstance( altura/TAMANHO, altura/TAMANHO, 1)).getImage();
	}
	
	public void carregarAgentes() {
		for(int i = 0; i < TAMANHO; i++) {
			for(int j = 0; j < TAMANHO; j++) {
				matrizCelulas[i][j] = new Celula(i,j);
			}
		}
		matrizCelulas[0][0].adicionaAgente(new Maca(inicioQuintalX - (altura/TAMANHO)/2,0,0,0,altura/TAMANHO,this));
	}
	
	public boolean trocarCelula(int i, int j, int novoi, int novoj, Agente g) {
		
		matrizCelulas[i][j].retiraAgente(g);
		matrizCelulas[i][j].adicionaAgente(g);
		return true;
		
	}

	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
