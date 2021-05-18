EM EDIÇÂO

# Trecho 1

5. Explore ao máximo o polimorfismo.

Decisão de arquitetura: usar caverna como uma variável estática de componente

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

# Trecho 2

3. Delegue o máximo possível a cada objeto coisas que lhe dizem respeito, por exemplo, cabe ao
objeto Herói saber quantas flechas ele tem e se há flechas disponíveis para disparar.

4. Explore ao máximo o encapsulamento e evite tarefas que o subvertem.

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

# Trecho 3

6. Evolua a arquitetura inicial de tal modo que ela seja fácil..

~~~java
public Sala() {
		meusComponentes = new ArrayList<Componente>();
		salaConhecida = false;
	}
 
 public boolean adicionaComponente(Componente c) {..}
 public boolean retiraComponente(Componente c) {..}
~~~

# Trecho 4

2. A distribuição da lógica do jogo pelas várias classes: tentem distribuir ao máximo as tarefas entre
as classes e evitem centralização de papéis.

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
