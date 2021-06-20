package framework;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import excecao.ErroAdicionarTeclado;
import excecao.ErroPilhaVazia;
import jogo.IJogo;



public class Motor implements IRJogo{
	
	private IJanela janela;
	private IGerenciadorModos gerenciadorModo;
	private Timer timer;

	public Motor() {		
		janela = new GerenciadorJanela("NOME DO JOGO");
		gerenciadorModo = new GerenciadorModos();
		timer = new Timer(20, new LoopJogo());
	}
	
	public void conecta(IJogo jogo) {
		Modo novoModo = jogo.retornaJogo();
		novoModo.setGerenciador(gerenciadorModo);
		gerenciadorModo.adicionarPilha(novoModo);
	}

	public void comecarJogo() {
		janela.adicionarPainel(new TelaAtual());
		try{
			janela.adicionarKeyListener(new Comandos());
		}catch(ErroAdicionarTeclado erro) {
			System.out.println(erro);
			System.exit(1);
		}
		
		janela.mostrarJanela();
		timer.start();
	}
	
	
	private class LoopJogo implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			try {
				gerenciadorModo.loop();
			} catch (ErroPilhaVazia erro) {
				System.out.println("Erro no Carregamento do Jogo: " + erro.getMessage());
				timer.stop();
				System.exit(1);
			}
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
				timer.stop();
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
