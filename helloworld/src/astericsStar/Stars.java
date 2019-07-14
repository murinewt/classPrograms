package astericsStar;

/**
 * @author user
 *
 */
public class Stars {
	public static void main(String[] args) {
	//1
	for(int x=1;x<=10;x++)
	{
		for(int y=1;y<=x;y++)
		{
			System.out.print("*");
		}
	System.out.println();
	}
	System.out.println();
	//2
	for(int x=10;x>=1;x--)
	{
		for(int y=x;y>=1;y--)
		{
			System.out.print("*");
		}
	System.out.println();
	}
	System.out.println();
	//3
	for(int x=10;x>=1;x--)
	{
		for(int w=10;w>=x;w--)
		{
			System.out.print(" ");
		}
		for(int y=x;y>=1;y--)
		{
			System.out.print("*");
		}
	System.out.println();
	}
	System.out.println();
	//4
	for(int x=1;x<=10;x++)
	{
		for(int z=10;z>=x;z--)
		{
			System.out.print(" ");
		}
		for(int y=1;y<=x;y++)
		{
			System.out.print("*");
		}
	System.out.println();
	}
	}
}
