
import framework.IRJogo;
import framework.Motor;
import jogo.IJogo;
import jogo.MenuPrincipal;

public class AppProjetoFinal {
	
	public static void main(String[] args) {
		
		
		
		IRJogo meuFramework = new Motor();
		
		IJogo meuJogo = new MenuPrincipal();
		
		meuFramework.conecta(meuJogo);
		meuFramework.comecarJogo();
	}
}
