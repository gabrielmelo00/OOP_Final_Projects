package excecao;

public class ErroImagemNaoEncontrada extends Exception{

	private static final long serialVersionUID = -8943894436689460834L;

	public ErroImagemNaoEncontrada() {
		super();
	} 
	
	public ErroImagemNaoEncontrada(String mensagem) {
		super(mensagem);
	}
	
}
