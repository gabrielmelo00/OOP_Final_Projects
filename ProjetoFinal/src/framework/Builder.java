package framework;

import images.Loader;

public class Builder {
	
	WindowManager window;

	public void initialize() {
		
		window = new WindowManager("Jogo MC");
		window.addPanel(new MainMenu());
		window.showWindow();
		
		//pilha-> MainMenu()
		
	}
	
	//builder activeListener 
	// escuta os clicks da tela
	// o jogo em si: builder trocar a tela e inicializa o motor do jogo
	// a partir dai daqui quem controla é o motor e controler



}
