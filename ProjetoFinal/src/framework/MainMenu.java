package framework;

import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import images.Loader;

public class MainMenu extends JPanel {

	private static final long serialVersionUID = 8525496320710312123L;
	
	private Image background;
	private JButton start;
	private JButton rules;

	public MainMenu()  {
		background = Loader.Images.get(Loader.BACKGROUND).getImage();
		setLayout(null);
		buttonSettings();
	}
	
	private void buttonSettings() {
		start = new JButton("Start Game");	
		rules = new JButton("Game Rules");
		start.setBounds(100,200,100,30);
		rules.setBounds(200,200, 100, 30);
		//start.addActionListener(this);
		//rules.addActionListener(this);
		
		this.add(start);
		this.add(rules);
	
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		 Dimension screen = this.getSize();
		double width = screen.getWidth();
        double height = screen.getHeight();

        Image image = new ImageIcon(background.getScaledInstance(
                (int) width, (int) height, 1)).getImage();

        g.drawImage(image, 0, 0, this);
	}
	
	public void addButtonListener(WindowManager window) {
		start.addActionListener(window);
		rules.addActionListener(window);
	}
	
	
	
	

}
