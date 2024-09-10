package jogo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import agente.FabricaAgente;
import jogo.midia.Carregador;

public class Quintal extends Comodo{
   
	private Image imgQuintal;
    private Image imgBackground;

	public Quintal(){
		
		fabricaAgente = new FabricaAgente();
		carregarImagens();
		carregarAgentes();
		
	}
	
	public void proximoNivel() {
		meuGerenciador.removerPilha();
		meuGerenciador.adicionarPilha(new Cozinha());
		
	}
	
	public void perdeuJogo() {
		meuGerenciador.removerPilha();
		meuGerenciador.adicionarPilha(new GameOver(estudante.getTempo()));
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
	
	public void keyTyped(KeyEvent e) {
		estudante.keyTyped(e);
		
	}

	
	public void keyPressed(KeyEvent e) {
		estudante.keyPressed(e);
	}

	
	public void keyReleased(KeyEvent e) {
		estudante.keyReleased(e);
	}
	
	public void carregarImagens() {
	    imgBackground = new ImageIcon(Carregador.Imagens.get(Carregador.BACKGROUND_JOGO).getImage().getScaledInstance( faixa, altura, 1)).getImage();
		imgQuintal = new ImageIcon(Carregador.Imagens.get(Carregador.BACKGROUND_QUINTAL).getImage().getScaledInstance( altura, altura, 1)).getImage();
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
	
}
