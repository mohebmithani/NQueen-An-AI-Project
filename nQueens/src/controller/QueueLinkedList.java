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
public class QueueLinkedList {
    LinkedList1 linklist;
    private Node1 rear;
    private Node1 front;
    
    public QueueLinkedList()
    {
        linklist = new LinkedList1();
        this.rear = null;
        this.front = null;
    }
    
    public boolean isEmpty()
    {
        return this.rear == null;
    }
    
    public void enqueue(NQueenBoard newBoard)
    {
        linklist.Append(newBoard);
        this.front = linklist.getFront();
        this.rear = linklist.getRear();
    }
    
    public NQueenBoard dequeue()
    {
        if(isEmpty())
        {
            System.out.println("Queue is empty");
            return null;
        }
        
        Node1 temp = linklist.delete();
        if(this.front == this.rear)
            this.front = this.rear = linklist.getFront();
        this.front = linklist.getFront();
        return temp.getData();
    }
    
    public NQueenBoard peek()
    {
        if(isEmpty())
        {
            System.out.println("Queue is empty");
            return null;
        }
        
        Node1 temp = linklist.getFront();
        return temp.getData();
    }
    
    
}
