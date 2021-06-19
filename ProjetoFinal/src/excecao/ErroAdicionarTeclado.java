package excecao;

public class ErroAdicionarTeclado extends Exception{

	private static final long serialVersionUID = -8590485799685590334L;
	
	public ErroAdicionarTeclado() {
		super();
	}
	
	public ErroAdicionarTeclado(String mensagem) {
		super(mensagem);
	}

}
