package com.company;
import java.util.HashMap;

/**
 * Created by Pim on 17-3-2016.
 */
public class TrieNode {
        char c;
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean isLeaf;

        public TrieNode() {}

        public TrieNode(char c)
        {
            this.c = c;
        }

}
