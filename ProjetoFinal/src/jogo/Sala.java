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

public class Sala extends Comodo {
	
	private int altura;
	private int largura;
	private int inicioQuintalX; 
	private int inicioQuintalY;
	private int delta;
	private int faixa;
   
	private Image imgSala;
    private Image imgBackground;
    
    private Agente estudante;
    private IFabricaAgente fabricaAgente;
   
    private Celula[][] matrizCelulas;
    private static final int TAMANHO = 12; 
	
	
	
	public Sala(){	
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
		imgSala = new ImageIcon(Carregador.Imagens.get(Carregador.BACKGROUND_SALA).getImage().getScaledInstance( altura, altura, 1)).getImage();		
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
		matrizCelulas[9][0].adicionaAgente(fabricaAgente.retornaAgente("PIPOCA",9, 0, delta, 20, this));
		matrizCelulas[9][2].adicionaAgente(fabricaAgente.retornaAgente("PIPOCA",9, 2, delta, 20, this));
		matrizCelulas[9][4].adicionaAgente(fabricaAgente.retornaAgente("PIPOCA",9, 4, delta, 20, this));
		matrizCelulas[9][6].adicionaAgente(fabricaAgente.retornaAgente("PIPOCA",9, 6, delta, 20, this));
		matrizCelulas[9][8].adicionaAgente(fabricaAgente.retornaAgente("PIPOCA",9, 8, delta, 20, this));
		matrizCelulas[9][10].adicionaAgente(fabricaAgente.retornaAgente("PIPOCA",9, 10, delta, 20, this));
		
		matrizCelulas[8][0].adicionaAgente(fabricaAgente.retornaAgente("RADIO",8, 0, delta, 25, this));
		matrizCelulas[8][6].adicionaAgente(fabricaAgente.retornaAgente("RADIO",8, 6, delta, 25, this));
		matrizCelulas[7][0].adicionaAgente(fabricaAgente.retornaAgente("TELEVISAO",7, 0, delta, 15, this));
		matrizCelulas[7][4].adicionaAgente(fabricaAgente.retornaAgente("TELEVISAO",7, 4, delta, 15, this));
		matrizCelulas[7][8].adicionaAgente(fabricaAgente.retornaAgente("TELEVISAO",7, 8, delta, 15, this));
		
		matrizCelulas[5][2].adicionaAgente(fabricaAgente.retornaAgente("RADIO",5, 2, delta, 15, this));
		matrizCelulas[5][5].adicionaAgente(fabricaAgente.retornaAgente("RADIO",5, 5, delta, 15, this));
		matrizCelulas[5][8].adicionaAgente(fabricaAgente.retornaAgente("RADIO",5, 8, delta, 15, this));
		matrizCelulas[5][11].adicionaAgente(fabricaAgente.retornaAgente("RADIO",5, 11, delta, 15, this));

		matrizCelulas[4][2].adicionaAgente(fabricaAgente.retornaAgente("VIDEOGAME",4, 2, delta, 10, this));
		matrizCelulas[4][6].adicionaAgente(fabricaAgente.retornaAgente("VIDEOGAME",4, 6, delta, 10, this));
		matrizCelulas[4][10].adicionaAgente(fabricaAgente.retornaAgente("VIDEOGAME",4, 10, delta, 10, this));
		
		matrizCelulas[3][2].adicionaAgente(fabricaAgente.retornaAgente("TELEVISAO",3, 2, delta, 15, this));
		matrizCelulas[3][8].adicionaAgente(fabricaAgente.retornaAgente("TELEVISAO",3, 8, delta, 15, this));
		
		matrizCelulas[1][0].adicionaAgente(fabricaAgente.retornaAgente("PIPOCA",1, 0, delta, 20, this));
		matrizCelulas[1][2].adicionaAgente(fabricaAgente.retornaAgente("PIPOCA",1, 2, delta, 20, this));
		matrizCelulas[1][4].adicionaAgente(fabricaAgente.retornaAgente("PIPOCA",1, 4, delta, 20, this));
		matrizCelulas[1][6].adicionaAgente(fabricaAgente.retornaAgente("PIPOCA",1, 6, delta, 20, this));
	    matrizCelulas[1][8].adicionaAgente(fabricaAgente.retornaAgente("PIPOCA",1, 8, delta, 20, this));
		matrizCelulas[1][10].adicionaAgente(fabricaAgente.retornaAgente("PIPOCA",1, 10, delta, 20, this));
		
		matrizCelulas[0][5].adicionaAgente(fabricaAgente.retornaAgente("OBJETIVO",0, 5, delta, 0, this));

		estudante = fabricaAgente.retornaAgente("ESTUDANTE" ,11, 11, delta, 0, this);
		matrizCelulas[11][11].adicionaAgente(estudante);		
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

	public void perdeuJogo() {
		meuGerenciador.removerPilha();
		meuGerenciador.adicionarPilha(new GameOver());		
	}

	public void proximoNivel() {
		meuGerenciador.removerPilha();
		meuGerenciador.adicionarPilha(new GameOver());	
	}
	
	public void pintarTela(Graphics g) {
		g.drawImage(imgSala, inicioQuintalX, 0, null);
		
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
