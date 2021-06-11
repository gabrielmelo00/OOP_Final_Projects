package agente;

import jogo.Comodo;

public class FabricaAgente implements IFabricaAgente{
	
	public Agente retornaAgente(String nomeAgente, int i, int j, int escala, Comodo meuComodo) {
		if(nomeAgente == null) {
			return null;
		}
		
		if(nomeAgente.equals("MACA")) {
			return new Maca(i, j, escala, meuComodo);
		}else if(nomeAgente.equals("ESTUDANTE")){
			Estudante aux = Estudante.getInstancia();
			aux.setParametros(i, j, escala, meuComodo);
			return aux;
		}else if(nomeAgente.equals("OBJETIVO")){
			return new Objetivo(i, j, escala, meuComodo);
		}else {
			return null;
		}
	}

}
