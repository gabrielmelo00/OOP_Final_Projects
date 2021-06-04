package framework;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JComponent;
import javax.swing.JPanel;

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
	
	public void keyTyped(KeyEvent e) {
		modos.peek().keyTyped(e);
	}
	
	public void keyPressed(KeyEvent e) {
		modos.peek().keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e) {
		modos.peek().keyReleased(e);
	}
	

}
	
	//public void keyPressed() {
		//mode.keyPressed
	//}


