package com.company;

/**
 * Created by Karen on 04-03-16.
 */

import java.io.*;



public class ChooseWord {

    public static BufferedReader letters;


    public void makeBoard() {


        private static String[] readfile("6x4_1.txt") {
            try {
                letters = new BufferedReader(new FileReader("6x4_1.txt"));
            }
            catch(Exception e) {
                System.out.println("Error.");
            }

            Character[][] board = new Character[6][4];
            for(int i = 0; i < 6; i++){
                String line  = letters.readLine();
                Character[] letterLine = line.toCharArray();
                board[i] = letterLine;
                System.out.println(letterLine);
            }
    }
}
