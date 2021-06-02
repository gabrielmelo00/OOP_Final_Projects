package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowManager implements ActionListener{
	
	private JFrame  frame;
	private Container painel;
	private Container painel2;
	private JButton button1;
	private JButton button2;
	
	public WindowManager(String nome) {
		frame = new JFrame(nome);
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    visual();
	    
	    
	}
	
	public void visual() {
		//setExtendedState(JFrame.MAXIMIZED_BOTH)
		painel = new JPanel();
		painel.setLayout(null);
		
		button1 = new JButton("Start");	
		button2 = new JButton("Settings");
		button1.setBounds(100,200,100,30);
		button2.setBounds(200,200, 100, 30);
		button1.addActionListener(this);
		button2.addActionListener(this);
		painel.add(button1);
		painel.add(button2);
		
		frame.add(painel);
		
	    frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
        //Changing Background Color
		
		if(event.getSource() == button1) {
			frame.remove(painel);
			painel2 = new JPanel();
		    painel2.setLayout(new BorderLayout());
		    AnimatedImage imagem = new AnimatedImage(WindowManager.class.getResource(".").getPath() + "dino.png",0, 0, 200, 200, 40, 0);
		    painel2.add(imagem, BorderLayout.CENTER);
		    frame.add(painel2);
		    Timer timer = new Timer(1000, imagem);
		    timer.start();
		    SwingUtilities.updateComponentTreeUI(frame);
		}else if(event.getSource() == button2){
			frame.getContentPane().setBackground(Color.pink);
			SwingUtilities.updateComponentTreeUI(frame);
		}
		
 
    }

}
