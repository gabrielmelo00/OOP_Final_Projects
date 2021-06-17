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

public class Quarto extends Comodo {
	private int altura;
	private int largura;
	private int inicioQuintalX; 
	private int inicioQuintalY;
	private int delta;
	private int faixa;
   
	private Image imgComodo;
    private Image imgBackground;
    
    private Agente estudante;
    private IFabricaAgente fabricaAgente;
   
    private Celula[][] matrizCelulas;
    private static final int TAMANHO = 12; 
    
	
	public Quarto(){
		
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
		imgComodo = new ImageIcon(Carregador.Imagens.get(Carregador.BACKGROUND_QUARTO).getImage().getScaledInstance( altura, altura, 1)).getImage();
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
		
		matrizCelulas[0][0].adicionaAgente(fabricaAgente.retornaAgente("DESKTOP",0, 0, delta, 0, this));
		matrizCelulas[0][1].adicionaAgente(fabricaAgente.retornaAgente("DESKTOP",0, 1, delta, 0, this));
		matrizCelulas[0][2].adicionaAgente(fabricaAgente.retornaAgente("OBJETIVO",0, 2, delta, 0, this));
		
		matrizCelulas[0][11].adicionaAgente(fabricaAgente.retornaAgente("DESKTOP",0, 11, delta, 0, this));
		matrizCelulas[0][10].adicionaAgente(fabricaAgente.retornaAgente("DESKTOP",0, 10, delta, 0, this));
		matrizCelulas[0][9].adicionaAgente(fabricaAgente.retornaAgente("OBJETIVO",0, 9, delta, 0, this));
		
		//matrizCelulas[0][6].adicionaAgente(fabricaAgente.retornaAgente("CELULAR",0, 6, delta, 5, this));
		matrizCelulas[1][0].adicionaAgente(fabricaAgente.retornaAgente("CELULAR",1, 0, delta, 5, this));
		
		matrizCelulas[2][0].adicionaAgente(fabricaAgente.retornaAgente("LIVRO",2, 0, delta, 10, this));
		matrizCelulas[2][4].adicionaAgente(fabricaAgente.retornaAgente("LIVRO",2, 4, delta, 10, this));
		matrizCelulas[2][8].adicionaAgente(fabricaAgente.retornaAgente("LIVRO",2, 8, delta, 10, this));
			
		
		matrizCelulas[10][0].adicionaAgente(fabricaAgente.retornaAgente("ROUPA_SUJA",10, 0, delta, 15, this));
		matrizCelulas[10][3].adicionaAgente(fabricaAgente.retornaAgente("ROUPA_SUJA",10, 3, delta, 15, this));
		matrizCelulas[10][6].adicionaAgente(fabricaAgente.retornaAgente("ROUPA_SUJA",10, 6, delta, 15, this));
		matrizCelulas[10][9].adicionaAgente(fabricaAgente.retornaAgente("ROUPA_SUJA",10, 9, delta, 15, this));
		
		matrizCelulas[9][0].adicionaAgente(fabricaAgente.retornaAgente("LIVRO",9, 0, delta, 10, this));
		matrizCelulas[9][6].adicionaAgente(fabricaAgente.retornaAgente("LIVRO",9, 6, delta, 10, this));
		
		matrizCelulas[8][0].adicionaAgente(fabricaAgente.retornaAgente("ROUPA_SUJA",8, 0, delta, 15, this));
		matrizCelulas[8][4].adicionaAgente(fabricaAgente.retornaAgente("ROUPA_SUJA",8, 4, delta, 15, this));
		matrizCelulas[8][8].adicionaAgente(fabricaAgente.retornaAgente("ROUPA_SUJA",8, 8, delta, 15, this));
		
		matrizCelulas[4][5].adicionaAgente(fabricaAgente.retornaAgente("CAMA_4",4, 5, delta, 0, this));
		matrizCelulas[4][6].adicionaAgente(fabricaAgente.retornaAgente("CAMA_3",4, 6, delta, 0, this));
		matrizCelulas[5][5].adicionaAgente(fabricaAgente.retornaAgente("CAMA_1",5, 5, delta, 0, this));
		matrizCelulas[5][6].adicionaAgente(fabricaAgente.retornaAgente("CAMA_1",5, 6, delta, 0, this));
		matrizCelulas[6][5].adicionaAgente(fabricaAgente.retornaAgente("CAMA_2",6, 5, delta, 0, this));
		matrizCelulas[6][6].adicionaAgente(fabricaAgente.retornaAgente("CAMA_2",6, 6, delta, 0, this));
		matrizCelulas[7][5].adicionaAgente(fabricaAgente.retornaAgente("CAMA_2",7, 5, delta, 0, this));
		matrizCelulas[7][6].adicionaAgente(fabricaAgente.retornaAgente("CAMA_2",7, 6, delta, 0, this));
		
		matrizCelulas[4][0].adicionaAgente(fabricaAgente.retornaAgente("ABAJUR",4, 0, delta, 15, this));
		matrizCelulas[4][7].adicionaAgente(fabricaAgente.retornaAgente("ABAJUR",4, 7, delta, 15, this));
		matrizCelulas[5][2].adicionaAgente(fabricaAgente.retornaAgente("CELULAR",5, 2, delta, 15, this));
		matrizCelulas[5][9].adicionaAgente(fabricaAgente.retornaAgente("CELULAR",5, 9, delta, 15, this));
		matrizCelulas[6][4].adicionaAgente(fabricaAgente.retornaAgente("ABAJUR",6, 4, delta, 15, this));
		matrizCelulas[6][11].adicionaAgente(fabricaAgente.retornaAgente("ABAJUR",6, 11, delta, 15, this));
		
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
		meuGerenciador.adicionarPilha(new Vitoria());	
	}
	
	public void pintarTela(Graphics g) {
		g.drawImage(imgComodo, inicioQuintalX, 0, null);
		
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

