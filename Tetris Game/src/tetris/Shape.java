package tetris;

public class Shape{
	
	private Location[] shapeLocation;
	
	
	public Shape(){
		shapeLocation = new Location[4];
		addShapeItem(0 , new Location(0,5));
		addShapeItem(1 , new Location(0,6));
		addShapeItem(2, new Location(1,5));
		addShapeItem(3 , new Location(1,6));
	}
	
	
	public void addShapeItem(int i , Location loc){
		shapeLocation[i] = loc;
	}
	
	public Location getShapeItem(int i){
		return shapeLocation[i];
	}
	
	public Location getCenter(){
		int minimum = 30;
		for(int i = 0; i< 4;i ++){
			minimum = i;
			if(shapeLocation[i].row < shapeLocation[minimum].row)
				minimum = i;
		}
		return shapeLocation[minimum];
		
	}
}
