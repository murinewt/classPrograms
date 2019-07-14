package com.newt.pizza;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PizzaReader {
	
	
	public static char[] arrayMaker(String line){
		char [] arr = new char[line.length()];
		
		for(int i = 0; i < line.length(); i ++){
			
			arr[i] = line.charAt(i);	
		}
		return arr;
	}
	
	
	
	public static void main(String [] args){
		
		int row = 0, column = 0,minIng = 0 , maxCells = 0 ,count = 0, rowCounter = 0;
		
		char[][] charArr = null;
		Scanner scan = null;
		
		try {
			scan = new Scanner(new File("F:\\Java\\Pizza\\src\\com\\newt\\pizza\\files\\medium.in"));
			
			while(scan.hasNext()){
				if(count == 0){
					count ++;
					String nums = scan.nextLine();
					String[] arr = nums.split(" ");
					
					row = Integer.parseInt(arr[0]);
					column = Integer.parseInt(arr[1]);
					minIng = Integer.parseInt(arr[2]);
					maxCells = Integer.parseInt(arr[3]);
					charArr = new char[row][column];
					
					System.out.println("rows  = "+row +" column = "+column +" minimum Ingridients = " + minIng + " Maximum Cells = "+ maxCells );
				}else{
					
					charArr[rowCounter] = arrayMaker(scan.nextLine());
					rowCounter ++;	
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			scan.close();
		}
		
		System.out.println(charArr[0]);
		
		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter(new File("F:\\Java\\Pizza\\src\\com\\newt\\pizza\\files\\output.txt"));
			
			writer.println("rows  = "+row +" column = "+column +" minimum Ingridients = " + minIng + " Maximum Cells = "+ maxCells);
			
			for(int i = 0; i < row ; i ++){
				writer.println(charArr[i]);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			writer.close();
		}
		
	}

}
