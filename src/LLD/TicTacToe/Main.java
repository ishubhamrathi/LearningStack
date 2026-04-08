import LLD.TicTacToe.Model.GameStatus;
import LLD.TicTacToe.manager.TicTacToeGame;

void main() {
    IO.println(String.format("Hello and welcome to TicTacTow Game!"));
    TicTacToeGame game = new TicTacToeGame();

    GameStatus status = game.startGame();
    switch (status) {
        case WIN -> IO.println(game.winner.name + " won the game");
        case DRAW -> IO.println("It's a DRAW!");
    }
    IO.println("====GAME OVER===");


}
