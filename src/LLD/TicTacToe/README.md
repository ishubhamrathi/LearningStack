# TicTacToe

Console Tic Tac Toe game with board logic, player turns, move validation, and winner detection.

## How To Run

Compile and run from the project root:

```bash
javac -cp src -d out src/commons/utils/Pair.java src/LLD/TicTacToe/Main.java src/LLD/TicTacToe/manager/*.java src/LLD/TicTacToe/Model/*.java
java -cp out LLD.TicTacToe.Main
```

When prompted, enter moves in `row,column` format such as `0,0` or `1,2`.

## Sample Test Case

Manual winning flow:

1. `Player1` enters `0,0`
2. `Player2` enters `1,0`
3. `Player1` enters `0,1`
4. `Player2` enters `1,1`
5. `Player1` enters `0,2`

Expected result:

- `Player1` wins by completing the first row.

Invalid move flow:

1. `Player1` enters `0,0`
2. `Player2` enters `0,0`

Expected result:

- The game prints an invalid move message.
- `Player2` gets to retry.

## Design Principles Used

- Separation of concerns: `Board` manages board state, while `TicTacToeGame` manages gameplay flow.
- Encapsulation: board rules such as validation and winner checks stay inside `Board`.
- Inheritance: `PlayingPieceX` and `PlayingPieceO` extend `PlayingPiece`.
- Composition: `Player` owns a playing piece and the game owns players plus a board.
- Single Responsibility Principle: models represent game entities, while manager classes handle execution logic.

## LLD Design

Core entities:

- `Player` - Represents a game participant with a name and piece.
- `PlayingPiece` - Base type for pieces used on the board.
- `PlayingPieceX` and `PlayingPieceO` - Concrete piece types.
- `PieceType` - Enum for piece identity.
- `GameStatus` and `MoveStatus` - Enums describing game and move outcomes.

Service layer:

- `Board` - Owns the 2D grid, validates moves, returns free cells, and checks winning conditions.
- `TicTacToeGame` - Initializes the game, rotates turns using a queue, takes input, and decides win or draw.

Interaction flow:

1. `Main` creates `TicTacToeGame`.
2. The game initializes two players and a `3 x 3` board.
3. On each turn, the current player enters `row,column`.
4. `Board` validates and places the move.
5. The game checks for a winner after every valid move.
6. The loop ends with `WIN` or `DRAW`.

## Files

- `Main.java` - Entry point for the Tic Tac Toe game.
- `manager/Board.java` - Board state, move validation, and win checks.
- `manager/TicTacToeGame.java` - Main game loop and player turn handling.
- `Model/GameStatus.java` - Overall game status values.
- `Model/MoveStatus.java` - Move result values.
- `Model/PieceType.java` - Piece type enum.
- `Model/Player.java` - Player model.
- `Model/PlayingPiece.java` - Base playing piece abstraction.
- `Model/PlayingPieceO.java` - O piece implementation.
- `Model/PlayingPieceX.java` - X piece implementation.
