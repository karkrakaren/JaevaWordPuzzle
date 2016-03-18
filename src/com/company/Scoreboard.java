package com.company;

/**
 * Created by Pim on 17-3-2016.
 */
public class Scoreboard {

    int[] scores;

    public Scoreboard(String file){

        String[] stringscores = Utilities.readFile(file);
        scores = new int[stringscores.length];

        for(int i = 0; i < scores.length; i++)
        {
            String line = stringscores[i];
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
