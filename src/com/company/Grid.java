package com.company;

/**
 * Created by Karen on 04-03-16.
 */

import java.io.*;



public class Grid {

    public static String[][] makeBoard(int breedte, int hoogte, String file) {

        String[] input = Utilities.readFile(file);
        String[][] grid = new String[hoogte][breedte];

        System.out.println("je grid ziet er nu zo uit:");
        for(int i = 0; i < hoogte; i++)
        {

            for(int j = 0; j < breedte; j++)
            {

                String letter = String.valueOf(input[i].charAt(j));
                System.out.print(letter + " ");

                grid[i][j] = letter;

            }

            System.out.print("\n");
        }

        return grid;
    }

}
