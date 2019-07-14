package snake;

import java.util.ArrayList;

public class Snake
{
  public ArrayList<Location> snakeArray;
  int size;
  
  public Snake(int s)
  {
    this.snakeArray = new ArrayList<Location>();
    this.size = s;
    initializeSnake();
  }
  
  private void initializeSnake()
  {
    for (int i = 0; i < this.size; i++)
    {
      Location loc = new Location(12, 12 + i);
      this.snakeArray.add(loc);
    }
  }
  
  public void increament(Location loc)
  {
    this.snakeArray.add(loc);
    this.size += 1;
  }
  
  public int size()
  {
    return this.size;
  }
  
  public Location get(int i)
  {
    if ((i < this.size) && (i >= 0)) {
      return (Location)this.snakeArray.get(i);
    }
    return null;
  }
  
  public void set(int i, Location loc)
  {
    this.snakeArray.set(i, loc);
  }
}
