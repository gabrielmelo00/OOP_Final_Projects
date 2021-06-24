package jogo.midia;

import java.util.ArrayList;


import javax.swing.ImageIcon;
import excecao.ErroImagemNaoEncontrada;

public class Carregador {
	
	public static  ArrayList<ImageIcon> Imagens = new ArrayList<ImageIcon>();
	
	//lista de imagens
	public static final byte BACKGROUND_MENU = 0;
	public static final byte SELECAO_MENU_JOGAR = 1;
	public static final byte SELECAO_MENU_REGRAS = 2;
	public static final byte SELECAO_REGRAS_JOGAR = 3;
	public static final byte SELECAO_REGRAS_MENU = 4;
	public static final byte BACKGROUND_REGRAS = 5;
	public static final byte BACKGROUND_JOGO = 6;
	public static final byte BACKGROUND_QUINTAL = 7;
	public static final byte MACA = 8;
	public static final byte ESTUDANTE = 9;
	public static final byte BACKGROUND_GAMEOVER_MENU = 10;
	public static final byte BACKGROUND_GAMEOVER_JOGAR = 11;
	public static final byte OBJETIVO = 12;
	public static final byte MACA_LAGARTA = 13;
	public static final byte TRANSPARENTE = 14;
	public static final byte CACHORRO = 15;
	public static final byte CACHORRO_2 = 16;
	public static final byte BOLA = 17;
	public static final byte GATO = 18;
	public static final byte GATO_2 = 19;
	public static final byte MANGUEIRA = 20;
	public static final byte CERCA = 21;
	public static final byte BACKGROUND_SALA = 22;
	public static final byte PIPOCA = 23;
	public static final byte TV = 24;
	public static final byte TV_SOM = 25;
	public static final byte RADIO = 26;
	public static final byte VIDEOGAME = 27;
	public static final byte BACKGROUND_COZINHA = 28;
	public static final byte PIA = 29;
	public static final byte ARMARIO = 30;
	public static final byte FOGAO = 31;
	public static final byte HAMBURGUER = 32;
	public static final byte FRIGIDEIRA = 33;
	public static final byte BACKGROUND_QUARTO = 34;
	public static final byte CAMA_1 = 35;
	public static final byte CAMA_2 = 36;
	public static final byte CAMA_3 = 37;
	public static final byte CAMA_4 = 38;
	public static final byte DESKTOP = 39;
	public static final byte BACKGROUND_VITORIA_MENU = 40;
	public static final byte BACKGROUND_VITORIA_JOGAR = 41;
	public static final byte CELULAR = 42;
	public static final byte ROUPA_SUJA = 43;
	public static final byte LIVRO = 44;
	public static final byte ABAJUR = 45;
	
	public static void carregar() throws ErroImagemNaoEncontrada{

		try {
			Imagens.add(BACKGROUND_MENU, new ImageIcon(Carregador.class.getResource("background.png")));
			Imagens.add(SELECAO_MENU_JOGAR, new ImageIcon(Carregador.class.getResource("selecao_menu_jogar.png")));
			Imagens.add(SELECAO_MENU_REGRAS, new ImageIcon(Carregador.class.getResource("selecao_menu_regras.png")));	
			Imagens.add(SELECAO_REGRAS_JOGAR, new ImageIcon(Carregador.class.getResource("selecao_regras_jogar.png")));		
			Imagens.add(SELECAO_REGRAS_MENU, new ImageIcon(Carregador.class.getResource("selecao_regras_menu.png")));	
			Imagens.add(BACKGROUND_REGRAS, new ImageIcon(Carregador.class.getResource("background_regras.png")));	
			Imagens.add(BACKGROUND_JOGO, new ImageIcon(Carregador.class.getResource("background_jogo.png")));	
			Imagens.add(BACKGROUND_QUINTAL, new ImageIcon(Carregador.class.getResource("background_quintal.png")));	
			Imagens.add(MACA, new ImageIcon(Carregador.class.getResource("maca.png")));	
			Imagens.add(ESTUDANTE, new ImageIcon(Carregador.class.getResource("carinhaFeliz.png")));	
			Imagens.add(BACKGROUND_GAMEOVER_MENU, new ImageIcon(Carregador.class.getResource("gameover_menu.png")));
			Imagens.add(BACKGROUND_GAMEOVER_JOGAR, new ImageIcon(Carregador.class.getResource("gameover_jogar.png")));
			Imagens.add(OBJETIVO, new ImageIcon(Carregador.class.getResource("objetivo.png")));
			Imagens.add(MACA_LAGARTA, new ImageIcon(Carregador.class.getResource("maca_lagarta.png")));
			Imagens.add(TRANSPARENTE, new ImageIcon(Carregador.class.getResource("transparente.png")));
			Imagens.add(CACHORRO, new ImageIcon(Carregador.class.getResource("cachorro.png")));
			Imagens.add(CACHORRO_2, new ImageIcon(Carregador.class.getResource("cachorro_2.png")));
			Imagens.add(BOLA, new ImageIcon(Carregador.class.getResource("bola.png")));
			Imagens.add(GATO, new ImageIcon(Carregador.class.getResource("gato.png")));
			Imagens.add(GATO_2, new ImageIcon(Carregador.class.getResource("gato_2.png")));
			Imagens.add(MANGUEIRA, new ImageIcon(Carregador.class.getResource("mangueira.png")));
			Imagens.add(CERCA, new ImageIcon(Carregador.class.getResource("cerca.png")));
			Imagens.add(BACKGROUND_SALA, new ImageIcon(Carregador.class.getResource("background_sala.png")));
			Imagens.add(PIPOCA, new ImageIcon(Carregador.class.getResource("pipoca.png")));
			Imagens.add(TV, new ImageIcon(Carregador.class.getResource("televisao.png")));
			Imagens.add(TV_SOM, new ImageIcon(Carregador.class.getResource("televisao_som.png")));
			Imagens.add(RADIO, new ImageIcon(Carregador.class.getResource("radio.png")));
			Imagens.add(VIDEOGAME, new ImageIcon(Carregador.class.getResource("videogame.png")));
			Imagens.add(BACKGROUND_COZINHA, new ImageIcon(Carregador.class.getResource("background_cozinha.png")));
			Imagens.add(PIA, new ImageIcon(Carregador.class.getResource("pia.png")));
			Imagens.add(ARMARIO, new ImageIcon(Carregador.class.getResource("armario1.png")));
			Imagens.add(FOGAO, new ImageIcon(Carregador.class.getResource("fogao.png")));
			Imagens.add(HAMBURGUER, new ImageIcon(Carregador.class.getResource("hamburguer.png")));
			Imagens.add(FRIGIDEIRA, new ImageIcon(Carregador.class.getResource("frigideira.png")));
			Imagens.add(BACKGROUND_QUARTO, new ImageIcon(Carregador.class.getResource("background_quarto.png")));
			Imagens.add(CAMA_1, new ImageIcon(Carregador.class.getResource("cama1.png")));
			Imagens.add(CAMA_2, new ImageIcon(Carregador.class.getResource("cama2.png")));
			Imagens.add(CAMA_3, new ImageIcon(Carregador.class.getResource("cama3.png")));
			Imagens.add(CAMA_4, new ImageIcon(Carregador.class.getResource("cama4.png")));
			Imagens.add(DESKTOP, new ImageIcon(Carregador.class.getResource("desktop.png")));
			Imagens.add(BACKGROUND_VITORIA_MENU, new ImageIcon(Carregador.class.getResource("vitoria_menu.png")));
			Imagens.add(BACKGROUND_VITORIA_JOGAR, new ImageIcon(Carregador.class.getResource("vitoria_jogar.png")));
			Imagens.add(CELULAR, new ImageIcon(Carregador.class.getResource("celular.png")));
			Imagens.add(ROUPA_SUJA, new ImageIcon(Carregador.class.getResource("roupasuja.png")));
			Imagens.add(LIVRO, new ImageIcon(Carregador.class.getResource("livro.png")));
			Imagens.add(ABAJUR, new ImageIcon(Carregador.class.getResource("abajur.png")));
		} catch( NullPointerException erro) {
			throw new ErroImagemNaoEncontrada("ErroImagemNaoEncontrada: não é  possível carregar imagens!");
		}
	}
}
