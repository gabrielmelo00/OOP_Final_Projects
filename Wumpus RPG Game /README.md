# Lab06 - The Wumpus World

## The Game

The Wumpus World is a game that takes place in a cave composed of 16 rooms (4x4) that are connected to each other. The hero (main character) must explore this cave in search of gold. However, there is also a monster called Wumpus in the cave that kills anyone who enters. To protect himself from the Wumpus, the hero has an arrow to attack the monster. Additionally, there are scattered pits in the cave. If the hero falls into one of them, he can't escape and loses the game.

## Objective

The goal of the game is for the hero to enter the cave, capture the gold, and exit without being killed by the Wumpus or falling into a pit.

## Game Elements

The game has the following components:

* Cave: composed of 16 interconnected rooms arranged in a 4x4 matrix;
* Hero: seeks the gold in the cave without dying;
* Wumpus: monster that kills anyone who enters the cave;
* Pit: a hole from which no one can escape;
* Gold: the prize the hero seeks;
* Stench*: odor emitted by the monster and shown in the adjacent cells (except diagonals);
* Breeze*: wind emitted by the pit and shown in the adjacent cells (except diagonals);

<sub>*Secondary elements that help explore the cave by indicating where the Wumpus and pits might be.<sub>

The hero has a single arrow to kill the Wumpus. The probability of killing the monster after shooting the arrow is 50%.
	
## Scoring
	
The hero starts the game with zero points.

The score is distributed as follows:

* +1000 points - if the hero exits the cave with the gold;
* -1000 points - if the hero falls into a pit or is killed by the Wumpus;
* -15 points - for each move;
* -100 points - for using the arrow;
* +500 points - if the hero kills the Wumpus.
	
## Game Information
	
* The hero always starts at cell (1,1);
* The Wumpus does not move within the cave;
* The hero only becomes aware of the elements inside a room after passing through it;
* To kill the Wumpus, the hero must have the arrow equipped before entering the room with the monster;
* If the hero equips the arrow and moves to a room without the monster, he will lose the arrow;
* The hero cannot leave the cave without the gold;
* Killing the monster is optional.
* There is a hierarchy among the elements in a room. Only the element of the highest hierarchy will be shown to the user, but other lower hierarchy elements may exist in the room. The order is: gold = Wumpus = pit > hero > breeze > stench.
	
## Game Movements
	
The game movements are:
	
* w -> Hero moves to the room above;
* s -> Hero moves to the room below;
* d -> Hero moves to the room to the right;
* a -> Hero moves to the room to the left;
* k -> Hero equips the arrow;
* c -> Hero captures the gold;
* q -> The user exits the game.
	
## Java Game Files
	
### How to Run the Game
	
To run the game, you should:
	
* Download the Lab06 folder from this GitHub.
* Run the game with an input string array, where the first position contains the path to the input file "../Lab06/data/data.csv".
* In the [data folder](https://github.com/gabrielmelo00/OOP_Final_Projects/tree/master/Wumpus%20RPG%20Game%20/data), there are other input files named `caverna1`, `caverna2`, and `caverna3`. To change the input file (game board), just change the file path to, for example, "../Lab06/data/caverna3.csv".
* After running the game, you will need to enter a name for your Player;
* Then, simply start playing!

The Java files for the game are in the following folder.

## Architecture Highlights
### Polymorphism
	
The snippet below illustrates the use of polymorphism in the lab. The game components (hero, wumpus, pit, stench, breeze) were all created as subclasses of a larger class called `Componente`. Thus, in the `Montador`, polymorphism is used to create the game components.

Additionally, in the snippet below, it can be seen that the `Componente` class has two constructors (overloading). In the first case, only the `Caverna` object is passed as a constructor parameter. For the resolution of this lab, it was decided that the `Componente` class would have a static instance of type `Caverna`, as all `Componente` subclasses share the same cave.

~~~java
  ...
  meusComponentes = new Componente(minhaCaverna);

  for(int x = 0; x < vetor_componentes.length; x++) {
    switch(vetor_componentes[x]) {
      case "B":
        meusComponentes = new Buraco(Integer.parseInt(vetor_i[x]), Integer.parseInt(vetor_j[x]));
        meusComponentes.conectaComponente();
        break;          
        ...
    }				
  }
~~~

## Modularization and Encapsulation
						 
Below are some instances and methods of the `Herói` class. This class contains instances and methods that store information about game aspects directly related to the hero, contributing to the modularization and encapsulation of the code.

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

## Facilitating the Implementation of New Game Components
						 
In each room, the components are stored in an array ordered according to the hierarchy of the components. Thus, if a new type of component is to be added to the game, it can simply be inserted within the hierarchy of the other components, without needing to modify other parts of the code beyond this.

~~~java
public Sala() {
	meusComponentes = new ArrayList<Componente>();
	salaConhecida = false;
}
 
public boolean adicionaComponente(Componente c) {..}
public boolean retiraComponente(Componente c) {..}
~~~

## Avoiding Centralization of Roles
	
The `Caverna` class mainly connects components with rooms. Therefore, it does not verify if the requested actions by the component are possible or not, but simply passes them to the `Sala`, where the verification occurs.

~~~java
public class Caverna {

  public void conectaSala(int x, int y, Componente c) {
    if (!matrizSala[x][y].adicionaComponente(c)) {
      System.out.println("Error: cave cannot add component");
    }
  }
  public void atiraFlecha(int x, int y) {
    matrizSala[x][y].atiraFlecha();
  }
}
~~~
