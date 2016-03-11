package com.company;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static BufferedReader reader;

    public static void main(String[] args) {


        String[] woordenBoek =  readFile("woordenlijst.txt");
        String sample = "null" ;
        String functie = "null" ;

        /*// arg grootte 1
        if (args.length == 1)
        {
            // is de file naam
            sample = args[0];

        }
        else
        {
            System.out.println("\n\nArg size invalid!\nAdd sample.txt as args[0]!");
            System.exit(1);
        }
        */

    }
    // maakt een hashtable van het woordenboek
    private static String[] readFile(String filename) {
            try {
                reader = new BufferedReader(new FileReader(filename));
            }
            // standaard foutmelding
            catch(Exception e) {
                System.out.println("Error.");
            }

            // array is x aantal lang
            String[] readWords = new String[1000000];
            // maak counter
            int count = 0;

            // vul je array met woorden
            while(true) {
                try {
                    String word = reader.readLine();
                    readWords[count] = word;
                    if(word == null) {
                        break;
                    }
                    //System.out.println(word);
                    count++;
                }
                catch(Exception e) {
                    System.out.println("Error.");
                    break;
                }
            }

            System.out.println(count);

           String[] woordenBoek = new String[count];
        int counter = 0;

        for(String s: readWords)
        {

           if(s == null)
           {
               break;
           }

            System.out.println(counter);
            counter++;

            // maak hash (identiek aan OA, zie comments daar)

            int hash = 3;

            for (int i = 0; i < s.length(); i++)
            {
                //System.out.println(hash);
                hash = (hash*13 + (int)s.charAt(i));
                hash = hash%(woordenBoek.length);
            }

            // stop een waarde in de array op een lege plek
            if(woordenBoek[hash] == null || woordenBoek[hash].isEmpty())
            {

                woordenBoek[hash] = s;

            }
            else
            {
                // als er daar geen lege plek is, append dan je waarde eraan
                woordenBoek[hash] += " " + s;


            }




        }

        // laat zien dat er een hashtable gemaakt is
        System.out.println("Succesfully created a hashtable!");

        // geef table terug aan main


            return woordenBoek;
        }
}
