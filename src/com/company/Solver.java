package com.company;

import java.util.*;

/**
 * Created by Pim on 17-3-2016.
 */

public class Solver{

    // trie, grid en een scoreboard als input
    Trie inputTrie;
    Grid inputBoard;
    Scoreboard inputScores;
    ArrayList<String> path;
    ArrayList<Objects> allPaths;
    ArrayList<Integer> globalscore;


    static final int BUREN = 8;

    public Solver(Trie trie, Grid board, Scoreboard scores)
    {

        inputBoard = board;
        allPaths = new ArrayList<Objects>();

        inputTrie = trie;
        inputScores = scores;

        globalscore = new ArrayList<>();

    }

    // solveboard
    public void solveBoard() {



    }

    // ga op zoek naar een path
    public void searchPath(int indexh, int indexb) {

        while(allPaths.size() < 10)
        {

            Grid GridToSolve = inputBoard;

            path = new ArrayList<>();

            int branch = path.indexOf(path.size() - 1);
            System.out.println(branch);

            searchNeighbours(indexh, indexb, path);
            evaluateArray(path);
        }

    }

    // checkt of er onderdelen van een woord in een array zitten
    // zo niet gooit ze eruit
    public ArrayList<String> evaluateArray(ArrayList<String> path){

        for(String wordPart: path)
        {
            //System.out.println(wordPart);

            // checken of het een woorddeel is wordt gedaan met een functie uit de tree
            // die true of false return bij het bestaan van een deel van dat woord
            boolean isWord = inputTrie.startsWith(wordPart);

            //System.out.println(isWord);

            //als het een woord is voeg het dan toe aan je mogelijke te nemen paden
            if (!isWord) {
                path.remove(wordPart);
            }
        }

        return path;
    }

    // functies voor alle mogelijke letters rondom een woord
    public ArrayList<String> searchNeighbours(int indexh, int indexb, ArrayList<String> path)
    {
        // maak een value aan
        String value = null;
        //int counter= 0;

        //ga na alle waarden om het punt heen kijken
        // hier met een try en catch + switch
        // (elke punt heeft 8 mogelijke buren)
        for (int i = 0; i < BUREN; i++) {


            // implementatie van links-boven van links naar rechts
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
            }
            // bij het niet bestaan van deze waarde in de array is er een erroy
            // deze voorkom je met catch
            catch (ArrayIndexOutOfBoundsException e) {

                //System.out.println("deze variabele ligt aan de rand");
                // deze catch is puur om de error te voorkomen als we de Array out of bounds krijgen
            }
        }

        return path;
    }


}
