package framework;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import midia.Carregador;

public class RegrasJogo extends Modo{
	
	private Image background;
	private Image regras_jogar;
	private Image regras_menu;
	private Image meuMenu;
	
	public static final byte JOGAR = 0;
	public static final byte MENU = 1;
	public int selecaoEstado;


	public RegrasJogo() {

		background = Carregador.Imagens.get(Carregador.BACKGROUND_REGRAS).getImage();
		regras_jogar = Carregador.Imagens.get(Carregador.SELECAO_REGRAS_JOGAR).getImage();
		regras_menu = Carregador.Imagens.get(Carregador.SELECAO_REGRAS_MENU).getImage();
		setLayout(null);
		meuMenu = regras_jogar;
		selecaoEstado = JOGAR;
	}

	
	public  void pintarTela(Graphics g, Dimension tela) {
		double largura = tela.getWidth();
	    double altura = tela.getHeight();
        Image imagem = new ImageIcon(background.getScaledInstance((int) largura, (int) altura, 1)).getImage();
        g.drawImage(imagem, 0, 0, this);
        g.drawImage(meuMenu, 30, 30, this);

	} 
//	public abstract void keyPressed(); // o que essa tecla representa nessa classe
	
	public  void loop() {
		
	}
	
	public void keyTyped(KeyEvent e) {
		// nada ocorre
		
	}

	public void keyPressed(KeyEvent e) {
		//nada ocorre
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			meuGerenciador.removerPilha();
			switch(selecaoEstado) {
			case JOGAR: meuGerenciador.adicionarPilha(new Jogo());break;
			case MENU: break;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			switch(selecaoEstado) {
			case MENU: 
				meuMenu = regras_jogar;
				selecaoEstado = JOGAR;
				break;
			case JOGAR: break;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_UP) {
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
