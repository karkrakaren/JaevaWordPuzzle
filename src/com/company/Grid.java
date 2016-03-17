package com.company;

/**
 * Created by Karen on 04-03-16.
 */

import java.io.*;



public class Grid {

    String[][] grid;

    public Grid(String file){

        String[] input = Utilities.readFile(file);

        int hoogte = input.length;
        int breedte = input[1].length();
        grid = new String[hoogte][breedte];

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
    }

    public String getValue(int hoogte, int breedte){

    String waarde = grid[hoogte][breedte];

    return waarde;
    }

    public void resetBoard(Grid board){

    }
}
