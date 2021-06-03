package midia;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Carregador {
	
	public static  ArrayList<ImageIcon> Imagens = new ArrayList<ImageIcon>();
	
	//lista de imagens
	public static final byte BACKGROUND = 0;
	public static final byte MACA = 1;


	public static void carregar() {
		
		Imagens.add(BACKGROUND, new ImageIcon("C:\\Users\\plath\\Documents\\Unicamp\\7º semestre\\MC322\\LabDupla\\TrabalhosMC\\ProjetoFinal\\src\\midia\\background.png"));
				
				//Loader.class.getResource(".").getPath() + "background.png"));
				
		Imagens.add(MACA, new ImageIcon("C:\\Users\\plath\\Documents\\Unicamp\\7º semestre\\MC322\\LabDupla\\TrabalhosMC\\ProjetoFinal\\src\\midia\\maca.png")); 
				
				//new ImageIcon(Loader.class.getResource(".").getPath() + "apple.png"));
				
		
	}

}
