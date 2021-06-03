package framework;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GerenciadorJanela {
	
	private JFrame frame;
	//private JPanel painel;

	public GerenciadorJanela(String nomejogo) {
		frame = new JFrame(nomejogo);
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void adicionarPainel(JPanel painel) {
		frame.add(painel);
	}
	
	public void mostrarJanela() {
		frame.setVisible(true);
	}
	
	//public void KeyPressed() {
		//panel.addkeylistener
	//}
	
	//public void addKeyListener() {
	//	this.panel.metodo();
//	}

}
