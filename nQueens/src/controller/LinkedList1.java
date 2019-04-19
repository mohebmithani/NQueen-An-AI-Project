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
public class LinkedList1 {
    private Node1 first;
    private Node1 rear;

    public LinkedList1() {
        this.first = null;
        this.rear = null;
    }
    
    public Node1 getFront()
    {
        return this.first;
    }
    
    public Node1 getRear()
    {
        return this.rear;
    }
    
    public boolean isEmpty()
    {
        return this.first == null;
    }
    
    public void Append(NQueenBoard newBoard)
    {
        Node1 nextNode1 = new Node1(newBoard, null);
        this.rear = nextNode1;
        Node1 temp = this.first;
        
        if(this.isEmpty())
        {
            this.first = nextNode1;
            return;
        }
        
        while(temp.getNext() != null)
        {
            temp = temp.getNext();
        }
        
        temp.setNext(nextNode1);
    }
    
    public Node1 delete() 
    {
        if(!isEmpty())
        {
            Node1 temp = first;
            first = temp.getNext();
            return temp;
        }
        return null;
    }
    
}
