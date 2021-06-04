package jogo;

import java.util.ArrayList;

public class Casa {
	
	private ArrayList<Comodo> meusComodos;
	
	public static final byte QUINTAL = 0;
	public static final byte COZINHA = 1;
	public static final byte SALA = 2;
	public static final byte QUARTO = 3;
	public static final byte NUMERO_COMODOS = 4;

	public Casa() {
		meusComodos = new ArrayList<Comodo>(NUMERO_COMODOS);
		
		meusComodos.add(QUINTAL, new Comodo('Q'));
		meusComodos.add(COZINHA, new Comodo('C'));
		meusComodos.add(SALA, new Comodo('S'));
		meusComodos.add(QUARTO, new Comodo('B'));
		
	}
	
	public void imprimeCasa() {
		for(int i = 0; i < NUMERO_COMODOS; i++) {
			meusComodos.get(i).imprimeComodo();
		}
	}

}
