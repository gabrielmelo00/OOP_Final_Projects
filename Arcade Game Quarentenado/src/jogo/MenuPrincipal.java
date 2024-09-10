package jogo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import excecao.ErroImagemNaoEncontrada;
import jogo.midia.Carregador;
import framework.Modo;

public class MenuPrincipal extends Modo implements IJogo{
	
	private Image background;
	private Image menu_jogar;
	private Image menu_regras;
	private Image meuMenu;
	
	public static final byte JOGAR = 0;
	public static final byte REGRAS = 1;
	public int selecaoEstado;

	

	public MenuPrincipal() throws ErroImagemNaoEncontrada{
		super();
		try{
			Carregador.carregar();
			carregarImagens();
		}catch(ErroImagemNaoEncontrada erro) {
			throw new ErroImagemNaoEncontrada(erro.getMessage());
		}
		
		
		meuMenu = menu_jogar;
		selecaoEstado = JOGAR;	

	}
	
	public void carregarImagens() {
		background = Carregador.Imagens.get(Carregador.BACKGROUND_MENU).getImage();
		menu_jogar = Carregador.Imagens.get(Carregador.SELECAO_MENU_JOGAR).getImage();
		menu_regras = Carregador.Imagens.get(Carregador.SELECAO_MENU_REGRAS).getImage();
	}
	
	public void pintarTela(Graphics g) {
		Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
		double largura = tela.getWidth();
	    double altura = tela.getHeight();
        Image imagem = new ImageIcon(background.getScaledInstance((int) largura, (int) altura, 1)).getImage();
        g.drawImage(imagem, 0, 0, null);
        g.drawImage(meuMenu, 130, 70, null);
	} 


	
	public void loop() {}

	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			switch(selecaoEstado) {
			case JOGAR: meuGerenciador.adicionarPilha(new Quintal()); break;
			case REGRAS:
				meuGerenciador.adicionarPilha(new RegrasJogo());
				meuMenu = menu_jogar;
				selecaoEstado = JOGAR;
				break;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_S ||e.getKeyCode() == KeyEvent.VK_DOWN) {
			switch(selecaoEstado) {
			case JOGAR: 
				meuMenu = menu_regras;
				selecaoEstado = REGRAS;
				break;
			case REGRAS: break;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_W ||e.getKeyCode() == KeyEvent.VK_UP) {
			switch(selecaoEstado) {
			case JOGAR: break;
			case REGRAS: 
				meuMenu = menu_jogar;
				selecaoEstado = JOGAR;
				break;
			}
		}
	}

	public Modo retornaJogo() {
		return this;
	}


}