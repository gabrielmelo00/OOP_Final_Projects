package mc322.lab06;

public class Controle {
	private Componente meuHeroi;
	private String nomeHeroi;
	
	public Controle(String nomeHeroi, Componente meuHeroi) {
		this.nomeHeroi = nomeHeroi;
		this.meuHeroi = meuHeroi;
		printa();
	}
	
	public boolean comando(String comando) {
		boolean retorno = true;
		boolean movInvalido = false;
		if(!meuHeroi.getPerdeu() && !meuHeroi.ganhei()) {
			switch(comando) {
			case "w":
				if(!meuHeroi.acima()) movInvalido = true;
				break;
			case "s":
				if(!meuHeroi.abaixo())movInvalido = true;
				break;
			case "d":
				if(!meuHeroi.direita())movInvalido = true;
				break;
			case "a":
				if(!meuHeroi.esquerda())movInvalido = true;
				break;
			case "k":
				if(!meuHeroi.equipaFlecha())movInvalido = true;
				break;
			case "c":
				if(!meuHeroi.capturaOuro())movInvalido = true;
				break;
			case "q":
				retorno = false;
				break;
			}
			
			if(meuHeroi.getPerdeu()) {
				printa();
				System.out.println("Voce perdeu =( ...");
				retorno = false;
			}else if(meuHeroi.ganhei()){
				printa();
				System.out.println("Voce ganhou =D !!!");
				retorno = false;
			}else if(comando.equals("q")) {
				printa();
				System.out.println("Volte sempre !");
			}else if(movInvalido == true){
				System.out.println("Movimento inválido.");
			}else {
				printa();
			}
		}
		return retorno;
	}
	
	private void printa() {
		System.out.println(meuHeroi.minhaCaverna.getEstadoCaverna());
		System.out.println("Player: "+ nomeHeroi);
		System.out.println("Score: "+ meuHeroi.getPontuacao());
		System.out.println("Ouro: "+ meuHeroi.getOuro());
		System.out.println("Flechas: "+ meuHeroi.getFlechas());
		if(meuHeroi.getFlechaEquipada() == false) {
			System.out.println("A flecha não está equipada.");
		}else {
			System.out.println("A flecha está equipada.");
		}
		if(meuHeroi.getWumpus() == true) {
			System.out.println("Você matou o Wumpus!");
		}
		
		
	}

}
