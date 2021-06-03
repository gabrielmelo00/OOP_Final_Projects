package framework;

import java.util.Timer;

import javax.swing.*;
import java.awt.*;

public class Engine {
	private WindowManager window;
	private ModeManager mode;
	private Timer timer;
	private JPanel menu;
	
	public Engine() {
		window = new WindowManager("NOME DO JOGO");
		window.showWindow();
	    menu = new MainMenu();
		window.addPanel(menu);
		window.showWindow();
	}
}
