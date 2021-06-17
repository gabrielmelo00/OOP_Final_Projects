package jogo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import framework.Modo;
import jogo.midia.Carregador;

public class Vitoria extends Modo {

	Image img;
	Image menu;
	Image jogar;

	public static final byte MENU = 0;
	public static final byte JOGAR = 1;
	public int selecaoEstado;
	
	public Vitoria() {
		carregarImagens();
		selecaoEstado = MENU;
		img = menu;
	}

	public void pintarTela(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	}

	public void loop() {

	}

	public void carregarImagens() {
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	    int largura = (int) tela.getWidth();
	    int altura = (int) tela.getHeight();
		menu = new ImageIcon(Carregador.Imagens.get(Carregador.BACKGROUND_VITORIA_MENU).getImage().getScaledInstance( largura, altura, 1)).getImage();
		jogar = new ImageIcon(Carregador.Imagens.get(Carregador.BACKGROUND_VITORIA_JOGAR).getImage().getScaledInstance( largura, altura, 1)).getImage();
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			switch(selecaoEstado) {
			case JOGAR: 
				meuGerenciador.removerPilha();
				meuGerenciador.adicionarPilha(new Quintal());
				break;
			case MENU:meuGerenciador.removerPilha();break;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			switch(selecaoEstado) {
			case MENU: break;
			case JOGAR: 
				img = menu;
				selecaoEstado = MENU;
				break;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_UP) {
			switch(selecaoEstado) {
			case MENU: 
				img = jogar;
				selecaoEstado = JOGAR;
				break;
			case JOGAR: break;
			
			}
		}
	}

}
