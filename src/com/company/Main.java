package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main{

    // om van een een ascii waarde een getal te maken
    private static final int asciiwaarde = 48;

    public static void main(String[] args) {

        // geef geen args mee
        if (args.length != 0)
        {
            System.out.println("\n\n Arg size invalid! \n geen argumenten meegeven!");
            System.exit(1);
        }

        // lees het woordenboek uit de file
        String[] woordenBoek =  Utilities.readFile("woordenlijst.txt");
        // maak hier een hashtable van

        Trie trie = Trie.fillTrie(woordenBoek);

        // zoeken of trie klopt
        //boolean search = T.search("abacadabra");
        //System.out.println(search);

        // maak een dubbele array van je grid
        Grid grid = new Grid("6x4_1.txt");

        // lees scores in
        Scoreboard scoreboard = new Scoreboard("jaeva_letterwaarden.txt");

        int score = scoreboard.getScore("AaAaaa");

        System.out.println(score);

        Solver solver = new Solver(trie, grid, scoreboard);
    }

}
