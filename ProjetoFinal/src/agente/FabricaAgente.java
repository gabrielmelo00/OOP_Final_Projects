package agente;

import jogo.Comodo;

public class FabricaAgente implements IFabricaAgente{
	
	public Agente retornaAgente(String nomeAgente, int i, int j, int escala, int ciclos, Comodo meuComodo) {
		if(nomeAgente == null) {
			return null;
		}
		
		if(nomeAgente.equals("MACA")) {
			return new Maca(i, j, escala, meuComodo, ciclos);
		}else if(nomeAgente.equals("ESTUDANTE")){
			Estudante aux = Estudante.getInstancia();
			aux.setParametros(i, j, escala, meuComodo);
			return aux;
		}else if(nomeAgente.equals("OBJETIVO")){
			return new Objetivo(i, j, escala, meuComodo, ciclos);
		}else if(nomeAgente.equals("CACHORRO")){
			return new Cachorro(i,j,escala, meuComodo, ciclos);
		}else if(nomeAgente.equals("BOLA")){
			return new Bola(i, j, escala, meuComodo, ciclos);
		}else if(nomeAgente.equals("GATO")){
			return new Gato(i,j,escala,meuComodo, ciclos);
		}else if(nomeAgente.equals("MANGUEIRA")){
			return new Mangueira(i,j,escala,meuComodo, ciclos);
		}else if(nomeAgente.equals("CERCA")){
			return new Cerca(i,j,escala);
		}else if(nomeAgente.equals("PIPOCA")){
			return new Pipoca(i,j,escala,meuComodo,ciclos);
		}else if(nomeAgente.equals("TELEVISAO")){
			return new Televisao(i,j,escala,meuComodo,ciclos);
		}else if(nomeAgente.equals("RADIO")){
			return new Radio(i,j,escala,meuComodo,ciclos);
		}else if(nomeAgente.equals("VIDEOGAME")){
			return new Videogame(i,j,escala,meuComodo,ciclos);
		}else if(nomeAgente.equals("PIA")){
			return new Pia(i,j,escala);
		}else if(nomeAgente.equals("FOGAO")){
			return new Fogao(i,j,escala);
		}else if(nomeAgente.equals("ARMARIO")){
			return new Armario(i,j,escala); 
		}else if(nomeAgente.equals("FRIGIDEIRA")){
			return new Frigideira(i,j,escala, meuComodo, ciclos);
		}else if(nomeAgente.equals("LOUCA")){
			return new Louca(i,j,escala, meuComodo, ciclos);
		}else if(nomeAgente.equals("CAMA_1")){
			return new Cama(i,j,escala,1);
		}else if(nomeAgente.equals("CAMA_2")){
			return new Cama(i,j,escala,2);
		}else if(nomeAgente.equals("CAMA_3")){
			return new Cama(i,j,escala,3);
		}else if(nomeAgente.equals("CAMA_4")){
			return new Cama(i,j,escala,4);
		}else if(nomeAgente.equals("DESKTOP")){
			return new Desktop(i,j,escala);
		}else if(nomeAgente.equals("CELULAR")){
			return new Celular(i, j, escala, meuComodo, ciclos);
		}else if(nomeAgente.equals("ROUPA_SUJA")){
			return new RoupaSuja(i, j, escala, meuComodo, ciclos);
		}else if(nomeAgente.equals("LIVRO")){
			return new Livro(i, j, escala, meuComodo, ciclos);
		}else if(nomeAgente.equals("ABAJUR")){
			return new Abajur(i, j, escala, meuComodo, ciclos);
		}else{
			return null;
		}
	}

}
