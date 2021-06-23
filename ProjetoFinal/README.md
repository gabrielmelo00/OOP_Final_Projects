# Projeto Final MC322

## Descrição Resumida do Projeto/Jogo

Há quase um ano e meio no EAD, nós estudantes sabemos que um dos maiores desafios do estudo remoto é se manter focado. Na superfície, isso pode parecer uma tarefa fácil, mas assistir aulas em casa é uma tarefa que apresenta vários desafios, como telefonemas inesperados, animais que demandam atenção e pilhas de louça que parecem nunca ter fim.

Com isso em mente, propomos um jogo em que você deve ajudar um estudante a chegar são e salvo no seu computador para assistir uma aula. Para isso ele deve atravessar diferentes cômodos da casa, desviando das distrações e obrigações que aparecem pelo caminho.
	
A dinâmica do jogo foi inspirado no jogo de Arcade, Frogger. 

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

## Documentação dos Componentes

## Diagramas

### Diagrama Geral do Projeto

O desenvolvimento deste projeto pode ser divido em duas frentes principais: a construção de um framework para o jogo e a elaboração do jogo em si.

A construção de qualquer jogo exige a elaboração de uma estrutura externa à lógica do jogo que é responsável por gerir 

estrutra externa à lógica do jogo

a gente queria desenvolver um framework que não especifico para esse jogo/generalista

Para construir um jogo é necessário um framework. Já que teriamos que construir um framework, a ideia foi transformar ele em um componente, de forma que outros jogos poderiam ser desenvolvidos através dele. Assim, teve-se a ideia de basear a arquitetura do nosso jogo em um esquema do tipo:

FRAMEWORK -> requisita comandos -> Modo -> matriz celulas/celulas -> agente 

Por exemplo, o framework precisa saber o que desenhar na tela. No decorrer da cadeia de objetos, cada um deles se desenha. Entende-se que isso contribui para o encapsulamento do código: cada objeto é responsável por tudo aquilo referente a ele msm.

(dar exemplo talvez do loop de jogo tmb)
(desenhos?)

Ideia da pilha: a nossa forma de alternar as telas do jogo.

Utilizar um componente Jogo para se conectar com o componente framework. Basta que ele tenha objetos/classes que estendam modo.

![ComponenteGeral](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/diagramaProjeto.png)

### Diagrama Geral de Componentes

![DiagramaComponente](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/diagrama_compontens_geral.png)

### Componente Framework

Encapsula os comandos referentes à escrita na tela, leitura do teclado e comandos ligados ao `timer`. Com isso, ele encaminha esses comandos para as classes responsáveis pela execução da ação.

![ComponenteFramework](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/framework.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | jogo.Motor
Autores | Hannah e Gabriel
Interfaces | IRJogo

#### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/InterfaceFramework.png)


### Componente Jogo

Implementa a dinâmica do jogo, sendo responsável pela execução das interações dos objetos do tipo `Agente` com o espaço celular.

![ComponenteJogo](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/jogo.png)

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

![Componente](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/agente.png)

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


## Plano de Exceções

### Diagrama da hierarquia de exceções

![Hierarquia Exceções](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/diagramaExcessao.png)

### Descrição das classes de exceção


Classe | Descrição
----- | -----
ErroImagem | Engloba todas as exceções referentes à escrita e leitura de imagens no jogo
ImagemNaoEncontrada | Indica que nenhuma imagem com o nome especificado foi encontrada no diretório dado.
PosicaoInvalidaVetorImagem | Indica que o vetor de imagem não possui uma posição correspondente à que foi requisitada pelo código.

