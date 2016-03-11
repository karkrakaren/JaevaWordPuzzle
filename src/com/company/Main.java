package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    // om van een een ascii waarde een getal te maken
    private static final int asciiwaarde = 48;

    public static void main(String[] args) {



        // geef geen args mee
        if (args.length != 0)
        {
            System.out.println("\n\n Arg size invalid! \n geen argumenten meegeven!");
            System.exit(1);
        }

        // vraag user om hoogte van de grid
        System.out.println("Geef hoogte in van je grid:\nmogelijke hoogtes: 6");


        int hoogte = 0;

        // met try en catch om errors te voorkomen
        while(hoogte != 6)
        {
            hoogte = 0;
            try {
                // read wat de user input
                hoogte = System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("incorrecte waarde!");
            }
            // userinput is in ascii, dus doe -48 voor het getal
            hoogte -= asciiwaarde;

        }

        // exact hetzelfde alleen nu voor de breedte (zie boven voor hoogte)
        System.out.println("Geef breedte in van je grid:\nmogelijke breedes: 4");

        int breedte = 0;

        while (breedte != 4) {

            try {
                breedte = System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("incorrecte waarde!");
            }

            breedte -= asciiwaarde;

        }

        // lees het woordenboek uit de file
        String[] woordenBoek =  Utilities.readFile("woordenlijst.txt");
        // maak hier een hashtable van
        woordenBoek = Utilities.createHashtable(woordenBoek);

        // maak een dubbele array van je grid
        String[][] Board = Grid.makeBoard(breedte, hoogte);

        // lees scores in
        String[] letterwaarde = Utilities.createScoreboard("jaeva_letterwaarden.txt");


    }

}
