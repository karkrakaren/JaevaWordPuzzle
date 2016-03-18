package com.company;
import java.util.*;

/**
 * Created by Karen on 18-03-16.
 */
public class Node {
    private List<Node> children = null;
    String letters;
    int xCoord;
    int yCoord;
    Node parent = null;
    int count = 0;

    public Node(String letters, int xCoord, int yCoord)
    {
        this.children = new ArrayList<Node>();
        this.letters = letters;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public void addChild(Node child)
    {
        child.parent = this;
        children.add(child);
    }

    public Node toParent(){
        return parent;
    }

    public Node toChild(){
        return children.get(count++);
    }


}
