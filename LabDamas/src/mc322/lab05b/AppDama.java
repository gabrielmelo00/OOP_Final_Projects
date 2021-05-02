package mc322.lab05b;


public class AppDama {
	
	public static void executaJogo(String [] comandos) {
		Tabuleiro meuTabuleiro = new Tabuleiro();
		System.out.println("Tabuleiro inicial: ");
		meuTabuleiro.imprimirTabuleiro();
		
		
		for(int i = 0; i < comandos.length; i++) {
			meuTabuleiro.solicitaMovimento(comandos[i]);
			String[] jogadas = comandos[i].split(":");			
			System.out.println("Source: " + jogadas[0]);
			System.out.println("Target: " + jogadas[1]);
			meuTabuleiro.imprimirTabuleiro();
		}
	}

	public static void main(String[] args) {
		
		CSVHandling csv = new CSVHandling();
		csv.setDataSource("../LabDamas/data/data.csv");
		String commands[] = csv.requestCommands();
		
		executaJogo(commands);
		
	}

}
