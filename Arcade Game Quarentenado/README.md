# Quarentenado

## Project/Game Brief Description

After nearly a year and a half of online learning, we students know that one of the biggest challenges of remote study is staying focused. At first glance, it may seem simple, but attending classes at home presents numerous challenges, such as unexpected phone calls, pets needing attention, and seemingly endless piles of dishes.

With this in mind, we propose the game `Quarentenado`, where you must help a student reach their computer safely to attend a class. To do so, the student must navigate through different rooms in the house, avoiding distractions and tasks that appear along the way.

The student can move in four directions (up, down, left, and right) using the arrow keys or WASD keys.

The gameplay was inspired by the Arcade game Frogger.

## Creators 
* Hannah de Oliveira Plath
* Gabriel Silva Vieira de Melo

Special thanks to Gabriela Ferreira for creating the game art ([@gabimarart](https://www.instagram.com/gabimarart/)).

## Project Videos

### Preview Video
[Preview presentation video](https://drive.google.com/file/d/1SO7CH6iEJi1w_buz3tIoBtMbhdTDB4hw/view?usp=sharing)

### Game Video
[Game presentation video](https://drive.google.com/file/d/1Yxa2iak5I-0ffU7tIU1D7wqaRLqFhISJ/view?usp=sharing)

## Project Slides

### Preview Slides
[Preview slides presentation](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/assets/Previa%20Projeto.pdf)

### Final Presentation Slides
[Final Presentation](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/assets/Quarentenado%20-%20ApresentacaoFinal.pdf)

## Instructions to Play the Game

To run the game, follow these steps:

* Download the `ProjetoFinal` folder from this GitHub.
* Open the project in an IDE like Eclipse and run it by executing the file [`AppProjetoFinal.java`](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/src/AppProjetoFinal.java) located in the `src` directory.

## Project Evolution Report

Throughout the project, we found it necessary to adapt the initial architecture and make several modifications.

Initially, the plan was to display the different rooms (levels) on the screen as a house floor plan, showing all four rooms (yard, kitchen, living room, and bedroom) simultaneously. However, after testing, we realized that this layout made each room too small and cluttered. We decided to load one room at a time instead, only transitioning to the next screen when the player finishes a level.

Additionally, we developed a base structure for use in other game projects. Inspired by the `Chain of Responsibility` pattern, this structure captures events (Timer, KeyListener, PaintComponent) and delegates the appropriate actions to increasingly specialized objects, improving encapsulation.

For instance, the base structure is responsible for painting the game window, but the details of what should be painted are stored in each object on the screen. The component responsible for painting calls the `paintScreen()` method of the object directly below it in the hierarchy. If there are more objects requiring painting, the request is passed down the chain until all elements on the screen are painted.

These decisions led us to revise and modify the original architecture.

The relationships between the `Room`, `Agent`, and `Cell` classes were retained, as was the initial idea of using an abstract `Agent` class to represent different game elements like the student, apple, ball, etc. However, the other classes were replaced by three components: `Engine`, `ModeManager`, and `WindowManager`, which form the base structure or framework of the game.

Additionally, the original plan to have each game element (student, apple, etc.) extend the `Agent` class was discarded. Instead of creating 23 classes with similar functionality, we implemented ten movement patterns and passed specific parameters like speed and image to each object. We used the `factory pattern` to simplify object instantiation and provide flexibility in creating new movement patterns.

One of the main challenges was identifying architectural flaws early in the process. As we coded, we encountered issues that required restructuring the architecture. We continuously refined the design until we reached the final version.

It's worth noting that, in addition to the course materials, we consulted the book [Game Programming Patterns by Robert Nystrom](https://gameprogrammingpatterns.com/contents.html) to better understand the game development process.

## Final Game Architecture Proposal

This project was developed in two main stages: building a `Framework` for the game and creating the `Game` itself.

The `Framework` controls the game's `main loop`, handles keyboard events, and initializes the game window. However, it delegates decisions on how to respond to events (such as key presses) to the current game `Mode`. This allows the same `Framework` to be used in other games by simply changing the set of `Modes`.

The `Framework` manages the different `Modes` through a stack.

The `Framework` consists of three main components: `Engine`, `ModeManager`, and `WindowManager`.

The `Game` is a state machine composed of `Modes`, managed by the stack of the `ModeManager`. For instance, to switch levels, the current `Mode` requests the `ModeManager` to add the next level to the top of the stack. This approach simplifies the management of game phases and screens.


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

#### Diagrama do Pattern

![FabricaAgente](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/assets/FabricaAgente.png)

#### Código do Pattern

Em [`FabricaAgente.java`](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/src/agente/FabricaAgente.java)

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

Em [`Quintal.java`](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/src/jogo/Quintal.java) que estende a classe abstrata [`Comodo.java`](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/src/jogo/Comodo.java);

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

A fim de facilitar a instanciação de objetos do tipo `Agente`, decidiu-se utilizar o `pattern factory`. Criou-se, assim, uma classe chamada `FabricaAgente` que possui um único método: `retornaAgente()`. Esse método retorna um objeto específico do tipo `Agente` de acordo com os parâmetros passados. As classes que estendem `Comodo`, como `Quintal`, `Quarto`, `Sala` e `Cozinha`, requisitam seus `Agentes` através do método `carregarAgentes()` e os adiciona a células da matriz.

Assim, pode-se dizer que os `Comodos` são clientes de `FabricaAgente`.

A comunicação entre as duas classes, `FabricaAgente` e `Comodo`, é feita através do uso da interface `IFabricaAgente`.

### Pattern Singleton

#### Diagrama do Pattern

![EstudanteSingleton](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/assets/EstudanteSingleton.png)

#### Código do Pattern 

Em [`Estudante.java`](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/src/agente/Estudante.java)

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

O `Estudante` é a classe do jogo que gera um objeto que pode ser controlado pelo jogador. Para que o jogo funcione corretamente deve existir somente um `Estudante` no jogo. Assim, decidiu-se usar o `pattern singleton` na sua construção a fim de garantir tal condição.

A classe `FabricaAgente` não consegue instanciar diretamente um objeto do tipo `Estudante`, mas requisita à essa classe que retorne um objeto desse tipo através do método `getInstancia()`. A classe `Estudante`, por sua vez, sempre retorna a mesma instância, garantindo a existência de apenas um objeto desse tipo.

## Conclusão e Trabalhos Futuros

O planejamento e execução desse projeto permitiu uma aplicação prática de todos os conceitos aprendidos em aula, o que proporcionou uma melhor sedimentação desses e um entendimento mais profundo sobre seus usos. Em particular, a elaboração de uma boa arquitetura para o jogo se mostrou uma tarefa desafiadora, mas interessante e que proporcionou um maior entendimento sobre modelagem de softwares mais complexos. A divisão das partes do código em componentes se mostrou muito poderosa e foi possível perceber na prática o quanto essa técnica facilita a expansão do programa e sua manutenção.

Quanto a mudanças na arquiteura, a geração dos diferentes cômodos poderia ser feita através de um `pattern factory` similar ao que foi feito para `Agente`. Dessa forma, a expansão de níveis ficaria ainda mais fácil. Além disso, o tratamento de exceções poderia ser mais detalhado. 

Para o futuro é possível implementar elementos extras no jogo que podem proporcionar maior divertimento, como número de vidas, pontuação por quantidade de movimento e atribuição de selos por missões cumpridas. Além disso, poderiam ser desenvolvidos outros cômodos (níveis).


## Documentação dos Componentes

## Diagramas

### Diagrama Geral do Projeto

![ComponenteGeral](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/assets/DiagramProjeto.png)

### Diagrama Geral de Componentes

![DiagramaComponente](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/assets/ComponentesGeral.png)

### Componente Gerenciador de Modos

Implementa a pilha responsável por controlar os modos do jogo e os métodos que serão repassados para cada modo resolver no seu contexto específico. 

![ComponenteGerenciadorModo](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/assets/GerenciadorModos.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | framework.GerenciadorModos
Autores | Hannah e Gabriel
Interfaces | IGerenciadorModos

#### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/assets/InterfaceGerenciadorModo.png)

### Componente Gerenciador de Janela

Responsável por gerar um `JFrame` e um `JPanel` e manter as imagens do jogo atualizadas na tela. Além disso, o componente coleta as informações advindas do teclado. 

![ComponenteGerenciadorJanela](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/assets/GerenciadorJanela.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | framework.GerenciadorJanela
Autores | Hannah e Gabriel
Interfaces | IJanela

#### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/assets/InterfaceJanela.png)


### Componente Motor

Responsável pelo controle do loop principal e é o componente que inicializa o `GerenciadorModos` e o `GerenciadorJanela`.

![ComponenteMotor](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/assets/Motor.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | framework.Motor
Autores | Hannah e Gabriel
Interfaces | IRJogo

#### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/assets/InterfaceRJogo.png)


### Componente Jogo

Implementa a dinâmica do jogo, sendo responsável pela execução das interações dos objetos do tipo `Agente` com o espaço celular. O jogo contém uma página de menu principal, uma página de regras, uma página de vitórias, uma página de GameOver e 4 cômodos (Quintal, Cozinha, Sala e Quarto). Vale ressaltar que cada cômodo contém seus agentes.

![ComponenteJogo](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/assets/Jogo.png)

**Máquina de estados do Jogo**

![MaquinaEstados](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/assets/MaquinaEstados.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | jogo.MenuPrincipal
Autores | Hannah e Gabriel
Interfaces | IJogo

#### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/assets/InterfaceJogo.png)


### Componente Agente

Implementa o pattern factory. Esse componente é responsável por fornecer ao componente jogo objetos do tipo `Agente`:

* `Estudante`;
* `VilaoBateVolta`;
* `VilaoD`;
* `VilaoDuploDinamico`;
* `VilaoDuploEstatico`;
* `VilaoE`;
* `VilaoQ`;
* `VilaoTransparente`;
* `Parede`;
* `Objetivo`.

![ComponenteAgente](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/assets/Agente.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | agente.FabricaAgente
Autores | Hannah e Gabriel
Interfaces | IFabricaAgente

#### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/assets/InterfaceFabrica.png)

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
`Agente retornaAgente` | Retorna um objeto do tipo `Agente` de acordo com as especificações. 

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
`void conecta` | Conecta um jogo ao componente Framework.
`void comecarJogo`| Executa os métodos necessários para começar o Jogo.


#### Interface IJogo

Interface provida que retorna um jogo do tipo `Modo` para o solicitante


~~~java
public interface IJogo {
	
	public Modo retornaJogo();

}
~~~

Método | Objetivo
-------| --------
`Modo retornaJogo` | Retorna um modo de jogo. 

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
`void adicionarPilha` | Adiciona um elemento do tipo `Modo` à pilha do `GerenciadorModos`. 
`void loop` | Chama o método `loop` do `Modo` que está no topo da pilha.
`void pintarTela` | Chama o método `pintarTela` do `Modo` que está no topo da pilha.
`GerenciadorModos retornaGerenciadorModo` | Retorna um `GerenciadorModos`.
`void keyReleased` | Chama o método `keyReleased` do `Modo` que está no topo da pilha.
`void keyPressed` | Chama o método `keyPressed` do `Modo` que está no topo da pilha.
`void keyTyped` | Chama o método `keyTyped` do `Modo` que está no topo da pilha.

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
`void adicionarPainel` | Adiciona um painel à janela.
`void mostrarJanela` | Torna a janela visível.
`void adicionarKeyListener` | Adiciona um `KeyListener` à janela.

## Plano de Exceções

### Diagrama da hierarquia de exceções

![Hierarquia Exceções](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Arcade%20Game%20Quarentenado/assets/Excecao.png)

### Descrição das classes de exceção


Class | Description
----- | -----
ErroImagemNaoEncontrada | Indica que nenhuma imagem com o nome especificado foi encontrada no diretório dado.
ErroAdicionarTeclado | Indica que não foi possível adicionar um `Teclado` (KeyListener) à janela.
ErroPilhaVazia | Indica tentativa de acesso à uma posição de memória que não existe, pois a pilha de modos está vazia.

