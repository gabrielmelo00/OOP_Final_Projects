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

public class Quintal extends Comodo{
	
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
    private static final int TAMANHO = 12; 
    
	
	public Quintal(){
		
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
		matrizCelulas[10][0].adicionaAgente(fabricaAgente.retornaAgente("CACHORRO",10, 0, delta, 20, this));
		matrizCelulas[10][4].adicionaAgente(fabricaAgente.retornaAgente("CACHORRO",10, 4, delta, 20, this));
		matrizCelulas[10][8].adicionaAgente(fabricaAgente.retornaAgente("CACHORRO",10, 8, delta, 20, this));
		
		matrizCelulas[9][0].adicionaAgente(fabricaAgente.retornaAgente("BOLA",9, 0, delta, 25, this));
		matrizCelulas[9][6].adicionaAgente(fabricaAgente.retornaAgente("BOLA",9, 6, delta, 25, this));
		
		matrizCelulas[8][3].adicionaAgente(fabricaAgente.retornaAgente("GATO",8, 3, delta, 30, this));
		matrizCelulas[8][7].adicionaAgente(fabricaAgente.retornaAgente("GATO",8, 7, delta, 30, this));
		matrizCelulas[8][11].adicionaAgente(fabricaAgente.retornaAgente("GATO",8, 11, delta, 30, this));
		
		matrizCelulas[7][3].adicionaAgente(fabricaAgente.retornaAgente("MANGUEIRA",7, 3, delta, 20, this));
		matrizCelulas[7][9].adicionaAgente(fabricaAgente.retornaAgente("MANGUEIRA",7, 9, delta, 20, this));
		
	
		matrizCelulas[5][1].adicionaAgente(fabricaAgente.retornaAgente("CERCA",5, 1, delta, 0, this));
		matrizCelulas[5][2].adicionaAgente(fabricaAgente.retornaAgente("CERCA",5, 2, delta, 0, this));
		matrizCelulas[5][3].adicionaAgente(fabricaAgente.retornaAgente("CERCA",5, 3, delta, 0, this));
		matrizCelulas[5][4].adicionaAgente(fabricaAgente.retornaAgente("CERCA",5, 4, delta, 0, this));
		matrizCelulas[5][5].adicionaAgente(fabricaAgente.retornaAgente("CERCA",5, 5, delta, 0, this));
		matrizCelulas[5][6].adicionaAgente(fabricaAgente.retornaAgente("CERCA",5, 6, delta, 0, this));
		matrizCelulas[5][7].adicionaAgente(fabricaAgente.retornaAgente("CERCA",5, 7, delta, 0, this));
		matrizCelulas[5][8].adicionaAgente(fabricaAgente.retornaAgente("CERCA",5, 8, delta, 0, this));
		matrizCelulas[5][9].adicionaAgente(fabricaAgente.retornaAgente("CERCA",5, 9, delta, 0, this));
		matrizCelulas[5][10].adicionaAgente(fabricaAgente.retornaAgente("CERCA",5, 10, delta, 0, this));
		matrizCelulas[5][11].adicionaAgente(fabricaAgente.retornaAgente("CERCA",5, 11, delta, 0, this));
		matrizCelulas[4][0].adicionaAgente(fabricaAgente.retornaAgente("BOLA",4, 0, delta, 15, this));
		matrizCelulas[4][4].adicionaAgente(fabricaAgente.retornaAgente("BOLA",4, 4, delta, 15, this));
		matrizCelulas[4][8].adicionaAgente(fabricaAgente.retornaAgente("BOLA",4, 8, delta, 15, this));
		matrizCelulas[3][3].adicionaAgente(fabricaAgente.retornaAgente("GATO",3, 3, delta, 20, this));
		matrizCelulas[3][7].adicionaAgente(fabricaAgente.retornaAgente("GATO",3, 7, delta, 20, this));
		matrizCelulas[3][11].adicionaAgente(fabricaAgente.retornaAgente("GATO",3, 11, delta, 20, this));
		matrizCelulas[1][0].adicionaAgente(fabricaAgente.retornaAgente("MANGUEIRA",1, 0, delta, 10, this));
		matrizCelulas[1][6].adicionaAgente(fabricaAgente.retornaAgente("MANGUEIRA",1, 6, delta, 10, this));	
		
		matrizCelulas[2][0].adicionaAgente(fabricaAgente.retornaAgente("CACHORRO",2, 0, delta, 20, this));
		matrizCelulas[2][4].adicionaAgente(fabricaAgente.retornaAgente("CACHORRO",2, 4, delta, 20, this));
		matrizCelulas[2][8].adicionaAgente(fabricaAgente.retornaAgente("CACHORRO",2, 8, delta, 20, this));
		
		matrizCelulas[0][0].adicionaAgente(fabricaAgente.retornaAgente("CERCA",0, 0, delta, 0, this));
		matrizCelulas[0][1].adicionaAgente(fabricaAgente.retornaAgente("CERCA",0, 1, delta, 0, this));
		matrizCelulas[0][2].adicionaAgente(fabricaAgente.retornaAgente("CERCA",0, 2, delta, 0, this));
		matrizCelulas[0][3].adicionaAgente(fabricaAgente.retornaAgente("CERCA",0, 3, delta, 0, this));
		matrizCelulas[0][4].adicionaAgente(fabricaAgente.retornaAgente("CERCA",0, 4, delta, 0, this));
		matrizCelulas[0][5].adicionaAgente(fabricaAgente.retornaAgente("CERCA",0, 5, delta, 0, this));
		matrizCelulas[0][6].adicionaAgente(fabricaAgente.retornaAgente("CERCA",0, 6, delta, 0, this));
		matrizCelulas[0][7].adicionaAgente(fabricaAgente.retornaAgente("CERCA",0, 7, delta, 0, this));
		matrizCelulas[0][8].adicionaAgente(fabricaAgente.retornaAgente("CERCA",0,8, delta, 0, this));
		matrizCelulas[0][9].adicionaAgente(fabricaAgente.retornaAgente("CERCA",0, 9, delta, 0, this));
		matrizCelulas[0][10].adicionaAgente(fabricaAgente.retornaAgente("CERCA",0, 10, delta, 0, this));
		
		matrizCelulas[0][11].adicionaAgente(fabricaAgente.retornaAgente("OBJETIVO",0, 11, delta, 0, this));
		
		estudante = fabricaAgente.retornaAgente("ESTUDANTE" ,11, 11, delta, 0, this);
		matrizCelulas[11][11].adicionaAgente(estudante);
	}
	
	public boolean inserirCelula(int i, int j, Agente g) {
		if(i >= 0 && i < TAMANHO && j >= 0 && j < TAMANHO) {
			return matrizCelulas[i][j].adicionaAgente(g);
		}else {
			return false;
		}
	}
	
	public int inserirCelulaInicioX(int i, Agente g) {
		int jAux = 0;
		while(!matrizCelulas[i][jAux].adicionaAgente(g)){
			jAux = jAux + 1;
		}
		return jAux;
	}
	
	public int inserirCelulaFimX(int i, Agente g) {
		int jAux = TAMANHO -1;
		while(!matrizCelulas[i][jAux].adicionaAgente(g)) {
			jAux = jAux -1;
		}
		return jAux;
	}
	
	public int inserirCelulaFimY(int j, Agente agente) {
        int iAux = TAMANHO -1;
        while(!matrizCelulas[iAux][j].adicionaAgente(agente)) {
        	iAux = iAux -1;
        }
		return iAux;
	}

	public int inserirCelulaInicioY(int j, Agente agente) {
        int iAux = 0;
        while(!matrizCelulas[iAux][j].adicionaAgente(agente)) {
        	iAux = iAux +1;
        }
		return iAux;
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
		imgQuintal = new ImageIcon(Carregador.Imagens.get(Carregador.BACKGROUND_QUINTAL).getImage().getScaledInstance( altura, altura, 1)).getImage();
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
		meuGerenciador.adicionarPilha(new Cozinha());
		
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
