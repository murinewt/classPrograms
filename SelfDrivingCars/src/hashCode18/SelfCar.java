package hashCode18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class SelfCar {
	
	static int row = 0, column = 0, vehicle = 0;
	static int rides = 0;
	static int bonus=0, maxSteps=0, rowCounter = 0;
	static int [] numA = null; 
	static int [] numB= null;
	static int [] numX= null;
	static int [] numY= null; 
	static int [] earlyStart= null;
	static int [] lateFinish= null;
	static LinkedHashMap<Integer, Integer> carRide1 = new LinkedHashMap<Integer, Integer>();
	static LinkedHashMap<Integer, List<Integer>> carRide = new LinkedHashMap<Integer, List<Integer>>();
	
	public static void main(String [] args) throws InterruptedException{
		
		int  count = 0;
		//int numA=0, numB=0, numX=0, numY=0, earlyStart=0, lateFinish=0;
		
		Scanner scan = null;
		
		try {
			scan = new Scanner(new File("F:\\Java\\SelfDrivingCars\\src\\hashCode18\\mine.in"));
			
			while(scan.hasNext()){
				if(count == 0){
					count ++;
					String nums = scan.nextLine();
					String[] arr = nums.split(" ");
					
					row = Integer.parseInt(arr[0]);
					column = Integer.parseInt(arr[1]);
					vehicle = Integer.parseInt(arr[2]);
					rides = Integer.parseInt(arr[3]);
					bonus = Integer.parseInt(arr[4]);
					maxSteps = Integer.parseInt(arr[5]);
					
					numA = new int[rides];
					numX = new int[rides];
					numB = new int[rides];
					numY = new int[rides];
					earlyStart = new int[rides];
					lateFinish = new int[rides];
					System.out.println("rows  = "+row +" column = "+column +" vehicles = " + vehicle + " rides = "+ rides+" Max Steps = "+maxSteps );
				}else{
					String coord=scan.nextLine();
					String [] coordi = coord.split(" ");
					numA[rowCounter] = Integer.parseInt(coordi[0]);
					numB[rowCounter] = Integer.parseInt(coordi[1]);
					numX[rowCounter] = Integer.parseInt(coordi[2]);
					numY[rowCounter] = Integer.parseInt(coordi[3]);
					earlyStart[rowCounter] = Integer.parseInt(coordi[4]);
					lateFinish[rowCounter] = Integer.parseInt(coordi[5]);
					rowCounter ++;	
					//}
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			scan.close();
		}
		int[][] car = new int[vehicle][10];
		//final int xyz= rides;
		//System.out.println(numA[0]+" "+numA[1]+" "+" " );
		
		
		LinkedHashMap<Integer,Integer> dictTotal = new LinkedHashMap<Integer,Integer>();
		
		LinkedHashMap<Integer,Integer> dictAll = new LinkedHashMap<Integer,Integer>();
		LinkedHashMap<Integer,Integer> dictStart = new LinkedHashMap<Integer,Integer>();
		LinkedHashMap<Integer,Integer> dictEnd = new LinkedHashMap<Integer,Integer>();
		LinkedHashMap<Integer,Integer> dictLate_All = new LinkedHashMap<Integer,Integer>();
		
		int[] orgStart, startEnd,totalStep,allSteps,late_all;
		orgStart = new int[rides];
		startEnd = new int[rides];
		totalStep = new int[rides];
		allSteps = new int[rides];
		late_all = new int[rides];
		for(int x=0;x<rides;x++){
			orgStart[x]=Math.abs(numA[x] - 0) + Math.abs(numB[x] - 0);
			startEnd[x] = Math.abs(numA[x] - numX[x]) + Math.abs(numB[x] - numY[x]);
			totalStep[x] = orgStart[x]+startEnd[x];
			allSteps[x] = totalStep[x]+earlyStart[x];
			late_all[x] = lateFinish[x]-allSteps[x];
			dictTotal.put(x, totalStep[x]);
			dictAll.put(x, allSteps[x]);
			dictStart.put(x, orgStart[x]);
			dictEnd.put(x, startEnd[x]);
			dictLate_All.put(x, late_all[x]);
		}
		/*for(int x=0;x<5;x++){
			System.out.println("org "+orgStart[x]+" end "+startEnd[x]+" total Steps "+totalStep[x]+" including start"+allSteps[x]);
		}*/
		/*for(int x=0;x<rides;x++){
			System.out.println(" old: "+totalStep[x]);
		}
		*/
		
		System.out.println("origin and Start Point = "+dictTotal);
		
		LinkedHashMap<Integer,Integer> newDictTotal = sortByValue(dictTotal);
		LinkedHashMap<Integer,Integer> newDictTotal1 = sortByValue(dictTotal);
		LinkedHashMap<Integer,Integer> newDictAll = sortByValue(dictAll);
		LinkedHashMap<Integer,Integer> newDictStart = sortByValue(dictStart);
		LinkedHashMap<Integer,Integer> newDictEnd = sortByValue(dictEnd);
		//LinkedHashMap<Integer,Integer> lateFinishH = sortByValue(dictLate_All);
		
		LinkedHashMap<Integer, Integer> carRide1= popOut1(newDictTotal1,0,vehicle);
		LinkedHashMap<Integer, List<Integer>> carRide= popOut(newDictTotal,0,vehicle);
		
		
		
		
		PrintWriter writer = null;
		System.out.println(carRide);
		System.out.println(carRide1);
		System.out.println("***"+dictLate_All);
		
		nextRide(carRide,carRide1,newDictAll,rides,dictLate_All);
		
		Collection<List<Integer>> usedCar = carRide.values();
		List<Integer> a=usedCar.iterator().next();
		System.out.println("qwertgfdd   "+a);
		Collection<Integer> newRide = carRide1.keySet();
		//List<Integer> b=usedCar.iterator().next();
		
		Iterator<List<Integer>> iter; // Declare the iterator variable.
		iter = usedCar.iterator(); // Get an iterator for the collection.
		
		Iterator<Integer> iterate; // Declare the iterator variable.
		iterate = newRide.iterator();
		
		System.out.println(newRide);
		int q=0;
		
		LinkedHashMap<Integer,List<Integer>> anotherDist = new LinkedHashMap<Integer,List<Integer>>();
		
		int A=0,b=0;
		int itemx =0;
		while(iterate.hasNext()&&q<carRide1.size()){
			itemx = iterate.next(); // Get the next item.
			System.out.println(itemx);
			
			A=numA[itemx];
			b=numB[itemx];
			System.out.println("A= "+A+" b="+b);
				
		}
		while ( iter.hasNext()&&q<vehicle ) {
			List<Integer> item = iter.next(); // Get the next item.
			System.out.println(item);
			Object[] items = item.toArray();
			int x= (int) items[q];
			//System.out.println(x);
			int X,y;
			X=numX[x];
			y=numY[x];
			
			System.out.println("X= "+X+" Y= "+y);
			
			int dist = Math.abs(numA[itemx] - numX[x]) + Math.abs(numB[itemx] - numY[x]);
			
			List listA = new ArrayList(); 
			listA.add(x);
			listA.add(dist);
			System.out.println("dist "+ dist);
			anotherDist.put(itemx, listA);
			System.out.println("dictionary: "+ anotherDist);
		}
		
			
		
	}
	
	
	
	
	public static void kituIngine(){
		
		
			
	}
	

	private static  LinkedHashMap<Integer, List<Integer>> nextRide(LinkedHashMap<Integer, List<Integer>> carRide,
			LinkedHashMap<Integer, Integer> newDictAll, LinkedHashMap<Integer, Integer> newDictAll2, 
			int rides, LinkedHashMap<Integer, Integer> dictLate_All) {
		
		// TODO Auto-generated method stub
		//shortest total time 
		//lateFinish-totaltime = lateFinishH
		
		
		return carRide;
	}

	private static LinkedHashMap<Integer, Integer> sortByValue(LinkedHashMap<Integer, Integer> map) {
		// TODO Auto-generated method stub
		List<Entry<Integer,Integer>>list=new LinkedList<Entry<Integer,Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>()
		{
			public int compare(Map.Entry<Integer, Integer>o1,Map.Entry<Integer, Integer>o2){
				return( o1.getValue()).compareTo(o2.getValue());
			}
		});
		LinkedHashMap<Integer, Integer>sortedMap = new LinkedHashMap<Integer,Integer>();
		for(Map.Entry<Integer, Integer>entry:list){
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		System.out.println(sortedMap);
		return sortedMap;
		
	}
	public static LinkedHashMap<Integer, List<Integer>> popOut(LinkedHashMap<Integer, Integer> map,int start,int stop){
		ArrayList <Integer> arrList= new ArrayList<Integer>(map.keySet());
		//System.out.print(arrList);
		LinkedHashMap<Integer,List<Integer>> returnIt = new LinkedHashMap<Integer,List<Integer>>();
		
		for(int x=start;x<stop;x++){
			List<Integer> ridess= new ArrayList<Integer>();
			int xyz = arrList.get(0);
			//System.out.println(xyz);
			arrList.remove(0);
			map.remove(xyz);
			ridess.add(xyz);
			returnIt.put(x+1, ridess);
		}
		//System.out.println(arrList);
		return returnIt;
	}
	public static LinkedHashMap<Integer, Integer> popOut1(LinkedHashMap<Integer, Integer> map,int start,int stop){
		ArrayList <Integer> arrList= new ArrayList<Integer>(map.keySet());
		//System.out.print(arrList);
		//LinkedHashMap<Integer,List<Integer>> returnIt = new LinkedHashMap<Integer,List<Integer>>();
		
		for(int x=start;x<stop;x++){
			List<Integer> ridess= new ArrayList<Integer>();
			int xyz = arrList.get(0);
			//System.out.println(xyz);
			arrList.remove(0);
			map.remove(xyz);
			ridess.add(xyz);
			//returnIt.put(x+1, ridess);
		}
		//System.out.println(arrList);
		return map;
	}
	
	public static void printIt(){
		//System.out.println("***"+newDictTotal);
				//remove(newDictTotal,0);
				//System.out.println(newDictTotal);
				//newDictTotal.keySet();
				/*for(Map.Entry<Integer, Integer>e:newDictTotal.entrySet()){
					System.out.println(e.getKey());
				}*/
				/*for(int x=0;x<vehicle;x++){
					
					
					
					try {
						writer = new PrintWriter(new File("F:\\Java\\SelfDrivingCars\\src\\hashCode18\\output.in"));
						
						writer.println(""+ newDictTotal.values()+newDictTotal.);
						
						for(int i = 0; i < row ; i ++){
							writer.println(charArr[i]);
						}
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally{
						writer.close();
					}
					
					newDictTotal.remove(00);
				}
				*/
				
				/*for(int x=0;x<vehicle;x++){
					for(int y=0;y<10;y++){
						car[x][y]=((Entry<Integer, Integer>) newDictTotal).getKey();
						System.out.println(car[x][y]);
					}
				}
				*/
				
				
				/*int [] sortTotal = new int[rides];
				sortTotal = Arrays.copyOf(totalStep,rides);
				Arrays.sort(sortTotal);
				*/
				/*for(int x=0;x<rides;x++){
					System.out.println(" new: "+sortTotal[x]);
				}*/
				
				/*PrintWriter writer = null;
				
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
				}*/
	}
	
}
