package mc322.lab06;

public class Sala {
	
	Componente [] meusComponentes;
	
	public Sala(Componente c) {
		meusComponentes = new Componente [1];
		meusComponentes[0] = c;
		meusComponentes[0].printa();
	}
	
	public void adicionaComponente(Componente c) {
		// método verifica
		if(verifica(c)) {
			Componente [] novoVetor = new Componente[meusComponentes.length + 1];
			novoVetor[0] = c;
			for(int i = 0; i < meusComponentes.length; i++ ) {
				novoVetor[i+1] = meusComponentes[i];
			}
			meusComponentes = new Componente[novoVetor.length];
			meusComponentes = novoVetor;

		}else {
			System.out.println("Não pode colocar nessa sala");
		}
		/*System.out.println("Printando " + meusComponentes.length + " componentes:");
		for(int i = 0; i < meusComponentes.length; i++) {
			meusComponentes[i].printa();
		}*/
	}
	
	private boolean verifica(Componente c) {
		//OURO, WUMPUS E BURACO não podem estar na mesma sala
		boolean estado = true;
		
		for(int i = 0; i < meusComponentes.length; i++) {
			if(meusComponentes[i].getTipo() == 'O' || meusComponentes[i].getTipo() == 'W' || meusComponentes[i].getTipo() == 'B') {
				if(c.getTipo() == 'O' || c.getTipo() == 'W' || c.getTipo() == 'B') {
					estado = false;
				}
			}
		}		
		return estado;
	}
	
}
