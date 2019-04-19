/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Moheb
 */
public class GeneticAlgorithm {
    private int generation;
    private int maxGenerations;

    
    private int nchildBoard;
    private BoardController parent;
    private BoardController child;
    private int selectionFactor;
    private boolean unethicalMutation;
    private int mutationChance;
    private ArrayList<NQueenBoard> solutionSet;
    
    public GeneticAlgorithm(int maxGenerations, int maxBoards, int noOfQueens, int selectionFactor, boolean unethicalMutation, int mutationChance)
    {
        this.generation = 0;
        this.maxGenerations = maxGenerations;
        this.nchildBoard = 0;
        this.parent = new BoardController(maxBoards, noOfQueens);
        this.child = new BoardController(maxBoards, noOfQueens);
        this.selectionFactor = selectionFactor;
        this.unethicalMutation = unethicalMutation;
        this.mutationChance = mutationChance;
        this.solutionSet = new ArrayList<>();
    }
    
    public void solve() throws CloneNotSupportedException
    {
//        int answer = 0, n;
//        
//        Scanner sc = new Scanner(System.in);
//        NQueenBoard[] parentBoard, childBoard;
//        initialization();
//        do
//        {
//            n = 0;
//            
//            for (int i = 0; i < this.parent.getMaxBoards() / 2; i++) 
//            {
//                parentBoard =  selection();
//                childBoard = crossover(parentBoard);
//                mutation(childBoard);
//            }
//            this.generation++;
//            System.out.println("generation: "+this.generation);
//            this.parent = this.child;
//            initialization();
//            
//            
//            BoardController temp = new BoardController(this.parent.getMaxBoards(), this.parent.getNoOfQueens());
//            this.child = temp;
//            this.nchildBoard = 0;
//            
//            if(this.parent.isIsAnyFit())
//            {
//                do
//                {
//                    if(this.parent.getBoard(n).getFitnessValue() == 0)
//                    {
//                            int a = 0;
//                            if(this.solutionSet.isEmpty())
//                            {
//                                System.out.println("nQueen board with no queen attacking is found.");
//                                System.out.println("pattern:"+this.parent.getBoards()[n].getQueensPosition());
//                                this.solutionSet.add(this.parent.getBoard(n));
//                                System.out.println("Do you want to see another fit board? press 1 for yes");
//                                answer = sc.nextInt();
//                                if(answer == 2)
//                                    return;
//                            }
//                            else
//                            {
//                                while(a < this.solutionSet.size())
//                                {
//                                    if(this.parent.getBoards()[n].getQueensPosition().equalsIgnoreCase(this.solutionSet.get(a).getQueensPosition()))
//                                    {
//                                        this.parent.getBoards()[n].setIsSame(true);
//                                        break;
//                                    }
//
//                                        a++;
//                                }
//                                if(this.parent.getBoards()[n].getIsSame() != true)
//                                {
//                                    System.out.println("nQueen board with no queen attacking is found.");
//                                    System.out.println("pattern:"+this.parent.getBoards()[n].getQueensPosition());
//                                    this.solutionSet.add(this.parent.getBoard(n));
//                                    System.out.println("Do you want to see another fit board? press 1 for yes");
//                                    answer = sc.nextInt();
//                                    if(answer == 2)
//                                        return;
//                                }
//                                    
//                            }
//                            
//                            n++;
//                    }
//                    else
//                    {
//                        break;
//                    }
//                }while(answer == 1);
//            }
//        }while(this.generation < this.maxGenerations);
    }
    
    public void initialization() throws CloneNotSupportedException
    {
        if(this.generation == 0)
            this.parent.createBoard();
        this.parent.fitnessFunction();
        
        RadixSort radixSort = new RadixSort(2);
        radixSort.sort(this.parent.getBoards(), this.parent.getMaxBoards());
    }
    
    public NQueenBoard[] selection()
    {
        NQueenBoard[] parentBoards = new NQueenBoard[2];
        
        for (int i = 0; i < 2; i++) 
        {
            int randIndex = (int)(this.parent.getMaxBoards() * Math.pow(Math.random(), this.selectionFactor));
            parentBoards[i] = this.parent.getBoard(randIndex);
        }
        
        return parentBoards;
    }
    
    public NQueenBoard[] crossover(NQueenBoard[] parentBoards)
    {
        NQueenBoard[] childBoards = new NQueenBoard[2];
        StringManager string = new StringManager();
        int crossOverPoint = (int)(Math.random() * (this.parent.getNoOfQueens() - 1));
        
        String[] splitParent1 = string.stringSplit(parentBoards[0].getQueensPosition(), crossOverPoint);
        String[] splitParent2 = string.stringSplit(parentBoards[1].getQueensPosition(), crossOverPoint);

        String[] newChild = new String[2];
        newChild[0] = string.intToString(string.stringToInt(splitParent1[0]), string.stringToInt(splitParent2[1]));
        newChild[1] = string.intToString(string.stringToInt(splitParent2[0]), string.stringToInt(splitParent1[1]));
        
        childBoards[0] = new NQueenBoard(this.parent.getNoOfQueens(), newChild[0]);
        childBoards[1] = new NQueenBoard(this.parent.getNoOfQueens(), newChild[1]);
        
        return childBoards;
    }
    
    public void mutation(NQueenBoard[] childBoards)
    {
        StringManager string = new StringManager();
        int[] child1 = string.stringToInt(childBoards[0].getQueensPosition());
        int[] child2 = string.stringToInt(childBoards[1].getQueensPosition());
        boolean isChild1Mutated = false;
        boolean isChild2Mutated = false;
        
        // if only two are in same row
        if(unethicalMutation)
        {
            int[][] noOfQueens = new int[2][this.parent.getNoOfQueens()];
            String[][] positionOfQueens = new String[2][this.parent.getNoOfQueens()];
            for (int i = 0; i < this.parent.getNoOfQueens(); i++) 
            {
                noOfQueens[0][i] = 0;
                noOfQueens[1][i] = 0;
                positionOfQueens[0][i] = "";
                positionOfQueens[1][i] = "";
            }
            
            for (int i = 0; i < this.parent.getNoOfQueens(); i++) 
            {
                noOfQueens[0][child1[i]]++;
                noOfQueens[1][child2[i]]++;
                positionOfQueens[0][child1[i]] += i;
                positionOfQueens[1][child2[i]] += i;
            }
            
            
            for (int i = 0; i < 2; i++) 
            {
                int flag = 0;
                int indexOfSamePositions = -1;
                int indexOfUnusedPosition = -1;
                for (int j = 0; j < this.parent.getNoOfQueens(); j++) 
                {
                    if(noOfQueens[i][j] <= 2)
                    {
                        if(noOfQueens[i][j] == 2)
                        {
                            if(flag == 0)
                            {
                                flag++;
                                indexOfSamePositions = j;
                            }
                            else
                            {
                                flag = 3;
                                break;
                            }
                        }
                        else if(noOfQueens[i][j] == 0)
                            indexOfUnusedPosition = j;
                    }
                    else
                    {
                        flag = 3;
                        break;    
                    }
                }
                
                if(flag == 1)
                {
                    
                    int rand = (int) (Math.random()*2);
                    if(i == 0)
                    {
                        int[] a = string.stringToInt(positionOfQueens[0][indexOfSamePositions]);
                        child1[a[rand]] = indexOfUnusedPosition;
                        isChild1Mutated = true;
                    }
                    else
                    {
                        int[] a = string.stringToInt(positionOfQueens[1][indexOfSamePositions]);
                        child2[a[rand]] = indexOfUnusedPosition;
                        isChild2Mutated = true;
                    }
                }
            }
        }
        
        if(isChild1Mutated == false || isChild2Mutated == false)
        {
            int rand = (int) Math.round(Math.random() * 100);

            if(rand <= this.mutationChance)
            {
                int[] randIndex = new int[2];
                int[] randValue = new int[2];
                randIndex[0] = (int) (Math.random() * this.parent.getNoOfQueens());
                randIndex[1] = (int) (Math.random() * this.parent.getNoOfQueens());
                randValue[0] = (int) (Math.random() * this.parent.getNoOfQueens());
                randValue[1] = (int) (Math.random() * this.parent.getNoOfQueens());
                
                if(isChild1Mutated == false && isChild2Mutated == false)
                {
                    child1[randIndex[0]] = randValue[0];
                    child2[randIndex[1]] = randValue[1];
                }
                else if(isChild1Mutated == false)
                    child1[randIndex[0]] = randValue[0];
                else
                    child2[randIndex[1]] = randValue[1];
            }
            
            // double mutation
            if(rand <= this.mutationChance / 2)
            {
                int[] randIndex = new int[2];
                int[] randValue = new int[2];
                randIndex[0] = (int) (Math.random() * this.parent.getNoOfQueens());
                randIndex[1] = (int) (Math.random() * this.parent.getNoOfQueens());
                randValue[0] = (int) (Math.random() * this.parent.getNoOfQueens());
                randValue[1] = (int) (Math.random() * this.parent.getNoOfQueens());
                
                child1[randIndex[0]] = randValue[0];
                child2[randIndex[1]] = randValue[1];
            }
        }
        
        
        this.child.getBoards()[this.nchildBoard++] = new NQueenBoard(this.parent.getNoOfQueens(), string.intToString(child1));
        this.child.getBoards()[this.nchildBoard++] = new NQueenBoard(this.parent.getNoOfQueens(), string.intToString(child2));
      
        if(this.child.getBoards()[this.nchildBoard - 2].getQueensPosition().equals(this.child.getBoards()[this.nchildBoard - 1].getQueensPosition()))
            this.child.getBoards()[this.nchildBoard - 2].setIsSame(true);
        
        int n = 0;
            try 
            {
                while(n < this.solutionSet.size())
                {
                    if(this.child.getBoards()[this.nchildBoard - 2].getQueensPosition().equals(this.solutionSet.get(n).getQueensPosition()))
                        this.child.getBoards()[this.nchildBoard - 2].setIsSame(true);
                    if(this.child.getBoards()[this.nchildBoard - 1].getQueensPosition().equals(this.solutionSet.get(n).getQueensPosition()))
                        this.child.getBoards()[this.nchildBoard - 1].setIsSame(true);
                    n++;
                }
            } catch (Exception e) 
            {
                System.out.println(e.getLocalizedMessage());
            }


            if(this.child.getBoards()[this.nchildBoard - 2].getIsSame() != true)
            {
                if(this.child.getBoards()[this.nchildBoard - 2].getFitnessValue() == 0)
                {
                    this.solutionSet.add(this.child.getBoards()[this.nchildBoard - 2]);
                }
            }
            if(this.child.getBoards()[this.nchildBoard - 1].getIsSame() != true)
            {
                if(this.child.getBoards()[this.nchildBoard - 1].getFitnessValue() == 0)
                {
                    
                    this.solutionSet.add(this.child.getBoards()[this.nchildBoard - 1]);
                }
            }
    }
    
    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }
    
    public BoardController getParent() {
        return parent;
    }

    public BoardController getChild() {
        return child;
    }
    
    public void setParent(BoardController parent) {
        this.parent = parent;
    }

    public void setChild(BoardController child) {
        this.child = child;
    }
    
    public int getMaxGenerations() {
        return maxGenerations;
    }

    public void setMaxGenerations(int maxGenerations) {
        this.maxGenerations = maxGenerations;
    }

    public int getNchildBoard() {
        return nchildBoard;
    }

    public void setNchildBoard(int nchildBoard) {
        this.nchildBoard = nchildBoard;
    }

    public int getSelectionFactor() {
        return selectionFactor;
    }

    public void setSelectionFactor(int selectionFactor) {
        this.selectionFactor = selectionFactor;
    }

    public boolean isUnethicalMutation() {
        return unethicalMutation;
    }

    public void setUnethicalMutation(boolean unethicalMutation) {
        this.unethicalMutation = unethicalMutation;
    }

    public int getMutationChance() {
        return mutationChance;
    }

    public void setMutationChance(int mutationChance) {
        this.mutationChance = mutationChance;
    }

    public ArrayList<NQueenBoard> getSolutionSet() {
        return solutionSet;
    }

    public void setSolutionSet(ArrayList<NQueenBoard> solutionSet) {
        this.solutionSet = solutionSet;
    }
}
