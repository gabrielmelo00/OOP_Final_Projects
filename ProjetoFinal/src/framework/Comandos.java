package framework;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Comandos  implements KeyListener {
	
	private GerenciadorModos gerenciadorModo;
	
	public Comandos(GerenciadorModos gerenciadorModo) {
		this.gerenciadorModo = gerenciadorModo;
	}
		
	public void keyTyped(KeyEvent e) {
		gerenciadorModo.keyTyped(e);
	}

	public void keyPressed(KeyEvent e) {
		gerenciadorModo.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		gerenciadorModo.keyReleased(e);
	}
}
