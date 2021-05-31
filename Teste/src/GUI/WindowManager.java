package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class WindowManager extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = -4861605391469864979L;
	private Container painel;
	private JButton button1;
	private JButton button2;
	
	public WindowManager(String nome) {
		super(nome);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    visual();
	}
	
	public void visual() {
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(400,400);
		painel = getContentPane();
		painel.setLayout(null);
		
		button1 = new JButton("Start");	
		button2 = new JButton("Settings");
		button1.setBounds(100,200,100,30);
		button2.setBounds(200,200, 100, 30);
		button1.addActionListener(this);
		button2.addActionListener(this);
		add(button1);
		add(button2);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
        //Changing Background Color
		if(event.getSource() == button1) {
			getContentPane().setBackground(Color.pink);
		}else if(event.getSource() == button2){
			getContentPane().setBackground(Color.orange);
		}
        
 
    }

}
