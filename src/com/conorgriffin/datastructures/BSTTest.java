package com.conorgriffin.datastructures;

import java.util.Random;

public class BSTTest {
    public static void main(String[] args) {
        LinkedBST<Integer> intTree = new LinkedBST<Integer>();
        long time = System.currentTimeMillis();
        for(int i = 0; i < 10000000; i++) {
            int randInt = randInt(1, 20);
            //System.out.println(randInt);
            intTree.insert(randInt);
        }
        time -= System.currentTimeMillis();
        System.out.println(intTree.toString());
        System.out.println("Time in seconds: " + Math.abs(time/1000.0));
        System.out.println("Tree contains 3: " + intTree.lookup(3));
        System.out.println("Tree contains 6: " + intTree.lookup(6));
        System.out.println("Tree contains 26: " + intTree.lookup(26));
    }
    
    public static int randInt(int min, int max) {

        // Usually this should be a field rather than a method variable so
        // that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
