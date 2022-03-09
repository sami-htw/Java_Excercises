package pflichtAufgabe2;

/**
 * 
 * @author Osama Ahmad  567074
 */
public class Square extends Rectangle {

    private double delta;

    // Initialization takes place in the constructor of the class Square, which calls the constructor of the super class.
    public Square(Point point, double sideLength, double delta) throws InValidValueException {

        super(point, sideLength, sideLength);
        this.delta = delta;
    }

    // this class used also the method of super class to delivers area and circumference


    /*
     * The class contains a toString() method, which delivers
     * The nature of the object (here SQUARE) and the value of delta .
     * @return delta
     */
    @Override
    public String toString() {
        return "Square with origin: (" +
                point.getxOrigin() +
                "," + point.getyOrigin() +
                ") and delta: " + delta;
    }
}
