package framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import excecao.ErroAdicionarTeclado;
import excecao.ErroPilhaVazia;
import jogo.IJogo;



public class Motor implements IRJogo{
	
	private IJanela janela;
	private IGerenciadorModos gerenciadorModo;
	private Timer timer;

	public Motor() {	
		gerenciadorModo = new GerenciadorModos();
		janela = new GerenciadorJanela("NOME DO JOGO", gerenciadorModo);
		timer = new Timer(20, new LoopJogo());
	}
	
	public void conecta(IJogo jogo) {
		Modo novoModo = jogo.retornaJogo();
		novoModo.setGerenciador(gerenciadorModo);
		gerenciadorModo.adicionarPilha(novoModo);
	}

	public void comecarJogo() {
		janela.adicionarPainel();
		try{
			janela.adicionarKeyListener();
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

}
