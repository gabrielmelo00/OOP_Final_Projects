package mc322.lab05;

public class AppDama {

	public static void main(String[] args) {
		Tabuleiro meuTabuleiro = new Tabuleiro();
		System.out.println(meuTabuleiro.retornaEstado());
		char [] s = {'-', '4','2'};
		meuTabuleiro.testaPeao();
	}

}