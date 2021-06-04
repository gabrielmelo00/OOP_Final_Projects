package framework;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

public abstract class Modo extends JPanel{
	
	private static final long serialVersionUID = 4629633899480787509L;
	public static GerenciadorModos meuGerenciador;


	public Modo(GerenciadorModos meuGerenciador) {
		this.meuGerenciador = meuGerenciador;
	}
	
	public Modo() {};

	
	public abstract void pintarTela(Graphics g, Dimension tela); //elementos desse modo que devem ser colocados na tela

//	public abstract void keyPressed(); // o que essa tecla representa nessa classe
	
	public abstract void loop(); //o que o loop desse modo deve fazer
	
	public abstract void keyTyped(KeyEvent e);
	public abstract void keyPressed(KeyEvent e);
	public abstract void keyReleased(KeyEvent e);
	


}
