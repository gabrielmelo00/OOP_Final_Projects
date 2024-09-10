

import excecao.ErroImagemNaoEncontrada;
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
		}catch(ErroImagemNaoEncontrada erro) {
			System.out.println(erro.getMessage());
			System.out.println("ErroImagemNaoEncontrada: n�o � possivel carregar jogo!");
		}catch(Exception erro) {
			System.out.println("Erro: n�o � poss�vel carregar jogo!");
		}
	}
}
