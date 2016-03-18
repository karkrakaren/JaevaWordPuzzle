package com.company;
import java.util.ArrayList;

/**
 * Created by Pim on 17-3-2016.
 * maakt een int[] scoreboard van een ingelezen file van
 * met 1-26 = a-z
 * methodes om scores op te vragen
 */
public class Scoreboard {

    int[] scores;

    public Scoreboard(String file){

        ArrayList<String> stringscores = Utilities.readFile(file);
        scores = new int[stringscores.size()];

        for(int i = 0; i < scores.length; i++)
        {
            String line = stringscores.get(i);
            if(line.length() > 3) {
                scores[i] = line.charAt(2) - '0' + ('9' -'0');
            } else {
                scores[i] = line.charAt(2) - '0';
            }
            //System.out.println(scores[i] + "," + line);
        }
    }

    public int getScore(String word)
    {

        int score = 0;
        int index = 0;
        int multpl = 0;

        for(int i = 0; i < word.length(); i++)
        {


            char c = word.charAt(i);
            if((c == 'B') || (c == 'Y'))
            {
              score = 0;
            }
            else
            {
              index = c - 'a';
              multpl = 1;
            }

            score = score + scores[index] * multpl;
        }

        return score;
    }
}
