/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static java.lang.Math.random;

/**
 *
 * @author Moheb
 */
public class BoardController implements Cloneable{
    private final int maxBoards;
    private final int noOfQueens;
    private  NQueenBoard[] board;
    private boolean isAnyFit;

    

    public BoardController(int maxBoards, int noOfQueens) 
    {
        this.noOfQueens = noOfQueens;
        if(maxBoards <= ((int)Math.pow((double)this.noOfQueens, (double)this.noOfQueens)))
            this.maxBoards = maxBoards;
        else
            this.maxBoards = ((int)Math.pow((double)this.noOfQueens, (double)this.noOfQueens)) + 10;
        this.board = new NQueenBoard[this.maxBoards];
        isAnyFit = false;
    }
    
    public void createBoard() throws CloneNotSupportedException
    {
        StringManager string = new StringManager();
        for (int i = 0; i < this.maxBoards; i++) 
        {
            String s = "";
            this.board[i] = new NQueenBoard(this.noOfQueens);
            for (int j = 0; j < this.noOfQueens; j++) 
            {
                s = string.intToString(s, ((int)(Math.random() * this.noOfQueens)));
            }
            this.board[i].setQueensPosition(s);
        }
    }
    
    void fitnessFunction()
    {
        StringManager string = new StringManager();
        int[] nqueens = new int[this.noOfQueens];
        for (int i = 0; i < this.maxBoards; i++) 
        {
            nqueens = string.stringToInt(this.board[i].getQueensPosition());
            int nattacks = 0;
            
            for (int j = 0; j < this.noOfQueens; j++) 
            {
                for (int k = 0; k < this.noOfQueens; k++) 
                {
                    if(j == k)
                        continue;
                    if((nqueens[j] == nqueens[k]) || ((j + nqueens[j]) == (k + nqueens[k])) || ((j - nqueens[j]) == (k - nqueens[k])))
                    {
                        nattacks++;
                    }
                }
            }
            
            if(nattacks/2 == 0)
                isAnyFit = true;
            this.board[i].setFitnessValue(nattacks/2);
        }
        
    }
    
    public int getMaxBoards() {
        return maxBoards;
    }

    public int getNoOfQueens() {
        return noOfQueens;
    }
    
    public void setBoard(NQueenBoard[] board) {
        this.board = board;
    }
    
    public void setBoard(NQueenBoard board, int i) {
        this.board[i] = board;
    }

    public NQueenBoard[] getBoards() {
        return board;
    }
    
    public NQueenBoard getBoard(int i)
    {
        return this.board[i];
    }

    public boolean isIsAnyFit() {
        return isAnyFit;
    }
    
    
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        BoardController clone = (BoardController) super.clone();
        NQueenBoard[] n;
        if(this.maxBoards <= ((int)Math.pow((double)this.noOfQueens, (double)this.noOfQueens)))
            n = new NQueenBoard[this.maxBoards];
        else
            n = new NQueenBoard[((int)Math.pow((double)this.noOfQueens, (double)this.noOfQueens)) + 10];
        for (int i = 0; i < (this.maxBoards <= ((int)Math.pow((double)this.noOfQueens, (double)this.noOfQueens))? this.maxBoards: ((int)Math.pow((double)this.noOfQueens, (double)this.noOfQueens)) + 10); i++) 
        {
            n[i] = (NQueenBoard)this.board[i].clone();
        }
        clone.board = n;
                
        return (Object)clone;
    }
}
