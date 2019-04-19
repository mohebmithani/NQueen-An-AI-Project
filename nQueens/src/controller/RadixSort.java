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
public class RadixSort {
    private int digits;
    private QueueLinkedList[] queue;
    
    public RadixSort(int digits)
    {
        this.digits = digits;
        queue = new QueueLinkedList[11];
    }
    
    public void sort(NQueenBoard[] nBoards, int noOfBoards)
    {
        int size = noOfBoards;
        for (int i = 0; i < this.digits; i++) 
        {
            int rem, div;
            for (int j = 0; j < size; j++) 
            {
                if(nBoards[j].getIsSame())
                {
                    if(queue[10] == null)
                        queue[10] = new QueueLinkedList();
                    queue[10].enqueue(nBoards[j]);
                }
                else
                {
                    rem = (int )(nBoards[j].getFitnessValue() % Math.pow(10, (i + 1)));
                    div = (int)(rem / Math.pow(10, i));

                    if(queue[div] == null)
                        queue[div] = new QueueLinkedList();
                    queue[div].enqueue(nBoards[j]);
                }
            }
            
                int j = 0;
                int k = 0;
                while(k < 11 || j < size)
                {
                    if(queue[k] == null)
                    {
                        k++;
                        continue;
                    }
                    while(!queue[k].isEmpty())
                    {
                        nBoards[j] = queue[k].dequeue();
                        j++;
                    }
                    k++;
                }
        }
    }
}
