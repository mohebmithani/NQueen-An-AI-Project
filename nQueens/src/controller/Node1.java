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
public class Node1 {
    private NQueenBoard board;
    private Node1 next;

    public Node1() {
        this.board = null;
        this.next = null;
    }
    
    public Node1(NQueenBoard board, Node1 next) 
    {
        this.board = board;
        this.next = next;
    }

    public NQueenBoard getData() {
        return this.board;
    }

    public Node1 getNext() {
        return next;
    }

    public void setNext(Node1 next) {
        this.next = next;
    }
}
