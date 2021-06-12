package jogo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import agente.Agente;
import agente.FabricaAgente;
import agente.IFabricaAgente;
import jogo.midia.Carregador;

public class Cozinha extends Comodo{

	private int altura;
	private int largura;
	private int inicioQuintalX; 
	private int inicioQuintalY;
	private int delta;
	private int faixa;
   
	private Image imgQuintal;
    private Image imgBackground;
    
    private Agente estudante;
    private IFabricaAgente fabricaAgente;
   
    private Celula[][] matrizCelulas;
    private static final int TAMANHO = 14; 
    
	
	public Cozinha(){
		
		fabricaAgente = new FabricaAgente();
		calculoDimensoes();
		carregarImagens();
		matrizCelulas = new Celula[TAMANHO][TAMANHO];
		
		for(int i = 0; i < TAMANHO; i++) {
			for(int j = 0; j < TAMANHO; j++) {
				int x = inicioQuintalX + j*delta;
				int y = inicioQuintalY + i*delta;
				matrizCelulas[i][j] = new Celula(i,j, x, y);
			}
		}
		carregarAgentes();
		
	}
	
	public void calculoDimensoes() {
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	    altura = (int) tela.getHeight();
	    largura = (int)  tela.getWidth();
	    inicioQuintalX = (largura - altura)/2;
	    inicioQuintalY = 0;
	    delta = altura/TAMANHO;
	    faixa = (largura - altura)/2;
	}
	
	public void carregarAgentes() {	
		matrizCelulas[1][0].adicionaAgente(fabricaAgente.retornaAgente("MACA",1, 0, delta, this));
		matrizCelulas[1][4].adicionaAgente(fabricaAgente.retornaAgente("MACA",1, 4, delta, this));
		matrizCelulas[1][8].adicionaAgente(fabricaAgente.retornaAgente("MACA",1, 8, delta, this));
		matrizCelulas[0][5].adicionaAgente(fabricaAgente.retornaAgente("OBJETIVO",0, 5, delta, this));
		estudante = fabricaAgente.retornaAgente("ESTUDANTE" ,13, 13, delta, this);
		matrizCelulas[13][13].adicionaAgente(estudante);
	}
	
	public boolean inserirCelula(int i, int j, Agente g) {
		if(i >= 0 && i < TAMANHO && j >= 0 && j < TAMANHO) {
			matrizCelulas[i][j].adicionaAgente(g);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean retirarCelula(int i, int j, Agente g) {
		if(i >= 0 && i < TAMANHO && j >= 0 && j < TAMANHO) {
			matrizCelulas[i][j].retiraAgente(g);
			return true;
		}else {
			return false;
		}
	}
	
	public void loop() {
		for(int i = 0; i < TAMANHO; i++) {
			for(int j = 0; j < TAMANHO; j++) {
				matrizCelulas[i][j].mover();
				matrizCelulas[i][j].colisao();
			}
		}
	}
	
	public void carregarImagens() {
	    imgBackground = new ImageIcon(Carregador.Imagens.get(Carregador.BACKGROUND_JOGO).getImage().getScaledInstance( faixa, altura, 1)).getImage();
		imgQuintal = new ImageIcon(Carregador.Imagens.get(Carregador.BACKGROUND_MENU).getImage().getScaledInstance( altura, altura, 1)).getImage();
	}
	
	public void pintarTela(Graphics g) {
		g.drawImage(imgQuintal, inicioQuintalX, 0, null);
		
		for(int i = 0; i < TAMANHO; i++) {
			for(int j = 0; j < TAMANHO; j++) {
				if(matrizCelulas[i][j] != null) {
					matrizCelulas[i][j].pintarTela(g);
				}
			}
		}
		g.drawImage(imgBackground, 0, 0, null);
		g.drawImage(imgBackground, largura - faixa, 0, null);
	}
	
	
	public void proximoNivel() {
		meuGerenciador.removerPilha();
		meuGerenciador.adicionarPilha(new GameOver());
		
	}
	
	public void perdeuJogo() {
		meuGerenciador.removerPilha();
		meuGerenciador.adicionarPilha(new GameOver());
	}
	
	public void keyTyped(KeyEvent e) {
		estudante.keyTyped(e);
		
	}

	
	public void keyPressed(KeyEvent e) {
		estudante.keyPressed(e);
	}

	
	public void keyReleased(KeyEvent e) {
		estudante.keyReleased(e);		
	}

}
