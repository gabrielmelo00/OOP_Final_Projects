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
		if(true) {
			Componente [] novoVetor = new Componente[meusComponentes.length + 1];
			novoVetor[0] = c;
			for(int i = 0; i < meusComponentes.length; i++ ) {
				novoVetor[i+1] = meusComponentes[i];
			}
			meusComponentes = new Componente[novoVetor.length];
			meusComponentes = novoVetor;

		}
		System.out.println("Printando " + meusComponentes.length + " componentes:");
		for(int i = 0; i < meusComponentes.length; i++) {
			meusComponentes[i].printa();
		}
	}
	
}
