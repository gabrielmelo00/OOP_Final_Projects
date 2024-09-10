package jogo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

import excecao.ErroPilhaVazia;
import framework.Modo;


import jogo.midia.Carregador;

public class RegrasJogo extends Modo {
	
	private Image background;
	private Image regras_jogar;
	private Image regras_menu;
	private Image meuMenu;
	
	
	public static final byte JOGAR = 0;
	public static final byte MENU = 1;
	public int selecaoEstado;


	public RegrasJogo() {
		carregarImagens();
		meuMenu = regras_menu;
		selecaoEstado = MENU;
	}
	
	public void carregarImagens() {
		background = Carregador.Imagens.get(Carregador.BACKGROUND_REGRAS).getImage();
		regras_jogar = Carregador.Imagens.get(Carregador.SELECAO_REGRAS_JOGAR).getImage();
		regras_menu = Carregador.Imagens.get(Carregador.SELECAO_REGRAS_MENU).getImage();
	}

	
	public  void pintarTela(Graphics g) {
		//setLayout(null);
		
	    Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
	    double largura = tela.getWidth();
	    double altura = tela.getHeight();
        Image imagem = new ImageIcon(background.getScaledInstance((int) largura, (int) altura, 1)).getImage();
        g.drawImage(imagem, 0, 0, null);
        g.drawImage(meuMenu, 30, 30, null);

	} 
	
	public  void loop() {}
	
	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			meuGerenciador.removerPilha();
			switch(selecaoEstado) {
			case JOGAR: meuGerenciador.adicionarPilha(new Quintal());break;
			case MENU: break;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_S ||e.getKeyCode() == KeyEvent.VK_DOWN) {
			switch(selecaoEstado) {
			case MENU: 
				meuMenu = regras_jogar;
				selecaoEstado = JOGAR;
				break;
			case JOGAR: break;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_W ||e.getKeyCode() == KeyEvent.VK_UP) {
			switch(selecaoEstado) {
			case MENU: break;
			case JOGAR: 
				meuMenu = regras_menu;
				selecaoEstado = MENU;
				break;
			}
		}
	}

}