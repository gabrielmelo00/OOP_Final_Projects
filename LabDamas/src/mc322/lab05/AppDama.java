package mc322.lab05;

public class AppDama {

	public static void main(String[] args) {
		Tabuleiro meuTabuleiro = new Tabuleiro();
		System.out.println(meuTabuleiro.retornaEstado());
		meuTabuleiro.moverPeca("b6:c5");
		System.out.println(meuTabuleiro.retornaEstado());
		meuTabuleiro.moverPeca("e3:d4");
		System.out.println(meuTabuleiro.retornaEstado());
		meuTabuleiro.moverPeca("c5:e3");
		System.out.println(meuTabuleiro.retornaEstado());
		meuTabuleiro.moverPeca("c3:d4");
		System.out.println(meuTabuleiro.retornaEstado());
		meuTabuleiro.moverPeca("e3:c5");
		System.out.println(meuTabuleiro.retornaEstado());
		meuTabuleiro.moverPeca("a3:b4");
		System.out.println(meuTabuleiro.retornaEstado());
		meuTabuleiro.moverPeca("c5:a3");
		System.out.println(meuTabuleiro.retornaEstado());
		meuTabuleiro.moverPeca("b2:c3");
		System.out.println(meuTabuleiro.retornaEstado());
		meuTabuleiro.moverPeca("d6:e5");
		System.out.println(meuTabuleiro.retornaEstado());
		meuTabuleiro.moverPeca("c1:b2");
		System.out.println(meuTabuleiro.retornaEstado());
		meuTabuleiro.moverPeca("a3:c1");
		System.out.println(meuTabuleiro.retornaEstado());
		
		/*Teste útil:
		System.out.println("avanca: " + avanca  + " ataca: " + ataca);
		
		//char [] s = {'-', '4','2'};
		//meuTabuleiro.testaPeao();
		//System.out.println("cor:" + meuTabuleiro.matrizPeao[5][1].getCor());
		//char [] s = meuTabuleiro.retornaDirecao(2, 2, 5, 5);
		*/
	}

}