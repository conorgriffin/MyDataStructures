package com.conorgriffin.datastructures.tests;

import org.junit.Test;

import com.conorgriffin.datastructures.LinkedBST;

import static org.junit.Assert.*;

public class LinkedBSTTest {
    
    @Test
    public void testAssertions() {
        
        // test insert, lookup and delete operations on Binary Search Tree implementation LinkedBST.java
        LinkedBST<Integer> intTree = new LinkedBST<Integer>();

        // test inserts
        intTree.insert(2);
        intTree.insert(10);
        intTree.insert(3);
        intTree.insert(6);
        intTree.insert(1);
        assertTrue(intTree.toString().equals("[1, 2, 3, 6, 10]"));
        intTree.insert(7);
        intTree.insert(4);
        intTree.insert(5);
        intTree.insert(8);
        intTree.insert(9);
        assertTrue(intTree.toString().equals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]"));
        
        // test lookups
        assertFalse(intTree.lookup(0));
        assertFalse(intTree.lookup(11));
        assertTrue(intTree.lookup(1));
        assertTrue(intTree.lookup(10));
        
        // test deletes
        intTree.delete(5);
        assertTrue(intTree.toString().equals("[1, 2, 3, 4, 6, 7, 8, 9, 10]"));
        intTree.delete(1);
        assertTrue(intTree.toString().equals("[2, 3, 4, 6, 7, 8, 9, 10]"));
        
    }
    
}
