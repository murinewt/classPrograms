package hashCode18;

public class Cordinate {

    private int x;
    private int y;

    public Cordinate(int x , int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getDistance(Cordinate c){
        return Math.abs(this.x - c.getX()) + Math.abs(this.y - c.getY());

    }
}
