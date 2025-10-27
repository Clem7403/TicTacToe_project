TicTacToe – Version 1.0

Description

TicTacToe is a two-player game played on a 3x3 grid. Players take turns placing their symbol (X or O) on the grid. 
The goal is to align three symbols horizontally, vertically, or diagonally before the opponent. 
If all cells are filled without a winner, the game ends in a draw.

This project is developed as part of the Advanced Developer training and aims to practice object-oriented design and Java programming.


Development Roadmap / Iterations

The game development will be carried out in several iterations, each adding new functionality:

Iteration 0 – Preparatory Reflections
  - Plan the overall design and structure of the game.
  - Define main classes, responsibilities, and relationships.

Class diagram (v1)
Here is the diagram representing the main classes in this first version:
```mermaid
classDiagram
direction TB
    class Main {
        -main()
    }
    class Cell {
	    -owner Player
	    +getRepresentation()
    }
    class TicTacToe {
	    -Game game
	    +display()
	    +getMoveFromPlayer()
	    +play()
    }
    class Player {
	    +String representation
	    +getRepresentation()
    }
    class Game {
	    +int size
	    +Cell[][]
	    +Player1
	    +Player2
	    +currentPlayer Player
	    +makeMove()
	    +setOwner()
	    +isOver()
	    +isWinner()
	    +switchPlayer()
	    +resetGame()
    }

	Main --> Game
    Game --> TicTacToe 
    TicTacToe --> Player
    TicTacToe --> Cell
    Cell --> Player
   
```

Iteration 1 – Display the Game Board
  - Implement the Board class.
  - Display an empty 3x3 grid in the console.

Iteration 2 – Player Creation and Cell Capture
  - Add a Player class and link each Cell to its owner.
  - Implement the logic to ask the player for their move.

Iteration 3 – Multiplayer TicTacToe
  - Add a second player to the game.
  - Allow players to take turns until the board is full.

Iteration 4 – Game End Conditions
  - Stop the game when a player aligns three symbols.
  - Detect a draw if the board is fully occupied without a winner.

Class Diagramm type MVC (v2)
```mermaid
classDiagram
direction BT
class ArtificialPlayer {
+ ArtificialPlayer(String)
+ decideMove(Game) Point
  }
  class Board {
+ Board(int, int)
- int width
- int height
+ getCell(int, int) Cell
+ setCellOwner(Point, Player) void
  int height
  boolean boardFull
  int width
  }
  class Cell {
+ Cell()
- Player owner
  String representation
  Player owner
  }
  class Game {
+ Game(int, int, Player[])
- Board board
- Player[] players
+ checkVictory() boolean
+ playMove(Point, Player) boolean
  boolean over
  Board board
  Player currentPlayer
  Player[] players
  }
  class GameController {
+ GameController(Game, View, UserInterface)
+ runGameLoop() void
+ handleVictory() void
+ start() void
  }
  class GameInterface {
  <<Interface>>
+ checkVictory() boolean
+ playMove(Point, Player) boolean
  boolean over
  }
  class Gomoku {
+ Gomoku(Player[])
  }
  class HumanPlayer {
+ HumanPlayer(String)
+ decideMove(Game) Point
  }
  class Main {
+ Main()
+ main(String[]) void
  }
  class Player {
+ Player(String)
- String representation
+ decideMove(Game) Point
  String representation
  }
  class Point {
+ Point(int, int)
- int y
- int x
  int y
  int x
  }
  class TicTacToe {
+ TicTacToe(Player[])
+ checkVictory() boolean
  }
  class UserInterface {
+ UserInterface()
+ getMove(Player, Game) Point
+ getMenuChoice(View) int
  }
  class View {
+ View()
+ displayBoard(Board) void
+ showMessage(String) void
  }

ArtificialPlayer  -->  Player
Game  ..>  GameInterface
Gomoku  -->  Game
HumanPlayer  -->  Player
TicTacToe  -->  Game 
```
