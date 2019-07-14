package com.michael.simulation;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTester {

    public static void main(String [] args){
        Queue<Integer> pool = new PriorityQueue<>();

        pool.add(1);
        pool.add(20);

        while(!pool.isEmpty()){
            System.out.println("The element available "+ pool.poll());
        }
    }
}
