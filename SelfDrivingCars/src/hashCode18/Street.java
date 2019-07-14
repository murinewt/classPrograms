package hashCode18;

public class Street {

    private int rows = 0;
    private int columns = 0;

    private int cars = 0;
    private int steps = 0;
    private int rides = 0;


    public Street(){}

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getCars() {
        return cars;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setCars(int cars) {
        this.cars = cars;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setRides(int rides) {
        this.rides = rides;
    }

    public int getSteps() {
        return steps;

    }

    public int getRides() {
        return rides;
    }
}
