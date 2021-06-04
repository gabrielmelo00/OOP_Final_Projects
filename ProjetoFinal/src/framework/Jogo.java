package framework;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import jogo.Montador;
import midia.Carregador;

public class Jogo extends Modo {
	
	private Image background;
	private Montador meuMontador;
	
	public Jogo() {
		carregarImagens();
		//montador
		meuMontador = new Montador();
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
	}

	public void loop() {}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {
		char keyChar = e.getKeyChar();
		if(keyChar == 'A' ) {
			meuGerenciador.removerPilha();
		}
	}

}
