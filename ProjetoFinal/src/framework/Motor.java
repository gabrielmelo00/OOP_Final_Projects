package framework;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Motor {
	
	private GerenciadorJanela janela;
	private GerenciadorModos modo;
	private Timer timer;

	public Motor() {
		
		janela = new GerenciadorJanela("NOME DO JOGO");
		modo = new GerenciadorModos();
		timer = new Timer(20, new LoopJogo());
		
		modo.adicionarPilha(new MenuPrincipal(modo));// um MenuPrincipal do tipo Modo
		
		janela.adicionarPainel(new TelaAtual());
		janela.mostrarJanela();

		//windowmanager como KeyListener
		//menu = new MainMenu();

	
		timer.start();
		
	}
	
	public class LoopJogo implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			modo.loop();
			//repaint();
		}
	}
	
	private class TelaAtual extends JPanel {

		private static final long serialVersionUID = 2925789023364782010L;
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Dimension tela = this.getSize();
			modo.pintarTela(g, tela);
			repaint();
		}
		
		// paintComponent
		
		//e ir chamando o render de cada estado?
	}
	
	//private class Comandos implements KeyListener {
		//o que fazer com os comandos mas entrando no codigo:
		// windowmanager.key....
	//	windowmanager.metodo();
	//}

}
