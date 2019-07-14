package houseChanger;

public class Rose {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 2;
		StdDraw.setXscale(-1,+1);
		StdDraw.setYscale(-1,+1);
		StdDraw.setPenColor(StdDraw.BLUE);
		
		double x0 = 0, y0 = 0;
		for(double t = 0.0; t <= 360.0; t += 0.1){
			double theta = Math.toRadians(t);
			double r = Math.sin(n * theta);
			double x1 = r * Math.cos(theta);
			double y1 = r * Math.sin(theta);
			StdDraw.line(x0, y0, x1, y1);
			x0=x1;
			y0=y1;
		}
	}

}
