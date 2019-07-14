package hashCode18;

public class Ride {

    private Cordinate start;
    private Cordinate finish;

    private int earliestStart;
    private int lastestFinish;

    private int rideNumber;


    public Ride(Cordinate c1 , Cordinate c2){
        this.start = c1;
        this.finish = c2;
    }


    public int stepsFromOrigin(){
        return start.getDistance(new Cordinate(0,0));

    }

    public int totalSteps(){
        return stepsFromOrigin() + start.getDistance(finish);
    }

    public int getRideNumber(){
        return rideNumber;
    }
    public void setRideNumber(int i){
        this.rideNumber = i;
    }
}
