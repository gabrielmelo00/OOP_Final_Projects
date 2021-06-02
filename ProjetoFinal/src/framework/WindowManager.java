package framework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import images.Loader;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class WindowManager extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = -6111255996436353556L;
	private JFrame frame;
	private JPanel panel;
	private Container menu;
	private Container rules;
	private Container game;
	Image image;

	public WindowManager(String gamename) {
		frame = new JFrame(gamename);
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void addPanel(JPanel panel) {
		frame.add(panel);
	}
	
	public void showWindow() {
		frame.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent event) {
		
		
	}

}
