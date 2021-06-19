package excecao;

public class ErroPilhaVazia extends Exception{

	private static final long serialVersionUID = -784297736917812704L;

	public ErroPilhaVazia() {
		super();
	}
	
	public ErroPilhaVazia(String mensagem) {
		super(mensagem);
	}
}
