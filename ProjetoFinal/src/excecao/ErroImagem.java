package excecao;

public class ErroImagem extends Exception{
	
	private static final long serialVersionUID = -5877555568978033043L;
	
	public ErroImagem() {
		super();
	} 
	
	public ErroImagem(String mensagem) {
		super(mensagem);
	}

}
