package framework;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import midia.Carregador;

public class RegrasJogo extends Modo{
	
	private Image background;
	private JButton start;
	private JButton rules;

	public RegrasJogo() {
		background = Carregador.Imagens.get(Carregador.MACA).getImage();
		setLayout(null);
	}

	
	public  void pintarTela(Graphics g, Dimension tela) {
		double largura = tela.getWidth();
	    double altura = tela.getHeight();
        Image imagem = new ImageIcon(background.getScaledInstance((int) largura, (int) altura, 1)).getImage();
        g.drawImage(imagem, 0, 0, this);
	} 
//	public abstract void keyPressed(); // o que essa tecla representa nessa classe
	
	public  void loop() {
		
	}
}
