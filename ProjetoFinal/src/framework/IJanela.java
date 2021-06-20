package framework;

import java.awt.event.KeyListener;

import javax.swing.JPanel;

import excecao.ErroAdicionarTeclado;


public interface IJanela {
	public void adicionarPainel(JPanel painel);
	public void mostrarJanela();
	public void adicionarKeyListener(KeyListener listener) throws ErroAdicionarTeclado;
}
