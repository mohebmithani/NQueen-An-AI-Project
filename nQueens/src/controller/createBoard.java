/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author hiqba
 */
public class createBoard { 

    private Integer[][] board;
    private int boardSize;

    public createBoard(int sizeOfBoard) {

        this.board = new Integer[sizeOfBoard][sizeOfBoard];
        this.boardSize = sizeOfBoard;

        for (int i = 0; i < sizeOfBoard; i++) {
            for (int j = 0; j < sizeOfBoard; j++) {
                this.board[i][j] = 0;
            }
        }

    }

    public void AddEdge(int row, int col) {
        board[row][col] = 1;
    }

    public void deleteEdge(int row, int col) {
        board[row][col] = 0;
    }

    public boolean holdsQueen(int row, int col) {
        return (board[row][col] == 1);
    }

    public Integer[][] getBoard() {
        return this.board;
    }

    public void setBoard(Integer[][] board) {
        this.board = board;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public void refreshBoard() {
        for (int k = 0; k < getBoardSize(); k++) {
            for (int l = 0; l < getBoardSize(); l++) {
                this.board[k][l] = 0;
            }
        }
    }
}
