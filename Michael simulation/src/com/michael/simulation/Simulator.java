package com.michael.simulation;

public interface Simulator {

    public enum ServerStatus{
        BUSY, IDLE
    }

    public void initialize();
    public void timing();
    public void arrive();
    public void depart();
    public void report();
    public void update_time_avg_stats();
    public double expon(double mean);
}
