
import framework.IRJogo;
import framework.Motor;
import jogo.IJogo;
import jogo.MenuPrincipal;
import midia.Carregador;

public class AppProjetoFinal {
	
	public static void main(String[] args) {
		
		Carregador.carregar();
		
		IRJogo meuFramework = new Motor();
		
		IJogo meuJogo = new MenuPrincipal();
		
		meuFramework.conecta(meuJogo);
		meuFramework.comecarJogo();
	}
}
