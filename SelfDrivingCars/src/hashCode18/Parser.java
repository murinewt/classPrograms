package hashCode18;

import java.util.ArrayList;
import java.util.List;

public class Parser {


    List<Ride> rides = null;
    Street street = null;
    List<Results> results = null;


    public Parser(){
        rides = new ArrayList<Ride>();
        street  = new Street();
        results = new ArrayList<Results>();
    }


    public void sortAccordingToDistances(){
        for(Ride r : rides){
            r.setRideNumber(rides.indexOf(r));
        }
    }


    public void findRide(){

        /*for(Ride r : rides){
            if(r.)
        }*/
    }

}
