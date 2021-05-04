package mc322.lab05b;


public class AppDama {
	
	public static void executaJogo(String entrada, String saida) {
		Tabuleiro meuTabuleiro = new Tabuleiro();
		System.out.println("Tabuleiro inicial: ");
		meuTabuleiro.imprimirTabuleiro();
		
		CSVHandling csv = new CSVHandling();
		csv.setDataSource(entrada);
		String comandos[] = csv.requestCommands();
		
		for(int i = 0; i < comandos.length; i++) {
			meuTabuleiro.solicitaMovimento(comandos[i]);
			String[] jogadas = comandos[i].split(":");			
			System.out.println("Source: " + jogadas[0]);
			System.out.println("Target: " + jogadas[1]);
			meuTabuleiro.imprimirTabuleiro();
		}
		
		meuTabuleiro.exportaArquivo(saida);
	}

	public static void main(String[] args) {
		
		executaJogo(args[0],args[1]);
		
		/* Caminhos:
		 * args[0] = "../LabDamas/data/data.csv";
		 * args[1] = "../LabDamas/data/out.csv";
		 */
	}

}

