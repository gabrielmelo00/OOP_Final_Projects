package mc322.lab06;

import java.util.ArrayList;

public class Sala {
	
	//Componente [] meusComponentes;
	ArrayList<Componente> meusComponentes;
	boolean salaConhecida;
	
	public Sala() {
		meusComponentes = new ArrayList<Componente>();
		salaConhecida = false;
	}
	
	public boolean adicionaComponente(Componente c) {
		boolean estado = false;
		if(verifica(c)) {
			int posicao = hierarquiaComponente(c);
			meusComponentes.add(posicao, c);
			if(c.getTipo() == 'P') {
				salaConhecida = true;
				for(int x = 0; x < meusComponentes.size(); x++) {
					if(meusComponentes.get(x).getTipo() == 'B') {
						c.setPerdeu();
					}else if(meusComponentes.get(x).getTipo() == 'W') {
						if(!c.getFlechaEquipada()) {
							c.setPerdeu();
						}
					}
				}
			}
			estado = true;
		}
		return estado;
	}
	
	public boolean retiraComponente(Componente c) {
		boolean estado = false;
		if(meusComponentes.contains(c)) {
			meusComponentes.remove(meusComponentes.indexOf(c));
			estado = true;
		}
		return estado;
	}
	
	private boolean verifica(Componente c) {
		//OURO, WUMPUS E BURACO não podem estar na mesma sala
		boolean estado = true;
		if(!meusComponentes.isEmpty()) {
			for(int i = 0; i < meusComponentes.size(); i++) {
				if(meusComponentes.get(i).getTipo() == 'O' || meusComponentes.get(i).getTipo() == 'W' || meusComponentes.get(i).getTipo() == 'B') {
					if(c.getTipo() == 'O' || c.getTipo() == 'W' || c.getTipo() == 'B') {
						estado = false;
					}
				}
			}
		}
		return estado;
	}
	
	private int hierarquiaComponente(Componente c) {
		int posicao = 0;
		if(c.getTipo() == 'P') {
			for(int i = 0; i < meusComponentes.size(); i++) {
				if(meusComponentes.get(i).getTipo() == 'O' || meusComponentes.get(i).getTipo() == 'B' || meusComponentes.get(i).getTipo() == 'W') {
					posicao += 1;
				}
			}
		}else if(c.getTipo() == 'f') {
			for(int i = 0; i < meusComponentes.size(); i++) {
				if(meusComponentes.get(i).getTipo() == 'O' || meusComponentes.get(i).getTipo() == 'B' || meusComponentes.get(i).getTipo() == 'W' || meusComponentes.get(i).getTipo() == 'P') {
					posicao += 1;
				}
			}
		}else if(c.getTipo() == 'b') {
			posicao = meusComponentes.size();
		}
		return posicao;
	}
	
	public void retiraOuro() {
		Componente ouro = null;
		Componente heroi = null;
		for(int i = 0; i < meusComponentes.size(); i++) {
			if(meusComponentes.get(i).getTipo() == 'O') {
				ouro = meusComponentes.get(i);
			}else if(meusComponentes.get(i).getTipo() == 'P') {
				heroi = meusComponentes.get(i);
			}
		}
		if(ouro != null && heroi!= null) {
			retiraComponente(ouro);
			heroi.setOuro();
		}
	}
	
	public void atiraFlecha() {
		Componente wumpus = null;
		Componente heroi = null;
		for(int i = 0; i < meusComponentes.size(); i++) {
			if(meusComponentes.get(i).getTipo() == 'W') {
				wumpus = meusComponentes.get(i);
			}else if(meusComponentes.get(i).getTipo() == 'P') {
				heroi = meusComponentes.get(i);
			}
		}
		if(wumpus != null && heroi != null) {
			if(wumpus.atacarWumpus()) {
				heroi.setWumpus();
				retiraComponente(wumpus);
			}else {
				heroi.setPerdeu();
			}
		}
	}
}
