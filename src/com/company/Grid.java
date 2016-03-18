package com.company;

/**
 * Created by Karen on 04-03-16.
 */

import java.io.*;



public class Grid {

    String[][] grid;
    Boolean[][] boolgrid;
    int height;
    int width;

    public Grid(String file){

        String[] input = Utilities.readFile(file);

        height = input.length;
        width = input[1].length();
        grid = new String[height][width];
        boolgrid = new Boolean[height][width];

        for(String s: input)
        {
            System.out.println(s);
        }
        System.out.println("je grid ziet er nu zo uit:");

        String letter;

        for(int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                letter = String.valueOf(input[i].charAt(j));
                grid[i][j] = letter;
            }
        }

        this.printGrid();
    }

    public Grid(){

        // los van een file doe dan niets
    }


    public String getValue(int hoogte, int breedte){

    String waarde = grid[hoogte][breedte];

    return waarde;
    }

    public void removeValue(int hoogte, int breedte){

        //schuif alle waarden een naar beneden die erboven liggen
        for(int i = 0; hoogte+1 < height; i++)
        {
            grid[hoogte+i][breedte] = grid[hoogte+i+1][width];
        }

    }

    public void resetBoard(Grid board){

    }

    public void printGrid(){
        for(int i = 0; i < height; i++)
        {

            for(int j = 0; j < width; j++)
            {

                System.out.print(grid[i][j] + " ");
            }

            System.out.print("\n");
        }
    }
}
