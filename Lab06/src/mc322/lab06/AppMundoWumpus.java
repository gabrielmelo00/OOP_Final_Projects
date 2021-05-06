package mc322.lab06;

import java.util.Scanner;

public class AppMundoWumpus {

	public static void main(String[] args) {
		String [] tabuleiro;
		CSVHandling csv = new CSVHandling();
		csv.setDataSource("../Lab06/data/data.csv");
		tabuleiro = csv.requestCommands();
		
		Montador meuMontador = new Montador(tabuleiro);
		Scanner keyboard = new Scanner(System.in);
		String  nome = keyboard.nextLine();
		System.out.println("Nome: " + nome);
		
	}
	
}
