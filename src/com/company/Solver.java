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
    ArrayList<GridPoint> path;
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

        //while(!inputBoard.isEmpty())
        //{
            System.out.println();

            // deze functie gaat nu 1 niveau diep
            for (int i = 0; i < inputBoard.height; i++)
            {
                // for colums
                for (int j = 0; j < inputBoard.width; j++) {
                    // ik wil elk punt op buren checken

                    path = new ArrayList<>();

                    GridPoint source = inputBoard.getPoint(i,j);
                    //System.out.println(source.getString());

                    //source.print();

                    boolean b = path.addAll(searchNeighbours(source));
                    //System.out.println(path);

                    // alle die daarvan woordbeginsels zijn
                    // vormen een mogelijke path
                    // voeg al je woordbeginsels toe aan je array

                    if(!path.isEmpty())
                    {
                        allPaths.add(path);
                    }

                }

            }



            //System.out.println(allPaths.size());
            path.clear();

            for(int k = 0; k < allPaths.size(); k++)
            {


                ArrayList<GridPoint> temp = allPaths.get(k);

                //doe iets
                for(GridPoint p: temp)
                {

                       int i = p.getIndexh();
                       int j = p.getIndexb();
                       GridPoint source = inputBoard.getPoint(i,j);
                       boolean b = path.addAll(searchNeighbours(source));



                }

                allPaths.add(k, path);
                System.out.println(allPaths);
            }



        //}


        /*
        for(ArrayList<String> s: allPaths)
        {

            for(String w: s)
            {
                System.out.println(w);
            }

        }
        */


    }

    // checkt of er onderdelen van een woord in een array zitten
    // zo niet gooit ze eruit

    // functies voor alle mogelijke letters rondom een woord
    public ArrayList<GridPoint> searchNeighbours(GridPoint source) {

        ArrayList<GridPoint> neighbours = new ArrayList<>();
        int indexh = source.getIndexh();
        int indexb = source.getIndexb();
        // maak een value aan
        GridPoint value;
        //int counter= 0;

        //ga na alle waarden om het punt heen kijken
        // hier met een try en catch + switch
        // (elke punt heeft 8 mogelijke buren)

            for (int i = 0; i < BUREN; i++) {
                try {


                    // implementatie van links-boven van links naar rechts
                    switch (i) {

                        //linksboven
                        case 0:
                            value = inputBoard.getPoint(indexh - 1, indexb - 1);
                            break;
                        //middenboven
                        case 1:
                            value = inputBoard.getPoint(indexh - 1, indexb);
                            break;

                        //rechtsboven
                        case 2:
                            value = inputBoard.getPoint(indexh - 1, indexb + 1);
                            break;

                        //links zijkant
                        case 3:
                            value = inputBoard.getPoint(indexh, indexb - 1);
                            break;

                        //rechts zijkant
                        case 4:
                            value = inputBoard.getPoint(indexh, indexb + 1);
                            break;

                        //links onder
                        case 5:
                            value = inputBoard.getPoint(indexh + 1, indexb - 1);
                            break;

                        //midden onder
                        case 6:
                            value = inputBoard.getPoint(indexh + 1, indexb);
                            break;

                        //rechts onder
                        case 7:
                            value = inputBoard.getPoint(indexh + 1, indexb + 1);
                            break;

                        default:
                            value = null;
                            break;
                    }
                }
                catch(NullPointerException e)
                {
                    continue;
                }

                if(value == null)
                {
                    continue;
                }
                //System.out.println(value);

                // bij het niet bestaan van deze waarde in de array is er een erroy
                //System.out.println("deze variabele ligt over de rand");
                // deze catch is puur om de error te voorkomen als we de Array out of bounds krijgen


                // checken of het een woorddeel is wordt gedaan met een functie uit de tree
                // een woordpart de oorspronkelijke letter + de buur waar je op zocht
                // die true of false return bij het bestaan van een deel van dat woord


                String wordPart = source.getString() + value.getString();

                boolean isWord = inputTrie.startsWith(wordPart);

                //System.out.println(isWord);

                //als het een woord is voeg het dan toe aan je mogelijke te nemen paden

                GridPoint point = source.add(value);

                if (isWord && checkValue(wordPart))
                {

                    if(inputTrie.search(wordPart+" ") == false)
                    {
                    //source.remove();
                    }


                    neighbours.add(point);
                }


        }

        //neighbours.remove(source.getString());

        /*
        for(String s: neighbours)
        {
            System.out.println(s);
        }
        */
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
