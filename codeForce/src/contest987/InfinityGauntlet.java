package contest987;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class InfinityGauntlet {

	public static void main(String [] args){
		
		int num=0, x=0;
		
		Scanner scan = null;
		
		String [] colour = null;
		
		LinkedHashMap<String, String> colours = new LinkedHashMap<String, String>();
		colours.put("purple", "Power");
		colours.put("green", "Time");
		colours.put("blue", "Space");
		colours.put("orange", "Soul");
		colours.put("red", "Reality");
		colours.put("yellow", "Mind");
		
		File f =new File("F:\\codeForce\\2.in");
		
		try {
			 
			scan = new Scanner(f);
			String nums = scan.nextLine();
			num = Integer.parseInt(nums);
			colour= new String[num];
			while(scan.hasNext()&& x<num){
				
				colour[x] = scan.nextLine();
				x++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			scan.close();
		}
			
		List<String> keyList = new ArrayList<String>(colours.keySet());
		System.out.println(keyList);
		for(int qw=0;qw<num;qw++){
			if(keyList.contains(colour[qw])){
				System.out.println(colour[qw]+" - "+colours.get(colour[qw]));
				keyList.remove(colour[qw]);
			}
		}
		System.out.println(keyList);
		String [] leftColour = keyList.toArray(new String[6-num]);
		System.out.println("ELSE");
		for(int qw=0;qw<(6-num);qw++){
			System.out.println(leftColour[qw]+" - "+colours.get(leftColour[qw]));
		}		
		
		PrintWriter writer = null;
		
		try {
			String name = f.getName();
			System.out.println(name);
			String[] nmae= new String[2];
			nmae = name.split(".in");
			System.out.println(nmae[0]);
			writer = new PrintWriter(new File("F:\\codeForce\\"+nmae[0]+".out"));
			writer.println(6-num);
			for(int nmm=0;nmm<6-num;nmm++){
				writer.println(colours.get(leftColour[nmm]));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			writer.close();
		}
	}
}
