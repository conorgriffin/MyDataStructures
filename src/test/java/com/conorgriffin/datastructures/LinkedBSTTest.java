package com.conorgriffin.datastructures;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedBSTTest {
    
    @Test
    public void testAssertions() {
        
        // test data
        LinkedBST<Integer> intTree = new LinkedBST<Integer>();
        for(int i = 1; i <= 10; i++) {
            intTree.insert(i);
        }
        
        assertFalse(intTree.lookup(0));
        assertFalse(intTree.lookup(11));

        assertTrue(intTree.lookup(1));
        assertTrue(intTree.lookup(10));
        assertTrue(intTree.toString().equals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]"));
        
        intTree.delete(5);
        assertTrue(intTree.toString().equals("[1, 2, 3, 4, 6, 7, 8, 9, 10]"));
    }
    
}
