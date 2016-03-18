package com.company;

import java.io.IOException;
import java.util.*;

public class Main{

    // om van een een ascii waarde een getal te maken
    private static final int asciiwaarde = 48;

    // main methode
    public static void main(String[] args) {

        // geef geen args mee
        if (args.length != 0)
        {
            System.out.println("\n\n Arg size invalid! \ngeef twee argumenten meegeven!");

            System.exit(1);
        }

        // lees het woordenboek uit de file
        ArrayList<String> woordenBoek =  Utilities.readFile("woordenlijst.txt");
        // maak hier een hashtable van

        Trie trie = Trie.fillTrie(woordenBoek);

        // zoeken of trie klopt
        //boolean search = T.search("abacadabra");
        //System.out.println(search);

        // maak een dubbele array van je grid

        Grid grid = new Grid("6x4_1.txt");

        // lees scores in
        Scoreboard scoreboard = new Scoreboard("jaeva_letterwaarden.txt");

        // test voor scores
        //int score = scoreboard.getScore("AaAaaa");

        //System.out.println(score);

        // maak een grid solver aan met de

        Solver solver = new Solver(trie, grid, scoreboard);
        solver.searchPath();
        // getClose geeft buren weer van een object


    }


}
