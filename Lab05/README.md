# Lab05 A and B - Checkers Game

## Objective

The objective of this lab is to write a set of classes that represent a simplified checkers game.

This task was solved in two distinct ways:

* `A` - without using the concepts of inheritance and polymorphism;
* `B` - using the concepts of inheritance and polymorphism.

## Board

The game board was represented as follows:

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

The pieces are represented as follows: black pawn - `p`, white pawn - `b`, black queen - `P`, and white queen - `B`.
Spaces not occupied by any piece are represented as `-`.

## Input

The program's input will be a `.csv` file containing all the commands to be executed in the game. Each command will consist of an initial position and a final position, separated by `:`. For example, `e3:f4` represents a command where the piece moves from position `e3` to position `f4`.

## Output

### Lab A

The program has two outputs:

* `standard output` - prints the initial and final position of the piece as well as the board state after the move;
  * if the move is invalid, the current board state (unchanged from the previous state) is printed.
* `vector of strings` - contains all the board states during the game.

### Lab B

The program has two outputs:

* `standard output` - prints the initial and final position of the piece as well as the board state after the move. If the move executed is invalid, the program will return the message `Invalid Move!`;
* `csv file` - contains the final board state, represented as `square number + piece/empty`, following the `columns-rows` order. If the executed move is invalid, the `.csv` file will contain the message `error!`.
  * Example: `a1b` - square a1 contains a white pawn, `a2P` - square a2 contains a black queen, `a3_` - square a3 is empty.

## Classes

### Lab A

* `CSVReader` - reads the input csv;
* `Tabuleiro` - creates a board object, executes moves and piece removals, and returns a string containing its state;
* `Peao` - responsible for validating pawn moves and checking if the move was a forward or an attack;
* `Dama` - responsible for validating queen moves and checking if the move was a forward or an attack;
* `AppDama` - runs the game.

### Lab B

* `CSVHandling` - reads the input csv and writes the output csv;
* `Tabuleiro` - creates a board object, executes moves and piece removals, and returns a string containing its state;
* `Peça` (superclass) - checks if the move is possible within the rules of checkers;
  * `Peao` - responsible for validating pawn moves and checking if the move was a forward or an attack;
  * `Dama` - responsible for validating queen moves and checking if the move was a forward or an attack;
* `AppDama` - runs the game.

## Game Rules

The checkers game developed in this lab is simplified.

The following is checked:

* Whether the move is diagonal;
* Whether the number of squares moved is compatible with the piece and the move (attack or forward);
* Whether the target square is valid. That is, within the board limits and vacant;
* Whether the direction of the move is correct (pawns cannot move backward);
* Whether the attack is being made against an opponent's piece.

The following is NOT checked:

* Whether the player moves their piece during their turn;
* The obligation to attack a piece when there is an opportunity.

## Instructions to Run the Game

To run the game, you should:

* Download the Lab05 folder from this GitHub.
* Modify the [data.csv](https://github.com/HannahPlath/MC322/blob/main/Lab05/data/data.csv) file with your move sequence.
* Delete the [out.csv](https://github.com/HannahPlath/MC322/blob/main/Lab05/data/out.csv) file. Otherwise, the outputs of different games will be concatenated in the file.
* Run the game, providing as input a vector of strings that contains the first position with the input file path `"../Lab05/data/data.csv"` and the second position with the output file path `"../Lab04/data/out.csv"`.




