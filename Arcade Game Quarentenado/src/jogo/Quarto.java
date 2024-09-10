package jogo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import agente.FabricaAgente;

import jogo.midia.Carregador;

public class Quarto extends Comodo {
   
	private Image imgComodo;
    private Image imgBackground;
    
	
	public Quarto(){		
		fabricaAgente = new FabricaAgente();
		carregarImagens();
		carregarAgentes();
	}
	
	public void proximoNivel() {
		meuGerenciador.removerPilha();
		meuGerenciador.adicionarPilha(new Vitoria(estudante.getTempo()));	
	}
	
	public void perdeuJogo() {
		meuGerenciador.removerPilha();
		meuGerenciador.adicionarPilha(new GameOver(estudante.getTempo()));		
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
	

	public void carregarImagens() {
		imgBackground = new ImageIcon(Carregador.Imagens.get(Carregador.BACKGROUND_JOGO).getImage().getScaledInstance( faixa, altura, 1)).getImage();
		imgComodo = new ImageIcon(Carregador.Imagens.get(Carregador.BACKGROUND_QUARTO).getImage().getScaledInstance( altura, altura, 1)).getImage();
	}


	public void carregarAgentes() {
		
		matrizCelulas[0][0].adicionaAgente(fabricaAgente.retornaAgente("DESKTOP",0, 0, delta, 0, this));
		matrizCelulas[0][1].adicionaAgente(fabricaAgente.retornaAgente("DESKTOP",0, 1, delta, 0, this));
		matrizCelulas[0][2].adicionaAgente(fabricaAgente.retornaAgente("OBJETIVO",0, 2, delta, 0, this));	
		matrizCelulas[0][11].adicionaAgente(fabricaAgente.retornaAgente("DESKTOP",0, 11, delta, 0, this));
		matrizCelulas[0][10].adicionaAgente(fabricaAgente.retornaAgente("DESKTOP",0, 10, delta, 0, this));
		matrizCelulas[0][9].adicionaAgente(fabricaAgente.retornaAgente("OBJETIVO",0, 9, delta, 0, this));	
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

	

	
	
	
	
	

}

