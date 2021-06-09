package jogo;

import java.awt.Graphics;
import java.util.ArrayList;

public class Celula {
	private ArrayList<Agente> meusAgentes;
	private int i;
	private int j;
	
	public Celula(int i, int j) {
		this.i = i;
		this.j = j;
		meusAgentes = new ArrayList<Agente>();
	}

	public void adicionaAgente(Agente agente) {
		System.out.println("Estou adicionado");
		meusAgentes.add(agente);
	}
	
	public void retiraAgente(Agente agente) {
		System.out.println("Estou retirando");
		meusAgentes.remove(agente);
	}
	
	public void pintarTela(Graphics g) {
		for(int i = 0; i < meusAgentes.size(); i++) {
			meusAgentes.get(i).pintarTela(g);
		}
	}
	
	public void mover() {
		for(int i = 0; i < meusAgentes.size(); i++) {
			meusAgentes.get(i).mover();
		}
	}
	
}
