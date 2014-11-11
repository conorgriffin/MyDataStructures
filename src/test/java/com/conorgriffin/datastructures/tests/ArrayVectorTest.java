package com.conorgriffin.datastructures.tests;

import com.conorgriffin.datastructures.ArrayVector;
import com.conorgriffin.exceptions.BoundaryViolationException;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayVectorTest {
    
    private ArrayVector<Integer> av;
    Integer a = new Integer(1);
    Integer b = new Integer(2);
    Integer c = new Integer(3);
    Integer d = new Integer(4);
    Integer e = new Integer(5);
    
    @Before
    public void setUp() {
        av = new ArrayVector<Integer>(5);
    }
    
    @Test
    public void insertAtRankTest() {
        av.removeAllItems();
        assertTrue(av.toString().equals("[]"));
        assertTrue(av.size() == 0);
        
        av.insertAtRank(a, av.size());
        av.insertAtRank(c, av.size());
        av.insertAtRank(d, av.size());
        av.insertAtRank(e, av.size());
        av.insertAtRank(b, av.size());
        assertTrue(av.toString().equals("[1, 3, 4, 5, 2]"));
        assertTrue(av.size() == 5);
    }
    
    @Test
    public void replaceAtRankTest() {
        av.removeAllItems();
        av.replaceAtRank(a, 0);
        assertTrue(av.elementAtRank(0).equals(a));
        av.replaceAtRank(b, 0);
        assertTrue(av.elementAtRank(0).equals(b));
    }
    
    @Test
    public void removeAtRankTest() {
        av.removeAllItems();
        av.insertAtRank(a, av.size());
        av.insertAtRank(b, av.size());
        av.insertAtRank(c, av.size());
        assertTrue(av.size() == 3);
        av.removeAtRank(1);
        av.removeAtRank(1);
        assertTrue(av.toString().equals("[3]"));
        assertTrue(av.size() == 1);
        
        av.removeAtRank(1);
        assertTrue(av.toString().equals("[]"));
        assertTrue(av.size() == 0);
    }
    
    @Test
    public void removeItemAtRank0() {
        av.removeAllItems();
        av.insertAtRank(a, 0);
        assertTrue(av.size() == 1);
        av.removeAtRank(0);
        assertTrue(av.size() == 0);
    }
    
    @Test(expected=BoundaryViolationException.class)
    public void removeItemBeyondSize() {
        av.removeAtRank(av.size() + 1);
    }
    
    @Test(expected=BoundaryViolationException.class)
    public void removeItemAtNegativeRank() {
        av.removeAtRank(-1);
    }
    
    @Test(expected=BoundaryViolationException.class)
    public void insertItemAtNegativeRank() {
        av.insertAtRank(a, -1);
    }
    
    @Test(expected=BoundaryViolationException.class)
    public void insertItemBeyondSize() {
        av.insertAtRank(a, av.size() + 1);
    }
    
    @Test
    public void removeAllItemsTest() {
        av.removeAllItems();
        assertTrue(av.size() == 0);
        av.insertAtRank(a, 0);
        av.insertAtRank(b, 1);
        assertTrue(av.size() == 2);
        av.removeAllItems();
        assertTrue(av.size() == 0);
    }
    
    /**
     * Testing that the vector extends to twice its size if an item
     * is inserted while the vector is full
     */
    @Test
    public void extendVector() {
        av.removeAllItems();
        int assertedSize = 5;
        av.insertAtRank(a, av.size());
        av.insertAtRank(c, av.size());
        av.insertAtRank(d, av.size());
        av.insertAtRank(e, av.size());
        av.insertAtRank(b, av.size());
        assertTrue(av.size() == assertedSize);
        assertTrue(av.size() == av.getCapacity());
        av.insertAtRank(b, av.size());
        assertTrue(av.getCapacity() == assertedSize*2);
    }
    
    /**
     * nullify all the fields used
     */
    @After
    public void tearDown() {
        av = null;
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
    }
}
