package com.company;

/**
 * Created by Pim on 17-3-2016.
 */
public class Solver {

    Trie inputTrie;
    Grid inputBoard;
    Scoreboard inputScores;
    String[][] solvedPuzzles;

    public Solver(Trie trie, Grid board, Scoreboard scores)
    {
        inputTrie = trie;
        inputBoard = board;
        inputScores = scores;

    }

    public void solveBoard()
    {


        while(true)
        {
            for(String[] rij : inputBoard)
            {
                for(String s : rij)
                {
                   SearchWord(s);
                }

            }

        }

    }

    public SearchWord(String s)
    {


    }



}
