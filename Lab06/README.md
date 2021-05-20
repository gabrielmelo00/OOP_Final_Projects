# Lab06 - O Mundo de Wumpus

## O Jogo

O Mundo de Wumpus é um jogo que consiste em uma caverna composta por 16 salas (4x4) que são conectadas entre si. O herói (personagem principal) deve desbravar essa caverna em busca do ouro. No entanto, nessa caverna há também um monstro chamado Wumpus que mata qualquer pessoa que entra na caverna. Para se proteger do Wumpus, o herói tem a sua disposição uma flecha para atacar o monstro. Na caverna, existem também buracos espalhados. Se o herói cair em uma delas, ele não consegue sair da caverna e perde o jogo.

## Objetivo

O objetivo do jogo é o héroi entrar na caverna, capturar o ouro e sair dela sem ser morto pelo Wumpus ou cair em um buraco.

## Elementos do Jogo

O jogo possui, então, os seguintes componentes:

* Caverna: composta por 16 salas conectadas dispostas como uma matriz 4x4;
* Herói: busca o ouro na caverna sem morrer;
* Wumpus: monstro que mata qualquer um que entrar na caverna;
* Buraco: um buraco que não permite que ninguém saia dele;
* Ouro: prêmio buscado pelo herói;
* Fedor*: odor emitido pelo monstro e mostrado nas células adjacentes a ele (exceto diagonais);
* Brisa*: vento emitido pelo buraco e mostrado nas células adjacentes a ele (exceto diagonais);

<sub>*Elementos secundários que ajudam na exploração da caverna visto que indicam onde podem estar o Wumpus e os buracos.<sub>

O herói possui uma única flecha para matar o Wumpus. A probabilidade de matar o monstro após atirar a flecha é de 50%.
	
## Pontuação
	
O herói começa o jogo com zero pontos.

A pontuação é, então, distribuída da seguinte forma:

* +1000 pontos - se o herói sai da caverna com o Ouro;
* -1000 pontos - se o herói cai no buraco ou é morto pelo Wumpus;
* -15 pontos - por cada movimento;
* -100 pontos - por usar a flecha;
* + 500 pontos - se o herói matar o Wumpus.
	
## Informações sobre o Jogo
	
* O herói sempre começa na célula (1,1);
* O Wumpus não se move pela caverna;
* O herói só toma conhecimento dos elementos dentro da sala após passar por ela;
* Para matar o Wumpus, o herói deve estar com a flecha equipada antes de entrar na sala com o monstro;
* Caso o herói equipe a flecha e se mova para uma sala sem  o monstro, ele perderá a flecha;
* O herói não pode sair da caverna sem o ouro;
* Matar o monstro é opcional.
* Existe uma hierarquia entre os elementos de uma sala. Apenas o elemento de maior hierarquia da sala será mostrado na tela para o usuário, mas podem existir outros elementos de menor hierarquia na sala. A ordem é: ouro = Wumpus = buraco > herói > brisa > fedor.
	
## Movimentos do Jogo
	
Os movimentos existentes no jogo são:
	
* w -> Herói movimenta para a sala acima;
* s -> Herói movimenta para a sala abaixo;
* d -> Herói movimenta para a sala a direita;
* a -> Herói movimenta para a sala a esquerda;
* k -> Herói equipa a flecha;
* c -> Herói captura o ouro;
* q -> O usuário sai do jogo.
	
## Arquivos Java do Jogo
	
### Como acionar o jogo
	
Para acionar o jogo você deve:
	
* Baixar a pasta Lab06 deste github.
* Executar o jogo tendo como entrada um vetor de Strings que contém na primeira posição o endereço para o arquivo de entrada "../Lab06/data/data.csv"
* Na pasta [data](\Lab06\data) existem outros arquivos de entrada intitulados de `caverna1` , `caverna2` e `caverna3`. Para trocar o arquivo de entrada (tabuleiro do jogo), basta alterar o caminho do arquivo para, por exemplo,  "../Lab06/data/caverna3.csv".
* Após executar o jogo, você deverá enserir um nome para o seu Player;
* Então basta começar a jogar!

Os arquivos de Java do jogo estão na seguinte pasta.

## Destaques de Arquitetura
### Polimorfismo
	
O trecho abaixo ilustra o uso de polimorfismo no laboratório. Os componentes do jogo (herói, wumpus, buraco, fedor, brisa) foram todos construídos como subclasses de uma classe maior chamada Componente. Assim, no Montador, utiliza-se desse polimorfismo para a criação dos componentes do jogo. 
	
Além disso, no trecho abaixo, nota-se que a classe Componente possui dois construtores (sobrecarga). No primeiro caso, somente o objeto Caverna é passado como parâmetro do construtor. Para a resolução desse laboratório, decidiu-se que a classe Componente teria uma instância estática do tipo Caverna, visto que todos as subclasses de Componente partilham da mesma caverna.

~~~java
  ...
  meusComponentes = new Componente(minhaCaverna);

  for(int x = 0;x < vetor_componentes.length;x++) {
    switch(vetor_componentes[x]) {
      case "B":
        meusComponentes = new Buraco(Integer.parseInt(vetor_i[x]),Integer.parseInt(vetor_j[x]));
        meusComponentes.conectaComponente();
        break;          
        ...
    }				
  }
~~~

## Modularização e Encapsulamento
						 
Abaixo, mostra-se algumas das instâncias e métodos da classe Herói. Essa classe possui instâncias e métodos que guardam informação sobre aspectos do jogo que são diretamente relacionados ao herói, contribuindo para a modularização e encapsulamento do código.

~~~java
public class Heroi extends Componente {
	
  private int flechas;
  private boolean equipada;
  private int ouro;
  private int pontuacao;
  private int wumpus;
  private boolean perdeu;
  
  ...
  
  public boolean capturaOuro() {..}
  public boolean equipaFlecha() {..}
  public boolean direita() {..}
  public void setWumpus() {..}
~~~

## Aspectos que Facilitam a Implementação de Novos Componentes no Jogo
						 
Em cada sala, os Componentes são armazenados em uma array ordenada de acordo com a hierarquia dos Componentes. Dessa forma, caso deseja-se inserir um novo tipo de Componente no jogo, basta inseri-lo dentro da hierarquia dos outros Componentes, não sendo alterar outras partes do código além dessa.

~~~java
public Sala() {
		meusComponentes = new ArrayList<Componente>();
		salaConhecida = false;
	}
 
 public boolean adicionaComponente(Componente c) {..}
 public boolean retiraComponente(Componente c) {..}
~~~

## Evitando Centralização de Papéis
	
A classe caverna tem como principal papel conectar os componentes com as salas. Dessa forma, ela não verifica se as ações requeridas pelo componente são possíveis ou não, mas apenas as passa para a Sala, onde essa verificação ocorrerá.

~~~java
public class Caverna {

  public void conectaSala(int x, int y, Componente c) {
    if(!matrizSala[x][y].adicionaComponente(c)) {
      System.out.println("Erro: caverna não pode adicionar componente");
    }
  }
  public void atiraFlecha(int x, int y) {
    matrizSala[x][y].atiraFlecha();
  }
}
~~~
