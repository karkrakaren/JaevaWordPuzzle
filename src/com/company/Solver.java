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
    ArrayList<ArrayList> allPaths;
    ArrayList<Integer> globalscore;


    static final int BUREN = 8;

    public Solver(Trie trie, Grid board, Scoreboard scores)
    {
        inputBoard = board;
        allPaths = new ArrayList<>();
        inputTrie = trie;
        inputScores = scores;
        globalscore = new ArrayList<>();

    }

    // ga op zoek naar een path
    // gaat een Arraylist returen
    public void searchPath(){
        // for(rijen)

        path = new ArrayList<>();

        // deze functie gaat nu 1 niveau diep
        for(int i = 0; i < inputBoard.height; i++)
        {
            // for colums
            for(int j = 0; j < inputBoard.width; j++ )
            {
                // ik wil elk punt op buren checken


                String source = inputBoard.getValue(i, j);
                //System.out.println(source);
                path = searchNeighbours(i, j, source);

                // alle die daarvan woordbeginsels zijn
                // vormen een mogelijke path
                // voeg al je woordbeginsels toe aan je array
                allPaths.add(path);

            }
        }

          /*
            int counter = 0;


            while(ArrayList<> p: allPaths)
            {
                p =
                counter++
            }

            System.out.println(counter);
s
            */

        for( ArrayList<String> s: allPaths)
        {

            for(String w: s)
            {
                System.out.println(w);
            }

        }


    }

    // checkt of er onderdelen van een woord in een array zitten
    // zo niet gooit ze eruit

    // functies voor alle mogelijke letters rondom een woord
    public ArrayList<String> searchNeighbours(int indexh, int indexb, String source)
    {

        ArrayList<String> neighbours = new ArrayList<>();

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

                    //linksboven
                    case 0:
                        value = inputBoard.getValue(indexh - 1, indexb - 1);
                        break;
                    //middenboven
                    case 1:
                        value = inputBoard.getValue(indexh - 1, indexb);
                        break;

                    //rechtsboven
                    case 2:
                        value = inputBoard.getValue(indexh - 1, indexb + 1);
                        break;

                    //links zijkant
                    case 3:
                        value = inputBoard.getValue(indexh, indexb - 1);
                        break;

                    //rechts zijkant
                    case 4:
                        value = inputBoard.getValue(indexh, indexb + 1);
                        break;

                    //links onder
                    case 5:
                        value = inputBoard.getValue(indexh + 1, indexb - 1);
                        break;

                    //midden onder
                    case 6:
                        value = inputBoard.getValue(indexh+1, indexb);
                        break;

                    //rechts onder
                    case 7:
                        value = inputBoard.getValue(indexh + 1, indexb + 1);
                        break;

                    default:
                        value = null;
                        break;
                }

                //System.out.println(value);
            }
            // bij het niet bestaan van deze waarde in de array is er een erroy
            // deze voorkom je met catch
            catch (ArrayIndexOutOfBoundsException e)
            {
                //System.out.println("deze variabele ligt over de rand");
                // deze catch is puur om de error te voorkomen als we de Array out of bounds krijgen
            }

            // checken of het een woorddeel is wordt gedaan met een functie uit de tree
            // een woordpart de oorspronkelijke letter + de buur waar je op zocht
            // die true of false return bij het bestaan van een deel van dat woord
            String wordPart = source + value;

            boolean isWord = inputTrie.startsWith(wordPart);

            //System.out.println(isWord);

            //als het een woord is voeg het dan toe aan je mogelijke te nemen paden
            if (isWord && checkValue(wordPart)) {
                neighbours.add(wordPart);
            }
        }

        /*
        for(String s: neighbours)
        {
            System.out.println(s);
        }*/

        return neighbours;
    }

    // check of je value niet een van de indicatoren is
    public boolean checkValue(String value){

        // alle cassusen toevoegen

        if(value.contains("B"))
            return false;
        else if(value.contains("Y"))
            return false;

        return true;
    }

    // alle special cases komen hier naar voren
    public int[] checkSpecialCases()
    {

        return null;
    }
}
