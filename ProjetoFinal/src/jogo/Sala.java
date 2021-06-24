package jogo;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import agente.FabricaAgente;
import jogo.midia.Carregador;

public class Sala extends Comodo {

	private Image imgSala;
    private Image imgBackground;
	
	public Sala(){	
		fabricaAgente = new FabricaAgente();
		carregarImagens();
		carregarAgentes();	
	}

	public void perdeuJogo() {
		meuGerenciador.removerPilha();
		meuGerenciador.adicionarPilha(new GameOver(estudante.getTempo()));		
	}

	public void proximoNivel() {
		meuGerenciador.removerPilha();
		meuGerenciador.adicionarPilha(new Quarto());	
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


	public void carregarImagens() {
		imgBackground = new ImageIcon(Carregador.Imagens.get(Carregador.BACKGROUND_JOGO).getImage().getScaledInstance( faixa, altura, 1)).getImage();
		imgSala = new ImageIcon(Carregador.Imagens.get(Carregador.BACKGROUND_SALA).getImage().getScaledInstance( altura, altura, 1)).getImage();		
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
		
		matrizCelulas[0][0].adicionaAgente(fabricaAgente.retornaAgente("OBJETIVO",0, 0, delta, 0, this));

		estudante = fabricaAgente.retornaAgente("ESTUDANTE" ,11, 11, delta, 0, this);
		matrizCelulas[11][11].adicionaAgente(estudante);		
	}

	

	

}
