package com.michael.simulation;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class QueueSimulator implements Simulator {

    //variable declaration
    public final int Q_LIMIT = 100;

    public int nextEventType , numOfCustsDelayed, numOfDelaysRequired, numOfEvents;

    public double areaNumInQ , areaServerStatus, meanInterarrival, meanService, time,timeLastEvent,totalNumOfDelays;

    public ServerStatus serverStatus;

    public Queue<Double> timeOfArrival;
    public double [] timeNextEvent;

    public File input, output;


    public static void main(String [] args){

        QueueSimulator queue = new QueueSimulator();
        queue.initialize();
        /**
         * Input and output files
         */
        try{
            Scanner scan = new Scanner(new FileReader(queue.input));
            String str = "";
            while(scan.hasNextLine()){
                str = scan.nextLine();
            }

            String [] doubleStr = str.split(",");
            queue.meanInterarrival = Double.parseDouble(doubleStr[0]);
            queue.meanService = Double.parseDouble(doubleStr[1]);
            queue.numOfDelaysRequired = Integer.parseInt(doubleStr[2]);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }

        // run the simulation while more delays are still needed
        while(queue.numOfCustsDelayed < queue.numOfDelaysRequired){
            //determine the next event
            queue.timing();
            //update time average statistical accumulators
            queue.update_time_avg_stats();

            //invoke the appropriate event function

            switch(queue.nextEventType){
                case 1:
                    queue.arrive();
                    break;
                case 2:
                    queue.depart();
                    break;
            }

        }
        //invoke the report generator
        queue.report();
    }





    @Override
    public void initialize() {
        //initialize simulation clock
        time = 0;

        //initializing the arrays
        timeOfArrival = new PriorityQueue<Double>();
        timeNextEvent = new double[3];

        //file initialization
        input = new File("src\\input.txt");
        output = new File("src\\output.txt");


        // initialize the state variables
        serverStatus = ServerStatus.IDLE;
        timeLastEvent = 0;

        numOfEvents = 2;

        // initialize the statistical counters
        numOfCustsDelayed = 0;
        totalNumOfDelays = 0;
        areaNumInQ = 0;
        areaServerStatus = 0;

        // initialize event list. Since no customers are present, the departure event is eliminated from consideration

        timeNextEvent[1] = time + expon(meanInterarrival);
        timeNextEvent[2] = Math.pow(10,30);

    }

    @Override
    public void timing() {
        double minTimeNextEvent = Math.pow(10,29);
        nextEventType = 0;

        // dertermine the event type of the next event to occur
        for(int i = 1; i <= numOfEvents; i ++){
            if(timeNextEvent[i] < minTimeNextEvent){
                minTimeNextEvent = timeNextEvent[i];
                nextEventType = i;

            }
        }

        //check to see whether the event list is empty
        if(nextEventType == 0){
            /**
             * stop the simulation
             */
            //System.exit(0);
            return;
        }

        // the event list is not empty, so advance the simulation clock
        time = minTimeNextEvent;
    }

    @Override
    public void arrive() {

        double delay;
        //schedule next arrival
        timeNextEvent[1] = time + expon(meanInterarrival);

        //check to see whether the server is busy
        if(serverStatus == ServerStatus.BUSY) {

            //check to see whether the overflow exists
            if (timeOfArrival.size() + 1 > Q_LIMIT) {
                //stop simulation
                return;
            }
            timeOfArrival.add(time);


        }else{
            // server is idle, so arriving customer has a delay of zero
            // increment the number of customers delayed, and make server busy
            numOfCustsDelayed ++;
            serverStatus = ServerStatus.BUSY;

            //schedule a departure
            timeNextEvent[2] = time + expon(meanService);
        }

    }

    @Override
    public void depart() {
        double delay;

        //check to see if the queue is empty
        if(timeOfArrival.size() == 0){
            // the queue is empty so make the server idle and eliminate the departure
            serverStatus = ServerStatus.IDLE;
            timeNextEvent[2] = Math.pow(10,30);
        }else{
            // compute the delay of the customer who is beginning service and update the total delay accumulator
            delay = time - timeOfArrival.peek();
            totalNumOfDelays += delay;

            // increment the number of customers delayed, and schedule departure
            numOfCustsDelayed ++;
            timeNextEvent[2] = time + expon(meanService);

            // move each customer in the queue, up one place
            timeOfArrival.remove();
        }

    }

    @Override
    public void report() {
        /**
         * Make report
         */
        System.out.println("Average delay in queue "+ totalNumOfDelays/ numOfCustsDelayed + " minutes");
        System.out.println("Average number in queue " + areaNumInQ / time);
        System.out.println("Server utilization " + areaServerStatus/ time);
        System.out.println("Time simulation ended " + time);

        try{
            PrintWriter writer = new PrintWriter(new FileWriter(output,true),true);
            writer.println("Single server Queueing System");
            writer.println("");
            writer.println("Mean Inter-arrival time " + meanInterarrival +" minutes");
            writer.println("");
            writer.println("Mean service Time " + meanService +" minutes");
            writer.println("");
            writer.println("Number of customers " + numOfDelaysRequired);
            writer.println("Average delay in queue "+ totalNumOfDelays/ numOfCustsDelayed + " minutes.");
            writer.println("Average number in queue " + areaNumInQ / time);
            writer.println("Server utilization " + areaServerStatus/ time);
            writer.println("Time simulation ended " + time + " minutes.");
            writer.println("");

        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update_time_avg_stats() {
        double timeSinceLastEvent;

        // compute time since last event, and update last event time marker

        timeSinceLastEvent = time - timeLastEvent;
        timeLastEvent = time;

        //update area under number in queue function
        areaNumInQ += timeOfArrival.size() * timeSinceLastEvent;

        //update area under server-busy indicator function
        areaServerStatus += serverStatus.ordinal() * timeSinceLastEvent;

    }

    @Override
    public double expon(double mean) {

        //generate a random number using the exponential distribution

        return -mean * Math.log(Math.random());

    }
}
