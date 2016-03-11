package com.company;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Pim on 11-3-2016.
 */
public class Utilities {

    public static BufferedReader reader;

    // maakt een hashtable van het woordenboek
    public static String[] readFile(String filename) {
        try {
            reader = new BufferedReader(new FileReader(filename));
        }
        // standaard foutmelding
        catch (Exception e) {
            System.out.println("Error.");
        }

        int count = 0;
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

        // return de woorden die je gelzen hebt
        return readWords;
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

    public static String[] createScoreboard(String file){

    //String[] scores = Utilities.readFile(file);

    return null;
    }
}
