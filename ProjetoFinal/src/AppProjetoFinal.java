
import framework.IFramework;
import framework.Modo;
import framework.Motor;
import jogo.MenuPrincipal;
import midia.Carregador;

public class AppProjetoFinal {
	
	public static void main(String[] args) {
		
		Carregador.carregar();
		
		IFramework meuJogo = new Motor();
		Modo meuModo = new MenuPrincipal();
		
		meuJogo.conecta(meuModo);
		meuJogo.comecarJogo();
		
		
		//motor implementa IFramework IRFramework
	}
}
