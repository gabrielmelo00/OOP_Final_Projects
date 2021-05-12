package mc322.lab06;

public class Sala {
	
	Componente [] meusComponentes;
	int heroi;
	int buraco;
	int ouro;
	int wumpus;
	int fedor;
	int brisa;
	
	public Sala(Componente c) {
		identidade('*');
		meusComponentes = new Componente [1];
		meusComponentes[0] = c;
		meusComponentes[0].printa();
		identidade(c.getTipo());
	}
	
	public void adicionaComponente(Componente c) {
		// método verifica
		if(verifica(c)) {
			identidade(c.getTipo());
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
		}
		System.out.println("W: " + wumpus);
		System.out.println("B: " + buraco);
		System.out.println("O: " + ouro);
		System.out.println("P: " + heroi);
		System.out.println("b: " + brisa);
		System.out.println("f: " + fedor);*/
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
	
	private void identidade(char tipo) {
		switch(tipo) {
			case 'P': heroi++; break;
			case 'B': buraco++; break;
			case 'O': ouro++; break;
			case 'W': wumpus++; break;
			case 'b': brisa++; break;
			case 'f': fedor++; break;
			case '*': 
				heroi = 0;
				buraco = 0;
				ouro = 0;
				wumpus = 0;
				brisa = 0;
				fedor = 0;
				break;
				
		}
	}
	
}
