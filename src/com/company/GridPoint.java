package com.company;

import java.util.*;

/**
 * Created by Pim on 18-3-2016.
 */
public class GridPoint {

    List<Integer> indexh;
    List<Integer> indexb;
    String value;

    GridPoint(int h, int b, String value){
        this.indexh = new ArrayList<>();
        this.indexh.add(h);
        this.indexb = new ArrayList<>();
        this.indexb.add(b);

        this.value = value;

        //this.print();
    }

    public boolean isEmpty()
    {
        if(this.value == null)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public int getIndexh(){
        return this.indexh.get(0);

    }

    public int getIndexb(){
        return this.indexb.get(0);
    }

    public void setIndexh(int height){
        this.indexh.set(0,height);
    }

    public void remove(){

        this.remove();
    }

    public String getString()
    {

        return this.value;
    }

    public void print(){
        System.out.println(this.indexh);
        System.out.println(this.indexb);
        System.out.println(this.value);
    }

    public GridPoint add(GridPoint p){
        this.value = value + p.getString();
        this.indexh.add(p.getIndexh());
        this.indexb.add(p.getIndexb());

        return this;
    }
}
