package LLD.TicTacToe.manager;

import LLD.TicTacToe.Model.GameStatus;
import LLD.TicTacToe.Model.Player;
import LLD.TicTacToe.Model.PlayingPieceO;
import LLD.TicTacToe.Model.PlayingPieceX;
import commons.utils.Pair;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board board;
    public Player winner;

    public TicTacToeGame() {
        initializeGame();
    }

    public void initializeGame() {
        // Creating 2 Players
        players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player1", crossPiece);

        PlayingPieceO noughtsPiece = new PlayingPieceO();
        Player player2 = new Player("Player2", noughtsPiece);

        players.add(player1);
        players.add(player2);

        // initializeBoard
        board = new Board(3);
    }

    public GameStatus startGame() {
        boolean noWinner = true;
        while (noWinner) {
            Player currentPlayer = players.removeFirst();
            board.printBoard();
            List<Pair<Integer, Integer>> freeCells = board.getFreeCells();

            if(freeCells.isEmpty()) {
                noWinner = false;
                continue;
            }

            System.out.print("Player: " + currentPlayer.name + " - Please enter your [row, column]: ");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputColumn = Integer.parseInt(values[1]);

            boolean validMove = board.addPiece(inputRow, inputColumn, currentPlayer.playingPiece);
            if(!validMove) {
                System.out.printf("Invalid move at row: %d col: %d. Position is outside the board or already occupied.%n", inputRow, inputColumn);
                players.addFirst(currentPlayer);
                continue;
            }

            players.addLast(currentPlayer);
            boolean isWinner = board.checkForWinner(inputRow, inputColumn, currentPlayer.playingPiece.pieceType);
            if (isWinner) {
                board.printBoard();
                winner = currentPlayer;
                return GameStatus.WIN;
            }
        }

        return GameStatus.DRAW;
    }
}
