package midia;

import java.util.ArrayList;

import javax.swing.ImageIcon;

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


	public static void carregar() {
		
		Imagens.add(BACKGROUND_MENU, new ImageIcon("C:\\Users\\plath\\Documents\\Unicamp\\7º semestre\\MC322\\LabDupla\\TrabalhosMC\\ProjetoFinal\\src\\midia\\background.png"));
		Imagens.add(SELECAO_MENU_JOGAR, new ImageIcon("C:\\Users\\plath\\Documents\\Unicamp\\7º semestre\\MC322\\LabDupla\\TrabalhosMC\\ProjetoFinal\\src\\midia\\selecao_menu_jogar.png"));
		Imagens.add(SELECAO_MENU_REGRAS, new ImageIcon("C:\\Users\\plath\\Documents\\Unicamp\\7º semestre\\MC322\\LabDupla\\TrabalhosMC\\ProjetoFinal\\src\\midia\\selecao_menu_regras.png"));
		Imagens.add(SELECAO_REGRAS_JOGAR, new ImageIcon("C:\\Users\\plath\\Documents\\Unicamp\\7º semestre\\MC322\\LabDupla\\TrabalhosMC\\ProjetoFinal\\src\\midia\\selecao_regras_jogar.png"));
		Imagens.add(SELECAO_REGRAS_MENU, new ImageIcon("C:\\Users\\plath\\Documents\\Unicamp\\7º semestre\\MC322\\LabDupla\\TrabalhosMC\\ProjetoFinal\\src\\midia\\selecao_regras_menu.png"));
		Imagens.add(BACKGROUND_REGRAS, new ImageIcon("C:\\Users\\plath\\Documents\\Unicamp\\7º semestre\\MC322\\LabDupla\\TrabalhosMC\\ProjetoFinal\\src\\midia\\background_regras.png"));
		Imagens.add(BACKGROUND_JOGO, new ImageIcon("C:\\Users\\plath\\Documents\\Unicamp\\7º semestre\\MC322\\LabDupla\\TrabalhosMC\\ProjetoFinal\\src\\midia\\background_jogo.png"));
		Imagens.add(BACKGROUND_QUINTAL, new ImageIcon("C:\\Users\\plath\\Documents\\Unicamp\\7º semestre\\MC322\\LabDupla\\TrabalhosMC\\ProjetoFinal\\src\\midia\\background_quintal.png"));
				//Loader.class.getResource(".").getPath() + "background.png"));
				
		Imagens.add(MACA, new ImageIcon("C:\\Users\\plath\\Documents\\Unicamp\\7º semestre\\MC322\\LabDupla\\TrabalhosMC\\ProjetoFinal\\src\\midia\\maca.png")); 
		Imagens.add(ESTUDANTE, new ImageIcon("C:\\Users\\plath\\Documents\\Unicamp\\7º semestre\\MC322\\LabDupla\\TrabalhosMC\\ProjetoFinal\\src\\midia\\soso.png")); 
				
				//new ImageIcon(Loader.class.getResource(".").getPath() + "apple.png"));
				
		
	}

}
