# Lab05 A e B - Jogo de Damas

## Objetivo

O objetivo deste laboratório é escrever um conjunto de classes que representam um jogo de damas (simplificado).

A resolução dessa tarefa foi feita de duas formas distintas: 

* `A` - não usando os conceitos de hierarquização e polimorfismo;
* `B` - usando os conceitos de hierarquização e polimorfismo.

## Tabuleiro

O tabuleiro do jogo foi representado da seguinte forma:

~~~
  8 - p - p - p - p
  7 p - p - p - p -
  6 - p - p - p - p
  5 - - - - - - - -
  4 - - - - - - - -
  3 b - b - b - b -
  2 - b - b - b - b
  1 b - b - b - b -
    a b c d e f g h 
~~~
    
As peças por sua vez são representadas como: peão preto - `p`, peão branco - `b`, dama preta `P` e dama branca `B`.
Os espaços que não estão ocupados por nenhuma peça são representados como `-`.

## Entrada

A entrada do programa será um arquivo `.csv` contendo todos os comandos a serem executados pelo jogo. Cada comando consistirá de uma posição inicial e uma posição final, separadas por `:`. Assim, `f4:d4` representa um comando em que a peça sai da casa `f4` e vai até a casa `d4`.

## Saída

### Lab A

O programa contém duas saídas:

* `saída padrão` - imprime a posição inicial e final da peça assim como o estado do tabuleiro após o movimento;
* `vetor de strings` - contém todos os estados do tabuleiro durante o jogo.

### Lab B

O programa contém duas saídas:

* `saída padrão` - imprime a posição inicial e final da peça assim como o estado do tabuleiro após o movimento. Caso o movimento executado tenha sido inválido, o programa retornará a mensagem `Movimento Inválido!`;
* `arquivo csv` - contém o estado final do tabuleiro, representado como `número da casa + peça/vazio`, seguindo a ordem `colunas-linhas`. Caso o movimento executado tenha sido inválido, o arquivo .csv conterá a mensagem `erro!`.
  * Exemplo: `a1b` - casa a1 contém um peão branco, `a2P` - casa a2 contém uma dama preta, `a3_` - casa a3 está vazia.
## Classes

### Lab A

* `CSVReader` - realiza a leitura do csv de entrada;
* `Tabuleiro` - gera um objeto tabuleiro, executa movimentos e retiradas de peças e retorna uma String contendo seu estado;
* `Peao` - responsável pela validação dos movimentos do peão e verifica se o movimento foi um avanço ou um ataque;
* `Dama` - responsável pela validação dos movimentos da dama e verifica se o movimento foi um avanço ou um ataque;
* `AppDama` - executa o jogo.

### Lab B

* `CSVHandling` - realiza a leitura e a escrita dos csv de entrada e saída, respectivamente;
* `Tabuleiro` - gera um objeto tabuleiro, executa movimentos e retiradas de peças e retorna uma String contendo seu estado;
* `Peça`(superclasse) - verifica se o movimento é possível de ser realizado dentro de um jogo de damas;
  * `Peao` - responsável pela validação dos movimentos do peão e verifica se o movimento foi um avanço ou um ataque;
  * `Dama` - responsável pela validação dos movimentos da dama e verifica se o movimento foi um avanço ou um ataque;
* `AppDama` - executa o jogo.

## Regras do Jogo

O jogo de damas desenvolvido neste laboratório está simplificado.

Verifica-se:

* Se o movimento é na diagonal;
* Se o número de casas percorridas é compatível com a peça e com a jogada (ataque ou avanço);
* Se a casa alvo é válida. Ou seja, está dentro dos limites do tabuleiro e está vaga;
* Se o sentido do movimento é correto (peão não pode andar para trás);
* Se o ataque está sendo feito em relação à uma peça adversária.

NÃO verifica-se:

* Se o jogador movimenta sua peça no seu turno;
* A obrigatoriedade de se atacar uma peça quando existe a oportunidade.

## Instruções para Acionar o Jogo

Para acionar o jogo você deve:

* Baixar a pasta Lab05 deste github.
* Alterar o documento [data.csv](https://github.com/HannahPlath/MC322/blob/main/Lab05//data/data.csv) com a sua sequência de jogadas.
* Apagar o arquivo [out.csv](https://github.com/HannahPlath/MC322/blob/main/Lab05//data/out.csv). Caso contrário, as saídas dos diferentes jogos serão concatenadas dentro do arquivo.
* Executar o jogo tendo como entrada um vetor de Strings que contém na primeira posição o endereço para o arquivo de entrada `"../Lab05/data/data.csv"` e na segunda posição o enderelo para o arquivo de saída "../Lab04/data/out.csv"



