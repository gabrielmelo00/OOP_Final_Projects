package images;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Loader {
	
	public static  ArrayList<ImageIcon> Images = new ArrayList<ImageIcon>();
	
	//list of images
	public static final byte BACKGROUND = 0;
	public static final byte APPLE = 1;


	public static void load() {
		
		Images.add(BACKGROUND, new ImageIcon("C:\\Users\\plath\\Documents\\Unicamp\\7� semestre\\MC322\\LabDupla\\TrabalhosMC\\ProjetoFinal\\src\\images\\background.png"));
				
				//Loader.class.getResource(".").getPath() + "background.png"));
				
		//Images.add(APPLE, 
				
				//new ImageIcon(Loader.class.getResource(".").getPath() + "apple.png"));
				
		
	}
}
