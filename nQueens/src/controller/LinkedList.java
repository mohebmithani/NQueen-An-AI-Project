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
public class LinkedList {

    private Node first;
    private int size;

    public LinkedList() {
        this.first = null;
        this.size = 0;
    }

    public Node getNodeAt(int i){ //5
        Node temp = this.first;
        int j = 0;
        if(this.isEmpty()){
            return null;
        }
        while(temp!=null){
            if(j == i){
                return temp;
            }
            temp = temp.getNext();
            j++;
        }
        return null;
    }
    
    public void Append(Integer[][] newBoard) {
        Node nextNode = new Node(newBoard);
        Node temp = this.first;

        if (this.isEmpty()) {
            this.first = nextNode;
            size++;
            return;
        }

        while (temp.getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(nextNode);
        size++;
    }

    public Node delete() {
        if (!isEmpty()) {
            Node temp = first;
            first = temp.getNext();
            size--;
            return temp;
        }
        return null;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
