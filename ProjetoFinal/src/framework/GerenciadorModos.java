package framework;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Stack;

public class GerenciadorModos {
	private Stack<Modo> modos;

	public GerenciadorModos() {
		modos = new Stack<Modo>();
	}
	
	public void adicionarPilha(Modo novoModo) {
		modos.push(novoModo);
	}
	
	public void removerPilha() {
		modos.pop();
	}
	
	public Modo olharPilha() {
		return modos.peek();
	}
	
	public void loop() {
		modos.peek().loop();
	}
	
	public void pintarTela (Graphics g, Dimension tela) {
		modos.peek().pintarTela(g, tela);
	}
	
	//public void keyPressed() {
		//mode.keyPressed
	//}

}
