package jogo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import agente.Agente;
import agente.FabricaAgente;
import agente.IFabricaAgente;
import jogo.midia.Carregador;

public class Cozinha extends Comodo{
	
	private Image imgCozinha;
    private Image imgBackground;
    private IFabricaAgente fabricaAgente;
    private Agente estudante;
	
	public Cozinha(){		
		fabricaAgente = new FabricaAgente();
		carregarImagens();
		carregarAgentes();
	}
	
	public void proximoNivel() {
		meuGerenciador.removerPilha();
		meuGerenciador.adicionarPilha(new Sala());	
	}
	
	public void perdeuJogo() {
		meuGerenciador.removerPilha();
		meuGerenciador.adicionarPilha(new GameOver(estudante.getTempo()));		
	}
	
	public void pintarTela(Graphics g) {
		g.drawImage(imgCozinha, inicioQuintalX, 0, null);
		
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
		imgCozinha = new ImageIcon(Carregador.Imagens.get(Carregador.BACKGROUND_COZINHA).getImage().getScaledInstance( altura, altura, 1)).getImage();
	}


	public void carregarAgentes() {
		matrizCelulas[0][0].adicionaAgente(fabricaAgente.retornaAgente("PIA",0, 0, delta, 0, this));
		matrizCelulas[0][1].adicionaAgente(fabricaAgente.retornaAgente("PIA",0, 1, delta, 0, this));
		matrizCelulas[0][2].adicionaAgente(fabricaAgente.retornaAgente("PIA",0, 2, delta, 0, this));
		matrizCelulas[0][3].adicionaAgente(fabricaAgente.retornaAgente("PIA",0, 3, delta, 0, this));
		matrizCelulas[0][4].adicionaAgente(fabricaAgente.retornaAgente("PIA",0, 4, delta, 0, this));
		matrizCelulas[0][5].adicionaAgente(fabricaAgente.retornaAgente("PIA",0, 5, delta, 0, this));
		matrizCelulas[0][6].adicionaAgente(fabricaAgente.retornaAgente("PIA",0, 6, delta, 0, this));		
		matrizCelulas[0][7].adicionaAgente(fabricaAgente.retornaAgente("PIA",0, 7, delta, 0, this));
		matrizCelulas[0][8].adicionaAgente(fabricaAgente.retornaAgente("PIA",0,8, delta, 0, this));
		matrizCelulas[0][9].adicionaAgente(fabricaAgente.retornaAgente("PIA",0, 9, delta, 0, this));
		matrizCelulas[0][10].adicionaAgente(fabricaAgente.retornaAgente("PIA",0, 10, delta, 0, this));
		matrizCelulas[0][11].adicionaAgente(fabricaAgente.retornaAgente("OBJETIVO",0, 11, delta, 0, this));
		matrizCelulas[4][0].adicionaAgente(fabricaAgente.retornaAgente("FOGAO",4, 0, delta, 0, this));
		matrizCelulas[4][2].adicionaAgente(fabricaAgente.retornaAgente("FOGAO",4, 2, delta, 0, this));
		matrizCelulas[4][4].adicionaAgente(fabricaAgente.retornaAgente("FOGAO",4, 4, delta, 0, this));
		matrizCelulas[4][6].adicionaAgente(fabricaAgente.retornaAgente("FOGAO",4, 6, delta, 0, this));
		matrizCelulas[4][8].adicionaAgente(fabricaAgente.retornaAgente("FOGAO",4,8, delta, 0, this));
		matrizCelulas[4][10].adicionaAgente(fabricaAgente.retornaAgente("FOGAO",4, 10, delta, 0, this));	
		matrizCelulas[8][1].adicionaAgente(fabricaAgente.retornaAgente("ARMARIO",8, 1, delta, 0, this));
		matrizCelulas[8][3].adicionaAgente(fabricaAgente.retornaAgente("ARMARIO",8, 3, delta, 0, this));
		matrizCelulas[8][5].adicionaAgente(fabricaAgente.retornaAgente("ARMARIO",8, 5, delta, 0, this));
		matrizCelulas[8][7].adicionaAgente(fabricaAgente.retornaAgente("ARMARIO",8, 7, delta, 0, this));
		matrizCelulas[8][9].adicionaAgente(fabricaAgente.retornaAgente("ARMARIO",8,9, delta, 0, this));
		matrizCelulas[8][11].adicionaAgente(fabricaAgente.retornaAgente("ARMARIO",8, 11, delta, 0, this));	
		matrizCelulas[1][0].adicionaAgente(fabricaAgente.retornaAgente("LOUCA",1, 0, delta, 20, this));
		matrizCelulas[1][4].adicionaAgente(fabricaAgente.retornaAgente("LOUCA",1, 4, delta, 20, this));
		matrizCelulas[1][8].adicionaAgente(fabricaAgente.retornaAgente("LOUCA",1, 8, delta, 20, this));	
		matrizCelulas[2][2].adicionaAgente(fabricaAgente.retornaAgente("MACA",2, 2, delta, 15, this));
		matrizCelulas[2][8].adicionaAgente(fabricaAgente.retornaAgente("MACA",2, 8, delta, 15, this));	
		matrizCelulas[3][0].adicionaAgente(fabricaAgente.retornaAgente("HAMBURGUER",3, 0, delta, 15, this));
		matrizCelulas[3][4].adicionaAgente(fabricaAgente.retornaAgente("HAMBURGUER",3, 4, delta, 15, this));
		matrizCelulas[3][8].adicionaAgente(fabricaAgente.retornaAgente("HAMBURGUER",3, 8, delta, 15, this));	
		matrizCelulas[5][0].adicionaAgente(fabricaAgente.retornaAgente("MACA",5, 0, delta, 15, this));
		matrizCelulas[5][6].adicionaAgente(fabricaAgente.retornaAgente("MACA",5, 6, delta, 15, this));	
		matrizCelulas[6][1].adicionaAgente(fabricaAgente.retornaAgente("FRIGIDEIRA",6, 1, delta, 15, this));
		matrizCelulas[6][5].adicionaAgente(fabricaAgente.retornaAgente("FRIGIDEIRA",6, 5, delta, 15, this));
		matrizCelulas[6][9].adicionaAgente(fabricaAgente.retornaAgente("FRIGIDEIRA",6, 9, delta, 15, this));	
		matrizCelulas[9][0].adicionaAgente(fabricaAgente.retornaAgente("FRIGIDEIRA",9, 0, delta, 15, this));
		matrizCelulas[9][4].adicionaAgente(fabricaAgente.retornaAgente("FRIGIDEIRA",9, 4, delta, 15, this));
		matrizCelulas[9][8].adicionaAgente(fabricaAgente.retornaAgente("FRIGIDEIRA",9, 8, delta, 15, this));	
		matrizCelulas[10][3].adicionaAgente(fabricaAgente.retornaAgente("MACA",10, 3, delta, 15, this));
		matrizCelulas[10][9].adicionaAgente(fabricaAgente.retornaAgente("MACA",10, 9, delta, 15, this));	

		estudante = fabricaAgente.retornaAgente("ESTUDANTE" ,11, 11, delta, 0, this);
		matrizCelulas[11][11].adicionaAgente(estudante);		
	}

}
