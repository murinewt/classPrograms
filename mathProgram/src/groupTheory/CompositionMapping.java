package groupTheory;

public class CompositionMapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numSides=3;
		String[] rotate= new String[numSides];
		String[] transform = new String[numSides]; 
		String[] alphabet = {"A","B","C","D","E","F","G","H","I"};
		String[] numOf = new String[numSides];
		for(int a=0;a<numSides;a++){
			numOf[a]=alphabet[a];
			System.out.println(numOf[a]);;
		}
		for(int b=0;b<numSides;b++){
			rotate[b]="X"+b;
			System.out.println(rotate[b]);
		}
		for(int c=0;c<numSides;c++){
			transform[c]="Y"+c;
			System.out.println(transform[c]);
		}
		for(int x=0;x<numSides;x++){
			for(int y=0;y<numSides;y++){
				System.out.print(rotate[x]+transform[y]);
			}
			System.out.println();
		}
		
		rotate[0]="sdf";
		
		
		
		
		
		
		
		
		
		/*for(int x=1;x<11;x++){
			for(int y=1;y<11;y++){
				if(x==1&&y==1){
					for(int q=1;q<11;q++){
						System.out.println(q+"	");
					}
					//x++;y++;
				}
				System.out.print(x*y+"	");
			}
			System.out.println();
		}*/

	}

}
