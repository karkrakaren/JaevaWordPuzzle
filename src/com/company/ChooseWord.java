package com.company;

/**
 * Created by Karen on 04-03-16.
 */

import java.io.*;



public class ChooseWord {

    public static BufferedReader letters;


    public void makeBoard() {




            Character[][] board = new Character[6][4];
            for(int i = 0; i < 6; i++){
                String line  = letters.readLine();
                Character[] letterLine = line.toCharArray();
                board[i] = letterLine;
                System.out.println(letterLine);
            }
    }
}
