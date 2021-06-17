package framework;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

import jogo.IJogo;



public class Motor implements IRJogo{
	
	private GerenciadorJanela janela;
	private GerenciadorModos gerenciadorModo;
	private Timer timer;
	private Comandos teclado;

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
		teclado = new Comandos(gerenciadorModo);
		janela.adicionarKeyListener(teclado);
		janela.mostrarJanela();
		timer.start();
	}
	
	
	private class LoopJogo implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			gerenciadorModo.loop();
		}
	}
	
	private class TelaAtual extends JPanel {

		private static final long serialVersionUID = 2925789023364782010L;
		
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);		
			gerenciadorModo.pintarTela(g);
			repaint();
		}
		
	}

	

}
