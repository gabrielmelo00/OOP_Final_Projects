package framework;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import excecao.ErroAdicionarTeclado;

public class GerenciadorJanela implements IJanela {
	
	private JFrame frame;
	private JPanel painel;

	public GerenciadorJanela(String nomejogo) {
		frame = new JFrame(nomejogo);
		Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize();
	    double largura = tamanhoTela.getWidth();
	    double altura = tamanhoTela.getHeight();
		frame.setSize((int) largura, (int) altura);
		frame.setResizable(true);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void adicionarPainel(JPanel painel) {
		frame.add(painel);
		this.painel = painel;
	}
	
	public void mostrarJanela() {
		frame.setVisible(true);
	}
	
	public void adicionarKeyListener(KeyListener listener) throws ErroAdicionarTeclado{
		if(this.painel == null) {
			throw new ErroAdicionarTeclado("KeyListener não pode ser adicionado a um JPanel null.");
		}else {
			this.painel.addKeyListener(listener);
			painel.setFocusable(true);
		}
	}

}
