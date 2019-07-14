package queue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Que {
	static final int Q_LIMIT = 100;
	static final int BUSY = 1;
	static final int IDLE = 0;
	static int next_event_type, num_custs_delayed;
	static int num_delays_required, num_events, num_in_q, server_status;
	static double area_num_in_q, area_server_status, mean_interarrival, mean_service;
	static double time, time_last_event, total_of_delays;
	static double[] time_arrival = new double[Q_LIMIT+1];
	static double[] time_next_event = new double [3];
	static File inFile = new File("F:\\mm1.in");
	static File outFile = new File("F:\\mm2.out");
	static PrintWriter writer = null;
	static Scanner scan;
	
	public static void main(String[] args) {
	
		num_events =2;
		try{
		scan = new Scanner(inFile);
		
		while(scan.hasNext()){
			String nums = scan.nextLine();
			String[] arr = nums.split(" ");
			mean_interarrival = Double.parseDouble(arr[0]);
			mean_service = Double.parseDouble(arr[1]);
			num_delays_required = Integer.parseInt(arr[2]);	
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			scan.close();
		}
		
		try {
			writer = new PrintWriter(outFile);
			writer.println("Single Server Queueing System");
			writer.printf("\nMean Interarrival time %11.3f\n",mean_interarrival);
			writer.println();
			writer.printf("\nMean Service Time %16.3f minutes",mean_service);
			writer.println();
			writer.printf("Number of Customers %14d",num_delays_required);
			writer.println();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		initialize();
		
		while(num_custs_delayed<num_delays_required){
			timing();
			update_time_avg_stats();
			
			switch(next_event_type){
			case 1:
				arrive();
				break;
			case 2:
				depart();
				break;
			}
			
		}
		
		report();
		writer.close();
		scan.close();
	}
	
	static void initialize(){
		time = 0.0;
		
		server_status = IDLE;
		num_in_q =0;
		time_last_event =0.0;
		
		num_custs_delayed = 0;
		total_of_delays = 0;
		area_num_in_q = 0.0;
		
		time_next_event[1] = time+expon(mean_interarrival);
		time_next_event[2] = Math.pow(10, 30);
		
	}
	static void timing(){
		int i;
		double min_time_next_event = Math.pow(10, 29);
		next_event_type = 0;
		
		for(i=1;i<=num_events;i++){
			if(time_next_event[i]<min_time_next_event){
					min_time_next_event = time_next_event[i];
					next_event_type = i;
			}
		}
		
		if(next_event_type == 0){	
				writer.println("Event List empty at time "+time);
		}
		
		time =min_time_next_event;
	}
	static void arrive(){
		double delay;
		
		time_next_event[1] = time + expon(mean_interarrival);
		
		if(server_status==BUSY){
			num_in_q++;
			
			if(num_in_q+1>Q_LIMIT){
					writer.println("Overflow of the array time_arrival at time "+time);
			}
			
			time_arrival[num_in_q] = time;
		}
		else{
			delay = 0.0;
			total_of_delays += delay;
			
			num_custs_delayed++;
			server_status = BUSY;
			
			time_next_event[2] = time + expon(mean_service);
		}
	}
	static void depart(){
		int i;
		double delay;
		if(num_in_q==0){
			server_status =IDLE;
			time_next_event[2] = Math.pow(10, 30);
		}
		else{
			num_in_q--;
			
			delay = time - time_arrival[1];
			total_of_delays += delay;
			
			num_custs_delayed++;
			time_next_event[2] = time +expon(mean_service);
			
			for(i=1;i<=num_in_q;i++){
				time_arrival[i] = time_arrival[i+1];
			}
		}
		
	}
	static void report(){
			writer.printf("\n\nAverage delay in queue %11.3f minutes ",total_of_delays/num_custs_delayed);
			writer.println();
			writer.printf("\nAverage number in queue %10.3f\n",area_num_in_q/time);
			writer.println();
			writer.printf("\nServer utilization %15.3f",area_server_status/time);
			writer.println();
			writer.printf("Time simulation ended %12.3f",time);
			
	}
	static void update_time_avg_stats(){
		
		double time_since_last_event;
		time_since_last_event =time-time_last_event;
		time_last_event = time;
		
		area_num_in_q += num_in_q * time_since_last_event;
		
		area_server_status += server_status * time_since_last_event;
		
	}
	static double expon(double mean_interarrival2){
		double u;
		//u = Randomizer.rand(1);
		u = Math.random();
		
		return -mean_interarrival2*Math.log(u);
		//return Math.exp(mean_interarrival2);
	}

}
