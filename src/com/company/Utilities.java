package com.company;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Pim on 11-3-2016.
 * code geschreven om bestanden in te lezen
 * ook een hashtable bij een vorige implementatie van het woordenboek
 */
public class Utilities {

    public static BufferedReader reader;

    // maakt een string[] van letters in een file
    public static String[] readFile(String filename) {
        try {
            reader = new BufferedReader(new FileReader(filename));
        }
        // standaard foutmelding
        catch (Exception e) {
            System.out.println("Error.");
        }

        int count = 0;

        // manier vinden om uit te zoeken hoeveel lines een files heeft zodat de array die lengte is
        /*
        while(file.hasNextLine())
        {
            count++;
            file.nextLine()
        }
        */

        // array is x aantal lang
        String[] readWords = new String[1000000];
        // maak counter
        //int count = 0;

        // vul je array met woorden
        while (true) {
            try {
                String word = reader.readLine();
                readWords[count] = word;
                if (word == null) {
                    break;
                }
                //System.out.println(word);
                count++;
            } catch (Exception e) {
                System.out.println("Error.");
                break;
            }
        }

        String[] output = new String[count];

        for(int i = 0; i < count; i++)
        {
           output[i] = readWords[i];
        }

        // return de woorden die je gelezen hebt
        return output;
    }

        public static String [] createHashtable(String[] readWords){

            String[] woordenBoek = new String[readWords.length];
            int counter = 0;

            for(String s: readWords)
            {
                //System.out.println(counter);

                if(s == null)
                {
                    break;
                }

                //System.out.println(counter);
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
            System.out.println("Woordenboek ingeladen!");

            // geef table terug aan main


            return woordenBoek;
    }
}
