# Projeto Final MC322

## Descrição Resumida do Projeto/Jogo

Há quase um ano e meio no EAD, nós estudantes sabemos que um dos maiores desafios do estudo remoto é se manter focado. Na superfície, isso pode parecer uma tarefa fácil, mas assistir aulas em casa é uma tarefa que apresenta vários desafios, como telefonemas inesperados, animais que demandam atenção e pilhas de louça que parecem nunca ter fim.

Com isso em mente, propomos um jogo em que você deve ajudar um estudante a chegar são e salvo no seu computador para assistir uma aula. Para isso ele deve atravessar diferentes cômodos da casa, desviando das distrações e obrigações que aparecem pelo caminho.

O estudante pode se mover nas quatro direções (cima, baixo, direita e esquerda) através das setas do teclado ou das teclas WASD.
	
A dinâmica do jogo foi inspirado no jogo de Arcade, Frogger. 

## Proposta da Arquitetura do Jogo

O desenvolvimento deste projeto pode ser divido em duas frentes principais: a construção de um `Framework` para o jogo e a elaboração do `Jogo` em si.

O `Framework` é responsável pelo controle do `loop principal` de jogo e dos eventos desencadeados pelo teclado assim como pela inicialização da janela do jogo. As ações que devem ser realizadas a partir da ocorrência de cada um desses eventos, no entanto, não são de responsabilidade do `Framework`. Ele delega essas decisões para o contexto apropriado de cada momento ou o `Modo` atual do jogo. Dessa forma, o evento desencadeado pelo pressionamento de uma tecla, por exemplo, varia de acordo com o `Modo` atual do jogo. Tal característica permite que o `Framework` possa ser usado no desenvolvimento de outros jogos e não somente desse, basta trocar o conjunto de `Modos` do jogo.

O `Framework` orquestra os diferentes `Modos` através de uma pilha.

O `Framework` criado é composto por três componentes: Motor, Gerenciador de Janela e Gerenciador de Modos.

Por sua vez, o `Jogo` consiste em uma máquina de estados de `Modos` que será gerenciada pela pilha do Gerenciador de Modos. Assim, por exemplo, para trocar de nível, basta que o `Modo` que implementa o nível atual requisite ao Gerenciador de Modos que coloque o próximo nível no topo da pilha. Essa dinâmica trouxe facilidade para o encadeamento de fases e telas do jogo desenvolvido.

## Equipe Fazendo Eletiva na Computação
* Hannah de Oliveira Plath - 198642
* Gabriel Silva Vieira de Melo - 216474

## Vídeos do Projeto

### Vídeo da Prévia
[Apresentação em vídeo da prévia do projeto](https://drive.google.com/file/d/1SO7CH6iEJi1w_buz3tIoBtMbhdTDB4hw/view?usp=sharing)

## Slides do Projeto

### Slides da Prévia
[Apresentação de slides da prévia do projeto](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/Previa%20Projeto.pdf)

## Destaques do Código

### Polimorfismo

Os elementos do jogo (estudante e obstáculos) foram criados a partir de classes que estendem uma classe abstrata chamada `Agente`. Como as operações das células do jogo, performadas pela classe `Celula`, são feitas considerando elementos da classe `Agente`, o uso do polimorfismo na codificação torna o código mais expansível. Isso pois, para se adicionar um novo tipo de obstáculo no jogo basta criar uma nova classe que estende Agente.


~~~java
public class Celula {
	private ArrayList<Agente> meusAgentes;
	...
	public boolean adicionaAgente(Agente agente){ ...}
	public void retiraAgente(Agente agente){ ...}
	...
	}
~~~

~~~java
public class Parede extends Agente{ ...}

public class Estudante extends Agente{ ...}

public class VilaoD extends Agente{ ...}

...
~~~
### Classe Abstrata

Para que a parte do código referente ao `Framework` possa ser usada para o desenvolvimento de outros jogo, o uso da classe abstrata `Modo` é essencial. Os componentes do `Framework` fazem referências à métodos de `Modo` para pintarem a tela, realizarem o loop do jogo e tratarem os eventos decorrentes do teclado. Dessa forma, para 
reaproveitar o `Framework` em outros jogos, basta que esse estenda a classe `Modo` e implemente os métodos abstratos obrigatórios.
~~~java
public abstract class Modo {
	...
	public abstract void pintarTela(Graphics g);	
	public abstract void loop(); 	
	public abstract void keyTyped(KeyEvent e);
	public abstract void keyPressed(KeyEvent e);
	public abstract void keyReleased(KeyEvent e);
	
	}
~~~
### Comunicação entre componentes

Neste trecho, nota-se que os dois componentes `Motor` e `Jogo` são conectados através do uso de duas interfaces. Essa componetização dos elementos do código é importante para tornar as diferentes partes do código reutilizáveis.

~~~java
public class AppProjetoFinal {
	...
	IRJogo meuFramework = new Motor();
	...
	IJogo meuJogo = new MenuPrincipal();
	meuFramework.conecta(meuJogo);
	meuFramework.comecarJogo();
	...
}
~~~

### Pilha de Modos

Para orquestrar os diferentes `Modos` do jogo, o `Gerenciador de Modos` utiliza uma pilha. O uso dessa estrutura facilita, por exemplo, a troca entre fases do jogo. Cada fase é construída como um `Modo` de forma que a passagem de nível se caracteriza pela adição do novo modo na pilha. Como os métodos de `Gerenciador de Modos` fazem referência ao elemento que está no topo da pilha, o `loop` do jogo executado, por exemplo, é aquele pertencente ao contexto atual do jogo, ou seja, seu `Modo` atual. 

~~~java
public class GerenciadorModos implements IGerenciadorModos{
	private Stack<Modo> modos;

	public GerenciadorModos() {
		modos = new Stack<Modo>();
	}
	
	public void adicionarPilha(Modo novoModo) {
		modos.push(novoModo);
	}
	
	public void loop() throws ErroPilhaVazia{
		if(modos.empty()) {
			throw new ErroPilhaVazia("A pilha de modos está vazia!");
		}else {
			modos.peek().loop();
		}
		
	}
	
	public void pintarTela (Graphics g) throws ErroPilhaVazia{
		if(modos.empty()) {
			throw new ErroPilhaVazia("A pilha de modos está vazia!");
		}else {
			 modos.peek().pintarTela(g);
		}
		
	}
	
	public void keyTyped(KeyEvent e) {
		if(modos.empty()) {
			System.out.println("Atenção: a pilha está vazia.");
		}else {
			modos.peek().keyTyped(e);
		}
		
	}
	
	...
}
~~~

## Destaques do Pattern

### Pattern Factory

A fim de facilitar a instanciação de objetos do tipo `Agente`, decidiu-se utilizar o `pattern factory`. Criou-se, assim, uma classe chamada `FabricaAgente` que possui um único método: `retornaAgente()`. Esse método retorna um objeto específico do tipo `Agente` de acordo com os parâmetros passados. As classes que estendem `Comodo`, como `Quintal`, `Quarto`, `Sala` e `Cozinha`, requisitam seus `Agentes` através do método `carregarAgentes()` e os adiciona a células da matriz.

Assim, pode-se dizer que os `Comodos` são clientes de `FabricaAgente`.

#### Diagrama do Pattern

![FabricaAgente](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/FabricaAgente.png)

#### Código do Pattern

Em [`FabricaAgente.java`](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/src/agente/FabricaAgente.java)

~~~java

public Agente retornaAgente(String nomeAgente, int i, int j, int escala, int ciclos, Comodo meuComodo) {
	if(nomeAgente == null) {
		return null;
	}

	if(nomeAgente.equals("MACA")) {
		Image img = new ImageIcon(Carregador.Imagens.get(Carregador.MACA).getImage().getScaledInstance(escala,escala, 1)).getImage();
		Image img2 = new ImageIcon(Carregador.Imagens.get(Carregador.MACA_LAGARTA).getImage().getScaledInstance(2*escala,escala, 1)).getImage();
		return new VilaoDuploDinamico(i, j, meuComodo, ciclos, img, img2);

	}else if(nomeAgente.equals("ESTUDANTE")){
		Image img = new ImageIcon(Carregador.Imagens.get(Carregador.ESTUDANTE).getImage().getScaledInstance(escala,escala, 1)).getImage();
		Estudante aux = Estudante.getInstancia();
		aux.setParametros(i, j, meuComodo, img);
		return aux;

	}
		...
	}else{
		return null;
	}
~~~

Em [`Quintal.java`](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/src/jogo/Quintal.java) que estende a classe abstrata Comodo.java;

~~~java

public Quintal(){		
	fabricaAgente = new FabricaAgente();
	carregarImagens();
	carregarAgentes();
}

public void carregarAgentes() {	
	matrizCelulas[10][0].adicionaAgente(fabricaAgente.retornaAgente("CACHORRO",10, 0, delta, 20, this));
	matrizCelulas[8][3].adicionaAgente(fabricaAgente.retornaAgente("GATO",8, 3, delta, 30, this));
	...
}
~~~

### Pattern Singleton

O `Estudante` é a classe do jogo que gera um objeto que pode ser controlado pelo jogador. Para que o jogo funcione corretamente deve existir somente um `Estudante` no jogo. Assim, decidiu-se usar o `pattern singleton` na sua construção a fim de garantir tal condição.

#### Diagrama do Pattern

![EstudanteSingleton](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/EstudanteSingleton.png)

#### Código do Pattern 

Em [`Estudante.java`](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/src/agente/Estudante.java)

~~~java

private static Estudante instanciaEstudante = new Estudante();

	...

private Estudante() {
	super(0,0,'E', 0, null);
	tempo = 0;
}

public static Estudante getInstancia() {
	return instanciaEstudante;
}

	...
~~~
## Documentação dos Componentes

## Diagramas

### Diagrama Geral do Projeto

![ComponenteGeral](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/DiagramProjeto.png)

### Diagrama Geral de Componentes

![DiagramaComponente](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/ComponentesGeral.png)

### Componente Gerenciador de Modos

![ComponenteGerenciadorModo](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/GerenciadorModos.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | framework.GerenciadorModos
Autores | Hannah e Gabriel
Interfaces | IGerenciadorModos

#### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/InterfaceGerenciadorModo.png)

### Componente Gerenciador de Janela


![ComponenteGerenciadorJanela](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/GerenciadorJanela.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | framework.GerenciadorJanela
Autores | Hannah e Gabriel
Interfaces | IJanela

#### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/InterfaceJanela.png)


### Componente Motor


![ComponenteMotor](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/Motor.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | framework.Motor
Autores | Hannah e Gabriel
Interfaces | IRJogo

#### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/InterfaceRJogo.png)


### Componente Jogo

Implementa a dinâmica do jogo, sendo responsável pela execução das interações dos objetos do tipo `Agente` com o espaço celular. O jogo contém uma página de menu principal, uma página de regras, uma página de vitórias, uma página de GameOver e 4 cômodos (Quintal, Cozinha, Sala e Quarto).  

![ComponenteJogo](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/Jogo.png)

**Máquina de estados do Jogo**

![MaquinaEstados](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/MaquinaEstados.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | jogo.MenuPrincipal
Autores | Hannah e Gabriel
Interfaces | IJogo

#### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/InterfaceJogo.png)


### Componente Agente

Implementa o pattern factory. Esse componente é responsável por fornecer ao componente jogo objetos do tipo `Agente`:

* Estudante;
* Vilão;
* Parede;
* Objetivo.

![ComponenteAgente](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/Agente.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | agente.FabricaAgente
Autores | Hannah e Gabriel
Interfaces | IFabricaAgente

#### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/InterfaceFabrica.png)



### Detalhamento das Interfaces

#### Interface IFabricaAgente 

Permite o acesso aos elementos do tipo Agente através de um pattern factory.

~~~java
public interface IFabricaAgente {
	
	Agente retornaAgente(String nomeAgente, int i, int j, int escala, int velocidade, Comodo meuComodo);
}

~~~

Método | Objetivo
-------| --------
`retornaAgente` | Retorna um objeto do tipo `Agente` de acordo com as especificações. 

#### Interface IRJogo

Interface requerida que permite que o jogo seja executado.   

~~~java
public interface IRJogo {

	public void conecta(IJogo novoJogo);	
	public void comecarJogo();
	
}
~~~

Método | Objetivo
-------| --------
`conecta` | Conecta um jogo ao componente Framework.
`comecarJogo`| Executa os métodos necessários para começar o Jogo.


#### Interface IJogo

Interface provida que retorna um jogo do tipo `Modo` para o solicitante


~~~java
public interface IJogo {
	
	public Modo retornaJogo();

}
~~~

Método | Objetivo
-------| --------
`retornaJogo` | Retorna um modo de jogo. 

#### Interface IGerenciadorModos

Interface que provê acesso aos métodos de `GerenciadorModos`  

~~~java
public interface IGerenciadorModos {
	public void adicionarPilha(Modo novoModo);
	public void loop() throws ErroPilhaVazia;
	public void pintarTela (Graphics g) throws ErroPilhaVazia;
	public GerenciadorModos retornaGerenciadorModo();
	public void keyReleased(KeyEvent e);
	public void keyPressed(KeyEvent e);
	public void keyTyped(KeyEvent e);
}
~~~

Método | Objetivo
-------| --------
`adicionarPilha` | Adiciona um elemento do tipo `Modo` à pilha do `GerenciadorModos`. 
`loop` | Chama o método `loop` do `Modo` que está no topo da pilha.
`pintarTela` | Chama o método `pintarTela` do `Modo` que está no topo da pilha.
`retornaGerenciadorModo` | Retorna um `GerenciadorModos`
`keyReleased` | Chama o método `keyReleased` do `Modo` que está no topo da pilha.
`keyPressed` | Chama o método `keyPressed` do `Modo` que está no topo da pilha.
`keyTyped` | Chama o método `keyTyped` do `Modo` que está no topo da pilha.

#### Interface IJanela

Interface que permite operações com a janela gráfica do jogo.

~~~java
public interface IJanela {
	public void adicionarPainel();
	public void mostrarJanela();
	public void adicionarKeyListener() throws ErroAdicionarTeclado;
}
~~~

Método | Objetivo
-------| --------
`adicionarPainel` | Adiciona um painel à janela.
`mostrarJanela` | Torna a janela visível.
`adicionarKeyListener` | Adiciona um `KeyListener` à janela.

## Plano de Exceções

### Diagrama da hierarquia de exceções

![Hierarquia Exceções](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/Excecao.png)

### Descrição das classes de exceção


Classe | Descrição
----- | -----
ErroImagemNaoEncontrada | Indica que nenhuma imagem com o nome especificado foi encontrada no diretório dado.
ErroAdicionarTeclado | Indica que não foi possível adicionar um `Teclado` (KeyListener) à janela.
ErroPilhaVazia | Indica tentativa de acesso à uma posição de memória que não existe, pois a pilha de modos está vazia.

