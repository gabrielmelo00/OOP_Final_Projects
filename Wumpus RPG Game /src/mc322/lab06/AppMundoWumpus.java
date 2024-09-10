package mc322.lab06;

import java.util.Scanner;

public class AppMundoWumpus {

	public static void main(String [] args) {
		
		String [][] tabuleiro;
		CSVHandling csv = new CSVHandling();
		csv.setDataSource(args[0]);
		tabuleiro = csv.requestCommands();
		
		Montador meuMontador = new Montador(tabuleiro);
		Scanner keyboard = new Scanner(System.in);
		String  nome = keyboard.nextLine();
		Controle controlador = new Controle(nome,meuMontador.getHeroi()); 
		boolean aux = true;
		do {
			String comando = keyboard.nextLine();
			if(!controlador.comando(comando)) {
				aux = false;
			}
		}while(aux);
	}
}