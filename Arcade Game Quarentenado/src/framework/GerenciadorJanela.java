package framework;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import excecao.ErroAdicionarTeclado;
import excecao.ErroPilhaVazia;

public class GerenciadorJanela implements IJanela {
	
	private JFrame frame;
	private JPanel painel;
	private GerenciadorModos gerenciadorModo;

	public GerenciadorJanela(String nomejogo, IGerenciadorModos gerenciadorModo) {
		frame = new JFrame(nomejogo);
		this.gerenciadorModo = gerenciadorModo.retornaGerenciadorModo();
		Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize();
	    double largura = tamanhoTela.getWidth();
	    double altura = tamanhoTela.getHeight();
		frame.setSize((int) largura, (int) altura);
		frame.setResizable(true);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void adicionarPainel() {
		JPanel painel = new TelaAtual();
		frame.add(painel);
		this.painel = painel;
	}
	
	public void mostrarJanela() {
		frame.setVisible(true);
	}
	
	public void adicionarKeyListener() throws ErroAdicionarTeclado{
		if(this.painel == null) {
			throw new ErroAdicionarTeclado("KeyListener não pode ser adicionado a um JPanel null.");
		}else {
			this.painel.addKeyListener(new Comandos());
			painel.setFocusable(true);
		}
	}
	
	
	private class TelaAtual extends JPanel {

		private static final long serialVersionUID = 2925789023364782010L;
		
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);		
			try {
				gerenciadorModo.pintarTela(g);
			} catch (ErroPilhaVazia erro) {
				System.out.println("Erro no Carregamento do Jogo: " + erro.getMessage());
				System.exit(1);
			}
			repaint();
		}
		
	}
	private class Comandos  implements KeyListener {
		
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

}
