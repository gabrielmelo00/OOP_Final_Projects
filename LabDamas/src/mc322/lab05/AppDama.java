package mc322.lab05;

public class AppDama {
	
	public static String[] executaJogo(String [] comandos) {
		String [] estados = new String[comandos.length+1];
		Tabuleiro meuTabuleiro = new Tabuleiro();
		System.out.println("Tabuleiro inicial: ");
		System.out.println(meuTabuleiro.retornaEstado());
		estados[0] = meuTabuleiro.retornaEstado();
		
		for(int i = 0; i < comandos.length; i++) {
			meuTabuleiro.moverPeca(comandos[i]);
			String[] jogadas = comandos[i].split(":");
			estados[i+1] = meuTabuleiro.retornaEstado();			
			System.out.println("Source: " + jogadas[0]);
			System.out.println("Target: " + jogadas[1]);
			System.out.println(meuTabuleiro.retornaEstado());
		}
		return estados;
	}

	public static void main(String[] args) {
		
		CSVReader csv = new CSVReader();
		csv.setDataSource("../LabDamas/data/data.csv");
		String commands[] = csv.requestCommands();
		
		String[] saida = executaJogo(commands);
		
		//String de saída com os estados
		
		//System.out.println("Vetor saida:");
		//for(int i = 0; i < saida.length; i++) {
		//	System.out.println(saida[i]);
		//}
		
	}

}