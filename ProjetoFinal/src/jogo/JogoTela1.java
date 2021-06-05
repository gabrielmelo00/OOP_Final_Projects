package jogo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import midia.Carregador;

public class JogoTela1 extends Modo {
	
	private Image background;
	private Quintal meuQuintal;
	
	public JogoTela1() {
		carregarImagens();
		meuQuintal = new Quintal();
		//montador
		//controleinterno -> montador
		//controlador (interface?)
	}
	
	public void carregarImagens() {
		background = Carregador.Imagens.get(Carregador.BACKGROUND_JOGO).getImage();
	}

	public void pintarTela(Graphics g) {
		//setLayout(null);
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		double largura = tela.getWidth();
	    double altura = tela.getHeight();
        Image imagem = new ImageIcon(background.getScaledInstance((int) largura, (int) altura, 1)).getImage();
        g.drawImage(imagem, 0, 0, null);
        meuQuintal.pintarTela(g);
	}

	public void loop() {	
		meuQuintal.mover();
		//checar colisao	
	}

	public void keyTyped(KeyEvent e) {
		meuQuintal.keyTyped(e);
	}

	public void keyPressed(KeyEvent e) {
		meuQuintal.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		meuQuintal.keyReleased(e);
		char keyChar = e.getKeyChar();
		if(keyChar == 'P' ) {
			meuGerenciador.removerPilha();
		}
	}

}

