package framework;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import excecao.ErroPilhaVazia;

public interface IGerenciadorModos {
	public void adicionarPilha(Modo novoModo);
	public void loop() throws ErroPilhaVazia;
	public void pintarTela (Graphics g) throws ErroPilhaVazia;
	public GerenciadorModos retornaGerenciadorModo();
	public void keyReleased(KeyEvent e);
	public void keyPressed(KeyEvent e);
	public void keyTyped(KeyEvent e);
}
