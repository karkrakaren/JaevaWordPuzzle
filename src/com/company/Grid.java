package com.company;
import java.io.*;
import java.util.*;

/**
 * Created by Karen on 04-03-16.
 * maakt een grid van een aantal variabelen uit een file
 */



public class Grid {

    ArrayList<GridPoint> grid;
    int height;
    int width;

    public Grid(String file){

        ArrayList<String> input = Utilities.readFile(file);

        height = input.size();
        width = input.get(0).length();
        grid = new ArrayList<GridPoint>();


        System.out.println("je grid ziet er nu zo uit:");

        String letter;

        for(int i = 0; i < height; i++)
        {
            for (int j = 0; j < width; j++)
            {
                letter = String.valueOf(input.get(i).charAt(j));
                grid.add(new GridPoint(i, j, letter));

            }
        }

        this.printGrid();
    }

    public Grid(){

        // los van een file doe dan niets
    }


    public String getValue(int hoogte, int breedte){

        for(GridPoint p: grid)
        {
            if(p.getIndexb() == hoogte && p.getIndexh() == breedte)
                return p.getString();
        }

    return null;
    }

    public GridPoint getPoint(int hoogte, int breedte){
        for(GridPoint p: grid)
        {
            if(p.getIndexh() == hoogte && p.getIndexb() == breedte)
                return p;
        }

        return null;
    }

    public void removeValue(int hoogte, int breedte){

        //schuif alle waarden een naar beneden die erboven liggen

            for(GridPoint p: grid )
            {
                if(p.getIndexb() == hoogte && p.getIndexh() == breedte)
                   p.setIndexh(hoogte);
            }

    }

    public boolean isEmpty(){

        for(GridPoint p: grid)
        {
              if(!p.isEmpty())
                  return false;
        }

        return true;
    }

    public void printGrid(){

        int lastHeight = -1;
        for(GridPoint p: grid)
        {

            if(lastHeight != p.getIndexh() )
                System.out.println();

            System.out.print(p.getString() + " ");

            lastHeight = p.getIndexh();


        }


    }
}
