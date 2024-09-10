package framework;

import excecao.ErroAdicionarTeclado;


public interface IJanela {
	public void adicionarPainel();
	public void mostrarJanela();
	public void adicionarKeyListener() throws ErroAdicionarTeclado;
}
