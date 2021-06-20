
import excecao.ErroImagem;
import framework.IRJogo;
import framework.Motor;
import jogo.IJogo;
import jogo.MenuPrincipal;

public class AppProjetoFinal {
	
	public static void main(String[] args) {
		
		IRJogo meuFramework = new Motor();
		
		try {
			IJogo meuJogo = new MenuPrincipal();
			meuFramework.conecta(meuJogo);
			meuFramework.comecarJogo();
		}catch(ErroImagem erro) {
			System.out.println(erro.getMessage());
			System.out.println("ErroImagem: Nao é possivel carregar jogo!");
		}
	}
}
