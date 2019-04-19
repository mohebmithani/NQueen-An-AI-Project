
# Overview
**nQueen Problem Solver** is an academic project which solves “N Queen Problem” with the help of AI algorithms: **Genetic Algorithm** and **Backtracking**. It is a GUI project made in JavaFX which can solve N Queen problem up to 10 queens.
# What is N Queen Problem?
The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other. For example, following is a solution for 4 Queen problem.
![Sample of N Queen]( https://github.com/mohebmithani/NQueen-An-AI-Project/blob/master/nQueens/images/sampleBoard.jpg)
# Data Structures Used: -
Linked List and Queue Linked List are used in this project.
# Sorting Algorithm: -
In order to easily get most fitted board in Genetic Algorithm some sorting algorithm must be used in accordance with the **fitness value**. For this purpose I’ve used **Radix Sort** in my algorithm.
# Genetic Algorithm: -
~~~
1) Randomly initialize population(t)
2) Determine fitness of population(t)
3) REPEAT
    select parents from population(t)
    perform crossover on parents creating population(t+1)
    perform mutation of population(t+1)
    determine fitness of population(t+1)
4) Until best individual is good enough
~~~ 
# Backtracking Algorithm: -
~~~
1) Start in the leftmost column
2) If all queens are placed
    return true
3) Try all rows in the current column.  Do following for every tried row.
    a) If the queen can be placed safely in this row then mark this [row, 
        column] as part of the solution and recursively check if placing queen here leads to a solution.
    b) If placing the queen in [row, column] leads to a solution then return 
        true.
    c) If placing queen doesn't lead to a solution then umark this [row, 
        column] (Backtrack) and go to step (a) to try other rows.
3) If all rows have been tried and nothing worked, return false to trigger 
    backtracking.
~~~
# Some Snippets: -
## Main Screen:
![Main Screen](https://github.com/mohebmithani/NQueen-An-AI-Project/blob/master/nQueens/images/mainScreen.gif)
## Result of N Queen for 10 Queens:
![Main Screen](https://github.com/mohebmithani/NQueen-An-AI-Project/blob/master/nQueens/images/result.gif)

