package mc322.lab06;

public class Montador {
	
	private Caverna minhaCaverna;

		// [[1:1,P]]
	public Montador(String[][] matriz) {
		String [] vetor_i = new String[matriz.length];
		String [] vetor_j = new String[matriz.length];
		String [] vetor_componentes = new String[matriz.length];
		
		for(int x = 0;x < matriz.length;x++) {
			vetor_i[x] = matriz[x][0].split(",")[0].split(":")[0];
			vetor_j[x] = matriz[x][0].split(",")[0].split(":")[1];
			vetor_componentes[x] = matriz[x][1];
		}
		
		
		if(verifica(vetor_componentes)) {
			minhaCaverna = new Caverna();
			Componente meusComponentes;
			meusComponentes = new Componente(minhaCaverna);
			
			for(int x = 0;x < vetor_componentes.length;x++) {
				switch(vetor_componentes[x]) {
					case "B":
						meusComponentes = new Buraco(Integer.parseInt(vetor_i[x]),Integer.parseInt(vetor_j[x]),'B');
						meusComponentes.conectaComponente();
						break;
						
					case "P":
						meusComponentes = new Heroi(Integer.parseInt(vetor_i[x]),Integer.parseInt(vetor_j[x]),'P');
						meusComponentes.conectaComponente();
						break;
						
					case "O":
						meusComponentes = new Ouro(Integer.parseInt(vetor_i[x]),Integer.parseInt(vetor_j[x]),'O');
						meusComponentes.conectaComponente();
						break;
						
					case "W":
						meusComponentes = new Wumpus(Integer.parseInt(vetor_i[x]),Integer.parseInt(vetor_j[x]),'W');
						meusComponentes.conectaComponente();
						break;
						
				}
								
			}
			
			//meusComponentes = new Heroi(1,4,'P');
			//meusComponentes.conectaComponente();
			
		}
		
	}
	
	public boolean verifica(String[] vetor_componentes) {
		int B = 0;
		int P = 0;
		int O = 0;
		int W = 0;
		boolean resultado = true;
		
		for(int x = 0;x < vetor_componentes.length;x++) {
			
			switch(vetor_componentes[x].charAt(0)) {
				case 'B':B++;break;
				case 'P':P++;break;
				case 'O':O++;break;
				case 'W':W++;break;
				case '_': break;
				default: P = 100;break;
			}
		}
		if(P != 1 || O != 1 || W != 1 || B < 2 || B> 3 || vetor_componentes[0].charAt(0) != 'P') {
			resultado = false;
		}
		
		return resultado;
	}
}
