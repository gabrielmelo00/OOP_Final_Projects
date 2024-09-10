package framework;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Stack;

import excecao.ErroPilhaVazia;

public class GerenciadorModos implements IGerenciadorModos{
	private Stack<Modo> modos;

	public GerenciadorModos() {
		modos = new Stack<Modo>();
	}
	
	public void adicionarPilha(Modo novoModo) {
		modos.push(novoModo);
	}
	
	public void removerPilha(){
		if(modos.empty()) {
			System.out.println("Aten��o: a pilha est� vazia.");
		}else {
			modos.pop();
		}
	}
	
	public Modo olharPilha() throws ErroPilhaVazia{
		if(modos.empty()) {
			throw new ErroPilhaVazia("A pilha de modos est� vazia!");
		}else {
			return modos.peek();
		}
		
	}
	
	public void loop() throws ErroPilhaVazia{
		if(modos.empty()) {
			throw new ErroPilhaVazia("A pilha de modos est� vazia!");
		}else {
			modos.peek().loop();
		}
		
	}
	
	public void pintarTela (Graphics g) throws ErroPilhaVazia{
		if(modos.empty()) {
			throw new ErroPilhaVazia("A pilha de modos est� vazia!");
		}else {
			 modos.peek().pintarTela(g);
		}
		
	}
	
	public void keyTyped(KeyEvent e) {
		if(modos.empty()) {
			System.out.println("Aten��o: a pilha est� vazia.");
		}else {
			modos.peek().keyTyped(e);
		}
		
	}
	
	public void keyPressed(KeyEvent e) {
		if(modos.empty()) {
			System.out.println("Aten��o: a pilha est� vazia.");
		}else {
			modos.peek().keyPressed(e);
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		if(modos.empty()) {
			System.out.println("Aten��o: a pilha est� vazia.");
		}else {
			modos.peek().keyReleased(e);
		}
		
	}

	
	public GerenciadorModos retornaGerenciadorModo() {
		return this;
	}
	

}


