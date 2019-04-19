/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Moheb
 */
public class NQueenBoard implements Cloneable{
    private int boardSize;
    private int fitnessValue;
    private String queensPosition;
    private boolean isSame;

    public NQueenBoard(int boardSize) {
        this.boardSize = boardSize;
        this.fitnessValue = -1;
        this.queensPosition = "";
        this.isSame = false;
    }
    
    public NQueenBoard(int boardSize, String queensPosition) {
        this.boardSize = boardSize;
        this.fitnessValue = -1;
        this.queensPosition = queensPosition;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getFitnessValue() {
        return fitnessValue;
    }

    public void setFitnessValue(int fitnessValue) {
        this.fitnessValue = fitnessValue;
    }
    
    public String getQueensPosition() {
        return queensPosition;
    }

    public void setQueensPosition(String queensPosition) {
        this.queensPosition = queensPosition;
    }
    
     public boolean getIsSame() {
        return isSame;
    }

    public void setIsSame(boolean isSame) {
        this.isSame = isSame;
    }
    
    
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
