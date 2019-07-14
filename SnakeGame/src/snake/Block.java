package snake;

public class Block
{
  public Location[] blockLocation;
  
  public Block(int i)
  {
    int loc = 0;
    int loc2 = 0;
    int loc3 = 0;
    int loc4 = 0;
    int loc5 = 0;
    int loc6 = 0;
    int loc7 = 0;
    int loc8 = 0;
    if (i == 1)
    {
      this.blockLocation = new Location[30];
      for (int j = 0; j < this.blockLocation.length; j++) {
        if (j < 15)
        {
          this.blockLocation[j] = new Location(5, 5 + j);
        }
        else
        {
          this.blockLocation[j] = new Location(19, 5 + loc);
          loc++;
        }
      }
    }
    else if (i == 2)
    {
      this.blockLocation = new Location[60];
      for (int j = 0; j < this.blockLocation.length; j++) {
        if (j < 15)
        {
          this.blockLocation[j] = new Location(5 + j, 5);
        }
        else if (j < 30)
        {
          this.blockLocation[j] = new Location(5 + loc, 6);
          loc++;
        }
        else if (j < 45)
        {
          this.blockLocation[j] = new Location(5 + loc2, 17);
          loc2++;
        }
        else
        {
          this.blockLocation[j] = new Location(5 + loc3, 18);
          loc3++;
        }
      }
    }
    else if (i == 3)
    {
      this.blockLocation = new Location[66];
      for (int j = 0; j < this.blockLocation.length; j++) {
        if (j < 15)
        {
          this.blockLocation[j] = new Location(6, 5 + j);
        }
        else if (j < 30)
        {
          this.blockLocation[j] = new Location(18, 5 + loc);
          loc++;
        }
        else if (j < 41)
        {
          this.blockLocation[j] = new Location(7, 7 + loc2);
          loc2++;
        }
        else if (j < 48)
        {
          this.blockLocation[j] = new Location(8, 9 + loc3);
          loc3++;
        }
        else if (j < 59)
        {
          this.blockLocation[j] = new Location(17, 7 + loc4);
          loc4++;
        }
        else
        {
          this.blockLocation[j] = new Location(16, 9 + loc5);
          loc5++;
        }
      }
    }
    else if (i == 4)
    {
      this.blockLocation = new Location[104];
      for (int m = 0; m < this.blockLocation.length; m++) {
        if (m < 15)
        {
          this.blockLocation[m] = new Location(5 + loc, 4);
          loc++;
        }
        else if (m < 30)
        {
          this.blockLocation[m] = new Location(5 + loc2, 5);
          loc2++;
        }
        else if (m < 45)
        {
          this.blockLocation[m] = new Location(5 + loc3, 19);
          loc3++;
        }
        else if (m < 60)
        {
          this.blockLocation[m] = new Location(5 + loc4, 20);
          loc4++;
        }
        else if (m < 71)
        {
          this.blockLocation[m] = new Location(5, 8 + loc5);
          loc5++;
        }
        else if (m < 82)
        {
          this.blockLocation[m] = new Location(6, 8 + loc6);
          loc6++;
        }
        else if (m < 93)
        {
          this.blockLocation[m] = new Location(18, 6 + loc7);
          loc7++;
        }
        else if (m < 104)
        {
          this.blockLocation[m] = new Location(19, 6 + loc8);
          loc8++;
        }
      }
    }
  }
  
  public void createBlock(int i) {}
}
