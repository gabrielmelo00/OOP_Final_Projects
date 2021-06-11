package agente;

import jogo.Comodo;

public interface IFabricaAgente {
	
	Agente retornaAgente(String nomeAgente, int i, int j, int escala, Comodo meuComodo);
}
