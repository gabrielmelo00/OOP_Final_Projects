package agente;

import java.awt.Image;

import javax.swing.ImageIcon;

import jogo.Comodo;
import jogo.midia.Carregador;

public class FabricaAgente implements IFabricaAgente{
	
	public Agente retornaAgente(String nomeAgente, int i, int j, int escala, int ciclos, Comodo meuComodo) {
		if(nomeAgente == null) {
		}
		
		if(nomeAgente.equals("MACA")) {
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.MACA).getImage().getScaledInstance(escala,escala, 1)).getImage();
			Image img2 = new ImageIcon(Carregador.Imagens.get(Carregador.MACA_LAGARTA).getImage().getScaledInstance(2*escala,escala, 1)).getImage();
			return new VilaoDuploDinamico(i, j, meuComodo, ciclos, img, img2);
			
		}else if(nomeAgente.equals("ESTUDANTE")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.ESTUDANTE).getImage().getScaledInstance(escala,escala, 1)).getImage();
			Estudante aux = Estudante.getInstancia();
			aux.setParametros(i, j, meuComodo, img);
			return aux;
			
		}else if(nomeAgente.equals("OBJETIVO")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.OBJETIVO).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new Objetivo(i, j, meuComodo, ciclos, img);
			
		}else if(nomeAgente.equals("CACHORRO")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.CACHORRO).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new VilaoE(i,j, meuComodo, ciclos, img);
			
		}else if(nomeAgente.equals("BOLA")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.BOLA).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new VilaoD(i, j, meuComodo, ciclos, img);
			
		}else if(nomeAgente.equals("GATO")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.GATO).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new VilaoE(i,j,meuComodo, ciclos, img);
			
		}else if(nomeAgente.equals("MANGUEIRA")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.MANGUEIRA).getImage().getScaledInstance(2*escala,escala, 1)).getImage();
			return new VilaoDuploEstatico(i,j,meuComodo, ciclos, img);
			
		}else if(nomeAgente.equals("CERCA")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.CERCA).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new Parede(i,j,img);
			
		}else if(nomeAgente.equals("PIPOCA")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.PIPOCA).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new VilaoQ(i,j,meuComodo,ciclos, img);
			
		}else if(nomeAgente.equals("TELEVISAO")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.TV).getImage().getScaledInstance(escala,escala, 1)).getImage();
			Image img2 = new ImageIcon(Carregador.Imagens.get(Carregador.TV_SOM).getImage().getScaledInstance(2*escala,escala, 1)).getImage();
			return new VilaoDuploDinamico(i, j, meuComodo, ciclos, img, img2);
			
		}else if(nomeAgente.equals("RADIO")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.RADIO).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new VilaoD(i,j,meuComodo,ciclos, img);
			
		}else if(nomeAgente.equals("VIDEOGAME")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.VIDEOGAME).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new VilaoE(i,j,meuComodo,ciclos, img);
			
		}else if(nomeAgente.equals("PIA")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.PIA).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new Parede(i,j,img);
			
		}else if(nomeAgente.equals("FOGAO")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.FOGAO).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new Parede(i,j,img);
			
		}else if(nomeAgente.equals("ARMARIO")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.ARMARIO).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new Parede(i,j,img); 
			
		}else if(nomeAgente.equals("FRIGIDEIRA")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.FRIGIDEIRA).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new VilaoE(i,j, meuComodo, ciclos, img);
			
		}else if(nomeAgente.equals("HAMBURGUER")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.HAMBURGUER).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new VilaoE(i,j, meuComodo, ciclos, img);
			
		}else if(nomeAgente.equals("CAMA_1")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.CAMA_1).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new Parede(i,j,img);
			
		}else if(nomeAgente.equals("CAMA_2")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.CAMA_2).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new Parede(i,j,img);
			
		}else if(nomeAgente.equals("CAMA_3")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.CAMA_3).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new Parede(i,j,img);
			
		}else if(nomeAgente.equals("CAMA_4")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.CAMA_4).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new Parede(i,j,img);
			
		}else if(nomeAgente.equals("DESKTOP")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.DESKTOP).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new Parede(i,j,img);
			
		}else if(nomeAgente.equals("CELULAR")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.CELULAR).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new VilaoBateVolta(i,j,meuComodo, ciclos, img);
			
		}else if(nomeAgente.equals("ROUPA_SUJA")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.ROUPA_SUJA).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new VilaoD(i, j, meuComodo, ciclos, img);
			
		}else if(nomeAgente.equals("LIVRO")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.LIVRO).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new VilaoE(i, j, meuComodo, ciclos, img);
			
		}else if(nomeAgente.equals("ABAJUR")){
			Image img = new ImageIcon(Carregador.Imagens.get(Carregador.ABAJUR).getImage().getScaledInstance(escala,escala, 1)).getImage();
			return new VilaoBateVolta(i,j,meuComodo, ciclos, img);
		}else{
			return null;
		}
	}
	

}
