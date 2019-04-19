/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

/**
 *
 * @author hiqba
 */
public class backTracking {

    private int N;
    private createBoard nQueenBoard;
    private LinkedList listOfSolutions;
    private int noOfSolutions;

    public backTracking(int N) {
        listOfSolutions = new LinkedList();
        noOfSolutions = -1;
        nQueenBoard = new createBoard(N);
        this.N = N;
    }

    private boolean placeQueen(Integer[][] board, int row, int col) { //3
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        /*Check this row on right side*/
        for (i = getN() - 1; i >= 0; i--) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        /* Check this col on upper side */
        for (i = 0; i < col; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        /*Check this col on bottom side*/
        for (i = getN() - 1; i >= 0; i--) {
            if (board[i][col] == 1) {
                return false;
            }
        }


        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        /* Check upper diagonal on right side */
        for (i = row, j = col; i < getN() && j < getN(); i++, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < getN(); i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        /* Check lower diagonal on right side */
        for (i = row, j = col; j < getN() && i >= 0; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private boolean applyBackTrackingCol(Integer[][] board, int row, int col) { //2
        /* base case */
        int noOfQueens = 0;
        for (int nr = 0; nr < getN(); nr++) {
            for (int nc = 0; nc < getN(); nc++) {
                if (board[nr][nc] == 1) {
                    noOfQueens++;
                }
            }
        }
        if (noOfQueens == getN()) {
            return true;
        }
        if (col >= getN()) {
            col = col % getN();
        }

        int i = 0;
        while (i < getN()) {
            if (placeQueen(board, row, col)) {
                nQueenBoard.AddEdge(row, col);

                if (applyBackTrackingCol(nQueenBoard.getBoard(), row, col + 1) == true) {
                    return true;
                }
                nQueenBoard.deleteEdge(row, col);
            }
            row++;
            if (row >= getN()) {
                row = row % getN();
            }
            i++;
        }
        return false;
    }

    private boolean applyBackTrackingRow(Integer[][] board, int row, int col) { //8
        /* base case */
        int noOfQueens = 0;
        for (int nr = 0; nr < getN(); nr++) {
            for (int nc = 0; nc < getN(); nc++) {
                if (board[nr][nc] == 1) {
                    noOfQueens++;
                }
            }
        }
        if (noOfQueens == getN()) {
            return true;
        }

        if (row >= getN()) {
            row = row % getN();
        }

        int i = 0;
        while (i < getN()) {
            if (placeQueen(board, row, col)) {
                nQueenBoard.AddEdge(row, col);

                if (applyBackTrackingRow(nQueenBoard.getBoard(), row + 1, col) == true) {
                    return true;
                }
                nQueenBoard.deleteEdge(row, col);
            }
            col++;
            if (col >= getN()) {
                col = col % getN();
            }
            i++;
        }
        return false;
    }

    public Integer[][] solveNQueens() { //1
        boolean sol = false;
        int tempRow = 0, tempCol = 0;

        if (applyBackTrackingCol(nQueenBoard.getBoard(), 0, 0) == false) {
            System.out.print("Solution does not exist\n");
            return null;
        }
        if (!nextPossibility()) {
            int i = 0;
            while (i < getN()) {
                for (int m = 0; m < getN(); m++) {
                    for (int j = 0; j < getN(); j++) {
                        if (nQueenBoard.holdsQueen(m, j)) {
                            tempRow = m;
                            tempCol = j;
                            while (tempCol < getN()) {
                                nQueenBoard.refreshBoard();
                                if (applyBackTrackingCol(nQueenBoard.getBoard(), (tempRow == -1) ? ++tempRow : tempRow, ++tempCol) == true && nextPossibility() == true) { //6
                                    sol = true;
                                    break;
                                }
                            }
                            if (sol) {
                                break;
                            }
                            if (tempRow == getN() - 1) {
                                tempRow = -1;
                            }
                            if (tempCol >= getN()) {
                                tempCol = -1;
                            }
                            while (tempRow < getN()) {
                                nQueenBoard.refreshBoard();
                                if (applyBackTrackingRow(nQueenBoard.getBoard(), ++tempRow, (tempCol == -1) ? ++tempCol : tempCol) == true && nextPossibility() == true) { //7
                                    sol = true;
                                    break;
                                }
                            }
                            if (tempCol >= getN()) {
                                tempCol = -1;
                            }
                            if (tempRow >= getN()) {
                                tempRow = -1;
                            }
                        }
                        if (sol) {
                            break;
                        }
                    }
                    if (sol) {
                        break;
                    }
                }
                i++;
                if (sol) {
                    break;
                }
            }
            if (!sol) {
                return null;
            }

        }
        Integer[][] tempSolution = new Integer[N][N];
        for (int i = 0; i < getN(); i++) {
            System.arraycopy(nQueenBoard.getBoard()[i], 0, tempSolution[i], 0, getN());
        }
        listOfSolutions.Append(tempSolution);
        noOfSolutions++;
        return nQueenBoard.getBoard();
    }

    private boolean nextPossibility() { //4

        if (listOfSolutions.isEmpty()) {
            return true;
        }

        return !equals(nQueenBoard.getBoard());
    }

    @Override
    public boolean equals(Object obj) {
        Integer[][] tempBoard = (Integer[][]) obj;

        for (int i = 0; i < listOfSolutions.getSize(); i++) {
            int flag = 0;
            for (int j = 0; j < tempBoard.length; j++) {
                for (int k = 0; k < tempBoard.length; k++) {
                    if ((tempBoard[j][k] == 1 && listOfSolutions.getNodeAt(i).getBoard()[j][k] == 1)) {
                        flag++;
                    }
                }

            }
            if (flag == getN()) {
                return true;
            }
        }
        return false;
    }

    public int getNoOfSolutions() {
        return noOfSolutions;
    }

    public void setNoOfSolutions(int noOfSolutions) {
        this.noOfSolutions = noOfSolutions;
    }

    public int getN() {
        return this.N;
    }

    public void setN(int N) {
        this.N = N;
    }

}
