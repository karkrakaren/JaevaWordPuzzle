package com.company;

import java.util.*;

/**
 * Created by Pim on 17-3-2016.
 */

public class Solver{

    Trie inputTrie;
    Grid inputBoard;
    Scoreboard inputScores;
    ArrayList<String> path;

    static final int BUREN = 8;

    public Solver(Trie trie, Grid board, Scoreboard scores)
    {

        inputTrie = trie;
        inputBoard = board;
        inputScores = scores;

        path = new ArrayList<String>();
    }

    public void solveBoard() {


    }

    public void search(int indexh, int indexb ) {

        createPath(indexh, indexb);

    }

    public ArrayList<String> getPath(){
        return path;
    }


    // functies voor alle mogelijke opties rondom een woord


    public void createPath(int indexh, int indexb)
    {


        String value = "";
        int counter= 0;
        for (int i = 0; i < BUREN; i++) {
            counter++;
            System.out.println(counter);

            try {

                switch (i) {
                    case 0:
                        value = inputBoard.getValue(indexh - 1, indexb - 1);
                        break;

                    case 1:
                        value = inputBoard.getValue(indexh - 1, indexb);
                        break;

                    case 2:
                        value = inputBoard.getValue(indexh - 1, indexb + 1);
                        break;

                    case 3:
                        value = inputBoard.getValue(indexh, indexb - 1);
                        break;

                    case 4:
                        value = inputBoard.getValue(indexh, indexb + 1);
                        break;

                    case 5:
                        value = inputBoard.getValue(indexh + 1, indexb - 1);
                        break;

                    case 6:
                        value = inputBoard.getValue(indexh + 1, indexb);
                        break;

                    case 7:
                        value = inputBoard.getValue(indexh + 1, indexb + 1);
                        break;

                    default:
                        break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {

                System.out.println("deze variabele ligt aan de rand");

                // deze catch is puur om de error te voorkomen als we de Array out of bounds krijgen
            }

            String wordPart = inputBoard.getValue(indexh, indexb) + value;

            System.out.println(wordPart);

            boolean isWord = inputTrie.startsWith(wordPart);
            System.out.println(isWord);

            if (isWord) {
                path.add(wordPart);
            }


        }
    }


}
