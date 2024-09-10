package jogo;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import framework.Modo;
import jogo.midia.Carregador;

public class Vitoria extends Modo {

	private Image img;
	private Image menu;
	private Image jogar;

	public static final byte MENU = 0;
	public static final byte JOGAR = 1;
	private int selecaoEstado;
	private double tempo;
	
	public Vitoria(int tempo) {
		carregarImagens();
		selecaoEstado = MENU;
		img = menu;
		this.tempo = (double) tempo*20/1000;
	}

	public void pintarTela(Graphics g) {
	    g.drawImage(img, 0, 0, null);
        Font f = new Font("Comic Sans MS", Font.BOLD, 60);
        g.setFont(f);
	    g.drawString("Tempo: "+Double.toString(tempo), 100, 100);
	}

	public void loop() {}

	public void carregarImagens() {
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	    int largura = (int) tela.getWidth();
	    int altura = (int) tela.getHeight();
		menu = new ImageIcon(Carregador.Imagens.get(Carregador.BACKGROUND_VITORIA_MENU).getImage().getScaledInstance( largura, altura, 1)).getImage();
		jogar = new ImageIcon(Carregador.Imagens.get(Carregador.BACKGROUND_VITORIA_JOGAR).getImage().getScaledInstance( largura, altura, 1)).getImage();
	}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			switch(selecaoEstado) {
			case JOGAR: 
				meuGerenciador.removerPilha();
				meuGerenciador.adicionarPilha(new Quintal());
				break;
			case MENU:meuGerenciador.removerPilha();break;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_S ||e.getKeyCode() == KeyEvent.VK_DOWN) {
			switch(selecaoEstado) {
			case MENU: break;
			case JOGAR: 
				img = menu;
				selecaoEstado = MENU;
				break;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_W ||e.getKeyCode() == KeyEvent.VK_UP) {
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
