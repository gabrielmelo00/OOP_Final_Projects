package framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import midia.Carregador;

public class MenuPrincipal extends Modo  {
	
	private static final long serialVersionUID = 356251201778918540L;
	
	private Image background;
	private Image menu_jogar;
	private Image menu_regras;
	private Image meuMenu;
	private JButton start;
	private JButton rules;
	private JPanel panel;
	
	public static final byte JOGAR = 0;
	public static final byte REGRAS = 1;
	public int selecaoEstado;

	

	public MenuPrincipal(GerenciadorModos meuGerenciador) {
		super(meuGerenciador);

		background = Carregador.Imagens.get(Carregador.BACKGROUND_MENU).getImage();
		menu_jogar = Carregador.Imagens.get(Carregador.SELECAO_MENU_JOGAR).getImage();
		menu_regras = Carregador.Imagens.get(Carregador.SELECAO_MENU_REGRAS).getImage();
		Image meuMenu = menu_jogar;
		setLayout(null);
		//ConfigBotao();
		
		selecaoEstado = JOGAR;
		
	}
	
	private void ConfigBotao() {
		panel = new JPanel();
		//System.out.println("entrou");
		start = new JButton("Start Game");	
		rules = new JButton("Game Rules");
		start.setBounds(100,200,100,30);
		rules.setBounds(200,200, 100, 30);
		//start.addActionListener(this);
		//rules.addActionListener(this);
		setBackground(Color.pink);
		
	}
	
	public void pintarTela(Graphics g, Dimension tela) {

	   double largura = tela.getWidth();
	   double altura = tela.getHeight();
       Image imagem = new ImageIcon(background.getScaledInstance((int) largura, (int) altura, 1)).getImage();
       g.drawImage(imagem, 0, 0, this);
       g.drawImage(meuMenu, 30, 30, this);
	} 


	
	public void loop() {
		//
		
	}

	public void keyTyped(KeyEvent e) {
		// nada ocorre
		
	}

	public void keyPressed(KeyEvent e) {
		//nada ocorre
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			switch(selecaoEstado) {
			case JOGAR: meuGerenciador.adicionarPilha(new Jogo()); break;
			case REGRAS: meuGerenciador.adicionarPilha(new RegrasJogo()); break;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			switch(selecaoEstado) {
			case JOGAR: 
				meuMenu = menu_regras;
				selecaoEstado = REGRAS;
				break;
			case REGRAS: break;
			}
		}else if(e.getKeyCode() == KeyEvent.VK_UP) {
			switch(selecaoEstado) {
			case JOGAR: break;
			case REGRAS: 
				meuMenu = menu_jogar;
				selecaoEstado = JOGAR;
				break;
			}
		}
	}
}
