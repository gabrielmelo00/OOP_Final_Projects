package agente;

import jogo.Comodo;

public class FabricaAgente implements IFabricaAgente{
	
	public IAgente retornaAgente(String nomeAgente, int i, int j, int escala, Comodo meuComodo) {
		if(nomeAgente == null) {
			return null;
		}
		
		if(nomeAgente.equals("MACA")) {
			return new Maca(i, j, escala, meuComodo);
		}else if(nomeAgente.equals("ESTUDANTE")){
			return new Estudante(i, j, escala, meuComodo);
			
		}else if(nomeAgente.equals("OBJETIVO")){
			return new Objetivo(i, j, escala, meuComodo);
		}else {
			return null;
		}
	}

}
