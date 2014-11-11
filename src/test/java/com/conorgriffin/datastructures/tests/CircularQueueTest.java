package com.conorgriffin.datastructures.tests;

import com.conorgriffin.datastructures.CircularQueue;
import com.conorgriffin.exceptions.EmptyQueueException;
import com.conorgriffin.exceptions.FullQueueException;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircularQueueTest {

    @Test
    public void testAssertions() throws FullQueueException, EmptyQueueException {
        CircularQueue<String> queue = new CircularQueue<String>(10);

        String a = new String("A");
        queue.enqueue(a);
        assertTrue(queue.dequeue().toString().equals("A"));
        
        String b = new String("B");
        String c = new String("C");
        String d = new String("D");
        String e = new String("E");
        String f = new String("F");
        String g = new String("G");
        String h = new String("H");
        String i = new String("I");
        String j = new String("J");
        
        
    }
//    public void testCircularQueue() {
//        fail("Not yet implemented");
//    }
//
//    @Test
//    public void testEnqueue() {
//        fail("Not yet implemented");
//    }
//
//    @Test
//    public void testSize() {
//        fail("Not yet implemented");
//    }
//
//    @Test
//    public void testDequeue() {
//        fail("Not yet implemented");
//    }
//
//    @Test
//    public void testIsEmpty() {
//        fail("Not yet implemented");
//    }
//
//    @Test
//    public void testIsFull() {
//        fail("Not yet implemented");
//    }
//
//    @Test
//    public void testHead() {
//        fail("Not yet implemented");
//    }

}
