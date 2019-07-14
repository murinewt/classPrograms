package hashCode18;

public class Results {

    public int[] rides;


    public Results(int ... ar){
        rides = new int[ar.length];
        for(int i = 0 ;i < ar.length ; i ++){

            rides[i] = ar[i];

        }
    }


    public int[] getResults(){
        return rides;
    }
}
