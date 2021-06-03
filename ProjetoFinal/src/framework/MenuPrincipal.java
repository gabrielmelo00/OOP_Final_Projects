package framework;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import midia.Carregador;

public class MenuPrincipal extends Modo  {
	
	private static final long serialVersionUID = 356251201778918540L;
	
	private Image background;
	private JButton start;
	private JButton rules;
	private int contador;

	public MenuPrincipal(GerenciadorModos meuGerenciador) {
		super(meuGerenciador);
		background = Carregador.Imagens.get(Carregador.BACKGROUND).getImage();
		setLayout(null);
		ConfigBotao();
		contador = 0;
	}
	
	private void ConfigBotao() {
		//System.out.println("entrou");
		start = new JButton("Start Game");	
		rules = new JButton("Game Rules");
		start.setBounds(100,200,100,30);
		rules.setBounds(200,200, 100, 30);
		//start.addActionListener(this);
		//rules.addActionListener(this);
		
		this.add(start);
		this.add(rules);
	}
	
	public void pintarTela(Graphics g, Dimension tela) {
		//System.out.println("entrou");
		
		double largura = tela.getWidth();
	    double altura = tela.getHeight();
        Image imagem = new ImageIcon(background.getScaledInstance((int) largura, (int) altura, 1)).getImage();
        g.drawImage(imagem, 0, 0, this);
		
	} 

//	public abstract void keyPressed(); // o que essa tecla representa nessa classe
	
	public void loop() {
		contador ++;
		System.out.println(contador);
		if(contador > 200) {
			meuGerenciador.removerPilha();
			meuGerenciador.adicionarPilha(new RegrasJogo());
		}
		
	} //o que o loop desse modo deve fazer

}
