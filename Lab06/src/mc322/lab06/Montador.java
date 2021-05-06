package mc322.lab06;

public class Montador {
	
	private Caverna minhaCaverna;

	public Montador(String[] vetor) {
		String [] vetor_i = new String[vetor.length];
		String [] vetor_j = new String[vetor.length];
		String [] vetor_componentes = new String[vetor.length];
		
		for(int x = 0;x < vetor.length;x++) {
			vetor_i[x] = vetor[x].split(",")[0].split(":")[0];
			vetor_j[x] = vetor[x].split(",")[0].split(":")[1];
			vetor_componentes[x] = vetor[x].split(",")[1];
		}
		
		
		if(verifica(vetor_componentes)) {
			minhaCaverna = new Caverna(101);
			Componente meusComponentes;
			meusComponentes = new Componente(minhaCaverna);
			
			
			for(int x = 1;x < vetor_componentes.length;x++) {
				switch(vetor_componentes[x]) {
					case "B":
						meusComponentes = new teste(Integer.parseInt(vetor_i[x]),Integer.parseInt(vetor_j[x]),'B');
						meusComponentes.printa();
						break;
					case "P":
						meusComponentes = new teste(Integer.parseInt(vetor_i[x]),Integer.parseInt(vetor_j[x]),'P');
						meusComponentes.printa();
						break;
					case "O":
						meusComponentes = new teste(Integer.parseInt(vetor_i[x]),Integer.parseInt(vetor_j[x]),'O');
						meusComponentes.printa();
						break;
					case "W":
						meusComponentes = new teste(Integer.parseInt(vetor_i[x]),Integer.parseInt(vetor_j[x]),'W');
						meusComponentes.printa();
						break;
				}
			}
			
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
