package mc322.lab06;

public class Controle {
	private Componente meuHeroi;
	private String nomeHeroi;
	
	public Controle(String nomeHeroi, Componente meuHeroi) {
		this.nomeHeroi = nomeHeroi;
		this.meuHeroi = meuHeroi;
		System.out.println(meuHeroi.minhaCaverna.getEstadoCaverna());
	}
	
	public boolean comando(String comando) {
		boolean retorno = true;
		switch(comando) {
			case "w":
				if(!meuHeroi.acima()) System.out.println("Movimento inválido");
				break;
			case "s":
				if(!meuHeroi.abaixo())System.out.println("Movimento inválido");
				break;
			case "d":
				if(!meuHeroi.direita())System.out.println("Movimento inválido");
				break;
			case "a":
				if(!meuHeroi.esquerda())System.out.println("Movimento inválido");
				break;
			case "k":
				if(!meuHeroi.equipaFlecha())System.out.println("Movimento inválido");
				break;
			case "c":
				if(!meuHeroi.capturaOuro())System.out.println("Movimento inválido");
				break;
			case "q":
				System.out.println("para");
				retorno = false;
				break;
		}
		System.out.println(meuHeroi.minhaCaverna.getEstadoCaverna());
		return retorno;
		
	}

}
