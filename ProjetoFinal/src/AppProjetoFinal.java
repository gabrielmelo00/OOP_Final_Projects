
import framework.IFramework;
import framework.Modo;
import framework.Motor;
import jogo.IJogo;
import jogo.MenuPrincipal;
import midia.Carregador;

public class AppProjetoFinal {
	
	public static void main(String[] args) {
		
		Carregador.carregar();
		
		IFramework meuMotor = new Motor();
		
		IJogo meuJogo = new MenuPrincipal();
		
		meuMotor.conecta(meuJogo);
		meuMotor.comecarJogo();
		
	}
}
