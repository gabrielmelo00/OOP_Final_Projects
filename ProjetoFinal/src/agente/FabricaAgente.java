package agente;

import jogo.Comodo;

public class FabricaAgente implements IFabricaAgente{
	
	public Agente retornaAgente(String nomeAgente, int i, int j, int escala, int velocidade, Comodo meuComodo) {
		if(nomeAgente == null) {
			return null;
		}
		
		if(nomeAgente.equals("MACA")) {
			return new Maca(i, j, escala, meuComodo, velocidade);
		}else if(nomeAgente.equals("ESTUDANTE")){
			Estudante aux = Estudante.getInstancia();
			aux.setParametros(i, j, escala, meuComodo);
			return aux;
		}else if(nomeAgente.equals("OBJETIVO")){
			return new Objetivo(i, j, escala, meuComodo, velocidade);
		}else if(nomeAgente.equals("CACHORRO")){
			return new Cachorro(i,j,escala, meuComodo, velocidade);
		}else if(nomeAgente.equals("BOLA")){
			return new Bola(i, j, escala, meuComodo, velocidade);
		}else if(nomeAgente.equals("GATO")){
			return new Gato(i,j,escala,meuComodo, velocidade);
		}else if(nomeAgente.equals("MANGUEIRA")){
			return new Mangueira(i,j,escala,meuComodo, velocidade);
		}else if(nomeAgente.equals("BASQUETE")) {
			return new Basquete(i,j,escala, meuComodo, velocidade);
		}else if(nomeAgente.equals("CERCA")){
			return new Cerca(i,j,escala);
		}else{
			return null;
		}
	}

}
