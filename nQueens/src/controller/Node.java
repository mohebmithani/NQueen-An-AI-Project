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
public class Node {

    private Integer[][] board;
    private Node next;

    public Node(Integer[][] board) {
        this.board = board;
        this.next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer[][] getBoard() {
        return board;
    }

    public void setBoard(Integer[][] board) {
        this.board = board;
    }

}
