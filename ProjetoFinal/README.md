# Projeto Final MC322

## Descrição Resumida do Projeto/Jogo

Há quase um ano e meio no EAD, nós estudantes sabemos que um dos maiores desafios do estudo remoto é se manter focado. Na superfície, isso pode parecer uma tarefa fácil, mas assistir aulas em casa é uma tarefa que apresenta vários desafios, como telefonemas inesperados, animais que demandam atenção e pilhas de louça que parecem nunca ter fim.

Com isso em mente, propomos um jogo em que você deve ajudar um estudante a chegar são e salvo no seu computador para assistir uma aula. Para isso ele deve atravessar diferentes cômodos da casa, desviando das distrações e obrigações que aparecem pelo caminho.
	
A dinâmica do jogo foi inspirado no jogo de Arcade, Frogger. 

## Equipe
* Hannah de Oliveira Plath - 198642
* Gabriel Silva Vieira de Melo - 216474

## Vídeos do Projeto

### Vídeo da Prévia
[Apresentação em vídeo da prévia do projeto](https://drive.google.com/file/d/1SO7CH6iEJi1w_buz3tIoBtMbhdTDB4hw/view?usp=sharing)

## Slides do Projeto

### Slides da Prévia
[Apresentação de slides da prévia do projeto](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/Previa%20Projeto.pdf)

## Documentação dos Componentes

## Diagramas

### Diagrama Geral do Projeto

### Diagrama Geral de Componentes

![DiagramaComponente](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/diagrama_compontens_geral.png)

### Componente Framework


![ComponenteFramework](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/framework.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | `<nome dos membros que criaram o componente>`
Interfaces | `<listagem das interfaces do componente>`

#### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/InterfaceFramework.png)

Interface agregadora do componente em Java:

~~~java
public interface IDataSet extends ITableProducer, IDataSetProperties {
}
~~~

### Componente Jogo

> <Resumo do papel do componente e serviços que ele oferece.>

![ComponenteJogo](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/jogo.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | `<nome dos membros que criaram o componente>`
Interfaces | `<listagem das interfaces do componente>`

#### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/InterfaceJogo.png)

Interface agregadora do componente em Java:

~~~java
public interface IDataSet extends ITableProducer, IDataSetProperties {
}
~~~

### Componente Agente

> <Resumo do papel do componente e serviços que ele oferece.>

![Componente](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/agente.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `<caminho completo da classe com pacotes>` <br> Exemplo: `pt.c08componentes.s20catalog.s10ds.DataSetComponent`
Autores | `<nome dos membros que criaram o componente>`
Interfaces | `<listagem das interfaces do componente>`

#### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](https://github.com/gabrielmelo00/TrabalhosMC/blob/master/ProjetoFinal/assets/InterfaceAgente.png)

Interface agregadora do componente em Java:

~~~java
public interface IDataSet extends ITableProducer, IDataSetProperties {
}
~~~


### Detalhamento das Interfaces

#### Interface `<nome da interface>`

`<Resumo do papel da interface.>`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Exemplo:

#### Interface `ITableProducer`

Interface provida por qualquer fonte de dados que os forneça na forma de uma tabela.

~~~java
public interface ITableProducer {
  String[] requestAttributes();
  String[][] requestInstances();
}
~~~

Método | Objetivo
-------| --------
`requestAttributes` | Retorna um vetor com o nome de todos os atributos (colunas) da tabela.
`requestInstances` | Retorna uma matriz em que cada linha representa uma instância e cada coluna o valor do respectivo atributo (a ordem dos atributos é a mesma daquela fornecida por `requestAttributes`.

#### Interface `IDataSetProperties`

Define o recurso (usualmente o caminho para um arquivo em disco) que é a fonte de dados.

~~~java
public interface IDataSetProperties {
  public String getDataSource();
  public void setDataSource(String dataSource);
}
~~~

Método | Objetivo
-------| --------
`getDataSource` | Retorna o caminho da fonte de dados.
`setDataSource` | Define o caminho da fonte de dados, informado através do parâmetro `dataSource`.

## Plano de Exceções

### Diagrama da hierarquia de exceções
`<Elabore um diagrama com a hierarquia de exceções como detalhado abaixo>`

![Hierarquia Exceções](exception-hierarchy.png)

### Descrição das classes de exceção

`<Monte uma tabela descritiva seguindo o exemplo>:`

Classe | Descrição
----- | -----
DivisaoInvalida | Engloba todas as exceções de divisões não aceitas.
DivisaoInutil | Indica que a divisão por 1 é inútil.
DivisaoNaoInteira | Indica uma divisão não inteira.
