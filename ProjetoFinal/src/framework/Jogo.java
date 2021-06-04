package framework;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import midia.Carregador;

public class Jogo extends Modo {
	
	private Image background;

	public Jogo() {
		background = Carregador.Imagens.get(Carregador.BACKGROUND_JOGO).getImage();
		setLayout(null);
	}

	public void pintarTela(Graphics g, Dimension tela) {
		double largura = tela.getWidth();
	    double altura = tela.getHeight();
        Image imagem = new ImageIcon(background.getScaledInstance((int) largura, (int) altura, 1)).getImage();
        g.drawImage(imagem, 0, 0, this);
	}

	public void loop() {
		// TODO Auto-generated method stub
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stubaaaa
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	public void keyReleased(KeyEvent e) {
		char keyChar = e.getKeyChar();
		if(keyChar == 'A' ) {
			meuGerenciador.removerPilha();
		}
	}

}
