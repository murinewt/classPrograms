package players;

import java.text.DecimalFormat;

public class Player {
	private String name;
	private double average;
	
	public Player(String name, double average){
		this.name = name;
		this.average = average;
	}
	public String getname(){
		return name;
	}
	public double getaverage(){
		return average;
	}
	public String getAverageString() {
		DecimalFormat decFormat = new DecimalFormat();
		decFormat.setMaximumIntegerDigits(0);
		decFormat.setMaximumFractionDigits(3);
		decFormat.setMinimumFractionDigits(3);
		return decFormat.format(average);
	}

}
