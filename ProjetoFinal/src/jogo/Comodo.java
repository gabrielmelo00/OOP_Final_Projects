package jogo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import agente.Agente;
import agente.IFabricaAgente;
import framework.Modo;

public abstract class Comodo extends Modo{
	
	protected int altura;
	protected int largura;
	protected int inicioQuintalX; 
	protected int inicioQuintalY;
	protected int delta;
	protected int faixa;
	protected IFabricaAgente fabricaAgente;
	protected Agente estudante;

	protected Celula[][] matrizCelulas;
	protected static final int TAMANHO = 12; 
	
	public Comodo(){		
		calculoDimensoes();
		matrizCelulas = new Celula[TAMANHO][TAMANHO];
		for(int i = 0; i < TAMANHO; i++) {
			for(int j = 0; j < TAMANHO; j++) {
				int x = inicioQuintalX + j*delta;
				int y = inicioQuintalY + i*delta;
				matrizCelulas[i][j] = new Celula(i,j, x, y);
			}
		}	
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

	public void loop() {
		for(int i = 0; i < TAMANHO; i++) {
			for(int j = 0; j < TAMANHO; j++) {
				matrizCelulas[i][j].mover();
				matrizCelulas[i][j].colisao();
			}
		}		
	}
	
	public boolean inserirCelula(int i, int j, Agente agente) {
		if(i >= 0 && i < TAMANHO && j >= 0 && j < TAMANHO) {
			return matrizCelulas[i][j].adicionaAgente(agente);
		}else {
			return false;
		}
	}

	public int inserirCelulaInicioX(int i, Agente agente) {
		int jAux = 0;
		while(!matrizCelulas[i][jAux].adicionaAgente(agente)){
			jAux = jAux + 1;
		}
		return jAux;
	}

	public int inserirCelulaFimX(int i, Agente agente) {
		int jAux = TAMANHO -1;
		while(!matrizCelulas[i][jAux].adicionaAgente(agente)) {
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

	public boolean retirarCelula(int i, int j, Agente agente) {
		if(i >= 0 && i < TAMANHO && j >= 0 && j < TAMANHO) {
			matrizCelulas[i][j].retiraAgente(agente);
			return true;
		}else {
			return false;
		}
	}
	
	public abstract void proximoNivel();
	
	public abstract void perdeuJogo();

	public abstract void pintarTela(Graphics g);
	
	public abstract void keyTyped(KeyEvent e);

	public abstract void keyPressed(KeyEvent e);

	public abstract void keyReleased(KeyEvent e);
	
	
	
	

	/*public abstract void pintarTela(Graphics g); 	
	public abstract void loop(); 	
	public abstract void carregarImagens();	
	public abstract void keyTyped(KeyEvent e);
	public abstract void keyPressed(KeyEvent e);
	public abstract void keyReleased(KeyEvent e);
	public abstract void calculoDimensoes();
	public abstract void carregarAgentes();
	public abstract boolean inserirCelula(int i, int j, Agente agente);
	public abstract int inserirCelulaInicioX(int i, Agente agente);
	public abstract int inserirCelulaFimX(int i, Agente agente);
	public abstract int inserirCelulaFimY(int j, Agente agente);
	public abstract int inserirCelulaInicioY(int j, Agente agente);
	public abstract boolean retirarCelula(int i, int j, Agente agente);
	public abstract void perdeuJogo();
	public abstract void proximoNivel();*/

}
