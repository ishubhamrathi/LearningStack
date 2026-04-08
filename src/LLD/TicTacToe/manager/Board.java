package LLD.TicTacToe.manager;

import LLD.TicTacToe.Model.PieceType;
import LLD.TicTacToe.Model.PlayingPiece;
import LLD.TicTacToe.utils.Pair;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;
    public PlayingPiece[][]board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];// creates an 2D array of size;
    }

    public boolean isValidMove(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            return false;
        }

        return board[row][col] == null;
    }

    public boolean addPiece(int row, int col, PlayingPiece currentPlayingPiece) {
        if (!isValidMove(row, col)) {
            return false;
        }
        board[row][col] = currentPlayingPiece;
        return true;

    }

    public void printBoard() {
        for (int i = 0; i<size; i++) {
            for ( int j = 0; j< size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "  ");
                } else {
                    System.out.print("   ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public List<Pair<Integer, Integer>>getFreeCells() {
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();

        for (int i = 0; i< size; i++) {
            for (int j =0; j<size; j++) {
                if (board[i][j] == null) {
                    freeCells.add(new Pair<>(i,j));
                }
            }
        }

        return freeCells;
    }

    public boolean checkForWinner(int row, int col, PieceType currentPieceType) {
        boolean rowMatch = true;
        boolean columnsMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // check row
        for (int i = 0; i < size; i++) {
            if (board[row][i] == null|| board[row][i].pieceType != currentPieceType) {
                rowMatch = false;
                break;
            }
        }

        // check col
        for (int i = 0; i < size; i++) {
            if (board[i][col] == null|| board[i][col].pieceType != currentPieceType) {
                columnsMatch = false;
                break;
            }
        }

        // check Diagonally
        for (int i = 0, j=0; i < size; i++, j++) {
            if (board[i][j] == null|| board[i][j].pieceType != currentPieceType) {
                diagonalMatch = false;
                break;
            }
        }

        for (int i = 0, j=size -1; i < size; i++, j--) {
            if (board[i][j] == null|| board[i][j].pieceType != currentPieceType) {
                antiDiagonalMatch = false;
                break;
            }
        }


        return rowMatch|| columnsMatch || diagonalMatch || antiDiagonalMatch;
    }

}
