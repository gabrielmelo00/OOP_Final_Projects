# Quarentenado

## Descrição Resumida do Projeto/Jogo

Há quase um ano e meio no EAD, nós estudantes sabemos que um dos maiores desafios do estudo remoto é se manter focado. Na superfície, isso pode parecer uma tarefa fácil, mas assistir aulas em casa é uma tarefa que apresenta vários desafios, como telefonemas inesperados, animais que demandam atenção e pilhas de louça que parecem nunca ter fim.

Com isso em mente, propomos o jogo `Quarentenado` em que você deve ajudar um estudante a chegar são e salvo no seu computador para assistir uma aula. Para isso ele deve atravessar diferentes cômodos da casa, desviando das distrações e obrigações que aparecem pelo caminho.

O estudante pode se mover nas quatro direções (cima, baixo, direita e esquerda) através das setas do teclado ou das teclas WASD.
	
A dinâmica do jogo foi inspirado no jogo de Arcade, Frogger. 

## Equipe Fazendo Eletiva em Computação
* Hannah de Oliveira Plath - 198642
* Gabriel Silva Vieira de Melo - 216474

Agradecimento à Gabriela Ferreira por ter feito a arte do jogo ([@gabimarart](https://www.instagram.com/gabimarart/)).

## Vídeos do Projeto

### Vídeo da Prévia
[Apresentação em vídeo da prévia do projeto](https://drive.google.com/file/d/1SO7CH6iEJi1w_buz3tIoBtMbhdTDB4hw/view?usp=sharing)

### Vídeo do Jogo
[Apresentação em vídeo do jogo](https://drive.google.com/file/d/1Yxa2iak5I-0ffU7tIU1D7wqaRLqFhISJ/view?usp=sharing)

## Slides do Projeto

### Slides da Prévia
[Apresentação de slides da prévia do projeto](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/Previa%20Projeto.pdf)

### Slides da Apresentação Final
[Apresentação Final](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/Quarentenado%20-%20ApresentacaoFinal.pdf)

## Procedimento para Jogar o Jogo

Para acionar o jogo você deve:

* Baixar a pasta ProjetoFinal deste github.
* Abrir em um ambiente eclipse ou similar e executar o projeto. Isto é, executar o arquivo [`AppProjetoFinal.java`](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/src/AppProjetoFinal.java) presente na pastar `src` deste diretório.

## Relatório de Evolução

Ao longo do projeto, foram surgindo necessidades de adaptação da arquitetura inicial proposta e várias modificações foram feitas.

Primeiramente, decidiu-se mudar a forma como os diferentes cômodos (níveis) seriam apresentados na tela. A ideia inicial era de simular a planta de uma casa, colocando os quatro cômodos (quintal, cozinha, sala e quarto) ao mesmo tempo na tela. Após testes, no entanto, percebeu-se que, com tal disposição, a área de tela de cada cômodo ficava pequena e o jogo poluído visualmente. Assim, decidiu-se carregar uma tela para cada cômodo. Isto é, somente quando o jogador passasse do primeiro nível a tela do segundo seria carregada.

Além disso, o grupo decidiu construir uma estrutura base que pudesse ser utilizada para o desenvolvimento de outros jogos. A ideia foi inspirada no pattern `Chain of Responsability`, em que um objeto repassa uma tarefa para um outro de hierarquia inferior à sua caso não consiga por si só resolver o problema. Analogamente, a estrutra base do jogo capta eventos (Timer, KeyListener, PaintComponent) e delega a ação a ser tomada a partir deles para objetos cada vez mais especializados, de forma a otimizar o encapsulamento. 

Por exemplo, a estrutura base deve pintar a janela do jogo. No entanto, a informação do que deve ser pintado está contida dentro de cada objeto que está na tela. Assim, o componente responsável por pintar a janela chama o método `pintarTela()` de um objeto imediatamente inferior à ele e esse, caso possua objetos hierarquicamente inferiores à ele que demandam pintura, repassa o pedido para eles e assim sucessivamente até que todos os elementos presentes na tela tenham se pintado.

Essas duas decisões levaram o grupo a reavaliar a arquitetura inicialmente proposta, modificando-a. 

As relações entre as classes `Comodo`, `Agente` e `Celula` foram mantidas assim como a ideia inicial de que a classe `Agente` seria uma classe abstrata a ser usada para a geração de diferentes elementos do jogo, como estudante, maça, bola etc. As outras classes, no entanto, foram substituidas por três componentes: `Motor`, `GerenciadorModos` e `GerenciadorJanela`, que compõem a chamada `estrutura base` ou `framework` do jogo.

Além disso, a ideia inicial apresentada de cada elemento do jogo (estudante, maça etc) estender `Agente` foi abandonada. Isto pois, tal abordagem levaria à criação de 23 classes com grandes similaridades. Decidiu-se, então, criar dez classes que descrevessem os dez padrões de movimento adotados no jogo e passar como parâmetros informações específicas para a criação de cada objeto como velocidade, imagem, etc. Também decidiu-se usar o `pattern factory` nesse caso para facilitar a instanciação desses elementos bem como a flexibilidade da criação de novos padrões de movimento.

A maior dificuldade encontrada foi visualizar os entraves que a nossa arquitetura proposta possuia antes de começar a programar. Durante a elaboração do código, foram encontradas falhas na arquitetura que demandavam uma reestruturação dessa. Assim, foi necessário repensar a arquitetura ao longo do projeto até chegarmos na versão final.

Vale ressaltar que, além dos materiais disponibilizados durante a disciplina, também foi consultado o seguinte material a fim de se compreender melhor as etapas necessárias para o desenvolvimento de um jogo: [Game Programming Patterns, Robert Nystrom](https://gameprogrammingpatterns.com/contents.html).

## Proposta Final da Arquitetura do Jogo

O desenvolvimento deste projeto pode ser divido em duas frentes principais: a construção de um `Framework` para o jogo e a elaboração do `Jogo` em si.

O `Framework` é responsável pelo controle do `loop principal` de jogo e dos eventos desencadeados pelo teclado assim como pela inicialização da janela do jogo. As ações que devem ser realizadas a partir da ocorrência de cada um desses eventos, no entanto, não são de responsabilidade do `Framework`. Ele delega essas decisões para o contexto apropriado de cada momento ou o `Modo` atual do jogo. Dessa forma, o evento desencadeado pelo pressionamento de uma tecla, por exemplo, varia de acordo com o `Modo` atual do jogo. Tal característica permite que o `Framework` possa ser usado no desenvolvimento de outros jogos e não somente desse, basta trocar o conjunto de `Modos` do jogo.

O `Framework` orquestra os diferentes `Modos` através de uma pilha.

O `Framework` criado é composto por três componentes: Motor, Gerenciador de Janela e Gerenciador de Modos.

Por sua vez, o `Jogo` consiste em uma máquina de estados de `Modos` que será gerenciada pela pilha do Gerenciador de Modos. Assim, por exemplo, para trocar de nível, basta que o `Modo` que implementa o nível atual requisite ao Gerenciador de Modos que coloque o próximo nível no topo da pilha. Essa dinâmica trouxe facilidade para o encadeamento de fases e telas do jogo desenvolvido.


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

Em [`Quintal.java`](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/src/jogo/Quintal.java) que estende a classe abstrata [`Comodo.java`](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/src/jogo/Comodo.java);

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

O `Estudante` é a classe do jogo que gera um objeto que pode ser controlado pelo jogador. Para que o jogo funcione corretamente deve existir somente um `Estudante` no jogo. Assim, decidiu-se usar o `pattern singleton` na sua construção a fim de garantir tal condição.

A classe `FabricaAgente` não consegue instanciar diretamente um objeto do tipo `Estudante`, mas requisita à essa classe que retorne um objeto desse tipo através do método `getInstancia()`. A classe `Estudante`, por sua vez, sempre retorna a mesma instância, garantindo a existência de apenas um objeto desse tipo.

## Conclusão e Trabalhos Futuros

O planejamento e execução desse projeto permitiu uma aplicação prática de todos os conceitos aprendidos em aula, o que proporcionou uma melhor sedimentação desses e um entendimento mais profundo sobre seus usos. Em particular, a elaboração de uma boa arquitetura para o jogo se mostrou uma tarefa desafiadora, mas interessante e que proporcionou um maior entendimento sobre modelagem de softwares mais complexos. A divisão das partes do código em componentes se mostrou muito poderosa e foi possível perceber na prática o quanto essa técnica facilita a expansão do programa e sua manutenção.

Quanto a mudanças na arquiteura, a geração dos diferentes cômodos poderia ser feita através de um `pattern factory` similar ao que foi feito para `Agente`. Dessa forma, a expansão de níveis ficaria ainda mais fácil. Além disso, o tratamento de exceções poderia ser mais detalhado. 

Para o futuro é possível implementar elementos extras no jogo que podem proporcionar maior divertimento, como número de vidas, pontuação por quantidade de movimento e atribuição de selos por missões cumpridas. Além disso, poderiam ser desenvolvidos outros cômodos (níveis).


## Documentação dos Componentes

## Diagramas

### Diagrama Geral do Projeto

![ComponenteGeral](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/DiagramProjeto.png)

### Diagrama Geral de Componentes

![DiagramaComponente](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/ComponentesGeral.png)

### Componente Gerenciador de Modos

Implementa a pilha responsável por controlar os modos do jogo e os métodos que serão repassados para cada modo resolver no seu contexto específico. 

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

Responsável por gerar um `JFrame` e um `JPanel` e manter as imagens do jogo atualizadas na tela. Além disso, o componente coleta as informações advindas do teclado. 

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

Responsável pelo controle do loop principal e é o componente que inicializa o `GerenciadorModos` e o `GerenciadorJanela`.

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

Implementa a dinâmica do jogo, sendo responsável pela execução das interações dos objetos do tipo `Agente` com o espaço celular. O jogo contém uma página de menu principal, uma página de regras, uma página de vitórias, uma página de GameOver e 4 cômodos (Quintal, Cozinha, Sala e Quarto). Vale ressaltar que cada cômodo contém seus agentes.

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

![Hierarquia Exceções](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/Excecao.png)

### Descrição das classes de exceção


Classe | Descrição
----- | -----
ErroImagemNaoEncontrada | Indica que nenhuma imagem com o nome especificado foi encontrada no diretório dado.
ErroAdicionarTeclado | Indica que não foi possível adicionar um `Teclado` (KeyListener) à janela.
ErroPilhaVazia | Indica tentativa de acesso à uma posição de memória que não existe, pois a pilha de modos está vazia.

